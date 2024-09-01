\ackage com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass
{
	@Test(groups="smokeTest")
	public void contactTest() throws Throwable
	{
		String lastName=eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();
		cp.getContactTxtFld().sendKeys(lastName);
		cp.getSaveContactBtn().click();
		String actHeader = cp.getHdrMsg().getText();
		//Hard Assert
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		//soft Assert
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(lastName, actHeader);
//		System.out.println("Step1");
//		System.out.println("Step2");
//		sa.assertAll();
	

		
	}

}
