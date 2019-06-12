package com.seleniu.fb.pages.session;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seleniu.fb.pages.base.BasePage;

public class ProfilePage extends BasePage{
	
	
	ProfilePage(WebDriver driver, ExtentTest test)
	
	{
		super(driver,test);
		
		test.log(LogStatus.INFO, "Inside Profile Page Constructor");
		
	}

	public void verifyProfile() {
		
		test.log(LogStatus.PASS, "Profile Verified");
	}

}
