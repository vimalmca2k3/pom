package com.seleniu.fb.pages.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.*;
import java.util.Date;

public class BasePage {

	public WebDriver driver;
	//public ExtentReports extent;
	public ExtentTest test;
	public BasePage()
	{}
	
	public BasePage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		System.out.println("In BasePAge constructor");
	
		
	}
	
	public void verifyTitle(String expectedTitle)
	
	{
		
		String actualTitle = driver.getTitle().trim();
		
		if (actualTitle.contains(expectedTitle))
			Assert.assertTrue(true,actualTitle);
			
		else
			Assert.assertTrue(false,actualTitle );
			
		
		
	}
	
	public void takeScreenshot()
	{
		
		Date d = new Date();
		String screenshotName = d.toString().replace(":","_").replace(" ","_")+".png";
		System.out.println("Printing Screenshot Name" +screenshotName);
		//String filePath= "C:\\screenshots\\"+screenshotName;
		String filePath= System.getProperty("user.dir")+"\\POMReports\\screenshots\\"+screenshotName;
		
		//C:\Appium_WS\selenium20182\POMWithPageFactoryOct28\POMReports\POMReports
		System.out.println("Printing filePath Name" +filePath);
		File scrFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
	//	test.log(LogStatus.INFO,test.addScreenCapture(filePath));
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, "logging it after screenshot");	
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
		
		
		
	}
	
}
