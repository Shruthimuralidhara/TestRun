package com.cafe.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.pages.HomePage;
import com.cafe.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	public LoginPage login; 
	public HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp()
	{
		initializebrowser();
		login = new LoginPage();
	}
	
	
	@Test(priority=2)
	public void LoginTest() throws InterruptedException
	{
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = homePage.validateHomePageTitle();
		String actURL = homePage.validateHomePageURL();
		Assert.assertEquals(title, "CafeTownsend-AngularJS-Rails");
		Assert.assertEquals(actURL, "https://cafetownsend-angular-rails.herokuapp.com/employees");
	}
	
	@Test(priority=1)
	public void loginPageFunctionality()
	{
		String title = login.validatePageTitle();
		Assert.assertEquals(title, "CafeTownsend-AngularJS-Rails");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
