package com.cafe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cafe.qa.base.TestBase;

public class CreateUserPage extends TestBase{
	
	
	@FindBy(xpath="//fieldset//label[1]//input[1]")
	WebElement firstName; 
	
	@FindBy(xpath = "//fieldset//label[2]//input[1]")
	WebElement lastName; 
	
	@FindBy(xpath="//input[@title='Please enter a date formatting YYYY-MM-DD']")
	WebElement startDate;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//a[@class='subButton bCancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addBtn;
	
	public CreateUserPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage CreateNewUser(String fName, String lName, String date, String emailID) throws InterruptedException
	{
		firstName.sendKeys(fName);
		Thread.sleep(3000);
		lastName.sendKeys(lName);
		Thread.sleep(3000);
		startDate.sendKeys(date);
		Thread.sleep(3000);
		email.sendKeys(emailID);
		Thread.sleep(3000);
		
		addBtn.click();
		Thread.sleep(3000);
		
		return new HomePage();
	}
	
	
	public String validateCreateNewUserURL()
	{
		String title = driver.getCurrentUrl();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return title;
		
	}
	
	

}
