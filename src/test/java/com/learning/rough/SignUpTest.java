package com.learning.rough;

import com.learning.pages.HomePage;
import com.learning.pages.SignUpPage;

public class SignUpTest {

	public static void main(String[] args) throws InterruptedException {

		HomePage home = new HomePage();
		// home.goToLogin();
		home.goToSignUp();

		SignUpPage signUp = new SignUpPage();

		signUp.doSignUp("rajatvermaa85@gmail.com", "HelloZoho@123");
		/* signUp.doSignUp("rajatvermaa65@gmail.com", "HelloZoho@123"); */

		/*
		 * LoginPage login = new LoginPage(); login.doLogin("rajatvermaa80@gmail.com",
		 * "HelloZoho@123");
		 * 
		 * ZohoAppPage zp = new ZohoAppPage(); zp.goToCRM();
		 * 
		 * Page.menu.goToAccounts();
		 */
		Thread.sleep(3000);
		System.out.println("Success");
	}

}
