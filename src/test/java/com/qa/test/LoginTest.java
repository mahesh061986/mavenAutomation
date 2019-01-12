/*
 * @Author Mahesh Nellore
 */
package com.qa.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


public class LoginTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		precondition(browser);
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	@Test
	public void verifyLogin() {
		
		String loginPageTitle = loginpage.getTitle();
		loginpage.login("maheshn", "test@123");
		homepage.logout();
		Assert.assertEquals(driver.getTitle(), loginPageTitle);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
