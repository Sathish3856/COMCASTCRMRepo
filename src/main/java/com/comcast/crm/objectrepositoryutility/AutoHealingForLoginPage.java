package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AutoHealingForLoginPage 
{
	WebDriver driver;
	@FindBy(name="user_name")
	WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
//	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type=\\\"submit\\\"]")})
//	WebElement ele3;
	@FindBys({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type=\"submit\"]")})
	WebElement ele3;
	
	public AutoHealingForLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginPage(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		ele3.click();
		driver.quit();
	}

}
