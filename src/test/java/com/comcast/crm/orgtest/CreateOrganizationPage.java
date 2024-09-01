package com.comcast.crm.orgtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.listener.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners(com.comcast.crm.listener.ListImpClass.class)
public class CreateOrganizationPage extends BaseClass
{
	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable
	{
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to org link");
		hp.getOrgLink().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,orgName+" "+ "Navigate to Create org link");
		cnop.createOrg(orgName);
		Thread.sleep(2000);
	}
	

	@Test(groups= {"regressionTest"})
	public void orgWithIndustryTest() throws Throwable
	{
			String orgName = eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
			String industryName = eLib.getDataFromExcel("org", 4, 3);
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrgWithIndustry(orgName, industryName);
			Thread.sleep(2000);
	}
	
	@Test(groups="regressionTest")
	public void orgWithPhone() throws Throwable {

		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String industryName = eLib.getDataFromExcel("org", 4, 3);
		String phone = eLib.getDataFromExcel("org", 7, 3).toString();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createNewOrgWithPhone(orgName, industryName, phone);
		Thread.sleep(2000);
	}

}
