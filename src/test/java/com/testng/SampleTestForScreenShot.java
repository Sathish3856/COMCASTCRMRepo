package com.testng;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class SampleTestForScreenShot 
{

	@Test
	public void amazonTest() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  ts.getScreenshotAs(OutputType.FILE);
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  File destination = new File("./screenshot/ss.png");
		  FileHandler.copy(source, destination);
		  
	}
	
}
