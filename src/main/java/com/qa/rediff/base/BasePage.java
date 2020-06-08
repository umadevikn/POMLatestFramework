package com.qa.rediff.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(WebElement header) {
		
		return header.getText();
	}

	@Override
	public void waitForElement(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	@Override
	public void clickOnElement(WebElement element) {
		element.click();
		
	}

	@Override
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
		
	}

	@Override
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

}
