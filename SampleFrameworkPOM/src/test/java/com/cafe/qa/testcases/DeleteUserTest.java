package com.cafe.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.pages.DeleteUserPage;
import com.cafe.qa.pages.HomePage;
import com.cafe.qa.pages.LoginPage;

public class DeleteUserTest extends TestBase {
	
	LoginPage login; 
	HomePage homePage;
	DeleteUserPage deleteUsern;
	

	public DeleteUserTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initializebrowser();
		login = new LoginPage();
		homePage = login.login("Luke", "Skywalker");
		String title = homePage.validateHomePageURL();
		Assert.assertEquals(title, "https://cafetownsend-angular-rails.herokuapp.com/employees");
	}
	
	@Test
	public void DeleteUser() throws InterruptedException
	{
		homePage.validateUser("Test1234");
		deleteUsern = homePage.clickOnDeleteBtn();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
