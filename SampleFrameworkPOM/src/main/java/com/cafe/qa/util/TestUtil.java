package com.cafe.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cafe.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	//public static  String TESTDATA_SHEET_NAME = null;
	public static long PAGE_LOAD_TIME = 10; 
	public static long IMPLICIT_WAIT_TIME = 20; 
	public static String TESTDATA_SHEET_NAME = "C:\\Users\\Shruthi Muralidhara\\Desktop\\SampleFramework\\SampleFrameworkPOM\\src\\main\\java\\com\\cafe\\qa\\testdata\\TestData.xlsx";
	
	public static Workbook workbook;
	public static Sheet sheet; 
	
	public static void highLight(WebElement element, WebDriver driver)
    {
        for (int i = 0; i <5; i++) 
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
	
	public static Object[][] getDate(String sheetName) throws IOException
	{
		FileInputStream file=null;
		try {
		file =new FileInputStream(TESTDATA_SHEET_NAME);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
			workbook=new XSSFWorkbook(file);
			
		
		
		
		sheet = workbook.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		
		
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		FileUtils.copyFile(scr,new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
	
	
	

}
