package com.learning.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learning.pages.crm.accounts.AccountsPage;

public class TopMenu {

	WebDriver driver;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * ISA - Inheritance HASA - Encapsulation
	 * 
	 * TopMenu ISA Page ??? - NO
	 * 
	 * HomePage HASA TopMenu, AccountsPage HASA TopMenu. LeadsPage HASA TopMenu
	 * 
	 * Page HASA TopMenu
	 */

	public void goToHome() {
	}

	public void goToLeads() {
	}

	public AccountsPage goToAccounts() {
		// driver.findElement(By.xpath("//*[@id=\"mainMenuTabDiv\"]/crm-menu/div[1]/crm-tab/div[2]/div[4]/a")).click();
		Page.click("crm.accounts.tab");

		return new AccountsPage();
	}

	public void goToContacts() {
	}

	public void signOut() {

	}
}
