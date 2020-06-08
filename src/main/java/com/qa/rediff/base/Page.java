package com.qa.rediff.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,15);
	}
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(WebElement header);
	
	public abstract void waitForElement(WebElement element);
	
	public abstract void clickOnElement(WebElement element);
	
	public abstract void enterText(WebElement element,String text);
	
	public abstract boolean isDisplayed(WebElement element);
	
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	{
		try
		
		{
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some error occured while creating the page object");
			return null;
		}
	}
	
	
	
	
	
	
	
	
	

}
