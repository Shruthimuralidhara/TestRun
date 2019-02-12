package com.cafe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cafe.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//Login Object Repository
	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn; 
	
	//Constructor to initialse the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions 
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String usrName,String pswd) throws InterruptedException
	{
		username.sendKeys(usrName);
		Thread.sleep(3000);
		password.sendKeys(pswd);
		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(3000);
		
		return new HomePage();
	}
}
