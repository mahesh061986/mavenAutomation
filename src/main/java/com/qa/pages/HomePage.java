/*
 * @Author Mahesh Nellore
 */
package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.qa.baseclass.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	public WebElement contactsLable;
	
	@FindBy(xpath = "(//a[contains(@class,'topnavlink')])[3]/..//*[contains(text(),'Logout')]")
	public WebElement logoutButton;
	
	@FindBy(name="mainpanel")
	public WebElement mainpanelFrame;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		driver.switchTo().frame(mainpanelFrame);
		Reporter.log("Switched to MainPanel Frame",true);
		logoutButton.click();
		Reporter.log("Clicked on Logout Button", true);
		waitForPageLoad();
	}
}
