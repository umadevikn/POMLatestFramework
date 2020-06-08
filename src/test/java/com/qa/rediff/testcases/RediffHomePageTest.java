package com.qa.rediff.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.rediff.basetest.BaseTest;
import com.qa.rediff.pages.CreateAccountPage;
import com.qa.rediff.pages.RediffHomePage;
import com.qa.rediff.pages.SignInPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RediffHomePageTest extends BaseTest{
	
	
	@Test(priority=0,description="Validating the Home page logo",enabled=true)
	@Description("Test Description:This is to validate the presence of Home page logo.")
	@Severity(SeverityLevel.MINOR)
	@Epic("Epic-1")
	@Feature("Feature-1")
	@Story("Story-1")
	public void checkHomeLogoTest()
	{
		Assert.assertTrue(page.getInstance(RediffHomePage.class).checkHomeLogo(), "Home page logo is not displayed");
	}
	
	@Test(priority=1,description="Validate the page title")
	@Description("Test Description:This is to verify the home page title.")
	@Severity(SeverityLevel.MINOR)
	@Epic("Epic-1")
	@Feature("Feature-1")
	@Story("Story-1")
	public void getTitleTest()
	{
		String expected="Google";
		Assert.assertEquals(page.getInstance(RediffHomePage.class).getRediffHomePageTitle(), expected);
	}
	
	@Test(priority=2,description="Validate the availability of Sign In link",enabled=true)
	@Description("Test Description:This is to verify the availability of Sign In link")
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Epic-1")
	@Feature("Feature-1")
	@Story("Story-1")
	public void checkSignInLinkTest()
	{
		Assert.assertTrue(page.getInstance(RediffHomePage.class).checkSignInLink(), "Sign In link is not displayed");
	}
	
	@Test(priority=3,description="Validate the availability of Create Account link",enabled=true)
	@Description("Test Description:This is to verify the availability of Create Account link")
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Epic-1")
	@Feature("Feature-1")
	@Story("Story-1")
	public void checkCreateAccountLinkTest()
	{
		Assert.assertTrue(page.getInstance(RediffHomePage.class).checkCreateAccountLink(), "Create Account link is not displayed");
	}
	
	@Test(priority=4,description="Verify the navigation to Sign In page",enabled=true)
	@Description("Test Description:This is to verify the navigation to Sign In page")
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Epic-1")
	@Feature("Feature-1")
	@Story("Story-1")
	public void navigateToSignInPageTest()
	{
		SignInPage signin=page.getInstance(RediffHomePage.class).navigateTosignInPage();
		Assert.assertTrue(signin.checkSignInFields(),"Navigation to Sign In page failed.");
	}
	
	@Test(priority=5,description="Verify the navigation to Create Account page",enabled=true)
	@Description("Test Description:This is to verify the navigation to Create Account page")
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Epic-1")
	@Feature("Feature-1")
	@Story("Story-1")
	public void navigateToCreateAccountPageTest()
	{
		CreateAccountPage createaccount=page.getInstance(RediffHomePage.class).navigateToCreateAccountPage();
		Assert.assertTrue(createaccount.checkCreateAccountPageHeader(),"Navigation to Create Account page failed");
	}

}
