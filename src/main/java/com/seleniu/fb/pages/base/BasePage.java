package com.seleniu.fb.pages.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

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
		String screenshotName = d.toString().replace(":","_").replace(" ","_");
		
		File scrFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/POMReports/POMReports/screenshots"+screenshotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
