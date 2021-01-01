package com.learning.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.base.BaseTest;
import com.learning.pages.HomePage;
import com.learning.pages.LoginPage;
import com.learning.pages.ZohoAppPage;
import com.learning.utilities.Constants;
import com.learning.utilities.Utilities;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) {
		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();

		ZohoAppPage zp = login.doLogin(data.get(Constants.username), data.get(Constants.password));

		// Assert.fail("Login Test failed");
		/*
		 * ZohoAppPage zp = login.doLogin("rajatvermaa65@gmail.com", "HelloZoho@123");
		 */
	}
	/*
	 * @Test public void loginTest() { HomePage home = new HomePage(); LoginPage
	 * login = home.goToLogin(); ZohoAppPage zp =
	 * login.doLogin("rajatvermaa65@gmail.com", "HelloZoho@123"); }
	 */}
