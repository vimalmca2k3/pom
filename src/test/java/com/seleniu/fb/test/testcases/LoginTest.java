package com.seleniu.fb.test.testcases;

import org.apache.tools.ant.taskdefs.Taskdef;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seleniu.fb.pages.session.LandingPage;
import com.seleniu.fb.pages.session.LaunchPage;
import com.seleniu.fb.pages.session.LoginPage;
import com.seleniu.fb.test.base.BaseTest;
import com.seleniu.fb.util.ExtentManager;
import com.seleniu.fb.util.FBConstants;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void launchTest()
	{
	 
	test = extent.startTest("launchTest");	
	init("Mozilla");
	test.log(LogStatus.INFO, "Opening Browser in launchTest");
	LaunchPage launchPage = new LaunchPage(driver,test);
	//launchPage.takeScreenshot();
	test.log(LogStatus.INFO, "Launching Page");
	PageFactory.initElements(driver, launchPage);
	LoginPage loginPage = launchPage.launch(FBConstants.TESTURL);
	
	
	loginPage.takeScreenshot();
	LandingPage landingPage = loginPage.doLogin(FBConstants.USERID,FBConstants.PASSWORD);
	landingPage.verifyTitle("Facebook");
	test.log(LogStatus.INFO, "Logged in");
	landingPage.takeScreenshot();
	//landingPage.getMenu().logOut();
	
	}
	
	
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void closingReport()
	{
		extent.endTest(test);
		extent.flush();
	}
}
