package Dealership;

/**
 * BlackPurl Automation
 * Creation date 17-nov-2021
 * By Sparsh Shrivastava
 */

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.*;
import org.testng.Reporter;

@Listeners(Dealership.Listeners.class)

public class Masterdata extends POM {
	
	@Test
	public static void AddCustomer() throws Exception
	{

		Assert.assertTrue(true);
		
	}
	
	@Test
	public static void Test2() throws IOException, InterruptedException
	{
			 
		driver.get("https://www.facebook.com");
		
	    Assert.assertEquals("sdasd", "1234");
	    
	    
	}
	
}
