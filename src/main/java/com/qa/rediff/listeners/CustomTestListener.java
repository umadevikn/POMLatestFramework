package com.qa.rediff.listeners;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.rediff.utilities.ScreenshotUtility;

import io.qameta.allure.Attachment;

public class CustomTestListener implements ITestListener{
	
	ExtentReports extentReport=ExtentReportGenerator.reportConfig();
	ExtentTest extentTest;
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();

	
	@Attachment
	public static byte[] saveScreenshot(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment
	public static String saveMessage(String message)
	{
		return message;
	}
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest=extentReport.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.get().log(Status.PASS, result.getMethod().getMethodName()+" :test case Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		//To attach failure screenshot to extent report
		test.get().log(Status.FAIL, result.getThrowable());
		ITestContext context=result.getTestContext();
		WebDriver driver=(WebDriver)context.getAttribute("WebDriver");
		try {
			test.get().addScreenCaptureFromPath(ScreenshotUtility.getScreenshotPath(driver, result.getMethod().getMethodName()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//To attach failure screenshot to allure report 
		saveScreenshot(driver);
		saveMessage("Test case: "+result.getMethod().getMethodName()+" failed and attached the screenshot.");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, result.getMethod().getMethodName()+" :test case got Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test suite execution start date: "+context.getStartDate());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getPassedTests());
		System.out.println(context.getFailedTests());
		System.out.println(context.getSkippedTests());
		extentReport.flush();
		
	}

}
