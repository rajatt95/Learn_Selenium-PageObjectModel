package com.learning.pages;

import com.learning.base.Page;

public class LoginPage extends Page {

	/*
	 * WebDriver driver;
	 * 
	 * public LoginPage(WebDriver driver) { this.driver = driver; }
	 */

	public ZohoAppPage doLogin(String username, String password) {

		type("loginPage.email.textBox", username);
		click("loginPage.email.next.button");
		type("loginPage.password.textBox", password);
		click("loginPage.signIn.button");

		return new ZohoAppPage();
	}

}
