package practice.program;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMethodTest 
{
	@Test(dataProvider = "getData")
	public void getElement(String brandName,String productName)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(brandName,Keys.ENTER);
		String price=driver.findElement(By.xpath("//div[.='"+productName+"']/../../div[2]/div[1]/div[1]/div[1]")).getText();
		System.out.println(price);
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][2];
		objArr[0][0] ="iphone";
		objArr[0][1] ="Apple iPhone 15 (Black, 256 GB)";
		
		objArr[0][0] ="iphone";
		objArr[0][1] ="Apple iPhone 15 (Blue, 128 GB)";
		
		objArr[0][0] ="iphone";
		objArr[0][1] ="Apple iPhone 15 (Pink, 128 GB)";
		
		return objArr;

	}
	

}
