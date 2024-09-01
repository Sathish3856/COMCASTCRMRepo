package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listener.ListImpClass.class)
public class SampleTest extends BaseClass
{
	@Test
	public void createSanpleTest()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		String title = driver.getCurrentUrl();
		System.out.println("Step3");
		Assert.assertEquals("login", title);
		
}

}
