package com.qa.rediff.testcases;

import org.testng.annotations.Test;

import com.qa.rediff.basetest.BaseTest;
import com.qa.rediff.pages.RediffHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SignInPageTest extends BaseTest{
	
	
	@Test(priority=7,dataProviderClass=com.qa.rediff.utilities.TestUtility.class,dataProvider="dp")
	@Description("Test Description:This is to validate the sign in functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("Epic-2")
	@Feature("Feature-2")
	@Story("Story-2")
	public void signInTest(String username,String password)
	{
		page.getInstance(RediffHomePage.class).navigateTosignInPage().enterCredentials(username, password);
		
		
	}
	

}
