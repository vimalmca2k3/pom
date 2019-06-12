package com.seleniu.fb.practice;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4j {
	private static WebDriver driver = null;
	public static void main(String[] args) {
		
	

			
		

			// Hit the URL for which you want to see logs
			//driver.get("http://google.ca/");

			// Create reference variable “log” referencing getLogger method of Logger class, it is used to store logs in selenium.txt
			Logger log = Logger.getLogger("Log4j");
			PropertyConfigurator.configure("Log4j.properties");
			System.setProperty("webdriver.gecko.driver", "C:\\browserDrivers\\gecko2\\geckodriver.exe");

			// Create a new instance of the Firefox driver
			driver = new FirefoxDriver();
			// Call debug method with the help of referencing variable log and log the information in test.logs file
		
			driver.get("http://google.ca/");
			log.debug("Getting errorszzzzzzzzzzzzzz");
			log.error("Errorzzzzzzzzzzzzzzzzzz");
			
			driver.findElement(By.xpath("testing")).sendKeys("EnteringText");
			}

			

	

}
