package com.cafe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.util.TestUtil;

public class EditUserPage extends TestBase{
	
	public static CreateUserPage mCUser;
	 
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editBtn; 
	
	@FindBy(xpath="//button[contains(text(),'Update')]")
	WebElement updateBtn;
	
	@FindBy(xpath="//fieldset//label[1]//input[1]")
	WebElement firstName; 
	
	@FindBy(xpath = "//fieldset//label[2]//input[1]")
	WebElement lastName; 
	
	@FindBy(xpath="//input[@title='Please enter a date formatting YYYY-MM-DD']")
	WebElement startDate;
	
	@FindBy(xpath="//a[@class='subButton bBack']")
	WebElement backBtn;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;

	public EditUserPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateEditUserPageTitle()
	{
		System.out.println("Printing the url inside validateEditUserPageTitle :: "+driver.getTitle());
		Assert.assertEquals(driver.getCurrentUrl(), "https://cafetownsend-angular-rails.herokuapp.com/employees/31107/edit");
		return true;
	}
	
	public void editExistingUser(String mName, String lName, String mDOB, String mEmail)
	{
		firstName.clear();
		lastName.clear();
		startDate.clear();
		email.clear();
		
		firstName.sendKeys(mName);
		TestUtil.highLight(firstName, driver);
		lastName.sendKeys(lName);
		startDate.sendKeys(mDOB);
		email.sendKeys(mEmail);
		updateBtn.click();
		//return new HomePage();
		
	}
	
	public void validateEditedUserValues(String mName, String lName, String mDOB, String mEmail)
	{
		//String actfName = firstName.getCssValue(arg0)
		//System.out.println(actfName);
		String actlName = lastName.getText().toString();
		String actDOB = startDate.getText().toString();
		String actEmail = email.getText().toString();
		//System.out.println(actfName.equals(mName));
		System.out.println(actlName.equals(lName));
		System.out.println(actDOB.equals(mDOB));
		System.out.println(actEmail.equals(mEmail));
		//Assert.assertEquals(actfName, mName);
		//Assert.assertEquals(actlName, lName);
		//Assert.assertEquals(actDOB, mDOB);
		//Assert.assertEquals(actEmail, mEmail);
		backBtn.click();
		
	}


}
