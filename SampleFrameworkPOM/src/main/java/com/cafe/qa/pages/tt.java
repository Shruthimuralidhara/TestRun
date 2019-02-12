package com.cafe.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tt {

	public static WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),'shruthimuralidhara91@gmail.com')]")
	static WebElement gmailID;
	 
	@FindBy(xpath="//input[@name='password']")
	static WebElement password; 
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	static WebElement nextBtn;
	
	public tt()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\DriversDownloaded\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		
	}
	
	
	@Test
	
	public static void LoginToGmail()
	{
		gmailID.click();
		password.sendKeys("shruthi06");
		nextBtn.click();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		
	}
	

}
