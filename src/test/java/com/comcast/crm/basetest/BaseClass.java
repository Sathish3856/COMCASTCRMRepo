package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericdatabaseutility.DataBaseUtility;
import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass
{
	public WebDriver driver;
	public static WebDriver sdriver;
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;

	

	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBs() throws SQLException
	{
		System.out.println("=Execution of Before Suite=");
		System.out.println("== connect to db ==");
		dLib.getDbConnection();
	}
	
	
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBc() throws IOException
	{
		System.out.println("== Execution of Before class ==");
		System.out.println("== Launch the Browser ==");
		String browser= fLib.getDataFromPropertiesFile("browser");
		
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
		driver.manage().window().maximize();
		wLib.waitForPageLoad(driver, 10);
		sdriver=driver;
		//setting driver to use multiple threads to do cross browser testing
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBm() throws Throwable
	{
		System.out.println("== Execution of Before Method ==");
		System.out.println("== Login ==");
		String username= fLib.getDataFromPropertiesFile("username");
		String password= fLib.getDataFromPropertiesFile("password");
		String url= fLib.getDataFromPropertiesFile("url");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);

	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAm()
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
		System.out.println("== Execution of After Method ==");
		System.out.println("== logout ==");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAc()
	{
		System.out.println("== Execution of After class ==");
		System.out.println("== Close the browser ==");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAs()
	{
		dLib.closeDbConnection();
		System.out.println("== Execution of After Suite ==");
		System.out.println("Close the db connection");
	}

}
