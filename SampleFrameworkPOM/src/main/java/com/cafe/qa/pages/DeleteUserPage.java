package com.cafe.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.cafe.qa.base.TestBase;

public class DeleteUserPage extends TestBase {
	
	
	public DeleteUserPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public void deleteUserMethod() throws InterruptedException {
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
	}

}
