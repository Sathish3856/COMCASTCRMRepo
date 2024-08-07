package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationForDynamicElementsInPom 
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{	
	//utility	
	FileUtility fu = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	
	String browser = fu.getDataFromPropertiesFile("browser");
	String url = fu.getDataFromPropertiesFile("url");
	String username = fu.getDataFromPropertiesFile("username");
	String password = fu.getDataFromPropertiesFile("password");
	String orgName = eu.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
	System.out.println(orgName);
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
	
	wlib.waitForPageLoad(driver, 10);
	driver.manage().window().maximize();
	driver.get(url);
	//objectRepository
	LoginPage lp = new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	OrganizationsPage op = new OrganizationsPage(driver);
	CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver); 

	lp.loginToApp(username, password);
	hp.getOrgLink().click();
	cnop.createOrg(orgName);
	Thread.sleep(3000);
	hp.getOrgLink().click();
	op.getSearchTxtBox().sendKeys(orgName);
	wlib.select(op.getSearchDD(),1);
	op.getSearchButton().click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[2]")).click();
	wlib.switchToAlertAndAccept(driver);
	hp.logout();
	driver.quit();
	}

}
