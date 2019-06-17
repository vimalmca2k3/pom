package com.seleniu.fb.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniu.fb.pages.base.BasePage;


public class LandingPage extends BasePage{

	
	//findby to find profile link
	public LandingPage(WebDriver driver,ExtentTest test)
	
	{
		
		super(driver,test);
	}

	public ProfilePage gotoProfilePage(){

		// click on profile link
		// TODO Auto-generated method stub


		// click on profile link

		// TODO Auto-generated method stub
		//
		ProfilePage profPage = new ProfilePage (driver,test);
		PageFactory.initElements(driver, profPage);
		return profPage;
	}
}
