package com.testng;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert 
{

	
	@Test
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName());
		System.out.println("Step1");
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals("Home", "home1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
		System.out.println("Step7");
		assertObj.assertAll();
		

		
	}
	
	@Test
	public void homePageTest1(Method mtd)
	{
		System.out.println(mtd.getName());
		System.out.println("Step1");
		Assert.assertEquals("Home", "Home");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
		System.out.println("Step7");
		

		
	}

}
