package com.luma.testcase;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.luma.testbase.TestBase;
import com.lume.pages.HomePage;

public class HomPageTest extends TestBase{
	
	HomePage homepage;
	
	HomPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void steup() throws Exception
	{
		Thread.sleep(3000);
		initialization();
		homepage = new HomePage();
	}

	@Test(priority = 1)
	public void validateTitle() throws Exception
	{
		String title = homepage.validateTitle();
		Assert.assertEquals(title, "Home Page");
	}
	
	@Test(priority = 2)
	public void validateLogo()
	{
		boolean logo = homepage.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void shopYoga()
	{
		homepage.shopYoga();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
