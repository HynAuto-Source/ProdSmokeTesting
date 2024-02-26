package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P1_CreateAccount extends KMABase {
	
	
	
	public P1_CreateAccount(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test =test;
		
		
		waitUntilElementVisisble("//*[@id='header-signIn']");
		if(!verifyTitle("Kia Owners Portal")){
			reportStep("This is not Kia Owners Portal", "FAIL");	
		}		
	}
	
		
		
		
		public P1_CreateAccount ClickTermsOfService() {
			clickByXpath("//*[text()='Terms of Service']");
			switchToLastWindow();
			Assert.assertEquals(driver.getTitle(), "Terms of Use & Service | Kia");
			return this;
		}
		
		
		public P1_CreateAccount clickPrivacyPolicy() {
			clickByXpath("(//*[text()='Privacy Policy'])[1]");
			switchToLastWindow();
			Assert.assertEquals(driver.getTitle(), "Privacy Policy | Kia");
			return this;
		}
	
//---------------------------------------------------------------------------------
	public P1_CreateAccount clickCreateAccountButton() {
		clickByXpath("//*[text()=' SIGN IN ']");
		clickByXpath("//*[@class='create-account-tab']");
		Assert.assertTrue(driver.findElement(By.id("resetIconClick")).isDisplayed());
		return this;
	}	
	
}
