package com.qa.rediff.testcases;

import org.testng.annotations.Test;

import com.qa.rediff.basetest.BaseTest;
import com.qa.rediff.pages.RediffHomePage;
import com.qa.rediff.utilities.TestUtility;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CreateAccountPageTest extends BaseTest{

	
	@Test(priority=6,dataProviderClass=TestUtility.class,dataProvider="dp")
	@Description("Test Description:This is to validate the create account functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("Epic-3")
	@Feature("Feature-3")
	@Story("Story-3")
	public void createAccountTest(String fullname,String emailaddress,String pass,String repassword,String altemail)
	{
		//throw new SkipException("Test case skipped");
		page.getInstance(RediffHomePage.class).navigateToCreateAccountPage().enterDetails(fullname, emailaddress, pass, repassword, altemail);
		
	}
	
}
