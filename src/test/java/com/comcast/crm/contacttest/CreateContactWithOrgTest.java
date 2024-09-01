package com.comcast.crm.contacttest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithOrgTest extends BaseClass
{
	@Test
	public void contactWithOrg() throws Throwable
	{
		String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.getCreateOrgPlus().click();
		cnop.getOrgNameTxtField().sendKeys(orgName);
		cnop.getOrgsaveBtn().click();
		Thread.sleep(2000);
		String lastName=eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
		hp.getContactLink().click();
		wLib.switchNewBrowserTabOnTitle(driver, "module=Accounts");
		ContactPage cp = new ContactPage(driver); 
		cp.getCreateContactBtn().click();
		cp.getContactTxtFld().sendKeys(lastName);
		cp.getSearchOrgBtn().click();
		String parentUrl = driver.getCurrentUrl();
		System.out.println(parentUrl);
		Thread.sleep(3000);
		wLib.switchNewBrowserTabOnTitle(driver, "Administrator - Contacts");
		String childUrl = driver.getCurrentUrl();
		System.out.println(childUrl);
		cp.getOrgTxtFld().sendKeys(orgName);
		cp.selectDDforOrgChild();
		cp.getSrchNowBtn().click();
		wLib.switchNewBrowserTabOnTitle(driver, "module");
		

	}
	
}
