package com.seleniu.fb.pages.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
	
	public TopMenu topMenu ;
	
	public BasePage()
	{}
	
	public BasePage(WebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		System.out.println("In BasePage constructor");
		topMenu = new TopMenu(driver,test);
		PageFactory.initElements(driver, topMenu);
	}
	
	public void verifyTitle(String expectedTitle)
	
	{
		
		String actualTitle = driver.getTitle().trim();
		
		if (actualTitle.contains(expectedTitle))
			Assert.assertTrue(true,actualTitle);
			
		else
			Assert.assertTrue(false,actualTitle );
			
		
		
	}
	
	public TopMenu getTopMenu(){
		return topMenu;
	}
	
	public void takeScreenshot()
	{
		
		Date d = new Date();
		String screenshotName = d.toString().replace(":","_").replace(" ","_")+".png";
		System.out.println("Printing Screenshot Name" +screenshotName);
		String filePath= System.getProperty("user.dir")+"\\POMReports\\screenshots\\"+screenshotName;
			
		File scrFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
	//	test.log(LogStatus.INFO,test.addScreenCapture(filePath));
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			reportException(ex.getMessage().toString());
		}
		
		test.log(LogStatus.INFO, "logging it after screenshot");	
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
			
		
	}
	
	public void reportException(String errorMessage) {
		takeScreenshot();
		test.log(LogStatus.FAIL,errorMessage);
		
	}
	public boolean isElementPresent(WebElement e)
	
	{
		
		return false;
	
		
	}
	
	
	
}
