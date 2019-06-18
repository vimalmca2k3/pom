package com.seleniu.fb.pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seleniu.fb.util.FBConstants;

public class TopMenu {
	
	
	@FindBy(xpath=FBConstants.NAVIGATION_LABEL)
	public WebElement navigationLabel;
	@FindBy(xpath=FBConstants.ACCOUNT_SETTINGS_XPATH)
	public WebElement accountSettings;
	@FindBy(xpath=FBConstants.LOGOUT_XPATH)
	public WebElement logout;
	
	ExtentTest test;
	
	
	WebDriver driver;
	
	
	TopMenu(WebDriver driver,ExtentTest test)
	{
		
		this.driver = driver;
		this.test = test;
		
		
	}

 public void logout()
 
 {
	 accountSettings.click();
	 logout.click();
	 
		
	}

    /*
    public GeneralSettingsPage gotoSettings(){
	test.log(LogStatus.INFO, "Going to settings");
	//navigationLabel.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("document.getElementById('userNavigationLabel').click()");
	settings.click();
	test.log(LogStatus.INFO, "Settings page opened");
	GeneralSettingsPage settings =new GeneralSettingsPage(driver,test);
	PageFactory.initElements(driver, settings);
	return settings;
}
*/
public void search(){
	
}


}
