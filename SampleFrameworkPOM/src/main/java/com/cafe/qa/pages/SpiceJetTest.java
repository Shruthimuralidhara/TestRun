package com.cafe.qa.pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class SpiceJetTest {
	
	public static WebDriver driver; 

	public SpiceJetTest()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods
	public static String validateTitle()
	{
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		return driver.getTitle();
	}
	
	public static void highLight(WebElement element, WebDriver driver)
    {
        for (int i = 0; i <2; i++) 
        {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 4px solid red;");
                Thread.sleep(500);
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

	public static void enterRoundTripDetails() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement roundTripRBtn = driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1"));
		//
		//WebElement arrCity = driver.findElement(By.cssSelector("#ctl00$mainContent$ddl_destinationStation1"));
		roundTripRBtn.click();
		WebElement depCityArrowBtn = driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction"));
		depCityArrowBtn.click();
		
		WebElement depCity = driver.findElement(By.xpath("//a[@value='BHO']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", depCity);
		
		
		WebElement arrCity = driver.findElement(By.xpath("//a[@value='BLR']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", arrCity);
		
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date1']")).click();
		Thread.sleep(3000);
		
		
		WebElement firstGrp = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']"));
		highLight(firstGrp,driver);
		WebElement deptDateTitle = firstGrp.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		highLight(deptDateTitle,driver);
		WebElement nextCalBtn = driver.findElement(By.xpath("//a[@title='Next']"));
		//WebElement nextCalBtn = driver.findElement(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
		highLight(nextCalBtn,driver);
		executor = (JavascriptExecutor) driver;
		System.out.println(nextCalBtn.getText());
		//executor.executeScript("arguments[0].click();", nextCalBtn);
		WebElement daten = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//tbody//tr[2]//td[5]"));
		daten.click();
		highLight(daten,driver);
		
		
		String curValue = deptDateTitle.getAttribute("innerHTML");
		System.out.println("Current Title = "+curValue);
		
	}
	
	private static Function<WebDriver,WebElement> presenceOfElementLocated(final By locator) {
	    return new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    };
	}


	@BeforeMethod
	public static void launchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\DriversDownloaded\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
	}
	


	/*@Test(priority=1)
	public void validateBrowser() throws InterruptedException
	{
		
		String title = validateTitle();
		Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}*/
	
	@Test(priority=1)
	public void selectRoundTripDetails() throws InterruptedException
	{
		enterRoundTripDetails();
	}

}
