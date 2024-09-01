package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	private WebDriver driver;
	@FindBy(xpath="(//a[.='Organizations'])[1]")
	private WebElement orgLink;
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	@FindBy(linkText="More")
	private WebElement moreLink;
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getMoreLink() 
	{
		return moreLink;
	}

	public WebElement getCampaignLink() 
	{
		return campaignLink;
	}


	
	public WebElement getOrgLink() 
	{
		return orgLink;
	}
	
	public WebElement getContactLink() 
	{
		return contactLink;
	}
	
	public void navigateToCampaginPage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void logout()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(adminImage).perform();
		signOutLink.click();
	}
	
	

}
