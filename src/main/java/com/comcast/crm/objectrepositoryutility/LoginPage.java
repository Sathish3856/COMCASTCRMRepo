package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genericwebdriverutility.WebDriverUtility;

/**
 * @author sathish
 * 
 * 
 * contains login page elements and business libraries
 */
public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	// Rule2:object creation
	@FindBy(name = "user_name")
	private WebElement usernameedt;
	@FindBy(name = "user_password")
	private WebElement passwordedt;
	@FindBy(id = "submitButton")
	private WebElement Loginbtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}

	/**
	 * login to application based on username,password,and url arguments
	 * 
	 * @author sathish
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password) {

		usernameedt.sendKeys(username);
		passwordedt.sendKeys(password);
		Loginbtn.click();

	}

}
