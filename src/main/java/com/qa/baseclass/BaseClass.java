/*
 * @Author Mahesh Nellore
 */
package com.qa.baseclass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
public class BaseClass {
	
	public static WebDriver driver;

	
	public static void precondition(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
			
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://www.freecrm.com");
		 driver.manage().window().maximize();
		 waitForPageLoad();
	}
	
	public void waitmethod() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void waitForPageLoad() {
		Reporter.log("Wait for few seconds let the page to be loaded successfully.............",true);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}

}
