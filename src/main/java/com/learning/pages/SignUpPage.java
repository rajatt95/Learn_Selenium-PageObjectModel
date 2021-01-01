package com.learning.pages;

import org.openqa.selenium.By;

import com.learning.base.Page;

public class SignUpPage extends Page {

	public void doSignUp(String username, String password) {

		driver.findElement(By.xpath("//input[@id='emailfield']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[@id='signup-termservice']")).click();
		driver.findElement(By.xpath("//input[@id='signupbtn']")).click();
	
		
		
		
	
	
	}
}
