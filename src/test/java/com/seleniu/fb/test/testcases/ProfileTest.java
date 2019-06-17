package com.seleniu.fb.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.seleniu.fb.pages.session.LandingPage;
import com.seleniu.fb.pages.session.LaunchPage;
import com.seleniu.fb.pages.session.LoginPage;
import com.seleniu.fb.pages.session.ProfilePage;
import com.seleniu.fb.test.base.BaseTest;
import com.seleniu.fb.util.FBConstants;

public class ProfileTest extends BaseTest{
	
	
	@Test
	public void profileTest()
	{
		
		test =  extent.startTest("profileTest");
		init("Mozilla");
		test.log(LogStatus.INFO, "Opening Browser in ProfileTest");
		LaunchPage launchPage = new LaunchPage(driver,test);
		
		LoginPage lPage = launchPage.launch(FBConstants.TESTURL);
		
		LandingPage landingPage = lPage.doLogin(FBConstants.USERID, FBConstants.PASSWORD);
		
		ProfilePage profPage = landingPage.gotoProfilePage();
		
		profPage.verifyProfile();
			
		
		
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void closingReport()
	{

		if(extent!=null)
		{
			extent.endTest(test);
			extent.flush();
		}

		extent.endTest(test);
		extent.flush();

	}


}
