package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom 
{
		@FindBy(name="user_name")
		WebElement ele1;
		@FindBy(name="user_password")
		WebElement ele2;
		@FindBy(id="submitButton")
		WebElement ele3;
		@Test
	public void sampleTest() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
	 	SampleTestWithPom s = PageFactory.initElements(driver, SampleTestWithPom.class);
	 	s.ele1.sendKeys("admin");
 	    s.ele2.sendKeys("admin");
 	    driver.navigate().refresh();
 	    Thread.sleep(3000);
	    s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		s.ele3.click();
		driver.quit();
	}
	

}
