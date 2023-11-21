package com.lume.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.luma.testbase.TestBase;

public class ShopYogaPage extends TestBase{
	
	@FindBy(xpath="//meta[@name='title']")
	WebElement title;
	
	@FindBy(id = "sorter")
	WebElement sort;
	
	Select sorting;
	
	public ShopYogaPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public String validateSorting()
	{
		 sorting = new Select(sort);
		String selectOption = sorting.getFirstSelectedOption().getText();
		return selectOption;
	}
	
	public void change_sorting()
	{
		sorting.selectByVisibleText("Product Name ");
	}

	
}
