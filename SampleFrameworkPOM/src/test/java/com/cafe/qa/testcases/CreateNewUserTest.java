package com.cafe.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.pages.CreateUserPage;
import com.cafe.qa.pages.HomePage;
import com.cafe.qa.pages.LoginPage;
import com.cafe.qa.util.TestUtil;

public class CreateNewUserTest extends TestBase{
		LoginPage login; 
		HomePage homePage;
		CreateUserPage createNewUser;
				
		
		public CreateNewUserTest()
		{
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
		
		
		@DataProvider()
		public Object[][] getCreateUserData() throws IOException
		{
			Object[][] data = TestUtil.getDate("CreateUser");
			return data;
			
		}
		@Test(priority=1,dataProvider = "getCreateUserData")
		public void createNewUserTest(String fName, String lName, String sDate, String emailID) throws InterruptedException, IOException
		{
			createNewUser = homePage.clickOnCreateUserBtn();
			String title = createNewUser.validateCreateNewUserURL();
			Assert.assertEquals(title , "https://cafetownsend-angular-rails.herokuapp.com/employees/new");
			usrName = "Test"+System.currentTimeMillis();
			createNewUser.CreateNewUser(fName,lName, sDate, emailID);
			
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			title = homePage.validateHomePageURL();
			Assert.assertEquals(title, "https://cafetownsend-angular-rails.herokuapp.com/employees");
			
			
		}
		
		/*@Test(priority=2)
		public void validateUser() throws InterruptedException
		{
			homePage.validateUser("Test1234");
		}*/
		
		
		
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
		
		

}
