package com.cafe.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.pages.CreateUserPage;
import com.cafe.qa.pages.EditUserPage;
import com.cafe.qa.pages.HomePage;
import com.cafe.qa.pages.LoginPage;
import com.cafe.qa.util.TestUtil;

public class EditNewUser extends TestBase {
	
	HomePage homePage;
	LoginPage login;
	CreateUserPage mUser;
	EditUserPage editUser; 
	TestUtil util;

	public EditNewUser() {
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
	
	@Test(priority=1)
	public void validateEditUserPage() throws InterruptedException
	{
		homePage.validateUser("Test1234");
		editUser = homePage.clickOnEditBtn();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		Thread.sleep(4000);
		editUser.editExistingUser("Test1234","User", "2019-02-06", "mtestuser@gmail.com");
		Thread.sleep(3000);
		String title = homePage.validateHomePageURL();
		Assert.assertEquals(title, "https://cafetownsend-angular-rails.herokuapp.com/employees");
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
