package com.vtiger.comcast.module;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganization
{

	

	public static void main(String[] args) throws IOException 
	{
		FileUtility fu = new FileUtility();
		JavaUtility jLib = new JavaUtility();

		String browser = fu.getDataFromPropertiesFile("browser");
		String url = fu.getDataFromPropertiesFile("url");
		String username = fu.getDataFromPropertiesFile("username");
		String password = fu.getDataFromPropertiesFile("password");
		
		ExcelUtility eu = new ExcelUtility();
		String orgName = eu.getDataFromExcel("org", 1, 3)+jLib.getRandomNumber();
		
		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		//login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		//click on create new organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getcreateNewOrgBtn().click();
		
		//enter all the details and click save
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		//verify header msg with excepted result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualHeaderMsg= oip.getHeadermsg().getText();
		if(actualHeaderMsg.contains(orgName)) 
		{
			System.err.println(orgName+" is displayed as expected");
		}
		else
		{
			System.out.println(orgName+" is not displayed as expected");
		}
		HomePage hp1 = new HomePage(driver);

		hp1.logout();
		driver.quit();
		
		
		
		
		
	}

}
