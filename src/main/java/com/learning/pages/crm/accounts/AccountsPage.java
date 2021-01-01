package com.learning.pages.crm.accounts;

import org.openqa.selenium.By;

import com.learning.base.Page;

public class AccountsPage extends Page {

	public CreateAccountPage goToCreateAccount() {
		// driver.findElement(By.xpath("//button[contains(@data-zcqa,'cv_createbtn')]")).click();
		click("crm.createAccount.button");
		return new CreateAccountPage();
	}

	public void goToImportAccounts() {
		driver.findElement(By.xpath("//button[@id='importButton']")).click();
		// Import accounts
		driver.findElement(By.xpath("//a[contains(text(),'Import Accounts')]")).click();

	}

}
