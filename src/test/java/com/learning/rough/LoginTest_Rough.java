package com.learning.rough;

import com.learning.base.Page;
import com.learning.pages.HomePage;
import com.learning.pages.LoginPage;
import com.learning.pages.ZohoAppPage;
import com.learning.pages.crm.accounts.AccountsPage;
import com.learning.pages.crm.accounts.CreateAccountPage;

public class LoginTest_Rough {

	// This is a rough package
	

	public static void main(String[] args) throws InterruptedException {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		ZohoAppPage zp = login.doLogin("rajatvermaa65@gmail.com", "HelloZoho@123");
		zp.goToCRM();
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccountPage cap = account.goToCreateAccount();
		cap.createAccount("Rajat");

		Thread.sleep(3000);
		System.out.println("Success");

		/*
		 * HomePage home = new HomePage(); home.goToLogin(); // home.goToSignUp();
		 * 
		 * LoginPage login = new LoginPage(); //
		 * login.doLogin("rajatvermaa80@gmail.com", "HelloZoho@123");
		 * login.doLogin("rajatvermaa65@gmail.com", "HelloZoho@123");
		 * 
		 * ZohoAppPage zp = new ZohoAppPage(); zp.goToCRM();
		 * 
		 * Page.menu.goToAccounts();
		 * 
		 * AccountsPage account = new AccountsPage(); account.goToCreateAccount();
		 * 
		 * CreateAccountPage cap = new CreateAccountPage(); cap.createAccount("Rajat");
		 * 
		 * Thread.sleep(3000); System.out.println("Success");
		 */ }

}
