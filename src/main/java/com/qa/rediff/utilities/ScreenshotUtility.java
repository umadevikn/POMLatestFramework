package com.qa.rediff.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	
	public static String getScreenshotPath(WebDriver driver,String testCaseName) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath=System.getProperty("user.dir")+"\\target\\Screenshots\\"+testCaseName+".png";
		
		FileUtils.copyFile(src, new File(screenshotPath));
					
		return screenshotPath;
		
	}

}
