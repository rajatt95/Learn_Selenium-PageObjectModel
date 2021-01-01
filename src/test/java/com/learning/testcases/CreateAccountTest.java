package com.learning.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learning.base.BaseTest;
import com.learning.base.Page;
import com.learning.pages.ZohoAppPage;
import com.learning.pages.crm.accounts.AccountsPage;
import com.learning.pages.crm.accounts.CreateAccountPage;
import com.learning.utilities.Constants;
import com.learning.utilities.Utilities;

public class CreateAccountTest extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) {

		ZohoAppPage zp = new ZohoAppPage();
		zp.goToCRM();
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccountPage cap = account.goToCreateAccount();
		cap.createAccount(data.get(Constants.accountname));

		// Assert.fail("CreateAccount Test failed");

	}
}
