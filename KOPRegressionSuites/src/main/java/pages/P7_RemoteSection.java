package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P7_RemoteSection extends KMABase {

	public P7_RemoteSection(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		// waitUntilElementVisisble("//*[@class='icon-info']");
		if (!verifyTitle("Remote")) {
			reportStep("This is not Remote Page", "FAIL");
		}
	}

	
	
	
	public P7_RemoteSection clickDoorUnLockRS()  {
		waitVisibilityOfElementLocatedByID("securitytab");
		clickByXpathJavascriptExecutor("//*[@class='remote-security-unlock action-button state-1']");
		waitVisibilityOfElementLocatedByXpath("(//*[@class='close'])[5]");
		return this;		
}
	
	
	public P7_RemoteSection remoteScheduleIsDisplayed() {
		waitVisibilityOfElementLocatedByID("securitytab");
		clickById("climatetab");
		waitUntilElementVisisble("(//*[@class='last-refreshed'])[2]");
		//waitUntilElementVisisble("(//*[@class='last-refreshed'])[2]");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='icon-climate-schedule']")).isDisplayed());
		return this;
	}
	
	
	
	public P7_RemoteSection clickRemoteStartRS() {
		waitVisibilityOfElementLocatedByID("securitytab");
		clickById("climatetab");
		waitElementToBeClickableXpathFW();
		//doubleClick("(//*[@class='down'])[1]");
		clickByXpath("(//*[@class='up'])[1]");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='remotebody']/div/div[2]/div[3]/div[1]/div/div[2]/span/label/span");
		waitElementToBeClickableXpathFW();
		/*clickByXpathJavascriptExecutor("//*[@id='remotebody']/div/div[2]/div[3]/div[3]/div/div[2]/span/label");
		waitElementToBeClickableXpathFW();*/
		//clickByXpath("//*[contains(text(),'Ok')]");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@class='action-button state-1 show-warning remote-start']");
		waitUntilElementVisisble("(//*[@class='button remote-command-action-button'])[2]");
		clickByXpath("//*[@id='command-warning1']/div/div/div/div/label/em");
		clickByXpath("(//*[@class='button remote-command-action-button'])[2]");
		waitVisibilityOfElementLocatedByXpath("(//*[@class='close'])[8]");
		return this;
	}
	
	
	public P7_RemoteSection clickRemoteStopRS() {
		waitVisibilityOfElementLocatedByID("securitytab");
		clickById("climatetab");
		clickByXpathJavascriptExecutor("//*[@class='action-button state-2 active trigger-remote-error remote-stop']");
		waitVisibilityOfElementLocatedByXpath("(//*[@class='close'])[8]");
		return this;
	}
	


	
	//----------------------------
	
	/**
	 *  Description: Method to click Lock button in RS
	 */
	public P7_RemoteSection clickDoorLockRS() {
		waitVisibilityOfElementLocatedByID("securitytab");
		clickByXpathJavascriptExecutor("//*[@class='remote-security-lock action-button state-2 trigger-remote-error']");
		getTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p");
		waitVisibilityOfElementLocatedByXpath("(//*[@class='close'])[5]");
		return this;
	}

	/**
	 *  Description: Method to click Remote Start in RS
	 */
	public P7_RemoteSection clickRemoteStart() {
		waitVisibilityOfElementLocatedByID("climatetab");
		reportStep("Clicking the remote start", "INFO");
		clickByXpathJavascriptExecutor("//a[text()=' Remote Start ']");
		return this;
	}

	/**
	 *  Description: Method to increase temperature in RS
	 * 
	 * @param is expected temperature to be set
	 */
	public P7_RemoteSection increaseTemperature(String expTemp) {
		waitVisibilityOfElementLocatedByID("climatetab");
		String climateStatus = driver.findElement(By.xpath(
				"//div[@class='remote-module remote-climate']//div[@class='overview-remote-command-header-state']//span[contains(@class,'state-1')]"))
				.getAttribute("class");
		if (climateStatus.contains("active")) {
			clickByXpathJavascriptExecutor("(//div[@class='action-buttons split']//span)[7]");

			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

			waitUntilElementVisisble("(//div[@class='overview-remote-command-header-state']//span)[4]");
		}

		String temperature = getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		int temp = Integer.parseInt(temperature);
		reportStep("Increasing the temperature", "INFO");
		for (int i = temp; i < 75; i++) {
			clickByXpathJavascriptExecutor(
					"//span[@class='ui-dial-temperateure']/following-sibling::span[@class='ui-dial-controls']/span[@class='up']");
		}
		String actTemp = getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		if (actTemp.equals(expTemp)) {
			reportStep("Temperature set to the expected temperature: " + actTemp, "PASS");
		} else {
			reportStep("Failed to set the expected temperature", "FAIL");
		}
		return this;
	}

	/**
	 *  Description: Method to decrease temperature in Remote
	 * Section
	 */
	public P7_RemoteSection decreaseTemperature() {
		waitVisibilityOfElementLocatedByID("climatetab");
		String temperature = getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		int temp = Integer.parseInt(temperature);
		clickByXpathJavascriptExecutor("//div[@class='ui-dial']//span[@class='down']");

		return this;
	}

	/**
	 *  Description: Method to increase temperature in Remote
	 * Section
	 */
	public P7_RemoteSection heatedAndVentilatedSeats() {

		waitVisibilityOfElementLocatedByID("securitytab");
		reportStep("Verifying the heated and ventilated seats are in OFF mode ", "INFO");
		String textByXpath = getTextByXpath("//div[@class='featuresIcon']/strong");

		if (textByXpath.equalsIgnoreCase("ON")) {

			reportStep("Clicking the heated and ventilated seats option", "INFO");
			clickByXpathJavascriptExecutor("//div[@class='controllerDiv horizontal']");
			waitUntilElementVisisble("//div[@class='modal-heated-seats']/strong");
			isElementPresent("//div[@class='modal-heated-seats']/strong");

			reportStep("Getting the heat and ventilated seats popup title ", "INFO");
			getTextByXpath("//div[@class='modal-heated-seats']/strong");

			reportStep("Selecting the seats to off the temperature", "INFO");
			clickByXpathJavascriptExecutor(
					"//div[@class='heated-seats-vehicle']//span[contains(@class,'heated-seat-1')]");

			reportStep("Setting the temperature off", "INFO");
			clickByXpathJavascriptExecutor(
					"//div[@class='ui-dial top left steps hot active']//span[@class='ui-dial-controls']/span[@class='down']");

			reportStep("Clicking the apply button after setting the temperature", "INFO");
			clickByXpathJavascriptExecutor(
					"//div[@class='ui-dial top left steps active nuetral']//button[@class='button reset apply-seat-temp']");

			reportStep("Closing the temperature popup", "INFO");
			clickByXpathJavascriptExecutor("//div[@class='modal fade heated-seats in']//span[@class='icon-close']");
		}

		reportStep("Clicking the heated and ventilated seats option", "INFO");
		clickByXpathJavascriptExecutor("//div[@class='controllerDiv horizontal']");
		waitUntilElementVisisble("//div[@class='modal-heated-seats']/strong");
		isElementPresent("//div[@class='modal-heated-seats']/strong");

		reportStep("Getting the heat and ventilated seats popup title ", "INFO");
		getTextByXpath("//div[@class='modal-heated-seats']/strong");

		reportStep("Selecting the seats to set the temperature", "INFO");
		clickByXpathJavascriptExecutor("//div[@class='heated-seats-vehicle']//span[contains(@class,'heated-seat-1')]");

		reportStep("Setting the temperature", "INFO");
		clickByXpathJavascriptExecutor(
				"//div[@class='ui-dial top left steps nuetral active']//span[@class='ui-dial-controls']//span[@class='up']");

		reportStep("Clicking the apply button after setting the temperature", "INFO");
		clickByXpathJavascriptExecutor(
				"//div[@class='ui-dial top left steps active hot']//button[@class='button reset apply-seat-temp']");

		reportStep("Closing the temperature popup", "INFO");
		clickByXpathJavascriptExecutor("//div[@class='modal fade heated-seats in']//span[@class='icon-close']");
		String SeatsMode = getTextByXpath("//div[@class='featuresIcon']/strong");

		if (SeatsMode.equals("ON")) {
			reportStep("Heated and Ventilated Seats successfully turned ON", "INFO");
		} else {
			reportStep("Failed to turn ON Heated and Ventilated Seats", "FAIL");
		}
		return this;
	}

	/**
	 *  Description: Method to Enable Defrost And Steering
	 * Toggle
	 */
	public P7_RemoteSection enableDefrostAndSteeringToggle() {
		waitVisibilityOfElementLocatedByID("climatetab");
		clickByXpathJavascriptExecutor("//div[@class='controllerDiv single']//span[@class='toggle1']//label");
		clickByXpathJavascriptExecutor("//div[@class='controllerDiv active double']//span[@class='toggle2']//label");
		clickByXpathJavascriptExecutor("//div[@class='controllerDiv single active']//span[@class='toggle3']//label");
		return this;
	}

	/**
	 *  Description: Method to Activate Climate in RS
	 */
	public P7_RemoteSection activateClimate() {
		waitVisibilityOfElementLocatedByID("climatetab");

		String climateStatus = driver.findElement(By.xpath(
				"//div[@class='remote-module remote-climate']//div[@class='overview-remote-command-header-state']//span[contains(@class,'state-1')]"))
				.getAttribute("class");
		if (climateStatus.contains("active")) {
			clickByXpathJavascriptExecutor("(//div[@class='action-buttons split']//span)[7]");

			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

			waitUntilElementVisisble("(//div[@class='overview-remote-command-header-state']//span)[4]");
		}
		getTextByXpath("//div[@class='overview-remote-command state-2']//span[@class='state-1']");
		clickByXpathJavascriptExecutor("//span[@class='action-button state-1 show-warning remote-start']");

		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
		getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

		clickByXpathJavascriptExecutor("(//div[@class='alert-actions']//button)[5]");
		waitUntilElementVisisble("(//div[@class='overview-remote-command-header-state']//span)[3]");
		String climate = getTextByXpath("(//div[@class='overview-remote-command-header-state']//span)[3]");
		if (climate.equalsIgnoreCase("Climate is on.")) {
			reportStep("Cimate successfully Started", "PASS");
		} else {
			reportStep("Failed to turn Start Climate", "FAIL");
		}
		return this;
	}

	/**
	 *  Description: Method to Stop Climate in RS
	 */
	public P7_RemoteSection stopClimate() {
		waitVisibilityOfElementLocatedByID("climatetab");

		String climateStatus = driver.findElement(By.xpath(
				"//div[@class='remote-module remote-climate']//div[@class='overview-remote-command-header-state']//span[contains(@class,'state-2')]"))
				.getAttribute("class");
		if (climateStatus.contains("active")) {
			clickByXpathJavascriptExecutor("//span[@class='action-button state-1 show-warning remote-start']");

			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

			clickByXpathJavascriptExecutor("(//div[@class='alert-actions']//button)[5]");
			waitUntilElementVisisble("(//div[@class='overview-remote-command-header-state']//span)[3]");
		}
		getTextByXpath("(//div[@class='overview-remote-command-header-state']//span)[3]");
		clickByXpathJavascriptExecutor("(//div[@class='action-buttons split']//span)[7]");

		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
		getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

		waitUntilElementVisisble("(//div[@class='overview-remote-command-header-state']//span)[4]");
		String climate = getTextByXpath("(//div[@class='overview-remote-command-header-state']//span)[4]");
		if (climate.equalsIgnoreCase("Climate is off.")) {
			reportStep("successfully stopped climate start", "PASS");
		} else {
			reportStep("Failed to stop Climate", "FAIL");
		}

		return this;
	}

	/**
	 *  Description: Method to Click On Options on the Left
	 * Panel
	 */
	public P7_RemoteSection clickOnLeftMenuOption(String option) throws InterruptedException {
		// waitUntilElementVisisble("//*[text()='Remote']");
		reportStep("Clicking " + option + " option from left panel", "INFO");
		clickOnLeftMenu(option);
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		return this;
	}

	/**
	 *  Description: Method to verify Remote security page
	 */
	public P7_RemoteSection verifyRemoteSecurityPage() {
		waitVisibilityOfElementLocatedByID("securitytab");

		scrollToElement("//span[contains(@class,'remote-security-unlock action-button')]");

		reportStep("Verifying car image and lock icon is present or not", "INFO");
		isElementPresent("//div[@class='right-front basecar-common']//img[@class='show']");

		reportStep("Verifying unlock button is present or not", "INFO");
		isElementPresent("//span[@class='remote-security-unlock action-button state-1']");
		getTextByXpath("//span[@class='remote-security-unlock action-button state-1']");

		reportStep("Verifying lock button is present or not", "INFO");
		isElementPresent("//span[@class='remote-security-lock action-button state-2 trigger-remote-error active']");
		getTextByXpath("//span[@class='remote-security-lock action-button state-2 trigger-remote-error active']");

		reportStep("Verifying lock unlock status text present or not", "INFO");
		isElementPresent(
				"(//div[@class='overview-remote-command-header']//div/span)[contains(@class,'state-2 remote-security-lock')]");
		getTextByXpath(
				"(//div[@class='overview-remote-command-header']//div/span)[contains(@class,'state-2 remote-security-lock')]");

		return this;
	}

	/**
	 * 
	 * 
	 * 
	 * Description: Method to click Remote Door Lock
	 * 
	 */

	public P7_RemoteSection clickRemoteDoorLockInRS() {

		waitVisibilityOfElementLocatedByID("securitytab");

		scrollToElement("//span[contains(@class,'remote-security-lock action-button')]");

		String lockStatus = driver
				.findElement(By.xpath("//span[contains(@class,'remote-security-lock action-button state-2')]"))
				.getAttribute("class");

		if (lockStatus.contains("active")) {

			clickByXpathJavascriptExecutor("//span[@class='remote-security-unlock action-button state-1']");

			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");

			String successMsg = getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

			if (successMsg.equalsIgnoreCase("The Remote command for door Unlock executed successfully.")) {

				reportStep("successfully Unlocked the car", "PASS");

			} else {

				reportStep("Failed to Unlock the car", "FAIL");

			}

			reportStep("Clicking close option in toast message", "INFO");

			clickByXpathJavascriptExecutor(
					"//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

			reportStep("Verifying Unlock status text", "INFO");

			waitUntilElementVisisble("//span[contains(@class,'state-1 remote-security-unlock')]");

			isElementPresent("//span[contains(@class,'state-1 remote-security-unlock')]");

			getTextByXpath("//span[contains(@class,'state-1 remote-security-unlock')]");

		}

		reportStep("Clicking lock button", "INFO");

		clickByXpathJavascriptExecutor("//span[contains(@class,'remote-security-lock action-button')]");

		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");

		String successMsg = getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

		if (successMsg.equalsIgnoreCase("The Remote command for door lock executed successfully.")) {

			reportStep("successfully locked the car", "PASS");

		} else {

			reportStep("Failed to lock the car", "FAIL");

		}

		reportStep("Clicking close option in toast message", "INFO");

		clickByXpathJavascriptExecutor(
				"//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

		reportStep("Verifying lock status text", "INFO");

		waitUntilElementVisisble(
				"(//div[@class='overview-remote-command-header']//div/span)[@class='state-2 remote-security-lock active']");

		isElementPresent(
				"(//div[@class='overview-remote-command-header']//div/span)[@class='state-2 remote-security-lock active']");

		getTextByXpath(
				"(//div[@class='overview-remote-command-header']//div/span)[@class='state-2 remote-security-lock active']");

		return this;

	}

	/**
	 * 
	 * 
	 * 
	 * Description: Method to click Remote Door UnLock
	 * 
	 */

	public P7_RemoteSection clickRemoteDoorUnLockInRS() {

		waitVisibilityOfElementLocatedByID("securitytab");

		scrollToElement("//span[@class='remote-security-unlock action-button state-1']");

		String unLockStatus = driver
				.findElement(By.xpath("//span[contains(@class,'remote-security-unlock action-button state-1')]"))
				.getAttribute("class");

		if (unLockStatus.contains("active")) {

			clickByXpathJavascriptExecutor("//span[contains(@class,'remote-security-lock action-button')]");

			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");

			String successMsg = getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

			if (successMsg.equalsIgnoreCase("The Remote command for door lock executed successfully.")) {

				reportStep("successfully locked the car", "PASS");

			} else {

				reportStep("Failed to lock the car", "FAIL");

			}

			reportStep("Clicking close option in toast message", "INFO");

			clickByXpathJavascriptExecutor(
					"//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

			reportStep("Verifying lock status text", "INFO");

			waitUntilElementVisisble(
					"(//div[@class='overview-remote-command-header']//div/span)[@class='state-2 remote-security-lock active']");

			isElementPresent(
					"(//div[@class='overview-remote-command-header']//div/span)[@class='state-2 remote-security-lock active']");

			getTextByXpath(
					"(//div[@class='overview-remote-command-header']//div/span)[@class='state-2 remote-security-lock active']");

		}

		reportStep("Clicking Unlock button", "INFO");

		clickByXpathJavascriptExecutor("//span[@class='remote-security-unlock action-button state-1']");

		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");

		String successMsg = getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

		if (successMsg.equalsIgnoreCase("The Remote command for door Unlock executed successfully.")) {

			reportStep("successfully Unlocked the car", "PASS");

		} else {

			reportStep("Failed to Unlock the car", "FAIL");

		}

		reportStep("Clicking close option in toast message", "INFO");

		clickByXpathJavascriptExecutor(
				"//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

		reportStep("Verifying Unlock status text", "INFO");

		waitUntilElementVisisble("//span[contains(@class,'state-1 remote-security-unlock')]");

		isElementPresent("//span[contains(@class,'state-1 remote-security-unlock')]");

		getTextByXpath("//span[contains(@class,'state-1 remote-security-unlock')]");

		return this;

	}

}