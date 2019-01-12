package com.qa.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.baseclass.BaseClass;
import com.qa.pages.LoginPage;


public class LoginTest extends BaseClass{
	
	LoginPage loginpage;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		precondition(browser);
		loginpage = new LoginPage();
	}
	@Test
	public void verifyLogin() {
		
		loginpage.getTitle();
		loginpage.login("maheshn", "test@123");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
