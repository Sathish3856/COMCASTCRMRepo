package com.testng;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;

public class InvoiceTestForRetryAnalyzer extends BaseClass
{
	@Test(retryAnalyzer = com.testng.RetryAnalyzer.class)
	public void createInvoiceTest()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, " ");
		System.out.println("Step4");
		System.out.println("Step5");
	}

	
	@Test(retryAnalyzer = com.testng.RetryAnalyzer.class)
	public void createInvoiceTest1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");

}

}
