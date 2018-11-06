package com.seleniu.fb.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniu.fb.pages.base.BasePage;

public class LaunchPage extends BasePage {

	public LaunchPage(WebDriver driver, ExtentTest test) {
	
		super(driver,test);
		System.out.println("In LaunchPage constructor");
	}

	public LoginPage launch(String url)
	{
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
		
	}
}
