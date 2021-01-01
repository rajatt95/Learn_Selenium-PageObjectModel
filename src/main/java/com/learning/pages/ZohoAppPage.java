package com.learning.pages;

import com.learning.base.Page;
import com.learning.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {

	/*
	 * WebDriver driver;
	 * 
	 * public ZohoAppPage(WebDriver driver) { this.driver = driver; }
	 */

	public CRMHomePage goToCliQ() {
		click("zohoAppPage.cliq.link"); /* driver.findElement(By.xpath("//div[contains(text(),'Cliq')]")).click(); */
		return new CRMHomePage();
	}

	public CRMHomePage goToCRM() {
		click("zohoAppPage.crm.link");
		return new CRMHomePage();
	}

}
