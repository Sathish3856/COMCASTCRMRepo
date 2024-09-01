package practice.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RetryImpClass implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult result) 
	{
		int count = 0;
		int upperLimit = 4;
		if(count<upperLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
