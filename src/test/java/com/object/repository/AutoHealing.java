package com.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.objectrepositoryutility.AutoHealingForLoginPage;

public class AutoHealing {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		AutoHealingForLoginPage ah = new AutoHealingForLoginPage(driver);
		ah.loginPage("http://localhost:8888/");
		
	}

}
