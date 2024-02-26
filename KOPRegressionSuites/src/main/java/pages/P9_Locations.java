package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P9_Locations extends KMABase {
	
	public P9_Locations(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("Locations")) {
			reportStep("This is not Locations Page", "FAIL");
		}
		
	}
	

	/*
	 * public P9_Locations vehicleCurrentLocation() {
	 * waitUntilElementVisisble("//*[@id='autoSearchInput']");
	 * Assert.assertTrue(driver.findElement(By.id("pinrefresh")).isDisplayed());
	 * return this; }
	 */


	public P9_Locations searchIsPresent_5754511() {
		waitUntilElementVisisble("//*[@id='autoSearchInput']");	
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='autoSearchInput']")).isDisplayed());
		return this; 
	}
	
	
	public P9_Locations savePOI(String locationPOI) {
		
		waitUntilElementVisisble("//*[@id='autoSearchInput']");						//waitUntilElementVisisble("//*[@id='poiDetailID']//*[@id='autoSearchInput']");
		enterByXpath("//*[@id='autoSearchInput']", locationPOI);					//enterByXpath("//*[@id='poiDetailID']//*[@id='autoSearchInput']", "Hertz");
		waitUntilElementVisisble("//ul[@class='locations-search-results-list']//li");
		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ul[@class='locations-search-results-list']//li"));
				//findElementsByXPath("//ul[@class='locations-search-results-list']//li");
		optionsToSelect.get(0).click();
		waitUntilElementVisisble("//*[@class='button add-to-pois']");
		clickByXpathJavascriptExecutor("//*[@class='button add-to-pois']");
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this;	
	}
	
	
	
	public P9_Locations deletePOI() {
		
		waitUntilElementVisisble("//*[@id='autoSearchInput']");
		clickByXpath("//*[text()='MY POIS']");
		waitUntilElementVisisble("(//*[@class='locations-search-results-list'])[2]");				////*[@class='locations-search-results-list']/li[2]
		clickByXpath("(//*[@class='locations-search-results-list'])[2]");
		waitUntilElementVisisble("(//*[@class='delete'])[1]");
		clickByXpath("(//*[@class='delete'])[1]");
		waitUntilElementVisisble("(//*[@class='close'])[8]");			
		return this;
	}
			
	
	public P9_Locations savePOIAddnSendToVehicle(String locationPOI) {
		waitUntilElementVisisble("//*[@id='autoSearchInput']");					
		enterByXpath("//*[@id='autoSearchInput']", locationPOI);					
		waitUntilElementVisisble("//ul[@class='locations-search-results-list']//li");
		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ul[@class='locations-search-results-list']//li"));
				//findElementsByXPath("//ul[@class='locations-search-results-list']//li");
		optionsToSelect.get(0).click();
		//waitUntilElementVisisble("//*[@class='button add-to-pois']");
		clickByXpathJavascriptExecutor("(//*[@title='Add to POIS'])[2]");
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this; 
	}
	
	
	/*
	 * public P9_Locations clickMyTrips() {
	 * waitUntilElementVisisble("//*[@class='page-view-subnav-items']/li[2]");
	 * clickByXpathJavascriptExecutor("(//*[@href='javascript:void(0)'])[6]");
	 * //waitUntilElementVisisble("div#reportrange"); return this; }
	 */
	
	
	public P9_Locations selectDateType() throws InterruptedException {
		waitUntilElementVisisble("(//*[text()='No trips found'])");
		clickById("reportrange");
		waitUntilElementVisisble("(//*[text()='This Month'])[1]");
		//waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("(//*[text()='This Month'])[1]");
		waitUntilElementVisisble("(//*[@class='export-btn'])");
		return this;
	}
	
	
	
	/*
	 * public P9_Locations addTags(String tripType) throws InterruptedException {
	 * 
	 * waitElementToBeClickableXpathFW();
	 * clickByCSSTagClass("span[class='badge add new-tag']");
	 * waitElementToBeClickableXpathFW();
	 * enterByXpathJSExecutor("(//*[@name='trip_tags'])[1]", tripType);
	 * waitElementToBeClickableXpathFW();
	 * waitUntilElementVisisble("(//*[@class='close'])[6]"); return this; }
	 */
	
	
	public P9_Locations deleteTags() {
		waitElementToBeClickableXpathFW();
		clickByCSSTagClass("span[class='badge add new-tag']");
		waitElementToBeClickableXpathFW();
		clearbyXpath("(//*[@name='trip_tags'])[1]");
		waitElementToBeClickableXpathFW();
		return this;
	}
	
	
	public P9_Locations deleteTagsForMergedTrip() {
		waitElementToBeClickableXpathFW();
		clickByCSSTagClass("span[class='badge add new-tag']");
		waitElementToBeClickableXpathFW();
		clearbyXpath("(//*[@name='trip_tags'])[1]");
		waitElementToBeClickableXpathFW();
		return this;
	}
	
	/*
	 * public P9_Locations mergeTrips() throws InterruptedException {
	 * waitUntilElementVisisble("(//*[text()='No trips found'])");
	 * clickByXpathJavascriptExecutor(
	 * "//*[@id='myTrips_results']/div/div[1]/div[1]/label/em");
	 * waitUntilElementVisisble("(//*[@class='icon-trip-alert-geo'])");
	 * clickByXpathJavascriptExecutor(
	 * "//*[@id='myTrips_results']/div/div[2]/div[1]/label/em");
	 * waitElementToBeClickableXpathFW();
	 * clickByXpathJavascriptExecutor("//*[@class='merge active']");
	 * waitUntilElementVisisble("(//*[@class='close'])[6]"); return this; }
	 */
	
	
	public P9_Locations addTagsForMergedTrips(String tripType) throws InterruptedException {
		waitElementToBeClickableXpathFW();
		//waitUntilElementVisisble("(//*[@class='badge add new-tag'])[1]");
		clickByXpathJavascriptExecutor("(//*[@name='trip_tags'])[2]");
		//clickByCSSTagClass("span[class='badge add new-tag']");
		waitElementToBeClickableXpathFW();
		//enterByXpathJSExecutor("(//*[@name='trip_tags'])[1]", tripType);
		enterByXpathJSExecutor("(//*[@name='trip_tags'])[2]", tripType);
		waitElementToBeClickableXpathFW();	
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}
	
	
	public P9_Locations unMergeTrips() {
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='myTrips_results']/div/div[1]/div[1]/label/em");
		waitUntilElementVisisble("//*[@class='unmerge active']");
		clickByXpathJavascriptExecutor("//*[@class='unmerge active']");
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}
	
	//----------------------------------------
	
		public P9_Locations vehicleCurrentLocation() {
			waitUntilElementVisisble("//*[@id='autoSearchInput']");
			Assert.assertTrue(driver.findElement(By.id("pinrefresh")).isDisplayed());
			reportStep("Getting the current loaction of the vehicle", "INFO");
			scrollToWebElement("(//*[@class='pin-data']//span)[1]");
			getTextByXpath("(//*[@class='pin-data']//span)[1]");
			return this;
		}
		
		/**
		 *  Description: Method to Enter value in location searchbox
		 */
		public P9_Locations enterValueInLoactionSearchBox(String pois) throws InterruptedException {
			waitUntilElementVisisble("//div[@class='vehicle-selector']");
			enterByXpath("//div[@class='locations-utility']//input[@placeholder='Search by name, city, state or zip']/../input", ""+pois+"");
			waitElementToBeClickableXpathFW();
			waitUntilElementVisisble("(//div[@class='locations-search-results-item-titles']/following-sibling::i)[1]");
			clickByXpath("(//div[@class='locations-search-results-item-titles']/following-sibling::i)[1]");
			waitUntilElementVisisble("//div[@class='poi-detail']/div[@class='poi-detail-main']");
			return this;
		}
		
		/**
		 *  Description: Method to Click Add To POIS
		 */
		public P9_Locations clickAddToPois(String pois) throws InterruptedException {
			reportStep("Adding POIS", "INFO");
			waitUntilElementVisisble("//div[@class='vehicle-selector']");
			clickByXpathJavascriptExecutor("(//span[@title='Add to POIS'])[1]");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "POI Updated Successfully");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			clickByXpathJavascriptExecutor("//span[text()='MY POIS']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			waitUntilElementVisisble("(//div[@class='locations-search-results-item-titles']/strong)[21]");
			verifyTextByXpath("(//div[@class='locations-search-results-item-titles']/strong)[21]", ""+pois+"");
			return this;
		}
		
		/**
		 *  Description: Method to Click Shell POI
		 */
		public P9_Locations clickShellPois() throws InterruptedException {
			reportStep("Clicking MY POIS", "INFO");
			waitUntilElementVisisble("//div[@class='vehicle-selector']");
//			clickByXpathJavascriptExecutor("//span[text()='MY POIS']");
			waitUntilElementVisisble("//div[@class='saved-pois-filters']/following-sibling::ul/li/div/div[@class='locations-search-results-item-titles']/strong[text()='Shell']");
			clickByXpathJavascriptExecutor("//div[@class='saved-pois-filters']/following-sibling::ul/li/div/div[@class='locations-search-results-item-titles']/strong[text()='Shell']");
//			waitUntilElementVisisble("//span[@class='delete']");
			return this;
		}
		
		/**
		 *  Description: Method to Delete POIS
		 */
		public P9_Locations deletePois() throws InterruptedException {
			reportStep("Deleting POIS", "INFO");
			waitUntilElementVisisble("(//div[@class='locations-search-results-item-titles']/strong)[21]");
			clickByXpathJavascriptExecutor("(//div[@class='locations-search-results-item-titles']/strong)[21]");
			waitUntilElementVisisble("//span[@class='delete']");
			clickByXpathJavascriptExecutor("//span[@class='delete']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "POI Deleted Successfully");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			return this;
		}
		
		/**
		 *  Description: Method to Click Add And Send To Vehicle
		 */
		public P9_Locations clickAddAndSendToVehicle(String pois) throws InterruptedException {
			reportStep("Add and Send To Vehicle POIS", "INFO");
			waitUntilElementVisisble("//div[@class='vehicle-selector']");
			clickByXpathJavascriptExecutor("(//span[@title='Add to POIS'])[1]");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "POI Updated Successfully");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			clickByXpathJavascriptExecutor("//span[text()='MY POIS']");
			waitUntilElementVisisble("(//div[@class='locations-search-results-item-titles']/strong)[21]");
			verifyTextByXpath("(//div[@class='locations-search-results-item-titles']/strong)[21]", ""+pois+"");
			return this;
		}
		
		/**
		 *  Description: Method to Add value in Notes field
		 */
		public P9_Locations enterValueInAddNotes(String pois) throws InterruptedException {
			waitUntilElementVisisble("//div[@class='vehicle-selector']");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			enterByXpath("//input[@name='notes']", "Test note");
			clickByXpathJavascriptExecutor("//button[@class='button save-poi-btn has-spinner']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "POI Updated Successfully");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			return this;
		}
		
		/**
		 *  Description: Method to click MY TRIPS in Locations
		 */
		public P9_Locations clickMyTrips() {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			reportStep("Clicking the remote start", "INFO");
			clickByXpath("//li[@class='trip-tab']");
			return this;
		}
		
		/**
		 *  Description: Method to select Date Range
		 */
		public P9_Locations selectDateRange(String date) {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			reportStep("Clicking the Date Range", "INFO");
			clickByXpathJavascriptExecutor("//div[@id='reportrange']");
			clickByXpathJavascriptExecutor("//li[@class='active']/following-sibling::li[text()='"+date+"']");
			return this;
		}
		
		/**
		 *  Description: select Custom Date Range
		 */
		public P9_Locations selectCustomDateRange(String customDate) {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			reportStep("Clicking the Date Range", "INFO");
			clickByXpathJavascriptExecutor("//div[@id='reportrange']");
			reportStep("Clicking Custom Date Range", "INFO");
			clickByXpathJavascriptExecutor("//li[@class='active']/following-sibling::li[text()='Custom Range']");
			clickByXpath("//div[@class='daterangepicker_input']/input[@class='input-mini form-control active']");
			enterByXpath("//div[@class='daterangepicker_input']/input[@class='input-mini form-control active']", customDate);
			reportStep("Clicking Apply Button", "INFO");
			waitElementToBeClickableXpathFW();
			clickByXpathJavascriptExecutor("(//button[text()='Apply'])[1]");
			return this;
		}
		
		/**
		 *  Description: Method to merge and un merge two trips
		 */
		public P9_Locations mergeTrips() {
			waitUntilElementVisisble("(//div[@class='trip-main'])[1]");
			reportStep("Clicking the trips checkbox", "INFO");
			clickByXpathJavascriptExecutor("(//label[@class='checkbox solo start-edit'])[1]");
			reportStep("Clicking the second trips checkbox", "INFO");
			clickByXpathJavascriptExecutor("(//label[@class='checkbox solo start-edit'])[2]");
			reportStep("Clicking Merge Selected Button", "INFO");
			waitUntilElementVisisble("//span[@class='merge active']");
			clickByXpathJavascriptExecutor("//span[@class='merge active']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextContainsByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "Merge or Unmerge executed successfully.");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']/div[@class='alert-actions']");
			//unmerging the trips for batch run purpose
			clickByXpathJavascriptExecutor("(//label[@class='checkbox solo start-edit'])[1]");
			clickByXpathJavascriptExecutor("//span[@class='unmerge active']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextContainsByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "Merge or Unmerge executed successfully.");
			return this;
		}
		
		/**
		 *  Description: Method to export trips details
		 */
		public P9_Locations exportTripDetails() {
			waitUntilElementVisisble("//span[@title='Export ']");
			reportStep("Clicking the export option", "INFO");
			clickByXpathJavascriptExecutor("//span[@title='Export ']");
			reportStep("Choosing file format", "INFO");
			waitUntilElementVisisble("//div[@class='export-settings']/strong[@class='modal-title']");
			reportStep("Clicking File Format", "INFO");
			clickByXpathJavascriptExecutor("//span[@class='dtmFormatPDF']");
			clickByXpathJavascriptExecutor("//span[@title='Export Submit']");
			return this;
		}
		
		/**
		 *  Description: Method to get Trip Details
		 */
		public P9_Locations getTripDetails() {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			reportStep("Getting Start Time", "INFO");
			getTextByXpath("//div[@class='trip-points']/span[contains(text(),'A')]/em");
			
			reportStep("Getting End Time", "INFO");
			getTextByXpath("//div[@class='trip-points']/span[contains(text(),'B')]/em");
			
			reportStep("Getting Trip Category", "INFO");
			getTextByXpath("//span[@class='trip-label']");
			
			reportStep("Getting distance in miles", "INFO");
			getTextByXpath("//div[@class='col-xs-4']/em[text()='Distance ']/../strong");
			
			reportStep("Getting Duration", "INFO");
			getTextByXpath("//div[@class='col-xs-4']/em[text()='Duration']/../strong");
			
			reportStep("Getting Average Speed", "INFO");
			getTextByXpath("//div[@class='col-xs-4']/em[text()='Avg Speed']/../strong");
			return this;
		}
		
		/**
		 *  Description: Method to change Trip Details
		 */
		public P9_Locations changeTripTypeAndVerify(String tripType) {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			
			String textByXpath = getTextByXpath("//span[@class='trip-label']");
			if (textByXpath.equalsIgnoreCase(tripType)) {
				clickByXpathJavascriptExecutor("//div[@class='radio-toggle milestone-status']/label/span[contains(text(),'PERSONAL TRIP')]");
				waitUntilElementVisisble("//span[@class='trip-label' and contains(text(),'PERSONAL TRIP')]");
			}
			clickByXpathJavascriptExecutor("//div[@class='radio-toggle milestone-status']/label/span[contains(text(),'"+tripType+"')]");
			
			reportStep("Getting Trip Category", "INFO");
			waitUntilElementVisisble("//span[@class='trip-label' and contains(text(),'BUSINESS TRIP')]");
			verifyTextByXpath("//span[@class='trip-label']", tripType);
			return this;
		}
		
		/**
		 *  Description: Method to add tags
		 */
		public P9_Locations addTags(String tagInfo) {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			
			reportStep("Clicking Plus icon(+) tag ", "INFO");
			clickByXpathJavascriptExecutor("//span[@class='badge add new-tag']/input");
			
			reportStep("Getting Trip Category", "INFO");
			enterByXpath("//span[@class='badge add new-tag']/input", tagInfo);
			
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
			verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "Trips category or tags saved sucessfully.");
			return this;
		}
		
		/**
		 *  Description: Method to Click Delete POIS
		 */
		public P9_Locations clickDeletePois() throws InterruptedException {
			reportStep("Clicking Delete POIS", "INFO");
			waitUntilElementVisisble("//span[@class='delete']");
			clickByXpathJavascriptExecutor("//span[@class='delete']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p[text()='POI Deleted Successfully']");
			verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "POI Deleted Successfully");
			clickByXpathJavascriptExecutor("//div[@class='alert alert-success alert-dismissible in']//div[@class='alert-actions']//button");
			return this;
		}
		

		/**
		 *  Description: Method to click 360 view
		 */
		public P9_Locations click360View() {
			waitVisibilityOfElementLocatedByID("locations-page-view");
			reportStep("Clicking 360 view tab", "INFO");
			clickByXpath("//li[@class='svm-tab']");
			waitUntilElementVisisble("//div[@class='page-view-header']/h2");
			verifyTextContainsByXpath("//div[@class='page-view-header']/h2", "360 VIEW GALLERY");
			return this;
		}
		
		/**
		 *  Description: Method to click Gallery Drop Down
		 */
		public P9_Locations clickGalleryDropDown() {
			waitUntilElementVisisble("(//div[@class='timeline-header']//i[@class='icon-arrow-right'])[1]");
			reportStep("Clicking Gallery Drop Down", "INFO");
			clickByXpath("(//div[@class='timeline-header']//i[@class='icon-arrow-right'])[1]");
			waitUntilElementVisisble("//div[@class='timeline-header']/following-sibling::div[@aria-expanded='true']");
			if (isElementPresent("//div[@class='timeline-header']/following-sibling::div[@aria-expanded='true']")) {
				scrollToElement("//div[@class='timeline-header']/following-sibling::div[@aria-expanded='true']");
				reportStep("Gallery is Present", "PASS");
				clickByXpath("(//div[@class='timeline-header']//i[@class='icon-arrow-right'])[1]");
			} else {
				reportStep("Gallery not available", "FAIL");
			}
			return this;
		}
		
		/**
		 *  Description: Method to verify Collapse All option
		 */
		public P9_Locations verifyCollapseAllOption() {
			waitUntilElementVisisble("(//div[@class='timeline-header']//i[@class='icon-arrow-right'])[1]");
			reportStep("Clicking Gallery Drop Down", "INFO");
			clickByXpath("(//div[@class='timeline-header']//i[@class='icon-arrow-right'])[1]");
			waitUntilElementVisisble("//div[@class='timeline-header']/following-sibling::div[@aria-expanded='true']");
			waitUntilElementVisisble("//span[@class='toggle-collapse']");
			clickByXpath("//span[@class='toggle-collapse']");
			if (isElementNotPresent("//div[@class='timeline-header']/following-sibling::div[@aria-expanded='true']")) {
				reportStep("Gallery successfully closed after clicking collapse button", "PASS");
			} else {
				reportStep("Gallery still present", "FAIL");
			}
			
			return this;
		}
		
		/**
		 *  Description: Method to verify Take Pic option
		 */
		public P9_Locations verifyTakePicOption() {
			waitUntilElementVisisble("//span[@title='Take Pic']");
			if (isElementPresent("//span[@title='Take Pic']")) {
				reportStep("TakePic is Present", "PASS");
			} else {
				reportStep("TakePic not available", "FAIL");
			}
			return this;
		}
		
		/**
		 *  Description: Method to Delete gallery 
		 */
		public P9_Locations deleteGallery() {
			reportStep("Deleting the gallery", "INFO");
			waitUntilElementVisisble("(//label[@class='checkbox'])[2]");
			clickByXpathJavascriptExecutor("(//label[@class='checkbox'])[2]");
			clickByXpath("//label[text()='DELETE SELECTED']");
			waitUntilElementVisisble("//strong[text()='Delete Image']");
			clickByXpath("//span[text()='DELETE']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']");
			verifyTextContainsByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "Selected images deleted sucessfully.");
			return this;
		}
		
		
}


