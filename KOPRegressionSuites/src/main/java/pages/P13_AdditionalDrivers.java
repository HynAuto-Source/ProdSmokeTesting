package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P13_AdditionalDrivers extends KMABase {
	

	
	public P13_AdditionalDrivers(WebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver = driver;
		this.test =test;
		if(!verifyTitle("Welcome")){
			reportStep("This is not Welcome Page", "FAIL");	
		}		
	}
	
	
	public P13_AdditionalDrivers addSecondaryDriver(String secondaryDriverEmailId ) {
		waitUntilElementVisisble("//*[@title='ADD DRIVER']");
		clickByXpathJavascriptExecutor("//*[@title='ADD DRIVER']");
		waitUntilElementVisisble("//*[text()='ADD DRIVER']");
		enterByXpath("(//*[@name='newDriverEmail'])[2]", secondaryDriverEmailId);
		waitUntilElementVisisble("//*[@id='addDriverbtn']");
		clickByXpath("//*[@id='addDriverbtn']");
		waitUntilElementVisisble("(//*[text()='CANCEL'])[2]");
		clickByXpath("(//*[@class='checkmark'])[4]");
		clickByXpath("(//*[@class='checkmark'])[5]");
		clickByXpath("(//*[@class='checkmark'])[6]");
		clickByXpath("(//*[@class='checkmark'])[7]");
		clickByXpath("(//*[@class='checkmark'])[8]");
		waitUntilElementVisisble("//*[text()='SEND REQUEST']");
		clickByXpathJavascriptExecutor("//*[text()='SEND REQUEST']");
		waitUntilElementVisisble("//*[text()='prodauto1@mailinator.com']");
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='prodauto1@mailinator.com']")).isDisplayed());
		waitElementToBeClickableXpathFW();
		return this;
	}
	

	
	public P2_Login clickLogoutAD() throws InterruptedException {
		waitUntilElementVisisble("(//*[text()='Log Out'])[2]");
		clickByXpath("(//*[text()='Log Out'])[2]");
		return new P2_Login(driver, test);
	}
	
	public P13_AdditionalDrivers verifyTheLinkedDriver() {
		waitUntilElementVisisble("(//*[@class='additional-driver-tab'])[2]");
		clickByXpathJavascriptExecutor("(//*[@class='additional-driver-tab'])[2]");
		waitUntilElementVisisble("//*[contains(text(),'prodauto1@mailinator.com')]");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'prodauto1@mailinator.com')]")).isDisplayed());		
		return this;
	}
	

	
	
	
	//SC request to Primary Driver: 
	
	public P13_AdditionalDrivers secondaryDriverAddVehicle(String enterVIN, String vehicleModel) throws InterruptedException {
		waitUntilElementVisisble("//*[@class='button dark-icon less-padding desktop dtmAddVehicle']");
		clickByXpath("//*[@class='button dark-icon less-padding desktop dtmAddVehicle']");
		waitElementToBeClickableXpathFW();
		enterByXpath("//*[@id='add-my-vehicle-slider']/div/div[1]/app-add-vehicle-modal/div/div/form/ul/li/span/input", enterVIN);
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[contains(text(),'Verify VIN')]");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[contains(text(),' Save and Close')]");
		waitUntilElementVisisble("(//*[contains(text(),'My TELLURIDE')])[1]");
		pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel, "//*[@title='TELLURIDE']");   
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		clickByXpath("//*[contains(text(),'Request Access?')]");
		waitUntilElementVisisble("//*[contains(text(),'ACCEPT VEHICLE ACCESS')]");
		clickByXpath("(//*[@class='checkmark'])[1]");
		clickByXpath("(//*[@class='checkmark'])[2]");
		clickByXpath("//*[contains(text(),'SEND REQUEST')]");
		waitUntilElementVisisble("//*[@class='icon-info']");
		return this;
	}		
	
	
	
	public P13_AdditionalDrivers sdRequestAcceptedByPrimaryDriver() throws InterruptedException {
		
		
		//waitUntilElementVisisble("//*[@title='ADD DRIVER']");
		clickByXpathJavascriptExecutor("//*[@title='ACCEPT']");
		//clickByXpath("//*[@title='ACCEPT']");
		//clickByXpath("//*[@id=\"additional-driver-view\"]/additional-drivers/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]");
		waitUntilElementVisisble("(//*[contains(text(),'CANCEL')])[2]");
		clickByXpath("(//*[@class='checkmark'])[4]");
		clickByXpath("(//*[@class='checkmark'])[5]");
		clickByXpath("(//*[@class='checkmark'])[6]");
		clickByXpath("(//*[@class='checkmark'])[7]");		
		clickByXpath("(//*[@class='checkmark'])[8]");
		waitUntilElementVisisble("//*[contains(text(),'YES, I AGREE')]");
		clickByXpath("//*[contains(text(),'YES, I AGREE')]");
		waitUntilElementVisisble("//*[contains(text(),'Linking in Progress')]");		
		return this; 
	}
	
	
	
	public P13_AdditionalDrivers unlinkTheSDAccount() {
	clickByXpath("//*[@title='UNLINK']");
	//waitUntilElementVisisble("//*[contains(text(),'Un-Linking in Progress')]");
	return this; 
}
	
	public P13_AdditionalDrivers deleteTheSCDriversAccountByPrimaryDriver() {
		clickByXpath("//*[@title='DELETE']");
		return this;
	}
	

