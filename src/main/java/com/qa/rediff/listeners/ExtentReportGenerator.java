package com.qa.rediff.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {

	public static ExtentReports extentReport;
	
	public static ExtentReports reportConfig()
	{
		String path=System.getProperty("user.dir")+"\\target\\ExtentReport\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Rediff Automation");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("Application Name", "Rediff.com");
		extentReport.setSystemInfo("Tester", "Uma");
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		
		
		return extentReport;
		
		
		
	}
	
	
	
	
	
	
}
