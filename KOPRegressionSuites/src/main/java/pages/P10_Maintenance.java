package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P10_Maintenance extends KMABase {

	public P10_Maintenance(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		waitUntilElementVisisble("//*[@id='maintenancetab']");
		if (!verifyTitle("Maintenance")) {
			reportStep("This is not Kia Owners Portal", "FAIL");
		}
	}
	
	public 	P10_Maintenance preferredDealer(String xpathValue, String dealerDetails) {
	waitUntilElementVisisble("(//*[@class='settings-icon'])[4]");
	clickByXpathJavascriptExecutor("(//*[@class='settings-icon'])[3]");
	waitUntilElementVisisble("//*[@name='dealer_map_search']");
	enterByXpathJSExecutor(xpathValue, dealerDetails);
	return this;
}


public P10_Maintenance nextServiceMiles(String expectedValue) {
	waitUntilElementVisisble("(//*[@class='settings-icon'])[4]");
	clickByXpath("(//*[@class='icon-arrow-right'])[1]");
	//Assert.assertTrue(driver.findElement(By.xpath("//*[@class='badge verified']")).isDisplayed());  //*[text()='22,500 miles']
	Assert.assertTrue(driver.findElement(By.xpath("//*[text()='30,000 miles']")).isDisplayed());
	//compareValues("//*[text()='30,000 miles']", expectedValue);
	return this;
}


public P10_Maintenance completeMilestone(String serviceLocation, String serviceNotes) {
	waitUntilElementVisisble("(//*[@class='settings-icon'])[3]");
	clickById("completeMilestone");
	enterByXpath("(//*[@id='serviceLocation'])[1]", serviceLocation);
	enterByXpath("(//*[@id='notes'])[1]", serviceNotes);
	clickByXpathJavascriptExecutor("(//*[contains(text(),'Save')])[1]");
	//clickByXpath("//*[@name='SAVE NOTE']");
	waitUntilElementVisisble("(//*[@class='close'])[10]");
	return this;
}


public P10_Maintenance updateMilestone(String serviceLocation, String serviceNotes) throws InterruptedException {
	waitUntilElementVisisble("(//*[@class='settings-icon'])[3]");
	clickByXpath("(//*[contains(text(),'History')])[1]");
	waitUntilElementVisisble("(//*[@class='print'])[1]");
	clickByXpath("//*[contains(text(),' COLLAPSE ALL ')]");
	//clickByXpath("(//*[@id='timeline-header-1']/span/text())[2]");
	waitUntilElementVisisble("(//*[contains(text(),'COMPLETE')])[3]");
	clickByXpath("(//*[contains(text(),'COMPLETE')])[3]");
	//scrollDownJavaScriptExecutor("(//*[contains(text(),'EDIT')])[2]");
	Thread.sleep(10000);
	waitUntilElementVisisble("(//*[contains(text(),'LOCATION')])[2]");
	scrollDownJavaScriptExecutor("(//*[contains(text(),'LOCATION')])[2]");
	clickByXpath("(//*[contains(text(),'EDIT')])[2]");
	waitUntilElementVisisble("(//*[@class='icon-close'])[5]");
	enterByXpath("(//*[@name='serviceLocation'])", serviceLocation);
	enterByXpath("(//*[@id='notes'])", serviceNotes);
	waitElementToBeClickableXpathFW();
	clickByXpath("//*[text()='UPDATE']");
	waitUntilElementVisisble("(//*[@class='print'])[1]");		
	return this;
}


public P10_Maintenance incompleteMilestone() throws InterruptedException {
	waitUntilElementVisisble("(//*[@class='settings-icon'])[3]");
	clickByXpath("(//*[contains(text(),'History')])[1]");
	waitUntilElementVisisble("(//*[@class='print'])[1]");
	clickByXpath("//*[contains(text(),' COLLAPSE ALL ')]");
	
	waitUntilElementVisisble("(//*[contains(text(),'COMPLETE')])[3]");
	clickByXpath("(//*[contains(text(),'COMPLETE')])[3]");
	Thread.sleep(10000);
	waitUntilElementVisisble("(//*[contains(text(),'LOCATION')])[2]");
	scrollDownJavaScriptExecutor("(//*[contains(text(),'LOCATION')])[2]");
	clickByXpath("(//*[contains(text(),'EDIT')])[2]");
	waitUntilElementVisisble("(//*[@class='icon-close'])[5]");
	waitElementToBeClickableXpathFW();
	clickByXpath("//*[contains(text(),'INCOMPLETE')]");
	waitUntilElementVisisble("(//*[@class='print'])[1]");		
	return this;
}


public P10_Maintenance chooseDealer(String dealerDetails, String dealerName) {
	waitUntilElementVisisble("//*[@title='Choose a Dealer']");
	clickByXpath("//*[@title='Choose a Dealer']");
	waitUntilElementVisisble("(//*[@class='icon-close'])[7]");
	enterByXpathJSExecutor("//*[@name='dealer_map_search']", dealerDetails);
	waitUntilElementVisisble("//*[contains(text(),'2.Garden Grove Kia ')]");
	chooseTheDealer("//*[@class='address']/strong", dealerName, "//*[contains(text(),'2.Garden Grove Kia ')]");
	waitUntilElementVisisble("//*[contains(text(),'Use this Dealer')]");
	clickByXpath("//*[contains(text(),'Use this Dealer')]");
	waitUntilElementVisisble("(//*[@class='close'])[10]");		
	return this;
}


public P10_Maintenance updateDealer(String dealerDetails, String dealerName) {
	waitUntilElementVisisble("//*[@title='Choose a Dealer']");
	clickByXpath("//*[@title='Choose a Dealer']");
	waitUntilElementVisisble("(//*[@class='icon-close'])[7]");
	enterByXpathJSExecutor("//*[@name='dealer_map_search']", dealerDetails);
	waitUntilElementVisisble("//*[contains(text(),'1.Kia of Irvine ')]");
	chooseTheDealer("//*[@class='address']/strong", dealerName, "//*[contains(text(),'1.Kia of Irvine ')]");
	waitUntilElementVisisble("//*[contains(text(),'Use this Dealer')]");
	clickByXpath("//*[contains(text(),'Use this Dealer')]");
	waitUntilElementVisisble("(//*[@class='close'])[10]");		
	return this;
}


public P10_Maintenance requestDealerAppointment() {									// need to handle this 
	scrollDownJavaScriptExecutor("//*[contains(text(),' Safety Recalls ')]");
	clickByXpath("//*[contains(text(),'Request Dealer Appointment')]");
	waitUntilElementVisisble("(//*[contains(text(),'Request Appointment ')])[1]");
	clickByXpath("(//*[contains(text(),'Request Appointment ')])[1]");
	
	scrollDownJavaScriptExecutor("(//*[@class='service__col col-7 col-md-9'])[1]");			// This is iframe
	waitUntilElementVisisble("(//*[@class='service__col col-7 col-md-9'])[1]");
	clickByXpath("(//*[@class='service__col col-7 col-md-9'])[1]");   
	waitUntilElementVisisble("//*[@id='continue_button']");
	clickByXpath("//*[@id='continue_button']");
	waitUntilElementVisisble("//*[contains(text(),'I have a ride')]");
	clickByXpath("//*[contains(text(),'I have a ride')]");
	waitUntilElementVisisble("//*[contains(text(),'NEXT')]");
	clickByXpath("//*[contains(text(),'NEXT')]");
	waitUntilElementVisisble("//*[contains(text(),'Appointment Time')]");
	scrollDownJavaScriptExecutor("//*[@class='data-slot']/div");
	clickByXpath("//*[contains(text(),'8:00')]");
	waitUntilElementVisisble("//*[contains(text(),'REVIEW')]");
	clickByXpath("//*[contains(text(),'REVIEW')]");
	waitUntilElementVisisble("//*[contains(text(),'BOOK SERVICE')]");
	clickByXpath("//*[contains(text(),'BOOK SERVICE')]");
	waitUntilElementVisisble("//*[@class='success__middle--title']");
	
	return this;
}

//--------------------------------------------------------------------------------

	/**
	 * 
	 * Description: method to click and verify gear icon
	 * 
	 */

	public P10_Maintenance clickAndVerifyGearIcon() {

		if (driver.findElement(By.xpath("//i[@title='Choose a Dealer']//*[local-name()='svg']")).isDisplayed()) {

			reportStep("As expected, Gear icon is displayed in maintenance section", "Pass");

			clickByXpath("//i[@title='Choose a Dealer']//*[local-name()='svg']");

			waitUntilElementVisisble("//*[@class='map']");

			reportStep("As expected, gear icon is clickable and 'choose a dealer' popup is displayed", "pass");

		} else {

			reportStep("Gear icon is not present", "Pass");

		}

		return this;

	}

	/**
	 * Description: method to verify gear icon
	 */

	public P10_Maintenance verifyGearIcon() {

		if (driver.findElement(By.xpath("//i[@title='Choose a Dealer']//*[local-name()='svg']")).isDisplayed()) {

			reportStep("As expected, Gear icon is displayed in maintenance section", "Pass");

		} else {

			reportStep("Gear icon is not present", "Pass");

		}

		return this;

	}

	/**
	 * Description: method to search dealer details
	 */

	public P10_Maintenance searchDealerDetails(String dealerCode) {

		enterByXpathJSExecutor("//input[@name='dealer_map_search']", dealerCode);

		reportStep("Dealer name with address", "info");

		getTextByXpath("//span[@class='address']");

		reportStep("Distance in mileage", "info");

		getTextByXpath("//span[@class='distance']");

		return this;

	}

	/**
	 * 
	 * Description: method to verify Use this dealer button
	 * 
	 */

	public P10_Maintenance checkUseThisDealerEnable(String dealerCode) {

		enterByXpathJSExecutor("//input[@name='dealer_map_search']", dealerCode);

		waitUntilElementVisisble("//label[@class='radio']/child::em");

		reportStep("Select the dealer", "info");

		clickByXpath("//label[@class='radio']/child::em");

		scrollToElement("//span[@title='Use this Dealer']");

		if (driver.findElement(By.xpath("//span[@title='Use this Dealer']")).isEnabled()) {

			reportStep("As expected,once select the dealer 'Use this dealer' button is enabled", "Pass");

		} else {

			reportStep("'Use this dealer' button is not enabled", "Fail");

		}

		return this;

	}

	/**
	 * 
	 * Description: method to Collapse and expand button
	 * 
	 */

	public P10_Maintenance checkMilesCollapseAllAndExpand() {

		clickById("historytab");

		waitUntilElementVisisble("//span[normalize-space()='COLLAPSE ALL']");

		clickByXpath("//span[normalize-space()='COLLAPSE ALL']");

		if (driver.findElement(By.xpath("//span[normalize-space()='EXPAND ALL']")).isDisplayed()) {

			reportStep("As expected,miles are collapse", "Pass");

			clickByXpath("//span[normalize-space()='EXPAND ALL']");

			if (driver.findElement(By.xpath("//span[normalize-space()='COLLAPSE ALL']")).isDisplayed()) {

				reportStep("As expected,miles are expanded", "Pass");

			}

		} else {

			reportStep("Collapse All is not displayed", "Fail");

		}

		return this;

	}

	/**
	 * Description: method to verify Request Dealer Appointment
	 * 
	 * @throws InterruptedException
	 */
	public P10_Maintenance verifyRequestDealerAppointment(String dealerCode) throws InterruptedException {

		scrollToElement("//span[@title='Request Dealer Appointment']");
		clickByXpath("//span[@title='Request Dealer Appointment']");
		waitUntilElementVisisble("//a[@class='dtmSelectNearbyDealer']");
		clickByXpath("//a[@class='dtmSelectNearbyDealer']");
		enterByXpathJSExecutor("//input[@name='dealer_map_search']", dealerCode);
		scrollToElement("//strong[contains(text(),'.Kia of Irvine')]");
		clickByXpath("//strong[contains(text(),'.Kia of Irvine')]");
		scrollToElement("//span[@title='Use this Dealer']");
		clickByXpath("//span[@title='Use this Dealer']");
		waitUntilElementVisisble("//span[contains(@title,'Request Appointment')]");
		clickByXpath("//span[contains(@title,'Request Appointment')]");
		Thread.sleep(2000);
//    		waitUntilElementVisisble("//span[normalize-space()='Kia of Irvine Recommened Basic']");
		clickByXpathJavascriptExecutor(
				"(//span[text()='Vehicle']//following::span[normalize-space()='Kia of Irvine Recommened Basic'])[2]");
		clickById("continue_button");
		clickByXpath("//div[normalize-space()='I have a ride']");
		clickById("continue_button");
		clickByXpath("//div[@class='time-selector__group']/div");
		clickByXpath("//*[@id='continue_button']//span/following::div");
		clickByXpath("//span[normalize-space()='BOOK SERVICE']");
		getTextByXpath("//h1[@class='success__middle--title']");
		return this;
	}

}
