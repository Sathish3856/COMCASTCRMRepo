package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	WebDriver driver;
	@FindBy(className="dvHeaderText")
	private WebElement headermsg ;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeadermsg() 
	{
		return headermsg;
	}
	
	
	

}
