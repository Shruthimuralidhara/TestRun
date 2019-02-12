package com.cafe.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	public String usrName;
	
	@FindBy(xpath="//a[contains(text(),'Create')]")
	WebElement createBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	WebElement deleteBtn;
	
	@FindBy(css="#employee-list")
	WebElement empList;
	
	
	
	//Initializing the page factory
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public String validateHomePageURL() {
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public void validateNewUserCreation(String usrName)
	{
		//WebElement empList = (WebElement) new Select(empList);
		//elect empTable = new Select(empList);
		
		System.out.println(usrName);
		WebElement usrNameEle = driver.findElement(By.xpath("//li[starts-with(text(),usrName)]"));
		if (usrNameEle.isDisplayed())
		{
			usrNameEle.click();
			System.out.println("Found");
		}
		
	}
	
	public CreateUserPage clickOnCreateUserBtn()
	{
		createBtn.click();
		return new CreateUserPage();
	}
	
	public EditUserPage clickOnEditBtn()
	{
		editBtn.click();
		return new EditUserPage();
	}
    
	public DeleteUserPage clickOnDeleteBtn()
	{
		deleteBtn.click();
		return new DeleteUserPage();
	}
	
	public void validateUser(String usrName) throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println(usrName);
		Thread.sleep(5000);
		TestUtil.highLight(empList, driver);
		//highLight
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement list = empList.findElement(By.xpath("//li[contains(text(),'"+usrName+"')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", list);
		Thread.sleep(5000);
		//if(list.isDisplayed())
		
		list.click();
		//flag = true; 
		//}
		TestUtil.highLight(list, driver);
		
	}
	
}
