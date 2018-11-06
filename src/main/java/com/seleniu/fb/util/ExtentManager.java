package com.seleniu.fb.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			Date d = new Date();
			String reportName = d.toString().replace(":","_").replace(" ","_");
			extent = new ExtentReports(System.getProperty("user.dir")+"/POMReports/"+reportName+".html",false);
			extent.addSystemInfo("Host Name", "First Extent Report");
			extent.addSystemInfo("ENV DETAILS","Just To Understand ENV");
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReportsConfig.xml"));
			
		}
		
		return extent;
		
	}

}
