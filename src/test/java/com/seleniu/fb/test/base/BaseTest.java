package com.seleniu.fb.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniu.fb.util.ExtentManager;

public class BaseTest {

	
	public  WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public void init(String browser)
	
	{
		System.setProperty("webdriver.gecko.driver", "C:\\browserDrivers\\gecko2\\geckodriver.exe");
		
		//below commented code used to work but now driver=new FirefoxDriver(capabilities); is deprecated
		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("permissions.default.deskto-notification", 1);
		//DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		//capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		//driver=new FirefoxDriver(capabilities);
		
		//below code disables web notifications
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(new FirefoxProfile());
		firefoxOptions.addPreference("dom.webnotifications.enabled", false);
				
        driver = new FirefoxDriver(firefoxOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
}
