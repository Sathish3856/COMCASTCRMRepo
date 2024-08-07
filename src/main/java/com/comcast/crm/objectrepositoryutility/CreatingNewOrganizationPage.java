package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage 
{
	WebDriver driver;
	@FindBy(xpath="//img[@title='Create Organization...']")
	WebElement createOrgPlus;
	@FindBy(xpath="//input[@name='accountname']")
	WebElement orgNameTxtField;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	WebElement saveOrgBtn;
	@FindBy(name="industry")
	private WebElement industryDd;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement orgsaveBtn;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	

	public void createOrg(String orgName)
	{
		createOrgPlus.click();
		orgNameTxtField.sendKeys(orgName);
		saveOrgBtn.click();
		
	}
	public void createOrgWithIndustry(String orgName,String industry)
	{
		orgNameTxtField.sendKeys(orgName);
		Select select = new Select(industryDd);
		select.selectByVisibleText(industry);
		orgsaveBtn.click();
	}
	
}
