package practice.program;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class TestCaseaboutAnnotationTest 
{
	@Test (invocationCount =10 )
	public void testCase1()
	{		System.out.println("Hi i am testcase 2");

	}
	
	@Test (enabled=false)
	public void testcase2()
	{
		System.out.println("Hi i am testcase 2");
	}
	
}
