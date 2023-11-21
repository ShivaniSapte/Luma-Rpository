package com.luma.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.luma.testbase.TestBase;
import com.lume.pages.HomePage;
import com.lume.pages.ShopYogaPage;

public class ShopYogaTest extends TestBase{

	HomePage hmp;
	ShopYogaPage syp;
	
	public ShopYogaTest()
	{
		super();
	}
	
	@BeforeClass
	public void steup() throws Exception
	{
		Thread.sleep(3000);
		initialization();
		hmp = new HomePage();
		syp = new ShopYogaPage();
	}
	
	@Test(priority = 1)
	public void sortValidation()
	{
		hmp.shopYoga();
		syp.validateSorting();
		Assert.assertEquals("Position", syp.validateSorting(), "Not matching option");
	}
	
	@Test(priority = 2)
	public void changeSorting() throws Exception
	{
		syp.change_sorting();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
