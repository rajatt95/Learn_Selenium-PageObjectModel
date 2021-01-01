package com.learning.pages.crm.accounts;

import com.learning.base.Page;

public class CreateAccountPage extends Page {

	public void createAccount(String accountName) {

		//driver.findElement(By.xpath("//input[@id='Crm_Accounts_ACCOUNTNAME']")).sendKeys(accountName);

		type("crm.createAccount.accountName.textBox", accountName);

		// driver.findElement(By.xpath(""));
	}
}
