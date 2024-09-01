package com.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTestJava 
{
	ExtentReports reports;
	
	@BeforeSuite
      
       public void configBs()
       {
    	 //spark report config
   		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
   		spark.config().setDocumentTitle("CRM test suite results");
   		spark.config().setReportName("CRM report");
   		spark.config().setTheme(Theme.DARK);
   		
   		//add Environment information & create Test
   		reports = new ExtentReports();
   		reports.attachReporter(spark);
   		reports.setSystemInfo("OS", "windows-10");
   		reports.setSystemInfo("Browser", "Chrome-10");
   		
   		
   		
   	}

		
	
	@Test
	public void createContactTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot eDriver = (TakesScreenshot)driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = reports.createTest("Create Contact Test");
   		test.log(Status.INFO, "Login to app");
   		test.log(Status.INFO, "Navigate to contact Page");
   		test.log(Status.INFO, "create contact");
   		if("Hdfc".equals("Hdfc"))
   		{
   			test.log(Status.PASS, "Contact is Created");
   		}
   		else
   		{
   			test.log(Status.FAIL, "Contact is not Created");
   			Assert.fail();
   			test.addScreenCaptureFromBase64String(filePath,"ErrorFile"); 
   		}
   		driver.quit();
   		
   	}
//		
//	@Test
//	public void createContactWithOrg()
//	{
//		ExtentTest test = reports.createTest("Create Contact with Org Test");
//   		test.log(Status.INFO, "Login to app");
//   		test.log(Status.INFO, "Navigate to contact Page");
//   		test.log(Status.INFO, "create contact");
//   		if("Hdfc".equals("Hdfc"))
//   		{
//   			test.log(Status.PASS, "Contact is Created");
//   		}
//   		else
//   		{
//   			test.log(Status.FAIL, "Contact is not Created");
//   		}
//	}
//	
//	@Test
//	public void createContactWithIndustry()
//	{
//		ExtentTest test = reports.createTest("Create Contact with Industry Test");
//   		test.log(Status.INFO, "Login to app");
//   		test.log(Status.INFO, "Navigate to contact Page");
//   		test.log(Status.INFO, "create contact");
//   		if("Hdfc".equals("Hdfc"))
//   		{
//   			test.log(Status.PASS, "Contact is Created");
//   		}
//   		else
//   		{
//   			test.log(Status.FAIL, "Contact is not Created");
//   		}
//		
//	}
	

	@AfterSuite
	public void cofigAs()
	{
		reports.flush();
   		
		
	}

}
