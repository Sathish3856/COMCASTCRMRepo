package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	@FindBy(name="search_text")
	private WebElement searchTxtBox;
	@FindAll({@FindBy(xpath="//select[@id='bas_searchfield']"),@FindBy(xpath="//select[@name='search_field']")})
	private WebElement SearchDD;
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchButton;
	@FindBy(xpath="//a[text()='Organization Name']/../../..//tr[@bgcolor='white']//td[3]//a")
	private WebElement actualOrgName;
	@FindBy(xpath="//img[contains(@title,'Create Organization...')]")
	WebElement createOrgLink;
	@FindBy(name="accountname")
	WebElement createOrgTxtField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement orgSaveBtn;
	
	
	public OrganizationsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchButton() 
	{
		return searchButton;
	}

	public WebElement getcreateNewOrgBtn()
	{
		return createNewOrgBtn;
	}


	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}



	public WebElement getSearchDD() {
		return SearchDD;
	}
	

	public WebElement getActualOrgName() {
		return actualOrgName;
	}
	
	public WebElement getCreateOrgTxtField() {
		return createOrgTxtField;
	}

	public WebElement getOrgSaveBtn() {
		return orgSaveBtn;
	}
	
	
	

}
