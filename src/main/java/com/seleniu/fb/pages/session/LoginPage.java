package com.seleniu.fb.pages.session;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seleniu.fb.pages.base.BasePage;

import com.seleniu.fb.util.FBConstants;

public class LoginPage extends BasePage{

	
	@FindBy(xpath=FBConstants.USERID_XPATH)
	WebElement email;
	
	@FindBy(xpath=FBConstants.PASSWORD_XPATH)
	WebElement pwd;
	
	@FindBy(xpath=FBConstants.LOGIN_BUTTON)
	WebElement login_btn;
	
	public LoginPage(WebDriver driver,ExtentTest test) {
	
		super(driver,test);
	}

	public LandingPage doLogin(String userid, String password) 
	{
		
		test.log(LogStatus.INFO, "Entering user id and password"+userid +"/" + password );	
		try {
		email.sendKeys(FBConstants.USERID);
		pwd.sendKeys(FBConstants.PASSWORD);
		pwd.sendKeys(Keys.ENTER);
		}
		catch (Exception ex)
		{
			reportException(ex.getMessage().toString());
			}
		
		test.log(LogStatus.INFO, "logged in");
		
		LandingPage landingPage = new LandingPage(driver,test);
		PageFactory.initElements(driver, landingPage);
		test.log(LogStatus.INFO, "Landing page opened");
	
		return landingPage;
		
		
	}

	
	
	

}
