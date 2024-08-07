package com.testng;

import org.testng.annotations.Test;

public class OrderTest 
{
	@Test
	public void createOrderTest() 
	{
		System.out.println("Execute the OrderTest");
		String data= null;
		System.out.println(data.equals("Hi"));
	}
	@Test(dependsOnMethods="createOrderTest")
	public void billingAnOrderTest()
	{
		System.out.println("Execute the billing order test");
	}

}
