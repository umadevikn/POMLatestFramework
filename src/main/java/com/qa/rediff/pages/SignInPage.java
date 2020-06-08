package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff.base.BasePage;

import io.qameta.allure.Step;

public class SignInPage extends BasePage {
	
	@FindBy(xpath="//input[@name='login']")
	WebElement userName;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@name='proceed']")
	WebElement signInBtn;
	
	

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean checkSignInFields()
	{
		return isDisplayed(userName);
	}
	
	@Step("Entering username as {0} and password as {1}")
	public void enterCredentials(String name,String password)
	{
		enterText(userName,name);
		enterText(passWord,password);
				
	}

}
