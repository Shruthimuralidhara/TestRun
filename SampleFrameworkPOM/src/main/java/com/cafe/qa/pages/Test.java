package com.cafe.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cafe.qa.base.TestBase;
import com.cafe.qa.util.TestUtil;

public class Test extends TestBase{
	
	static LoginPage login; 
	static HomePage homePage;
	static WebDriver driver;
	
	public Test()
	{
		super();
	}

	public void scrollIntoView() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("id_of_element"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\DriversDownloaded\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		 
		
		driver.get("https://cafetownsend-angular-rails.herokuapp.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Luke");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Skywalker");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.cssSelector("#employee-list"));
		TestUtil.highLight(ele, driver);
		String usrName="Test1549064950224"; 
		//List<WebElement> options = ele.findElements(By.tagName("li"));
		//for(int i=0;i<options.size();i++)
		//{
			//System.out.println(options.get(i));
		//	if(options.get(i).equals(obj))
		//}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement newEle = ele.findElement(By.xpath("//li[contains(text(),'"+usrName+"')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", newEle);
		Thread.sleep(500); 
		TestUtil.highLight(newEle, driver);
		newEle.click();
		//dropdown.selectByVisibleText("testfname6edit testlname2");
		
		
				

	}

}
