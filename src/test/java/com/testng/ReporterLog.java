package com.testng;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterLog 
{
	@Test
	public void reporterLog1(Method mtd)
	{
		System.out.println(mtd.getName());
		Reporter.log("step1",true);		
		Reporter.log("step2",true);
		Reporter.log("step3",true);
		Reporter.log("step4",true);
		Reporter.log("step5",true);
		Reporter.log("step6",true);
		Reporter.log("step7",true);

	}
	
	@Test
	public void reporterLog2(Method mtd)
	{
		System.out.println(mtd.getName());
		Reporter.log("step1",true);		
		Reporter.log("step2",true);
		Reporter.log("step3",true);
		Reporter.log("step4",true);
		Reporter.log("step5",true);
		Reporter.log("step6",true);
		Reporter.log("step7",true);
		

	}

}
