package com.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listener.ListImpClass.class)
public class  InvoiceTest extends BaseClass
{
	
	@Test
	public void CreateInvoiceTest()
	{
		System.out.println("execute CreateInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");

	}
	
	@Test
	public void createContactTest(Method mtd)
	{
		System.out.println("execute"+mtd.getName()+"");
		System.out.println("Step 1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");

	}

}
