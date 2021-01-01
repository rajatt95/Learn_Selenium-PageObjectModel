package com.learning.pages;

import org.openqa.selenium.By;

import com.learning.base.Page;

public class HomePage extends Page {

	/*
	 * WebDriver driver;
	 * 
	 * // Constructor // will be called when its object is created public
	 * HomePage(WebDriver driver) { this.driver = driver; }
	 */

	public LoginPage goToLogin() {
		// driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		click("homePage.login.link");
		return new LoginPage();

	}

	public void goToSignUp() {
		click("homePage.signUp.link");

	}

	public void goToFooterLinks() {

	}

	public void goToSupport() {

	}

	public void goToZohoEu() {

	}

	public void goToLearnMore() {

	}

}
