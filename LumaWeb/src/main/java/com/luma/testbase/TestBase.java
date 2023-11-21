package com.luma.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("E:\\New folder\\Eclipse WS\\LumaWeb\\src\\main\\java\\com\\luma\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public void initialization()
	{
//		ExtentReports report = ExtentReports.start(ExtentReport.class);
//		report.init("myreport.html", true);
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\New folder\\Eclipse WS\\LumaWeb\\driver\\chromedriver.exe");
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
			 driver= new ChromeDriver(options);
		 }
		 else
			 System.out.println("Enter correct browser name");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
