package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath = "//input[contains(@value,'Login')]")
	public WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		Reporter.log("LoginPage Title:: "+driver.getTitle(),true);
		return driver.getTitle();
	}
	
	public void login(String uname, String pwd) {
		username.sendKeys(uname);
		Reporter.log("Entered Username :"+uname,true);
		password.sendKeys(pwd);
		Reporter.log("Entered Password:"+pwd,true);
		waitmethod();
		loginButton.click();
		Reporter.log("Clicked on Login Button",true);
	}
	

}
