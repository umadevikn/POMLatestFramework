package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rediff.base.BasePage;


public class CreateAccountPage extends BasePage {

	@CacheLookup
	@FindBy(xpath="//td[contains(text(),'Create a Rediffmail account')]")
	WebElement createAccountHeader;
	 
	@FindBy(xpath="//input[starts-with(@name,'name')]")
	WebElement fullName;
	
	
	@FindBy(xpath="//input[contains(@name,'login')]")
	WebElement email;
	
	@FindBy(xpath="//tr//td[text()='Password']//following-sibling::td//input[contains(@name,'passwd')]")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@name,'confirm_passwd')]")
	WebElement conPassword;
	
	@FindBy(xpath="//input[contains(@name,'altemail')]")
	WebElement altEmail;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement backHome;
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	public boolean checkCreateAccountPageHeader()
	{
		return isDisplayed(createAccountHeader);
	}
	
	
	public void enterDetails(String fullname,String emailaddress,String pass,String repassword,String altemail)
	{
		
		enterText(fullName,fullname);
		enterText(email,emailaddress);
		enterText(password,pass);
		enterText(conPassword,repassword);
		enterText(altEmail,altemail);
	}
	
	public RediffHomePage backToHome()
	{
		clickOnElement(backHome);		
		return getInstance(RediffHomePage.class);
	}

}
