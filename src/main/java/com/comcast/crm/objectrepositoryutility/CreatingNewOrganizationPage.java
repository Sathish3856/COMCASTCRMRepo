package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage 
{
	WebDriver driver;
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement createOrgPlus;
	@FindBy(xpath="//input[@name='accountname']")
	WebElement orgNameTxtField;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	WebElement saveOrgBtn;
	@FindBy(name="industry")
	private WebElement industryDd;
	@FindBy(id="phone")
	private WebElement phoneTxtFld;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement orgsaveBtn;
	
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getCreateOrgPlus() {
		return createOrgPlus;
	}

	public WebElement getOrgNameTxtField() {
		return orgNameTxtField;
	}

	public WebElement getSaveOrgBtn() {
		return saveOrgBtn;
	}

	public WebElement getIndustryDd() {
		return industryDd;
	}


	public WebElement getPhoneTxtFld() {
		return phoneTxtFld;
	}


	public WebElement getOrgsaveBtn() {
		return orgsaveBtn;
	}



	public void createOrg(String orgName)
	{
		createOrgPlus.click();
		orgNameTxtField.sendKeys(orgName);
		saveOrgBtn.click();
		
	}
	public void createOrgWithIndustry(String orgName,String industry)
	{
		createOrgPlus.click();
		orgNameTxtField.sendKeys(orgName);
		Select select = new Select(industryDd);
		select.selectByVisibleText(industry);
		orgsaveBtn.click();
	}
	public void createNewOrgWithPhone(String orgName,String industry,String phone)
	{
		createOrgPlus.click();
		orgNameTxtField.sendKeys(orgName);
		Select select = new Select(industryDd);
		select.selectByVisibleText(industry);
		phoneTxtFld.sendKeys(phone);
		orgsaveBtn.click();
	}
		
	}
	

