package com.cafe.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cafe.qa.util.TestUtil;
import com.cafe.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver; 
	public static Properties prop;
	public static String usrName;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener; 
	
	
	public TestBase()
	{
		try 
		{
			System.out.println("Loading base class");
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Shruthi Muralidhara\\Desktop\\SampleFramework\\SampleFrameworkPOM\\src\\main\\java\\com\\cafe\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setconfigProperty(String key,String value) throws IOException {
		Properties prop = new Properties();
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Shruthi Muralidhara\\Desktop\\SampleFramework\\SampleFrameworkPOM\\src\\main\\java\\com\\cafe\\qa\\config\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty(key));
		long s = System.currentTimeMillis();
		System.out.println(s);
		String newValue = value+s;
		prop.setProperty(key, newValue);
		System.out.println(prop.getProperty(key));
		
	}
	
	public static void initializebrowser()
	{
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\DriversDownloaded\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Driver initialsed to chrome");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
