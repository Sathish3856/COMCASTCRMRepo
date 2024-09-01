package com.comcast.crm.listener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) 
	{

   	 //spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
  		spark.config().setDocumentTitle("CRM test suite results");
  		spark.config().setReportName("CRM report");
  		spark.config().setTheme(Theme.DARK);
  		
  		//add Environment information & create Test
  		reports = new ExtentReports();
  		reports.attachReporter(spark);
  		reports.setSystemInfo("OS", "windows-10");
  		reports.setSystemInfo("Browser", "Chrome-10");
  			}

	@Override
	public void onFinish(ISuite suite) 
	{
		System.out.println("Report Backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===================>"+result.getMethod().getMethodName()+"<============START===================");
		//create the test on extentreport
		test=reports.createTest(result.getMethod().getMethodName());
		//setting test to use multiple threads to do cross browser testing
		UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==> Started <==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//also take screenshot on success test script
		System.out.println("===================>"+result.getMethod().getMethodName()+"<============END===================");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"==> Completed <==");

		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		  String testName = result.getMethod().getMethodName();
		  TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		  String filePath = ts.getScreenshotAs(OutputType.BASE64);
		  String time = new Date().toString().replace(" ", "_").replace(":", "_");
		  test.addScreenCaptureFromBase64String(filePath,testName+" "+time);
		  test.log(Status.FAIL, result.getMethod().getMethodName()+"==> Failure <==");

	 }

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 test.log(Status.SKIP, result.getMethod().getMethodName()+"==> Started <==");

		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//save the report in Extent report
		reports.flush();
		
	}
	

}
