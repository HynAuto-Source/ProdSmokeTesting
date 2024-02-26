package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P8_Schedules extends KMABase {

	public P8_Schedules(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if (!verifyTitle("Schedules")) {
			reportStep("This is not Schedules Page", "FAIL");
		}
	}

	/*
	 * public P8_Schedules createNewSchedule() throws InterruptedException {
	 * waitUntilElementVisisble("//*[@title='Create Schedule']");
	 * clickByXpathJavascriptExecutor("//*[@title='Create Schedule']");
	 * clickByXpathJavascriptExecutor("//*[@title='Create Climate Schedule']");
	 * waitElementToBeClickableXpathFW();
	 * //clickByXpathJavascriptExecutor("(//*[@class='ui-dial-temperateure'])[1]");
	 * clickByXpathJavascriptExecutor("//*[@class='up']");
	 * waitElementToBeClickableXpathFW(); clickByXpathJavascriptExecutor(
	 * "//*[@id='createClimateForm']/ul/li[2]/div/div[2]/div/div[5]/span/label/span"
	 * ); waitElementToBeClickableXpathFW();
	 * clickByXpathJavascriptExecutor("(//*[@class='checkbox checkbox-round'])[1]");
	 * waitElementToBeClickableXpathFW(); clickByXpathJavascriptExecutor(
	 * "//*[@id='createClimateForm']/ul/li[5]/span/label/span");
	 * waitElementToBeClickableXpathFW();
	 * clickByXpathJavascriptExecutor("//*[@title='Save New Climate Schedule']");
	 * //waitUntilElementVisisble("(//*[@class='button main has-spinner'])[1]");
	 * clickByXpathJavascriptExecutor("(//*[@class='button main has-spinner'])[1]");
	 * waitUntilElementVisisble("(//*[@class='close'])[8]"); return this; }
	 */

	public P8_Schedules updateSchedule() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='Create Schedule']");
		clickByXpathJavascriptExecutor("(//*[@class='icon-settings climate'])[2]");
		waitUntilElementVisisble("(//*[@class='icon-close'])[5]");
		clickByXpathJavascriptExecutor("//*[@id='viewClimateForm']/ul/li[2]/div/div[1]/div/div[3]/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("(//*[@class='checkbox checkbox-round'])[5]");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='Save Edit Climate Schedule']");
		/*
		 * waitUntilElementVisisble("//*[@title='Climate Ventilation OK']");
		 * clickByXpathJavascriptExecutor("//*[@title='Climate Ventilation OK']");
		 */
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}

	public P8_Schedules enableParentToggle() {
		waitUntilElementVisisble("//*[@title='Create Schedule']");
		clickByCSSTagClass("span[class='toggle tiny']");
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this;
	}

	public P8_Schedules deleteSchedule() {
		waitUntilElementVisisble("//*[@title='Create Schedule']");
		clickByXpathJavascriptExecutor("(//*[@class='icon-settings climate'])[2]");
		waitUntilElementVisisble("(//*[@class='icon-close'])[5]");
		clickByXpathJavascriptExecutor("//*[@title='Delete Climate Schedule']");
		waitUntilElementVisisble("//*[@title='Create Schedule']");
		return this;
	}

	// ---------------------------------------------------------------------

	public P8_Schedules clickCreateSchedule() {
		waitUntilElementVisisble("//span[@title='Create Schedule']");

		reportStep("Clicking Create A Schedule", "INFO");
		clickByXpath("//span[@title='Create Schedule']");
		waitUntilElementVisisble("//div[@class='modal-create-alert']");

		String schedulePopup = getTextByXpath("//div[@class='modal-create-alert']/strong");

		if (schedulePopup.equalsIgnoreCase("Choose Schedule Type")) {
			reportStep("Climate Schedule popup displayed : " + schedulePopup, "PASS");
		} else {
			reportStep("Climate Schedule popup not displayed :" + schedulePopup, "Failed");
		}

		return this;
	}

	public P8_Schedules clickClimateSchedulesButton() {
		waitUntilElementVisisble("//ul[@class='alert-choices']");
		isElementPresent("//ul[@class='alert-choices']");
		clickByXpathJavascriptExecutor("//li[@title='Create Climate Schedule']/strong");
		return this;
	}

	public P8_Schedules verifyClimateSchedulesButton() {
		waitUntilElementVisisble("//ul[@class='alert-choices']");

		isElementPresent("//ul[@class='alert-choices']");

		String climateSchedule = getTextByXpath("//li[@title='Create Climate Schedule']/strong");

		if (climateSchedule.equalsIgnoreCase("Climate Schedules")) {
			reportStep("Climate Schedule option is displayed : " + climateSchedule, "PASS");
		} else {
			reportStep("Climate Schedule option not displayed :" + climateSchedule, "Failed");
		}
		return this;
	}

	public P8_Schedules verifyClimateSchedulesPopup() {
		waitUntilElementVisisble("//ul[@class='alert-choices']");

		clickByXpathJavascriptExecutor("//i[@class='icon-schedule-red-climate']");

		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong");
		isElementPresent("//div[@class='modal-climate-schedule']/strong");

		String createClimateSchedulePopup = getTextByXpath("//div[@class='modal-climate-schedule']/strong");

		if (createClimateSchedulePopup.equalsIgnoreCase("Create Climate Schedule")) {
			reportStep("Create Climate Schedule option is displayed : " + createClimateSchedulePopup, "PASS");
		} else {
			reportStep("Create Climate Schedule option not displayed :" + createClimateSchedulePopup, "Failed");
		}
		return this;
	}

	public P8_Schedules clickFirstSchedule() {
		waitUntilElementVisisble("//div[@class='schedules-header']");

		reportStep("Clicking First Schedule", "INFO");
		clickByXpath("(//div[@class='schedules-alert-area-cards']//div[@class='alert-body'])[1]");
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong[text()='Edit Climate Schedule  ']");

		String editSchedulePopup = getTextByXpath(
				"//div[@class='modal-climate-schedule']/strong[text()='Edit Climate Schedule  ']");

		if (editSchedulePopup.equalsIgnoreCase("Edit Climate Schedule")) {
			reportStep("Edit Climate Schedule popup displayed : " + editSchedulePopup, "PASS");
		} else {
			reportStep("Edit Climate Schedule popup not displayed :" + editSchedulePopup, "Failed");
		}

		return this;
	}

	public P8_Schedules clickSecondSchedule() {
		waitUntilElementVisisble("//div[@class='schedules-header']");

		reportStep("Clicking Second Schedule", "INFO");
		clickByXpath("(//div[@class='schedules-alert-area-cards']//div[@class='alert-body'])[2]");
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong[text()='Edit Climate Schedule  ']");

		String editSchedulePopup = getTextByXpath(
				"//div[@class='modal-climate-schedule']/strong[text()='Edit Climate Schedule  ']");

		if (editSchedulePopup.equalsIgnoreCase("Edit Climate Schedule")) {
			reportStep("Edit Climate Schedule popup displayed : " + editSchedulePopup, "PASS");
		} else {
			reportStep("Edit Climate Schedule popup not displayed :" + editSchedulePopup, "Failed");
		}

		return this;
	}

	public P8_Schedules closeCreateClimateSchedulePopup() {
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong[text()='Edit Climate Schedule  ']");

		reportStep("Closing the climate schedule popup", "INFO");
		clickByXpathJavascriptExecutor(
				"//div[@class='modal fade edit-climate-schedule heated-seats in']//span[@class='icon-close']");
		waitUntilElementVisisble("//div[@class='schedules-header']");
		isElementPresent("//div[@class='schedules-header']");

		return this;
	}

	public P8_Schedules deleteClimateSchedule() {
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong[text()='Edit Climate Schedule  ']");
		reportStep("Deleting the climate schedule", "INFO");
		scrollToElement("//button[@title='Delete Climate Schedule']");

		reportStep("Clicking the delete button in climate schedule popup", "PASS");
		clickByXpathJavascriptExecutor("//button[@title='Delete Climate Schedule']");
//		int scheduleCount = driver.findElements(By.xpath("(//div[@class='schedules-alert-area-cards']//div[@class='alert-body'])")).size();
//		if(scheduleCount<2) {
//			reportStep("Successfully deleted the schedule", "PASS");
//		}else {
//			reportStep("unable to deleted the schedule", "FAIL");
//		}
		return this;
	}

	public P8_Schedules setTemperature() {
		String temperature = getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		int temp = Integer.parseInt(temperature);
		reportStep("Setting the temperature", "INFO");
		for (int i = temp; i < 75; i++) {
			clickByXpathJavascriptExecutor("//div[@class='modal-climate-schedule']//div/span/span[@class='up']");
		}
		getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		return this;
	}

	public P8_Schedules reduceTemperature(String expTemp) {
		String temperature = getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		int temp = Integer.parseInt(temperature);
		reportStep("Decreasing the temperature", "INFO");
		for (int i = temp; i > 62; i--) {
			clickByXpathJavascriptExecutor("//div[@class='modal-climate-schedule']//div/span/span[@class='down']");
		}

		String actTemp = getTextByXpath("//span[@class='ui-dial-temperateure']//span");
		if (actTemp.equals(expTemp)) {
			reportStep("Temperature set to the expected temperature: " + actTemp, "PASS");
		} else {
			reportStep("Failed to set the expected temperature " + actTemp, "FAIL");
		}

		return this;
	}

	public P8_Schedules enableDefrostToggle() {

		reportStep("Turning on the Defrost Toggle", "INFO");
		scrollDownJavaScriptExecutor("//input[@id='defroster']/following-sibling::span");
		clickByXpathJavascriptExecutor("//input[@id='defroster']/following-sibling::span");
		clickByXpathJavascriptExecutor("//input[@id='heatedAccessories']/following-sibling::span");
		clickByXpathJavascriptExecutor("//input[@id='steeringWheelStatus']/following-sibling::span");
		return this;
	}

	public P8_Schedules disableDefrostToggle() {

		reportStep("Turning off the Defrost Toggle", "INFO");
		scrollDownJavaScriptExecutor("//input[@id='defroster']/following-sibling::span");
		clickByXpathJavascriptExecutor(
				"(//div[@class='col-md-4 col-sm-4 col-xs-4']//input[@class='ng-untouched ng-pristine ng-valid']/following-sibling::span)[1]");
		clickByXpathJavascriptExecutor(
				"(//div[@class='col-md-4 col-sm-4 col-xs-4']//input[@class='ng-untouched ng-pristine ng-valid']/following-sibling::span)[2]");
		clickByXpathJavascriptExecutor(
				"(//div[@class='col-md-4 col-sm-4 col-xs-4']//input[@class='ng-untouched ng-pristine ng-valid']/following-sibling::span)[3]");
		return this;
	}

	public P8_Schedules createNewSchedule() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='Create Schedule']");
		clickByXpathJavascriptExecutor("//*[@title='Create Schedule']");
		clickByXpathJavascriptExecutor("//*[@title='Create Climate Schedule']");
		waitElementToBeClickableXpathFW();
		// clickByXpathJavascriptExecutor("(//*[@class='ui-dial-temperateure'])[1]");
		clickByXpathJavascriptExecutor("//*[@class='up']");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='createClimateForm']/ul/li[2]/div/div[2]/div/div[5]/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("(//*[@class='checkbox checkbox-round'])[1]");
		waitElementToBeClickableXpathFW();
		/*
		 * clickByXpathJavascriptExecutor(
		 * "//*[@id='createClimateForm']/ul/li[5]/span/label/span");
		 * waitElementToBeClickableXpathFW();
		 */
		clickByXpathJavascriptExecutor("//*[@title='Save New Climate Schedule']");
		// waitUntilElementVisisble("(//*[@class='button main has-spinner'])[1]");
		clickByXpathJavascriptExecutor("(//*[@class='button main has-spinner'])[1]");
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this;
	}

	public P8_Schedules clickTurnScheduleOnToggle() {
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong");
		reportStep("Clicking Turn Schedule on toggle", "INFO");
		scrollToElement("//span[@class='toggle no-border']//span");
		clickByXpathJavascriptExecutor("//span[@class='toggle no-border']//span");
		return this;
	}

	public P8_Schedules saveNewClimateSchedule() {
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong");
		reportStep("Save the climate schedule", "INFO");
		scrollToElement("//span[@title='Save New Climate Schedule']");

		reportStep("Clicking the save button in climate schedule popup", "INFO");
		clickByXpathJavascriptExecutor("//span[@title='Save New Climate Schedule']");
		waitUntilElementVisisble("//div[@class='item show-back active']//div[@class='modal-ventilation-warning']");

		reportStep("Clicking Ok in Ventilation Warning", "Info");
		clickByXpathJavascriptExecutor("//div[@class='item show-back active']//span[@class='button main has-spinner']");
		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
		getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");
		waitUntilElementVisisble("(//div[@class='schedules-alert-area-cards']//div[@class='alert-body'])[2]");
		int scheduleCount = driver
				.findElements(By.xpath("(//div[@class='schedules-alert-area-cards']//div[@class='alert-body'])"))
				.size();
		if (scheduleCount == 2) {
			reportStep("Successfully saved the schedule", "PASS");
		} else {
			reportStep("unable to save the schedule", "FAIL");
		}
		return this;
	}

	public P8_Schedules selectDaysToBeActive() {
		reportStep("Selecting the days to be active", "INFO");
		scrollToElement(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Su']");

		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Su']");
		return this;
	}

	public P8_Schedules saveClimateSchedule() {
		reportStep("Save the climate schedule", "INFO");
		scrollToElement("//span[@title='Save Edit Climate Schedule']");

		clickByXpathJavascriptExecutor("//span[@title='Save Edit Climate Schedule']");
		return this;
	}

	public P8_Schedules selectAllDaysToBeActive() {
		reportStep("Selecting all the days to be active", "INFO");
		scrollToElement(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Su']");

		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Su']");
		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='M']");
		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Tu']");
		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='W']");
		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Th']");
		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='F']");
		clickByXpathJavascriptExecutor(
				"//div[@id='createClimateActiveDays']//label[@class='checkbox checkbox-round']/em/span[text()='Sa']");

		return this;
	}

	public P8_Schedules deactivateActivateDays(String day) {
		reportStep("Selecting the day to be de active", "INFO");
		scrollToElement(
				"//div[@id='climateActiveDays']//label[@class='checkbox checkbox-round']/input/../em/span[text()='"
						+ day + "']");

		clickByXpathJavascriptExecutor(
				"//div[@id='climateActiveDays']//label[@class='checkbox checkbox-round']/input/../em/span[text()='"
						+ day + "']");

		return this;
	}

	public P8_Schedules verifyScheduleActive() {
		String successMsgByXpath = getSuccessMsgByXpath("(//div[@class='alert-status']/span)[2]");
		if (successMsgByXpath.contains("ACTIVE")) {
			reportStep("Successfully activated the schedule", "PASS");
		} else {
			reportStep("Schedule Inactive " + successMsgByXpath, "Fail");
		}
		return this;
	}

	public P8_Schedules setScheduleDuration() {
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong");
		reportStep("Setting the duration", "INFO");
		clickByXpath("//span[@title='10 mins']/following-sibling::span");
		clickByXpath("//ul//li[text()='8 mins']");
		return this;
	}

	public P8_Schedules setTiming() {
		waitUntilElementVisisble("//div[@class='modal-climate-schedule']/strong");
		reportStep("Setting the duration", "INFO");
		clickByXpath("(//*[contains(@id,'select2') and text()='06:00 AM'])[1]");
		clickByXpath("//ul//li[text()='07:00 AM']");
		return this;
	}
}