/*	public P13_AdditionalDrivers requestAcceptByPrimaryDriver() { 
		waitUntilElementVisisble("//*[@title='ADD DRIVER']");
		clickByXpathWithCondition(status, xpathVal);
		return this;
	}*/


/*clickByXpathJavascriptExecutor("//*[@title='ADD DRIVER']");
waitUntilElementVisisble("//*[text()='ADD DRIVER']");	
enterById("txtEmail", secondaryDriverEmailID );
clickById("addDriverbtn");
waitUntilElementVisisble("//*[text()='Kia Connect Terms of Service Agreement']");
clickByXpathJavascriptExecutor("(//*[@class='checkmark'])[3]");
clickByXpathJavascriptExecutor("(//*[@class='checkmark'])[4]");
clickByXpathJavascriptExecutor("(//*[@class='checkmark'])[5]");
clickByXpathJavascriptExecutor("(//*[@class='checkmark'])[6]");
clickByXpathJavascriptExecutor("//*[text()='SEND REQUEST']");*/
	
	
	//-------------------------------------------------
	
	public P13_AdditionalDrivers verifyAcceptAndRejectLink() {
		waitUntilElementVisisble("//span[normalize-space()='ACCEPT']");
		if (driver.findElement(By.xpath("//span[normalize-space()='ACCEPT']")).isDisplayed()) {
			reportStep("As expected, accept link is displayed in driver's account", "Pass");
		}else {
			reportStep("Accept link is not displayed", "Fail");
		}
		if (driver.findElement(By.xpath("//span[normalize-space()='REJECT']")).isDisplayed()) {
			reportStep("As expected, REJECT link is displayed in driver's account", "Pass");
		}else {
			reportStep("REJECT link is not displayed", "Fail");
		}
		return this;
	}
	
	public P13_AdditionalDrivers verifyDeleteAndCancelButtonIsDisabled() {
		waitUntilElementVisisble("//*[normalize-space()='DELETE']");
		if (!driver.findElement(By.xpath("//*[normalize-space()='DELETE']")).isEnabled()) {
			reportStep("As expected, Delete button is diabled", "Pass");
		}else {
			reportStep("Delete button is enable", "Fail");
		}
		if (driver.findElement(By.xpath("//*[normalize-space()='CANCEL']")).isDisplayed()) {
			reportStep("As expected, Cancel button is disabled", "Pass");
		}else {
			reportStep("Cancel button is not enable", "Fail");
		}
		return this;
	}
	
	public P13_AdditionalDrivers verifyDeleteAndAuthorizedButtonIsDisabledPostReject() {
		waitUntilElementVisisble("//*[normalize-space()='DELETE']");
		if (!driver.findElement(By.xpath("//*[normalize-space()='DELETE']")).isEnabled()) {
			reportStep("As expected, Delete button is diabled", "Pass");
		}else {
			reportStep("Delete button is enable", "Fail");
		}
		if (driver.findElement(By.xpath("//*[normalize-space()='AUTHORIZED']")).isDisplayed()) {
			reportStep("As expected, authurized button is disabled", "Pass");
		}else {
			reportStep("Cancel button is not enable", "Fail");
		}
		return this;
	}
	
	
	public P13_AdditionalDrivers clickAndVerifyAcceptLink() {
		waitUntilElementVisisble("//span[normalize-space()='ACCEPT']");
		clickByXpathJavascriptExecutor("//span[normalize-space()='ACCEPT']");
		clickByXpath("//span[normalize-space()='REQUEST 2']");
		clickByName("isTOSChecked");
		clickByName("geoLocationChecked");
		clickByName("isTOUChecked");
		clickByXpathJavascriptExecutor("//span[normalize-space()='LINK ACCOUNT']");
		clickByXpath("//button[normalize-space()='Account']");
		clickByXpath("//a[@id='account-logout']");
		waitUntilElementVisisble("//*[text()=' SIGN IN ']");
		return this;
	}
	
	public P13_AdditionalDrivers clickAndVerifyRejectLink() {
		waitUntilElementVisisble("//span[normalize-space()='REJECT']");
		clickByXpathJavascriptExecutor("//span[normalize-space()='REJECT']");
		waitUntilElementVisisble("//strong[@normalize-space='Unlinking in progress']");
		reportStep("As expected,status change into unlinking in progress", "Pass");
		clickByXpath("//button[normalize-space()='Account']");
		clickByXpath("//a[@id='account-logout']");
		waitUntilElementVisisble("//*[text()=' SIGN IN ']");
		return this;
	}
	
	public P13_AdditionalDrivers verifyStatusWhileAcceptingLink() {
		waitUntilElementVisisble("//span[normalize-space()='ACCEPT']");
		if (driver.findElement(By.xpath("//*[normalize-space()='STATUS']//following::span")).isDisplayed()) {
			getTextByXpath("//*[normalize-space()='STATUS']//following::span");
		}else {
			reportStep("Failed to accept link", "Fail");
		}
		
		return this;
	}
}