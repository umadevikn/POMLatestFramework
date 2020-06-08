package com.qa.rediff.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.rediff.base.BasePage;
import com.qa.rediff.base.Page;
import com.qa.rediff.listeners.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public Page page;
	public WebEventListener eventListener;
	public EventFiringWebDriver edriver;
	
	@BeforeMethod
	@Parameters({"Browser","url"})
	public void setUp(String browser,String url,ITestContext context)
	{
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Please provide a valid browser name");
		}
		
		
		eventListener=new WebEventListener();
		edriver=new EventFiringWebDriver(driver);
		edriver.register(eventListener);
		driver=edriver;
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
		
		page=new BasePage(driver);
		
		context.setAttribute("WebDriver", driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
