package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule1:create a separate a java class
{
	WebDriver driver;
	//Rule2:object creation
	@FindBy(name="user_name")
	private WebElement usernameedt;
	@FindBy(name="user_password")
	private WebElement passwordedt;
	@FindBy(id="submitButton")
	private WebElement Loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement getUsernameedt() {
		return usernameedt;
	}
	
	public WebElement getPasswordedt() 
	{
		return passwordedt;
	}
	
	public WebElement getLoginbtn() 
	{
		return Loginbtn;
	}
	
	//Business Library
	public void loginToApp(String username,String password)
	{
		driver.manage().window().maximize();
		usernameedt.sendKeys(username);
		passwordedt.sendKeys(password);
		Loginbtn.click();
	
	}
	
	
	

}
