package com.comcast.crm.orgtest;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericfileutility.ExcelUtility;
import com.comcast.crm.genericfileutility.FileUtility;
import com.comcast.crm.genericwebdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateOrganizationTest {

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
		
		//step1:login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		//Step2:navigate to navigation module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3:click on create organization button
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization...')]")).click();
		
		//step4:create organization and enter all the details from the excel
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verify header msg expected result
		String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName))
		{
			System.out.println(orgName+"is created==pass");
		}
		else
		{
			System.out.println(orgName+"is not created==fail");
		}
		//verify header orgname info excpected result
		String actualResult=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actualResult.equals(orgName)) 
		{
			System.out.println(orgName+"is created==pass");
		}
		else
		{
			System.out.println(orgName+"is not created==fail");
		}
		//step5:logout
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[(@src='themes/softed/images/user.PNG')]"))).perform();
		
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.quit();
		

	}

}
