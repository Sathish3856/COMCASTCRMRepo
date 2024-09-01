package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage 
{
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactBtn;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement contactTxtFld;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveContactBtn;
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement searchOrgBtn;
	
	//child tab of org in contact module
	@FindBy(name="search_text")
	private WebElement orgTxtFld;
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement inDrpDwn;
	@FindBy(xpath="//input[@name='search']")
	private WebElement srchNowBtn;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	WebElement hdrMsg;
	WebDriver driver;
	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getContactTxtFld() {
		return contactTxtFld;
	}

	public WebElement getSaveContactBtn() {
		return saveContactBtn;
	}

	public WebElement getSearchOrgBtn() {
		return searchOrgBtn;
	}
	

	public WebElement getOrgTxtFld() {
		return orgTxtFld;
	}

	public WebElement getInDrpDwn() {
		return inDrpDwn;
	}

	public WebElement getSrchNowBtn() {
		return srchNowBtn;
	}
	


	public WebElement getHdrMsg() {
		return hdrMsg;
	}

	
	public void selectDDforOrgChild()
	{
		Select select = new Select(inDrpDwn);
		select.selectByIndex(0);
	}
	
	
	public void createContact(String lastName)
	{
		createContactBtn.click();
		contactTxtFld.sendKeys(lastName);
		saveContactBtn.click();
	}
}
