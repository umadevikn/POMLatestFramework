package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff.base.BasePage;
import com.qa.rediff.pages.CreateAccountPage;
import com.qa.rediff.pages.SignInPage;

import io.qameta.allure.Step;

public class RediffHomePage extends BasePage {	

	@CacheLookup
	@FindBy(xpath="//span[@class='hmsprite logo']")
	WebElement homeLogo;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='signin']")
	WebElement signInLink;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Create Account')]")
	WebElement createAccountLink;
	
	public RediffHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@Step("Capturing the page title")
	public String getRediffHomePageTitle()
	{
		return getPageTitle();
	}
	
	@Step("Checking Home Logo")
	public boolean checkHomeLogo()
	{
		return homeLogo.isDisplayed();	
		
	}
	
	@Step("Checking Sign In link")
	public boolean checkSignInLink()
	{
		return isDisplayed(signInLink);
	}
	
	@Step("Checking Create Account link")
	public boolean checkCreateAccountLink()	
	{
		return isDisplayed(createAccountLink);
	}
	
	
	@Step("Clicking on Sign In link")
	public SignInPage navigateTosignInPage()
	{
		
		clickOnElement(signInLink);
		return getInstance(SignInPage.class);
	}
	
	@Step("Clicking on Create Account link")
	public CreateAccountPage navigateToCreateAccountPage()
	{
		
		clickOnElement(createAccountLink);
		return getInstance(CreateAccountPage.class);
	}
	
	
	
	
	
	
	

}
