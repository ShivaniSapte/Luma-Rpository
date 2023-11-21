package com.lume.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.testbase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(name = "title")
	WebElement title;
	
	@FindBy(xpath = "//a[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath = "//*[@class = 'action more button']")
	WebElement shopYoga;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() throws Exception
	{
		Thread.sleep(3000);
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		Boolean p = logo.isDisplayed();
		return p;
	}

	public ShopYogaPage shopYoga()
	{
		shopYoga.click();
		return new ShopYogaPage();
	}
}
