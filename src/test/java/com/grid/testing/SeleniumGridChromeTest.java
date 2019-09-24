package com.grid.testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGridChromeTest {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void initializeTest() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);
		
		String hubUrl="http://192.168.0.103:4444/wd/hub";
		driver=new RemoteWebDriver(new URL(hubUrl),options); //here we can also give capability cap instead of chromeoptions and still it will run
		
		
	}
	@Test
	public void addTest()
	{
		driver.get("https://www.guru99.com/introduction-to-selenium-grid.html");
		System.out.println(driver.getTitle());
	}
	@AfterTest
	public void finalizeTest()
	{
		driver.close();
	}
}
