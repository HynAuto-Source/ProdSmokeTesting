package pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P4_MyVehicles extends KMABase {

	public P4_MyVehicles(WebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		waitUntilElementVisisble("//*[@class='vehicle-tab active']");
		if (!verifyTitle("Welcome")) {
			reportStep("This is not Welcome Page", "FAIL");
		}
	}

	
	
	
	public P4_MyVehicles(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver = driver;
		this.test =test;
		waitUntilElementVisisble("//*[@class='vehicle-tab active']");
		if(!verifyTitle("Welcome")){
			reportStep("This is not Welcome Page", "FAIL");	
		}		
	}
		
	// For Prod Environment 
	/*
	 * public P5_Dashboard pickTheCar(String vehicleModel) throws
	 * InterruptedException {
	 * waitUntilElementVisisble("(//*[@title='TELLURIDE'])[1]");
	 * pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong",
	 * vehicleModel, "(//*[@title='TELLURIDE'])[1]");
	 * waitUntilElementVisisble("//*[@class='dropdown-toggle']"); return new
	 * P5_Dashboard(driver, test); }
	 */
		
	
	//For Stage Environment
/*	public P5_Dashboard pickTheCarStg(String vehicleModel) throws InterruptedException {
		waitUntilElementVisisble("(//*[@title='TELLURIDE'])[2]");
		pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel, "(//*[@title='TELLURIDE'])[2]");   
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		return new P5_Dashboard(driver, test);
	}*/
		
		public P4_MyVehicles clickAccount() throws InterruptedException {
			waitUntilElementVisisble("//*[@class='dropdown-toggle']");
			clickByXpathJavascriptExecutor("//*[@class='dropdown-toggle']");
			return new P4_MyVehicles(driver, test);
		}
		
		
		public P0_Settings clickSettings() {
			waitUntilElementVisisble("//*[@class='dropdown-toggle']");
			clickByXpathJavascriptExecutor("(//*[text()='Settings'])[1]");
			waitUntilElementVisisble("//*[@class='personal-tab active']");
			return new P0_Settings(driver, test);
		}
		
		public P2_Login clickLogout() throws InterruptedException {
			waitUntilElementVisisble("(//*[text()='Log Out'])[2]");
			clickByXpath("(//*[text()='Log Out'])[2]");
			return new P2_Login(driver, test);
		}
		
		
		
		public P4_MyVehicles clickAddVehicle() {
			waitUntilElementVisisble("(//*[@title='Add Vehicle'])[1]");
			clickByXpathJavascriptExecutor("(//*[@title='Add Vehicle'])[1]");
			//clickByXpath("//span[normalize-space()='Add Vehicle']");
			waitUntilElementVisisble("//*[@title=' Where can I find my VIN?']");
			return this;
		}
		
		
		
		
		
		/*
		 * public P13_AdditionalDrivers clickAdditionalDrivers() throws
		 * InterruptedException {
		 * waitUntilElementVisisble("(//*[@class='additional-driver-tab'])[2]");
		 * clickByXpathJavascriptExecutor("(//*[@class='additional-driver-tab'])[2]");
		 * waitUntilElementVisisble("//*[contains(text(),'Additional Drivers')]");
		 * return new P13_AdditionalDrivers(driver, test); }
		 */
		
		
		public P13_AdditionalDrivers acceptRequestFromPrimaryAccount(String vehicleModel) throws InterruptedException {
			waitUntilElementVisisble("//*[@class='acceptRejectLinkBtn button outline red']");
			pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel, "//*[@class='acceptRejectLinkBtn button outline red']");
			//waitUntilElementVisisble("//*[text()=' DRIVER ACCESS']");
			waitUntilElementVisisble("(//*[@class='icon-close'])[5]");
			clickByXpath("(//*[@class='checkmark'])[1]");
			clickByXpath("(//*[@class='checkmark'])[2]");
			clickByXpath("(//*[@class='checkmark'])[3]");
			waitUntilElementVisisble("//*[contains(text(),'LINK ACCOUNT')]");
			clickByXpath("//*[contains(text(),'LINK ACCOUNT')]");
			waitUntilElementVisisble("//*[contains(text(),'Linking in progress')]");
			return new P13_AdditionalDrivers(driver, test);
		}

		
		
		
		public P4_MyVehicles rejectThePrimaryDriverRequest(String vehicleModel) {		
			waitUntilElementVisisble("(//*[contains(text(),'REJECT')])[1]");
			pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel, "(//*[contains(text(),'REJECT')])[1]");
			//clickByXpath("(//*[contains(text(),'REJECT')])[1]");
			waitUntilElementVisisble("//*[contains(text(),' Unlinking in progress')]");			
			return this;
		}
		
		
		public P4_MyVehicles addRequestBySecondaryDriver(String vehicleModel) {
			waitUntilElementVisisble("(//*[@title='TELLURIDE'])[1]");
			pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel, "(//*[@title='TELLURIDE'])[1]");   
		    waitUntilElementVisisble("//*[contains(text(),'Request Access?')]");
		    clickByXpath("//*[contains(text(),'Request Access?')]");
		    waitUntilElementVisisble("(//*[contains(text(),'2023 TELLURIDE')])[3]"); 
		   // waitUntilElementVisisble("(//*[contains(text(),'Cancel ')])[3]");
		    clickByXpath("(//*[@class='checkmark'])[1]");
		    clickByXpath("(//*[@class='checkmark'])[2]");
		    clickByXpath("(//*[@class='checkmark'])[3]");
		    waitUntilElementVisisble("//*[contains(text(),'SEND REQUEST')]");
		    clickByXpath("//*[contains(text(),'SEND REQUEST')]");
		    waitUntilElementVisisble("//*[@class='icon-info']");	
		return this;
	}
		
		
		
		
		
	/*	public P13_AdditionalDrivers secondaryDriverInitiateTheRequest(String VINNumber) throws InterruptedException {
			waitUntilElementVisisble("(//*[@title='Add Vehicle'])[1]");
			clickByXpath("(//*[@title='Add Vehicle'])[1]");
			//enterValuesInAlert(VINNumber);
			//waitUntilElementVisisble("//*[@name='vin']");
			waitUntilElementVisisble("//*[@id='add-my-vehicle-slider']/div/div[1]/app-add-vehicle-modal/div/div/form/ul/li/span/input");
			enterByXpathJavascriptExecutor("//*[@id='add-my-vehicle-slider']/div/div[1]/app-add-vehicle-modal/div/div/form/ul/li/span/input", VINNumber);
			waitUntilElementVisisble("//*[@title='Verify VIN']");
			clickByXpath("//*[@title='Verify VIN']");
			waitUntilElementVisisble("//*[@title='Save and Close']");
			clickByXpath("//*[@title='Save and Close']");
			waitUntilElementVisisble("(//*[contains(text(),'My TELLURIDE')])[1]");			
			return new P13_AdditionalDrivers(driver, test);
		}*/
		
	
	//--------------------------------------------------------
	/**
	 *  Description: My vehicle Option
	 */
	public P4_MyVehicles verifyMyVechileScreen() throws InterruptedException {

		waitUntilElementVisisble(
				"//div[@class='my-vehicles-ulility-nav']//following::h1[contains(text(),'My Vehicles')]");
		if (driver.findElement(By.xpath(
						"//div[@class='my-vehicles-ulility-nav']//following::h1[contains(text(),'My Vehicles')]")).isDisplayed()) 
		{
			reportStep("As expected user has been navigate to 'My vehicle' screen", "pass");
			
			if (driver.findElement(By.xpath("//input[@placeholder='Search']/../input")).isDisplayed()) {
				
				String searchText = driver.findElement(By.xpath("//input[@placeholder='Search']/../input"))
						.getAttribute("placeholder");
				reportStep("Vehicle search box is present name as " + searchText, "pass");
			} else {
				reportStep("Vehicle search box is not present", "Fail");
			}
			if (driver.findElement(By.xpath("//span[@title='Add Vehicle']")).isDisplayed()) {
				reportStep("Add Vechile button is present", "pass");
			} else {
				reportStep("Add Vechile button not present", "Fail");
			}
			verifyCarDetails();
		} else {
			reportStep("Failed to navigate to My vehicle page", "Fail");
		}
		return this;
	}

	/**
	 *  Description: My vehicle Option
	 */
	public P4_MyVehicles verifyCarDetails() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		if (driver.findElement(By.xpath("//*[@title='TELLURIDE']")).isDisplayed()) {
			reportStep("As expected Car section is present under my vechile  ", "pass");
			String mileageText = getTextByXpath1(
					"//*[@title='TELLURIDE']/../following-sibling::div//div//div//strong[normalize-space()='Mileage']//following-sibling::em");
			String serviceText = getTextByXpath1(
					"//*[@title='TELLURIDE']/../following-sibling::div//div//div//strong[normalize-space()='Next Service In']//following-sibling::em");
			String diagnosticText = getTextByXpath1(
					"//*[@title='TELLURIDE']/../following-sibling::div//div//div//strong[normalize-space()='Diagnostic Issue']//following-sibling::em");
			reportStep("As expected car 'Mileage' detail is present as " + mileageText, "pass");
			reportStep("As expected car 'Next Service In' detail is present as " + serviceText, "pass");
			reportStep("As expected car 'Diagnostic Issue' detail is present as " + diagnosticText, "pass");
		} else {
			reportStep("Failed to display car section in my vehicle page", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Validate searchbox
	 */
	public P4_MyVehicles enterInvalidDataInSearchBox() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		enterByXpath("//input[@placeholder='Search']/../input", "fhf");
		waitUntilElementVisisble("//div[@class='no-results-found show']");
		String warningMsg = getTextByXpath1("//div[@class='no-results-found show']");
		if (warningMsg.equalsIgnoreCase("No vehicles matched this search")) {
			reportStep("As expected pop up is displayed", "Pass");
		} else {
			reportStep("Pop up not displayed", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Validate searchbox by year
	 */
	public P4_MyVehicles verifysearchBoxByYear(String year) throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		enterByXpath("//input[@placeholder='Search']/../input", year);
		waitUntilElementVisisble("//*[@title='TELLURIDE']//preceding::em[normalize-space()='2023 TELLURIDE']");
		reportStep("As expected, vehicle is displayed through search by year.", "Pass");
		return this;
	}

	/**
	 *  Description: Validate searchbox by model
	 */
	public P4_MyVehicles verifysearchBoxByModel(String model) throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		enterByXpath("//input[@placeholder='Search']/../input", model);
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		reportStep("As expected,vehicle is displayed through search by model name.", "Pass");
		return this;
	}

	/**
	 *  Description: Validate searchbox by model
	 */
	public P4_MyVehicles verifysearchBoxByNickName(String nickName) throws InterruptedException {
		enterByXpath("//input[@placeholder='Search']/../input", nickName);
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		reportStep("As expected vehicle is displayed through search by model name", "Pass");
		return this;
	}

	/**
	 *  Description: Verify Addvechile button
	 */
	public P4_MyVehicles clickAddVechilesButton() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		reportStep("verify 'Add your Vechile'pop up", "info");
		clickByXpath("//span[@title='Add Vehicle']");
		waitUntilElementVisisble("//div[@class='item active remember-back']");
		reportStep("As expected 'Add vechile' button is clickable", "Pass");
		return this;
	}

	/**
	 *  Description: Verify Addvechile button
	 */
	public P4_MyVehicles VerifyAddVechilesButton() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		reportStep("verify 'Add your Vechile'pop up", "info");
		clickByXpath("//span[@title='Add Vehicle']");
		waitUntilElementVisisble("//div[@class='item active remember-back']");
		reportStep("As expected 'Add your Vechile'pop up is displayed while clicking the 'Add vechile' button", "Pass");
		return this;
	}

	/**
	 *  Description: Verify VIN button
	 */
	public P4_MyVehicles verifyVinButtonIsDisable() throws InterruptedException {
		if (driver.findElement(By.name("vin")).getAttribute("value").isEmpty()) {
			String disableChk = driver.findElement(By.xpath("//span[@title='Verify VIN']")).getAttribute("class");
			if (disableChk.contains("disabled")) {
				reportStep("As expected 'Verify vin' button is disabled", "Pass");

			} else {
				reportStep("Enabled", "Fail");
			}
		} else {
			reportStep("SearchBox is not empty", "Fail");

		}

		return this;
	}

	/**
	 *  Description: Verify VIN button
	 */
	public P4_MyVehicles enterVinNumber(String vinNumber) throws InterruptedException {
		if (driver.findElement(By.name("vin")).getAttribute("value").isEmpty()) {
			enterByName("vin", vinNumber);
			reportStep("As expected user able to enter the vin number", "Pass");
		} else {
			reportStep("SearchBox is not empty", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Verify setting button
	 */
	public P4_MyVehicles checkSettingsButton() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		scrollDownJavaScriptExecutor("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']//a[@class='my-vehicles-list-item-settings-icon']//*[local-name()='svg']");
//		scrollToElement("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']//a[@class='my-vehicles-list-item-settings-icon']//*[local-name()='svg']");
		clickByXpath(
				"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']//a[@class='my-vehicles-list-item-settings-icon']//*[local-name()='svg']");
		if (driver.findElement(By.xpath("//strong[normalize-space()='2023 TELLURIDE']")).isDisplayed()) {
			reportStep("As Expected,'Setting' button is clickable and navigate to respective screen", "Pass");

		} else {
			reportStep("Setting button failed to click", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Verify VIN button
	 */
	public P4_MyVehicles verifyVinButton(String vinNumber) throws InterruptedException {
		if (driver.findElement(By.name("vin")).getAttribute("value").isEmpty()) {
			enterByName("vin", vinNumber);
			String disableChk = driver.findElement(By.xpath("//span[@title='Verify VIN']")).getAttribute("class");
			if (!disableChk.contains("disabled")) {
				reportStep("As expected 'Verify vin' button is enabled post enter the Vin numner", "Pass");

			} else {
				reportStep("Enabled", "Fail");
			}
		} else {
			reportStep("SearchBox is not empty", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Verify invalid VIN number
	 */
	public P4_MyVehicles verifyInvalidVinNumber(String vinNumber) throws InterruptedException {

		verifyVinButton(vinNumber);
		clickByXpath("//span[@title='Verify VIN']");
		reportStep("To check warning is displayed while entering invalid VIN ", "Info");
		if (driver.findElement(By.xpath("//span[@class='error-message']")).isDisplayed()) {
			String warnMessage = getTextByXpath1("//span[@class='error-message']");
			if (warnMessage.equalsIgnoreCase("Please enter a valid VIN")) {
				reportStep("As Expected warning message is displayed as " + warnMessage, "Pass");
			}
		} else {
			reportStep("Failed to display warning message", "Fail");
		}
		return this;
	}

	public P4_MyVehicles clickVechiles() throws InterruptedException {
		//waitUntilElementVisisble("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		clickByXpath("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		return this;
	}

	/**
	 *  Description: verify Where can I find my VIN
	 */

	public P4_MyVehicles verifyWhereICanFindVin() {
		waitUntilElementVisisble("//span[@title=' Where can I find my VIN?']");
		clickByXpath("//span[@title=' Where can I find my VIN?']");
		if (driver.findElement(By.xpath("//div[@class='modal-find-vin']/strong")).isDisplayed()) {
			reportStep("'Where can I find my VIN' is clickable and pop up is displayed as expected", "Pass");
		} else {
			reportStep("'Where can I find my VIN' is not clickable", "Fail");
		}
		return this;
	}

	/**
	 *  Description: VechileName
	 */

	public P4_MyVehicles searchVehicleName(String vehicleModel) {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		enterByXpath("//input[@placeholder='Search']/../input", vehicleModel);
		reportStep("As expected user able vehicle name fo search", "Pass");
		return this;
	}

	/**
	 *  Description: Select the car
	 */

	public P4_MyVehicles selectTheCar() {
		waitUntilElementVisisble(
				"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
		clickByXpathJavascriptExecutor("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		reportStep("As expected vechile is selected through search keyword", "pass");
		return this;
	}

	/**
	 *  Description: select the car by checkbox
	 */

	public P4_MyVehicles verifyCheckboxOnCar() {
		waitUntilElementVisisble(
				"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
		clickByXpathJavascriptExecutor(
				"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']//label");
		waitUntilElementVisisble("//span[normalize-space()='Cancel']");
		if (driver.findElement(By.xpath("//span[normalize-space()='Cancel']")).isDisplayed()) {
			reportStep("As expected,'Cancel' button is displayed while select the car", "pass");
		} else {
			reportStep("Cancel button not displyed as expected", "Fail");
		}
		if (driver.findElement(By.xpath("//span[@class='delete-selected']")).isDisplayed()) {
			reportStep("As expected,'Delete selected' button is displayed while select the car", "pass");
		} else {
			reportStep("Delete selected not displyed as expected", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Verify cancel button
	 */

	public P4_MyVehicles clickAndVerifyCancelButton() {
		if (driver.findElement(By.xpath("//span[normalize-space()='Cancel']")).isDisplayed()) {
			clickByXpath("//span[normalize-space()='Cancel']");
			if (driver.findElement(By.xpath(
					"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']//label"))
					.isSelected()) {
				reportStep("Failed to deselect the car", "Fail");
			} else {
				reportStep("As expected,'Cancel' button is clicked and selected car is deselected", "pass");
			}
		} else {
			reportStep("Cancel button not displyed as expected", "Fail");
		}
		return this;
	}

	/**
	 *  Description: Verify gridView
	 */
	public P4_MyVehicles verifyGrid() {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		if (driver.findElement(By.xpath("//a[@class='switch-view-grid active']//*[local-name()='svg']")).isDisplayed()) {
			reportStep("As expected vehicle view is in grid view", "Pass");
		} else {
			reportStep("Grid view is not as expected", "Fail");
		}
		return this;
	}
	
	/**
	 *  Description: Verify map icon
	 */
	public P4_MyVehicles verifyMap() {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
			clickByXpath("//a[@class='switch-view-map']//*[local-name()='svg']");
			waitUntilElementVisisble("//a[@class='switch-view-map active']");
			if (driver.findElement(By.xpath("//a[@class='switch-view-map active']")).isDisplayed()) {
			reportStep("As expected Map is clickable and redirected to map screen", "Pass");
		} else {
			reportStep("Map icon is not as expected", "Fail");
		}
		return this;
	}
	
	/**
	 *  Description: Verify gridView
	 */
	public P4_MyVehicles verifyVehicleListByhamburgerIcon() {
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		if (driver.findElement(By.xpath("//a[@class='switch-view-list']//*[local-name()='svg']")).isDisplayed()) {
			clickByXpath("//a[@class='switch-view-list']//*[local-name()='svg']");
			List<WebElement> modelName=driver.findElements(By.xpath("//div[@class='my-vehicles-list-item-model cell-model']"));
			for (WebElement vechilename : modelName) {
				String name= vechilename.getText();
				reportStep("vehicle name is displayed as list as "+name, "pass");			
			}
		} else {
			reportStep("Hamburger icon is not found", "Fail");
		}
		return this;
	}

	public P5_Dashboard pickTheCar(String vehicleModel) throws InterruptedException {
		waitUntilElementVisisble("//div[@class='my-vehicles-grid-item-image']//img[@title='TELLURIDE'][1]");
		scrollToElement("//div[@class='my-vehicles-grid-item-image']//img[@title='TELLURIDE'][1]");
		pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel,
				"(//img[@title='TELLURIDE'])[1]");
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		reportStep("As expected vehicle is selected through search keyword", "pass");
		
		 driver.findElement(By.xpath("//button[text()='CLOSE']")).click();
		 
		return new P5_Dashboard(driver, test);
	}
	
	public P5_Dashboard pickTheStingerCar(String vehicleModel) throws InterruptedException {
		waitUntilElementVisisble("//div[@class='my-vehicles-grid-item-image']//img[@title='STINGER']");
		scrollToElement("//div[@class='my-vehicles-grid-item-image']//img[@title='STINGER']");
		pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel,
				"(//img[@title='STINGER'])[1]");
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		reportStep("As expected vechile is selected through search keyword", "pass");
		
		 driver.findElement(By.xpath("//button[text()='CLOSE']")).click();
		 
		return new P5_Dashboard(driver, test);
	}
	
	public P4_MyVehicles goToSettings() throws InterruptedException {
		waitUntilElementVisisble("//div[@class='my-vehicles-grid-item-image']//img[@title='TELLURIDE'][1]");
		reportStep("Clicking settings icon", "INFO");
		clickByXpath("//div[@class='account-menu']");
		
		reportStep("Clicking settings Icon", "INFO");
		clickByXpath("//a[@id='account-settings']");
		return this;
}
	
	  public P5_Dashboard pickTheEV6Car(String vehicleModel) throws InterruptedException {
	        waitUntilElementVisisble("//div[@class='my-vehicles-grid-item-image']//img[@title='EV6']");
	        scrollToElement("//div[@class='my-vehicles-grid-item-image']//img[@title='EV6']");
	        pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel,
	                "(//img[@title='EV6'])[1]");
	        waitUntilElementVisisble("//*[@class='dropdown-toggle']");
	        reportStep("As expected vechile is selected through search keyword", "pass");    
	         driver.findElement(By.xpath("//button[text()='CLOSE']")).click();
	        return new P5_Dashboard(driver, test);

	    }
	  
		public P13_AdditionalDrivers clickAdditionalDrivers() throws InterruptedException {
			waitUntilElementVisisble("//a[@class='additional-driver-tab']");
			clickByXpath("//a[@class='additional-driver-tab']");
			return new P13_AdditionalDrivers(driver, test);
		}
		
		/**
		 *  Description: select the car by checkbox
		 */

		public P4_MyVehicles verifyDeleteButtonIsEnabled() {
			waitUntilElementVisisble(
					"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
			clickByXpathJavascriptExecutor(
					"//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']//label");
			waitUntilElementVisisble("//span[normalize-space()='Cancel']");
			if (driver.findElement(By.xpath("//span[@class='delete-selected']")).isEnabled()) {
				reportStep("As expected,'Delete selected' button is enable", "pass");
			} else {
				reportStep("Delete selected not displyed as expected", "Fail");
			}
			return this;
		}
	
}
