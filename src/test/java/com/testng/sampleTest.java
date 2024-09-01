package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class sampleTest extends BaseClass
{
	@Test(retryAnalyzer =com.testng.RetryAnalyzer.class )
	public void executeRetry()
	{
		Assert.assertEquals("a", "b");
	}

}
