package com.seleniu.fb.pages.session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniu.fb.pages.base.BasePage;


public class LandingPage extends BasePage{

	
	@FindBy(xpath="//div[@id='userNav']/ul/li/a")
	WebElement profileLink;
	
	
	public LandingPage(WebDriver driver,ExtentTest test)
	
	{
		
		super(driver,test);
	}

	public ProfilePage gotoProfilePage(){

		profileLink.click();
		ProfilePage profPage = new ProfilePage (driver,test);
		PageFactory.initElements(driver, profPage);
		return profPage;
	}
}
