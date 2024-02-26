package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P5_Dashboard extends KMABase {

	public P5_Dashboard(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		waitUntilElementVisisble("//*[@class='icon-info']");
		if (!verifyTitle("Dashboard")) {
			reportStep("This is not Dashboard Page", "FAIL");
		}
	}
	
	
	public P5_Dashboard(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test =test;
		waitUntilElementVisisble("//*[@class='icon-info']");
		if(!verifyTitle("Dashboard")){
			reportStep("This is not Dashboard Page", "FAIL");	
		}		
	}
	

	public P5_Dashboard clickDoorUnLock() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//span[@class='action-button state-1 btn-unlock']");
		waitUntilElementVisisble("(//*[@class='close'])[7]");
		return this;
	}
	
	
	
	public P5_Dashboard clickDoorlock() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[@class='action-button state-2 btn-lock']");
		waitUntilElementVisisble("(//*[@class='close'])[7]");
		return this;
	}
	
	//--------------------Remote Climate----------------------------------------- 
	
	public P5_Dashboard clickRemoteStart() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[@class='action-button active btn-climate']");
		waitElementToBeClickableXpathFW();
		doubleClick("(//span[@class='up'])[1]");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='edit-climate-schedule-modal-slider']/div/div[1]/div/form/ul/li[2]/div/div[1]/div/div[3]/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='edit-climate-schedule-modal-slider']/div/div[1]/div/form/ul/li[2]/div/div[3]/div/div[3]/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[@class='button main']");
		waitUntilElementVisisble("//*[@id='ventilation-warning-okbtn']");
		clickByXpath("//*[@id='ventilation-warning-okbtn']");
		//waitElementToBeClickableXpathFW();
		//clickByXpath("//*[contains(text(),'Ok')]");
		waitUntilElementVisisble("(//*[@class='close'])[7]");
		return this;
	}
	
	
	public P5_Dashboard clickRemoteStartWithToggles() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[@class='action-button active btn-climate']");
		waitElementToBeClickableXpathFW();
		doubleClick("(//span[@class='up'])[1]");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='edit-climate-schedule-modal-slider']/div/div[1]/div/form/ul/li[2]/div/div[1]/div/div[3]/span/label/span");
		waitElementToBeClickableXpathFW();	
		clickByXpathJavascriptExecutor("//*[@id='edit-climate-schedule-modal-slider']/div/div[1]/div/form/ul/li[2]/div/div[2]/div/div[4]/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='edit-climate-schedule-modal-slider']/div/div[1]/div/form/ul/li[4]/div/div/label[2]/div/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[@class='button main']");
		waitUntilElementVisisble("(//*[@class='close'])[7]");
		return this;
	}
	
	
	/*public P5_Dashboard clickRemoteStartWithHeatedAccessories() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[@class='action-button active btn-climate']");
		clickByXpath("//*[@class='toggle5']");
		clickByXpath("//*[@class='button main']");
		waitUntilElementVisisble("//*[@id='ventilation-warning-okbtn']");
		clickById("ventilation-warning-okbtn");
		waitUntilElementVisisble("(//*[@class='close'])[7]");
		return this;
	}*/

	
	public P5_Dashboard clickRemoteStop()  {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[@class='action-button active btn-climate']");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[@class='button main']");
		waitUntilElementVisisble("(//*[@class='close'])[7]");
		return this;
	}

	
	
	//===================================================================================
	
	
	public P5_Dashboard clickMasterRefresh() throws InterruptedException {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("(//*[@class='refresh-ready active'])[2]");
		waitUntilElementVisisble("(//*[@class='refresh-ready active'])[2]");
		return this; 
	}
	

	
	
	
	public P5_Dashboard lastRefresh() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='time'])[2]")).isDisplayed());
		return this;
	}
	
	
	
	public P5_Dashboard handleToastMessage() {
		
		waitUntilElementVisisble("//button[@class='close']");
		HandlingToastMessage("//div[@class='alerts']/div/p)[6]", "//button[@class='close']", "The remote command for unlock executed successfully", "The remote command for lock executed successfully.",
								" alert alert-failed alert-dismissible","We cannot process your request. Please verify that your vehicle's doors, hood, and trunk are closed and locked", "null");
		waitUntilInvisibilityOfElementLocated("//button[@class='close']");
		return this;
	}
	
	
	//===================================================================================

		
	public P6_VehicleStatus clickVehicleStatus() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[@title='Vehicle Status Tile']");
		waitUntilElementVisisble("//*[@style='text-align: center;']/strong");
		return new P6_VehicleStatus(driver, test);
		//return new P6_VehicleStatus(driver, test);
	}
	
		
	public P7_RemoteSection clickRemote() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[text()='Remote']");
		//waitVisibilityOfElementLocatedByID("securitytab");
		return new P7_RemoteSection(driver, test);
	}
	
	
	public P8_Schedules clickSchedules() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("//*[text()='Schedules']");
		return new P8_Schedules(driver, test);
	}
	
	public P9_Locations clickLocations() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		//clickByXpath("//*[text()='Locations']");
		clickByXpathJavascriptExecutor("//*[text()='Locations']");
		return new P9_Locations(driver, test);
	}
	
	
	public P10_Maintenance clickMaintenance() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("(//*[text()='Maintenance'])[2]");
		return new P10_Maintenance(driver, test);
	}
	
	public P11_MyCarZone clickMyCarZone() {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpathJavascriptExecutor("(//*[text()='My Car Zone'])[2]");
		return new P11_MyCarZone(driver, test);
	}
	
	public P12_KIAConnectSubscription clickKIAConnectSUbscription() throws InterruptedException {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpath("(//*[text()='Subscription'])[1]");
		return new P12_KIAConnectSubscription(driver, test);
	}

	
	
	
	//---------------------------------------------------------------------
	
	public P4_MyVehicles deleteTheVechileFromSecondaryDriversAccount() throws InterruptedException {
		waitUntilElementVisisble("//*[@class='icon-info']");
		clickByXpath("//*[@class='icon-info']");
		waitUntilElementVisisble("(//*[contains(text(),'Delete ')])[1]");
		clickByXpath("(//*[contains(text(),'Delete ')])[1]");
		waitUntilElementVisisble("(//*[@class='button'])[5]");
		clickByXpath("(//*[@class='button'])[5]");
		waitUntilElementVisisble("(//*[contains(text(),' My Vehicles')])[2]");
		return new P4_MyVehicles(driver, test);
	}
	
	//--------------------------------------

	public P5_Dashboard clickDashboardIcon() {

		waitUntilElementVisisble("//i[@class='icon-dashboard']");
		clickByXpath("//i[@class='icon-dashboard']");
		return this;
	}

	public P13_AdditionalDrivers clickViewAllDrivers() throws InterruptedException {
		waitUntilElementVisisble("//span[normalize-space()='My TELLURIDE']/following::span");
		clickByXpath("//span[normalize-space()='My TELLURIDE']/following::span");
		clickByXpath("//ul[@class='dropdown-menu vehicle-selector-list']//following::a[normalize-space()='View All Vehicles']");
		return new P13_AdditionalDrivers(driver, test);
	}
	
	/**
	  Description: Method to Click On Set Your Climate in
	 * Dashboard Page
	 */
	public P5_Dashboard ClickOnSetYourClimate() {
		waitUntilElementVisisble("//*[text()='Remote']");
		clickByXpathJavascriptExecutor("//span[@class='action-button active btn-climate']");
		return this;
	}

	public P5_Dashboard verifyStartStopClimateButton(String climateMode) {
		waitVisibilityOfElementLocatedByID("edit-climate-schedule-modal-slider");
		scrollToElement("//div[@class='footer-action']/button");
		String climateState = getTextByXpath("//div[@class='footer-action']/button");

		if (climateState.contains(climateMode)) {
			reportStep("Climate Status obtained as expected : " + climateState, "PASS");
		} else {
			reportStep("Climate Status mismatch :" + climateState, "Failed");
		}
		return this;
	}

	/**
	  Description: Method to Click On Options on the Left
	 * Panel
	 */
	public P5_Dashboard clickOnLeftPanelOption(String option) throws InterruptedException {
		waitUntilElementVisisble("//*[text()='Remote']");
		reportStep("Clicking option from left panel", "INFO");
		clickOnLeftMenu(option);
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		return this;
	}

	/**
	  Description: verify door tile
	 */
	public P5_Dashboard verifyFeaturesInDoorTile() {
		waitUntilElementVisisble("//div[@class='overview-remote-command-header-state']/span");
		if (driver.findElement(By.xpath("//div[@class='overview-remote-command-header-state']/span")).isDisplayed()) {
			String text = getTextByXpath1("//div[@class='overview-remote-command-header-state']/span");
			reportStep("As expected door status is present in tile as " + text, "Pass");
		} else {
			reportStep("Door status not yet displayed", "Fail");

		}
		scrollToElement("//*[@id='unlockdoor']");
		if (driver.findElement(By.id("unlockdoor")).isDisplayed()) {
			reportStep("As expected 'Unlock' button is present in tile", "Pass");
		} else {
			reportStep("Door Unlock button not yet displayed", "Fail");

		}
		if (driver.findElement(By.xpath("//span[@title='Remote Command Lock']")).isDisplayed()) {
			reportStep("As expected 'Lock' button is present in tile", "Pass");
		} else {
			reportStep("Door Lock button not yet displayed", "Fail");

		}
		if (driver.findElement(By.xpath("//span[@class='icon-remote']")).isDisplayed()) {
			reportStep("As expected 'Door icon'is present in tile", "Pass");
		} else {
			reportStep("Door icon not yet displayed", "Fail");

		}

		return this;
	}

	/**
	  Description: Door Lock/Unlock and verify toast message
	 */
	public P5_Dashboard verifyToastMessageForDoorLockUnlock() {

		waitUntilElementVisisble("//span[@class='state-1 active']");
		if (isElementVisibility("//span[contains(text(),'Doors are locked')]")) {
			reportStep("As expected, doors are locked", "Pass");
			reportStep("Need to click unlock button", "info");
			clickByXpathJavascriptExecutor("//span[@class='action-button state-1 btn-unlock']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");
			clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
		} else
//            if(isElementPresent("//span[contains(text(),'Doors are unlocked')]")) {
			reportStep("As expected, doors are unlocked", "Pass");
		reportStep("Need to click unlock button", "info");
		clickByXpathJavascriptExecutor("//span[@title='Remote Command Lock']");
		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
		getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");
		clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
		return this;
	}

	/**
	  Description: Door Lock/Unlock and verify toast message
	 * 
	 * @throws InterruptedException
	 */
	public P5_Dashboard clickDoorLockUnlockAndVerifyRemoteSection(String remote) throws InterruptedException {

		waitUntilElementVisisble("//span[@class='state-1 active']");
		if (isElementVisibility("//span[contains(text(),'Doors are locked')]")) {
			scrollToElement("//span[@class='action-button state-1 btn-unlock']");
			reportStep("As expected, doors are locked", "Pass");
			reportStep("Need to click unlock button", "info");
			clickByXpathJavascriptExecutor("//span[@class='action-button state-1 btn-unlock']");
			waitUntilElementVisisble(
					"//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
			clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
			clickOnLeftPanelOption(remote);	
			scrollToElement("//div[@class='overview-remote-command-header-state']");
			scrollDownJavaScriptExecutor("//span[contains(text(),'Vehicle is unlocked')]");
			if (isElementVisibility("//span[contains(text(),'Vehicle is unlocked')]")){
				reportStep("As expected, status changes as 'Vechile is unlocked'", "Pass");

			} else {
				reportStep("No response in remote section for door", "fail");
			}
		} else {
//            if(isElementPresent("//span[contains(text(),'Doors are unlocked')]")) {
			reportStep("As expected, doors are unlocked", "Pass");
			reportStep("Need to click unlock button", "info");
			clickByXpathJavascriptExecutor("//span[@title='Remote Command Lock']");
			waitUntilElementVisisble(
					"//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
			clickOnLeftPanelOption(remote);
			waitUntilElementVisisble("//div[@class='overview-remote-command-header-state']");
			scrollToElement("//span[contains(text(),'Vehicle is locked')]");
			if (driver.findElement(By.xpath("//span[contains(text(),'Vehicle is locked')]")).isDisplayed()) {
				reportStep("As expected, status changes as 'Vechile is locked'", "Pass");

			} else {
				reportStep("No response in remote section for door", "fail");
			}
		}

		return this;

	}

	public P5_Dashboard clickOnMaintanceVehicleStatus() throws InterruptedException {

		waitUntilElementVisisble("//div[@class='overview-remote-command-header-state']/span");

		scrollToElement("//em[normalize-space()='VEHICLE STATUS']");

		clickByXpath("//em[normalize-space()='VEHICLE STATUS']");

		waitUntilElementVisisble("//strong[normalize-space()='VEHICLE STATUS']");

		return this;

	}

	/**
	 * 
	  Description: Method to Check Vehicle status present
	 * 
	 * under maintenance
	 * 
	 */

	public P5_Dashboard verifyVechileStatusForMaintenance() throws InterruptedException {

//        waitUntilElementVisisble("//img[@alt='vehicle status']/following-sibling::span']");

		getTextByXpath("//img[@alt='vehicle status']/following-sibling::span");

		return this;

	}

	/**
	 * 
	  Description: Method to Click On Vehicle status present
	 * 
	 * under maintenance
	 * 
	 */

	public P5_Dashboard verifyFuelRange() throws InterruptedException {

		getTextByXpath("//b[normalize-space()='Est. Range:']//parent::*");

		if (isElementVisibility("//a[normalize-space()='Find Gas Station Nearby']")) {

			reportStep("As expected,'Find Gas Station Nearby, is present", "Pass");

		}

		return this;

	}

	public P5_Dashboard verifyDoorAndWindowsSubmodules(String val) throws InterruptedException {

		String[] values = val.split(",");
		for (int i = 0; i < values.length; i++) {
			if (driver.findElement(By.xpath("//div[normalize-space()='" + values[i] + "']")).isDisplayed()) {
				reportStep(values[i] + "status  sub modules is displayed under 'Doors and window' section", "Pass");
				getTextByXpath("//div[normalize-space()='" + values[i] + "']/following-sibling::div");
			} else {
				reportStep(values[i] + " sub modules is not displayed under 'Door snd window' section", "Fail");
			}
		}
		return this;
	}

	public P5_Dashboard verifyLightSubmodules(String val) throws InterruptedException {
		String[] values = val.split(",");
		for (int i = 0; i < values.length; i++) {
			if (driver.findElement(By.xpath("//div[normalize-space()='" + values[i] + "']")).isDisplayed()) {
				reportStep(values[i] + " status sub modules is displayed under 'Lights' section", "Pass");
				getTextByXpath("//div[normalize-space()='" + values[i] + "']/following-sibling::div");
			} else {
				reportStep(values[i] + " sub modules is not displayed under 'Lights' section", "Fail");
			}
		}

		return this;

	}

	public P5_Dashboard verifyFluidsSubmodules(String val) throws InterruptedException {

		String[] values = val.split(",");
		scrollToElement("//div[normalize-space()='Washer Fluid']");
		for (int i = 0; i < values.length; i++) {
			if (driver.findElement(By.xpath("//div[normalize-space()='" + values[i] + "']")).isDisplayed()) {
				reportStep(values[i] + " status sub modules is displayed under 'Fluids' section", "Pass");
				getTextByXpath("//div[normalize-space()='" + values[i] + "']/following-sibling::div");
			} else {
				reportStep(values[i] + " sub modules is not displayed under 'Fluids' section", "Fail");
			}
		}
		return this;
	}

	public P5_Dashboard verifySmartKeySection() throws InterruptedException {

		scrollToElement("//div[normalize-space()='Washer Fluid']");
		if (driver.findElement(By.xpath("//div[normalize-space()='Smart Key Battery']")).isDisplayed()) {
			reportStep("Smart Key Battery status sub modules is displayed under 'Smart Key' section", "Pass");
			getTextByXpath("//div[normalize-space()='Smart Key Battery']/following-sibling::div");
		} else {
			reportStep("Smart Key Battery sub modules is not displayed under 'Fluids' section", "Fail");
		}

		return this;
	}

	/**
	  Description: Method to find the gas station location under
	 * maintenance
	 */
	public P5_Dashboard verifyFindGasStationLocation() throws InterruptedException {
//            if(isElementVisibility("//a[normalize-space()='Find Gas Station Nearby']")) {
		clickByXpathJavascriptExecutor("//a[normalize-space()='Find Gas Station Nearby']");
//                acceptAlert();
		waitUntilElementVisisble("//li[@class='location-tab']");
		reportStep("As expected, redirected to location screen to find the gas station nearby'", "Pass");
//            }else {
//                reportStep("Find Gas Station Nearby is not present as Expected", "fail");
//            }
		return this;
	}

	/**
	 
	 * 
	 * Description: Method to verify close button in pop up
	 * 
	 */

	public P5_Dashboard closePopUpAndVerifyForVechileStatus() throws InterruptedException {

		if (driver.findElement(By.xpath("//span[@id='open_vehicleStatus_modal']/following::span[@class='icon-close']"))
				.isDisplayed()) {

			clickByXpath("//span[@id='open_vehicleStatus_modal']/following::span[@class='icon-close']");

			waitUntilElementVisisble("//em[normalize-space()='VEHICLE STATUS']");

			reportStep("As expected, vehicle status pop up is disappear and navigate to respective screen", "Pass");

		} else {

			reportStep("vehicle status pop up is not displayed", "Fail");

		}

		return this;

	}

	/**
	 * 
	 
	 * 
	 * Description: Method to verify diagnostic issue
	 * 
	 */

	public P5_Dashboard verifyDiagnosticIssue() throws InterruptedException {

		waitUntilElementVisisble("//div[@class='dtc-issue']");

		reportStep("To verify diagnostic has no issue", "info");

		getTextByXpath("//div[@class='dtc-issue']/p");

		return this;

	}
	
	  /**

      Description: Method to verify stop climate

     */

    public P5_Dashboard stopClimateFromDasboard() throws InterruptedException {

        waitUntilElementVisisble("//*[@title='Remote Command Set Climate']");

        clickByXpath("//*[@title='Remote Command Set Climate']");

        waitUntilElementVisisble(

                "//div[@class='modal-climate-schedule']//following-sibling::strong[@class='modal-title']");

        scrollToElement("//button[@class='button main']");

        if (isElementVisibility("//button[normalize-space()='Stop Climate']")) {

            clickByXpath("//button[normalize-space()='Stop Climate']");

            waitUntilElementVisisble(

                    "//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

            clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

        }

        clickByXpath("//button[normalize-space()='Start Climate']");

        waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

//        clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

        clickByXpath("//*[@title='Remote Command Set Climate']");

        waitUntilElementVisisble(

                "//div[@class='modal-climate-schedule']//following-sibling::strong[@class='modal-title']");

        scrollToElement("//button[@class='button main']");

        clickByXpath("//button[normalize-space()='Stop Climate']");

        waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

        return this;

    }

 

    /**

     

     * Description: Method to verify the toast message for stop climate

     */

    public P5_Dashboard stopClimateAndverifyToastMessage() throws InterruptedException {

 

        waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

        getSuccessMsgByXpath("//div[@class='alert alert-success alert-dismissible in']/p");

        clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

        reportStep("As expected, close button is displayed", "Pass");

        return this;

    }

    /**

     * Description: Method to verify the toast message for stop climate

     */

    public P5_Dashboard verifyClimateIsOffInRemote(String remote) throws InterruptedException {

 
    	 waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
        clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");

        waitElementToBeClickableXpathFW();
        clickOnLeftPanelOption(remote);

        waitUntilElementVisisble("//div[@class='overview-remote-command-header-state']");

        waitVisibilityOfElementLocatedByID("climatetab");

        reportStep("Clicking the remote start", "INFO");

        clickByXpathJavascriptExecutor("//a[normalize-space()='Remote Start']");

//        clickById("climatetab");

        waitUntilElementVisisble("//span[@class='degree']");

        scrollToElement("//span[@class='state-2 active']");

        getSuccessMsgByXpath("//span[@class='state-2 active']");

        return this;

    }
    
    /**

     

     * Description: method to click maintenance

     * @throws InterruptedException

     */

    public     P10_Maintenance clickOnMaintenanceTab(String maintenance) throws InterruptedException {

        clickOnLeftMenu(maintenance);

        waitUntilElementVisisble("//i[@title='Choose a Dealer']");

        reportStep("As expected, navigate to maintenance screen", "pass");

        return new P10_Maintenance(driver,test);

    }
    
	public 	P12_KIAConnectSubscription clickOnKiaSubcriptions(String subscription) throws InterruptedException {
		
		waitUntilElementVisisble("//span[normalize-space()='Remote']");
		scrollToElement("//span[normalize-space()='Subscription']");
		clickOnLeftMenu(subscription);
		waitUntilElementVisisble("//button[normalize-space()='Update Package']|//button[@name='Get Kia Connect']");
		reportStep("As expected, navigate to Kia subcription screen", "pass");
		return new P12_KIAConnectSubscription(driver,test);
	}
	
	 /**
     
     * Description: Method to verify Chech What's around option
     */
    public P5_Dashboard verifyCheckWhatsAroundOption() throws InterruptedException {
        waitUntilElementVisisble("//span[contains(text(),'CHECK OUT WHAT')]");
       isElementPresent("//span[contains(text(),'CHECK OUT WHAT')]");
        reportStep("As expected, Check out What's around is displayed", "Pass");
        return this;

    }
    
    /**
     
     * Description: Method to verify View and Take pic options are present
     */
    public P5_Dashboard verifyViewAndTakePicOption() throws InterruptedException {
        waitUntilElementVisisble("//span[contains(text(),'CHECK OUT WHAT')]");
       isElementPresent("//span[@title='View 360']");
        reportStep("As expected, View option is displayed", "Pass");
        isElementPresent("//span[@title='Take Pic']");
        reportStep("As expected, Take Pic option is displayed", "Pass");
        return this;

    }
    
    /**
     
     * Description: Method to click Take pic options
     */
    public P5_Dashboard clickTakePicOption() throws InterruptedException {
        waitUntilElementVisisble("//span[contains(text(),'CHECK OUT WHAT')]");
        isElementPresent("//span[@title='Take Pic']");
        clickByXpathJavascriptExecutor("//span[@title='Take Pic']");
        reportStep("As expected, Take Pic option is displayed", "Pass");
        return this;

    }
    
    /**
     
     * Description: Method to click View option
     */
    public P5_Dashboard clickViewOption() throws InterruptedException {
        waitUntilElementVisisble("//span[contains(text(),'CHECK OUT WHAT')]");
        reportStep("Clicking View option", "INFO");
        clickByXpathJavascriptExecutor("//span[@title='View 360']");
        waitUntilElementVisisble("//h2[text()='360 VIEW GALLERY ']");
        isElementPresent("//h2[text()='360 VIEW GALLERY ']");
        reportStep("As expected, View option is clicked and navigated to location page", "Pass");
        return this;

    }
    
    /**
     
     * Description: Method to click I icon
     */
    public P5_Dashboard clickVehicleInformationIcon() throws InterruptedException {
        reportStep("Clicking i icon", "INFO");
        clickByXpathJavascriptExecutor("//*[@class='icon-info']");
        waitUntilElementVisisble("//div[@class='vehicle-settings-main-header']");
       verifyTextContainsByXpath("//div[@class='vehicle-settings-main-header']/strong", "2023 TELLURIDE");
        return this;

    }
    
    /**
     
     * Description: Method to verify Close vehicle information popup
     */
    public P5_Dashboard closeVehicleInformationIcon() throws InterruptedException {
        reportStep("Closing information i icon", "INFO");
        clickByXpathJavascriptExecutor("//div[@id='vehicleSettingForm']//span[@class='icon-close']");
        waitUntilElementVisisble("//button[@class='dropdown-toggle']//span[@class='title']");
        verifyTextContainsByXpath("//button[@class='dropdown-toggle']//span[@class='title']", "My TELLURIDE");
        return this;

    }
    
    /**
     
     * Description: Method to verify vin number in vehicle information popup
     */
    public P5_Dashboard verifyVinNumberVehicleInformation() throws InterruptedException {
        reportStep("Veryfying vin number", "INFO");
        waitUntilElementVisisble("//div[@class='vehicle-settings-main-header']");
       getTextByXpath("//div[@class='vehicle-settings-main-meta-item']/em");
       verifyTextContainsByXpath("//div[@class='vehicle-settings-main-meta-item']/em", "5XYP5DHC4PG283819");
        return this;

    }
    
    /**
     
     * Description: Method to update nick name and  verify
     */
    public P5_Dashboard updateNickName(String vehicleName) throws InterruptedException {
        reportStep("update NickName", "INFO");
        waitUntilElementVisisble("//div[@class='vehicle-settings-main-header']");
       enterByXpath("//label/strong[normalize-space()='Nickname']/following-sibling::input[@name='nickName']", vehicleName);
       clickByXpathJavascriptExecutor("//span[normalize-space()='Save']");
       waitElementToBeClickableXpathFW();
       verifyTextContainsByXpath("//div[@class='overview-header-title']/strong", vehicleName);
        return this;

    }
    
    /**
     
     * Description: Method to Click Get direction from Information popup
     */
    public P5_Dashboard clickGetDirection() throws InterruptedException {
        reportStep("Click get direction", "INFO");
        waitUntilElementVisisble("//a[normalize-space()='Get Directions']");
       clickByXpathJavascriptExecutor("//a[normalize-space()='Get Directions']");
       waitElementToBeClickableXpathFW();
       switchToLastWindow();
       String val = driver.findElement(By.xpath("//link[@title='Google Maps']")).getAttribute("title");
       verifyText(val, "Google Maps");
        return this;

    }
    
    /**
     
     * Description: Method to Click Create Custom Field from Information popup
     */
    public P5_Dashboard clickCreateCustomField() throws InterruptedException {
        reportStep("Click Create Custom Field", "INFO");
        waitUntilElementVisisble("//span[normalize-space()='Create a custom field']");
       clickByXpathJavascriptExecutor("//span[normalize-space()='Create a custom field']");
       verifyTextByXpath("//strong[normalize-space()='Create Custom Field']", "Create Custom Field");
       return this;

    }
    
    /**
     
     * Description: Method to Create Custom Field from Information popup
     */
    public P5_Dashboard createCustomField(String fieldLabel, String helperText) throws InterruptedException {
        reportStep("Click Create Custom Field", "INFO");
        waitUntilElementVisisble("//span[normalize-space()='Create a custom field']");
       clickByXpathJavascriptExecutor("//span[normalize-space()='Create a custom field']");
       waitUntilElementVisisble("//strong[normalize-space()='Create Custom Field']");
       verifyTextByXpath("//strong[normalize-space()='Create Custom Field']", "Create Custom Field");
       enterByXpath("//input[@id='customFieldLabel']", fieldLabel);
       enterByXpath("//input[@id='customHelperText']", helperText);
       clickByXpathJavascriptExecutor("//span[@class='button add-meta-field-submit has-spinner']");
       waitUntilElementVisisble("//span[normalize-space()='Create a custom field']");
       return this;

    }
    
    /**
     
     * Description: Method to verify create field Field button disabled from Information popup
     */
    public P5_Dashboard verifyCreateFieldBtnDisabled(String labelTxt) throws InterruptedException {
        reportStep("Click Create Custom Field", "INFO");
        waitUntilElementVisisble("//strong[normalize-space()='Create Custom Field']");
        enterByXpath("//label/strong[normalize-space()='Field Label']/following-sibling::input[@name='customFieldLabel']", labelTxt);
        enterByXpath("//label/strong[normalize-space()='Helper Text']/following-sibling::input[@name='customHelperText']", labelTxt);
        String btnStatus = driver.findElement(By.xpath("//div[@class='form-footer']//span[contains(@class,'button')]")).getAttribute("class");
       verifyText(btnStatus, "disabled");
       return this;

 

    }

    /**
     
     * Description: Method to verify create field Field button enabled from Information popup
     */
    public P5_Dashboard verifyCreateFieldBtnEnabled(String labelTxt, String helperText){

        enterByXpath("//label/strong[normalize-space()='Field Label']/following-sibling::input[@name='customFieldLabel']", labelTxt);
        enterByXpath("//label/strong[normalize-space()='Helper Text']/following-sibling::input[@name='customHelperText']", helperText);

            String disableChkAftInput=driver.findElement(By.xpath("//div[@class='form-footer']//span[contains(@class,'button')]")).getAttribute("class");
            if (!disableChkAftInput.contains("disabled")) {
                reportStep("As expected Create Field button is Enabled after entering values", "Pass");

            }else {
                reportStep("Create Field button is Disabled", "Fail");
            }
        return this;
    }
    /**
     
     * Description: Method to remove nick name and verify
     */
    public P5_Dashboard removeNickName() throws InterruptedException {
        reportStep("Remove NickName", "INFO");
        waitUntilElementVisisble("//div[@class='vehicle-settings-main-header']");
       enterByXpath("//label/strong[normalize-space()='Nickname']/following-sibling::input[@name='nickName']", "");
       clickByXpathJavascriptExecutor("//span[normalize-space()='Save']");
       waitUntilElementVisisble("//div[@class='overview-header-title']/strong[contains(text(),'TELLURIDE')]");
       verifyTextContainsByXpath("//div[@class='overview-header-title']/strong", "TELLURIDE");
        return this;
    }  
    
    /**
     
     * Description: Method to click Account 
     */
    public P5_Dashboard clickAccountsDropDown() throws InterruptedException {
        reportStep("Clicking Accounts Dropdown", "INFO");
        clickByXpathJavascriptExecutor("//div[@class='account-menu']//button");
        List<WebElement> findElements = driver.findElements(By.xpath("//ul[@class='dropdown-menu account-menu-list']//i//following-sibling::span"));
        for (WebElement languages : findElements)
        {
            if (languages.getText().contains("Settings") || languages.getText().contains("Driver Preferences") || languages.getText().contains("Log Out")) {
                 reportStep(languages.getText(), "PASS");
            }
             else {
                 reportStep("Actual text not matching with the expected text "+languages.getText(), "FAIL");
            }
           }
        return this;

 

    }

    /**
     
     * Description: Method to click settings 
     */
    public P5_Dashboard goToSettings() throws InterruptedException {
        reportStep("Clicking settings", "INFO");
        clickByXpath("//a[@id='account-settings']");
        waitUntilElementVisisble("//*[text()='First Name ']");
        isElementPresent("//*[text()='First Name ']");
        return this;
}

    /**
     
     * Description: Method to click Driver preference 
     */
    public P5_Dashboard goToDriverPreferences() throws InterruptedException {
          reportStep("Clicking Driver preferences", "INFO");
          clickByXpath("//a[@id='account-driverpref']");
          waitUntilElementVisisble("//div[@class='page-view-header']/h2");
           verifyTextContainsByXpath("//div[@class='page-view-header']/h2", "Driver Preferences");
          return this;
  }
    
    /**
     
     * Description: Method to click Logout 
     */
    public P5_Dashboard clickLogout() throws InterruptedException {
        reportStep("Clicking Log out option", "INFO");
        clickByXpath("//a[@id='account-logout']");
        waitUntilElementVisisble("//a[@id='header-signIn']");
         verifyTextContainsByXpath("//a[@id='header-signIn']", "SIGN IN");
        return this;
}
    
    /**
     
     * Description: Method to click Notification icon 
     */
    public P5_Dashboard clickNotificationIcon() throws InterruptedException {
        reportStep("Clicking Notification Icon", "INFO");
        waitUntilElementVisisble("//div[@class='notifications-menu unread']");
        clickByXpath("//div[@class='notifications-menu unread']");
        waitUntilElementVisisble("//div[@class='menu-anchor']/a");
         verifyTextContainsByXpath("//div[@class='menu-anchor']/a", "SEE ALL NOTIFICATIONS");
        return this;
}
    
    /**
     
     * Description: Method to click See All Notifications 
     */
    public P5_Dashboard verifySeeAllNotifications() throws InterruptedException {
        reportStep("Clicking SEE ALL Notifications", "INFO");
        waitUntilElementVisisble("//div[@class='menu-anchor']");
        clickByXpath("//div[@class='menu-anchor']");
        waitUntilElementVisisble("//div[@class='page-view-inner']/h2");
         verifyTextContainsByXpath("//div[@class='page-view-inner']/h2", "Notifications");
        return this;
}
    
    /**
     
     * Description: Method to verify All and Remote category  
     */
    public P5_Dashboard verifyAllAndRemoteCategory() throws InterruptedException {
        reportStep("Verifying ALL And Remote Category Present", "INFO");
        waitUntilElementVisisble("//ul[@class='category-filter-list']/li[1]");
        verifyTextContainsByXpath("//ul[@class='category-filter-list']/li[1]", "ALL");
         verifyTextContainsByXpath("//ul[@class='category-filter-list']/li[9]", "REMOTE");
        return this;
}
    
    /**
     
     * Description: Method to verify All Notifications category  
     */
    public P5_Dashboard verifyAllNotificationsCategory() throws InterruptedException {
        reportStep("Verifying ALL Category", "INFO");
        waitUntilElementVisisble("//ul[@class='category-filter-list']/li[1]");
        clickByXpath("//ul[@class='category-filter-list']/li[1]");
        int size = driver.findElements(By.xpath("//ul[@class='notification-list']/li")).size();
        String AllNotificationCnt = String.valueOf(size);
        verifyTextContainsByXpath("//ul[@class='category-filter-list']/li[1]/span", AllNotificationCnt);
        return this;
}
    
    /**
     
     * Description: Method to verify Remote Notifications category  
     */
    public P5_Dashboard verifyRemoteNotificationsCategory() throws InterruptedException {
        reportStep("Verifying Remote Category", "INFO");
        waitUntilElementVisisble("//ul[@class='category-filter-list']/li[1]");
        clickByXpath("//ul[@class='category-filter-list']/li[9]");
        int size = driver.findElements(By.xpath("//ul[@class='notification-list']/li")).size();
        String RemoteNotificationCnt = String.valueOf(size);
        verifyTextContainsByXpath("//ul[@class='category-filter-list']/li[1]/span", RemoteNotificationCnt);
        return this;
}
    
    /**
     
     * Description: Method to click Make An Appointment  
     */
    public P5_Dashboard clickMakeAnAppointment() throws InterruptedException {
        reportStep("Clicking Make An Appointment", "INFO");
        waitUntilElementVisisble("//a[@id='headerMakeAnAppointmentLink']");
        clickByXpath("//a[@id='headerMakeAnAppointmentLink']");
        waitUntilElementVisisble("//div[@class='modal-request-appointment']//strong[@class='modal-title']");
        verifyTextContainsByXpath("//div[@class='modal-request-appointment']//strong[@class='modal-title']", "MAKE AN APPOINTMENT");
        return this;
}
    
    /**
     
     * Description: Method to click SELECT NEARBY DEALER  
     */
    public P5_Dashboard clickSelectNearbyDealerLink() throws InterruptedException {
        reportStep("Clicking Select Nearby Dealer Link", "INFO");
        waitUntilElementVisisble("//a[@class='dtmSelectNearbyDealer']");
        clickByXpath("//a[@class='dtmSelectNearbyDealer']");
        waitUntilElementVisisble("//div[@class='modal-preferred-dealer']/strong");
        verifyTextContainsByXpath("//div[@class='modal-preferred-dealer']/strong", "SELECT NEARBY DEALER");
        return this;
}
    /**
     
     * Description: Method to SELECT NEARBY DEALER  
     */
    public P5_Dashboard selectNearbyDealer(String zipCode) throws InterruptedException {
    	clickByXpath("//a[@class='dtmSelectNearbyDealer']");
        waitUntilElementVisisble("//div[@class='modal-preferred-dealer']/strong");
        verifyTextContainsByXpath("//div[@class='modal-preferred-dealer']/strong", "SELECT NEARBY DEALER");
        enterByXpath("//div[@class='item show-back active']//input[@name='dealer_map_search']", zipCode);
        driver.findElement(By.xpath("//div[@class='item show-back active']//input[@name='dealer_map_search']")).sendKeys(Keys.ENTER);
        waitUntilElementVisisble("//label[@title='Kia of Irvine']");
        scrollToElement("//label[@title='Kia of Irvine']");
        clickByXpathJavascriptExecutor("//label[@title='Kia of Irvine']");
        scrollToElement("//span[@class='button preferred-dealer-submit has-spinner']");
        clickByXpathJavascriptExecutor("//span[@class='button preferred-dealer-submit has-spinner']");
        waitUntilElementVisisble("//div[@class='modal-request-appointment']//strong[@class='modal-title']");
        return this;
}
    
     public P14_ReferenceMaterial clickOnReferenceMaterialTab(String referenceMaterial) throws InterruptedException {
		
		waitUntilElementVisisble("//span[normalize-space()='Remote']");
		scrollToElement("//span[normalize-space()='Reference Material']");
		clickOnLeftMenu(referenceMaterial);
		waitUntilElementVisisble("//*[@class='RMDisclaimer']");
		return new P14_ReferenceMaterial(driver,test);
	}
     
     /**
         
         * Description: Method to click Vehicle Repair radio button 
         */

        public P5_Dashboard checkVehicleRepairRadioButton() {
        	boolean enabled = driver.findElement(By.xpath("//label[@class='radio']//strong[contains(text(),'Vehicle Repair')]")).isEnabled();
            clickByXpathCheck("//label[@class='radio']//strong[contains(text(),'Vehicle Repair')]");
            if (enabled==true) {
				reportStep("Vehicle Repair radio button is enabled and clicked", "PASS");
			} else {
				reportStep("Vehicle Repair radio button is disabled", "FAIL");
			}
            return this;
        }

        /**
         
         * Description: Method to click Maintenance radio button 
         */
        public P5_Dashboard checkMaintenanceRadioButton() {
        	boolean enabled = driver.findElement(By.xpath("//label[@class='radio']//strong[contains(text(),'Maintenance')]")).isEnabled();
        	clickByXpathCheck("//label[@class='radio']//strong[contains(text(),'Maintenance')]");
        	if (enabled==true) {
				reportStep("Maintenance radio button is enabled and clicked", "PASS");
			} else {
				reportStep("Maintenance radio button is disabled", "FAIL");
			}
            return this;
        }

        /**
         
         * Description: Method to click other radio button 
         */
        public P5_Dashboard checkOtherRadioButton() {
        	boolean enabled = driver.findElement(By.xpath("//label[@class='radio']//strong[contains(text(),'Other')]")).isEnabled();
            clickByXpathCheck("//label[@class='radio']//strong[contains(text(),'Other')]");
            if (enabled==true) {
				reportStep("Other radio button is enabled and clicked", "PASS");
			} else {
				reportStep("Other radio button is disabled", "FAIL");
			}
            return this;
        }

        /**
         
         * Description: Method to click Request Appointment radio button 
         */
        public P5_Dashboard clickRequestAppointmentButton() {
        	boolean enabled = driver.findElement(By.xpath("//span[@id='create_request_appointment']")).isEnabled();
            clickByXpathJavascriptExecutor("//span[@id='create_request_appointment']");
            if (enabled==true) {
				reportStep("Request Appointment button is enabled and clicked", "PASS");
			} else {
				reportStep("Request Appointment button is disabled", "FAIL");
			}
            return this;
        }
        
        /**
        
        * Description: Method to close Make An Appointment popup 
        */
       public P5_Dashboard closeMakeAnAppointmentpopup() {
           clickByXpathJavascriptExecutor("//div[@id='request-appointment']//span[@class='icon-close']");
           return this;
       }
       
       /**
        
        * Description: Method to Request Appointment
        */
       public P5_Dashboard requestAppointment() throws InterruptedException {
    	   waitUntilElementVisisble("//div[normalize-space()='Services']");
           clickByXpath("//div[@aria-label='Rotate tires, inspect tread wear, and tire pressure']");
           clickByXpathJavascriptExecutor("//span[text()='Next']");
           waitUntilElementVisisble("//h1[text()='While we are servicing your vehicle...']");
           clickByXpathJavascriptExecutor("//div[text()='I have a ride']");
           clickByXpathJavascriptExecutor("//span[text()='Next']");
           waitUntilElementVisisble("//div[@aria-label='8:00 AM']");
           clickByXpathJavascriptExecutor("//div[@aria-label='8:00 AM']");
           waitUntilElementVisisble("//div[text()='REVIEW']");
           clickByXpathJavascriptExecutor("//div[text()='REVIEW']");
           waitUntilElementVisisble("//div[@class='button-label']/span[text()='BOOK SERVICE']");
           clickByXpathJavascriptExecutor("//div[@class='button-label']/div/span[text()='schedule']");
           waitUntilElementVisisble("//h1[@class='success__middle--title']");
           verifyTextByXpath("//h1[@class='success__middle--title']", "Success!");
           return this;
       }
     
       /**
        
        * Description: Method to Change DEALER  
        */
       public P5_Dashboard changeDealer(String zipCode) throws InterruptedException {
    	   waitUntilElementVisisble("//li[@class='extra-space no-input has-dealer-choice']//span[@class='link']");
       	clickByXpath("//li[@class='extra-space no-input has-dealer-choice']//span[@class='link']");
           waitUntilElementVisisble("//div[@class='modal-preferred-dealer']/strong");
           verifyTextContainsByXpath("//div[@class='modal-preferred-dealer']/strong", "CHOOSE A DEALER");
           enterByXpath("//div[@class='item show-back active']//input[@name='dealer_map_search']", zipCode);
           driver.findElement(By.xpath("//div[@class='item show-back active']//input[@name='dealer_map_search']")).sendKeys(Keys.ENTER);
           waitUntilElementVisisble("//label[@title='Kia of Irvine']");
           scrollToElement("//label[@title='Kia of Irvine']");
           clickByXpathJavascriptExecutor("//label[@title='Kia of Irvine']");
           scrollToElement("//span[@class='button preferred-dealer-submit has-spinner']");
           clickByXpathJavascriptExecutor("//span[@class='button preferred-dealer-submit has-spinner']");
           waitUntilElementVisisble("//div[@class='vehicle-settings-main-header']");
           verifyTextContainsByXpath("//span[@class='preferred-dealer-choice']/strong", "Kia of Irvine");
           return this;
   }
       
       /**
        
        * Description: Method to click Print Icon
        */
       public P5_Dashboard clickPrintIcon() {
    	   waitUntilElementVisisble("//span[@class='print']");
           clickByXpath("//span[@class='print']");
           closeAllBrowsers();
           return this;
       }

}
