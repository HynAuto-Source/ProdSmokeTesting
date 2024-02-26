package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P11_MyCarZone extends KMABase {
	
	public P11_MyCarZone(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test= test; 
		
		if(!verifyTitle("My Car Zone"))
			reportStep("This is not MyCarZone Page", "FAIL");
	}
	
	
	public P11_MyCarZone geoFenceAlerts(String alertName, String locationName) {
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='CREATE ALERT']");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='Geo Fence Alert ']");
		waitElementToBeClickableXpathFW();
		enterByName("geofenceName", alertName);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[text()=' Next: Set Boundaries ']");
		waitElementToBeClickableXpathFW();
		enterByName("searchLocation", locationName);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@class='button full has-spinner dtmSaveGeofenceAlert']");
		//waitUntilElementVisisble("(//*[@class='close'])[10]");
		return this;	
	}
	
	public P11_MyCarZone updateGeoFenceAlerts(String enterLocation) {
		waitUntilElementVisisble("(//*[@id='6e2e1aa2-3972-48cc-a3d8-42bb0b6343c6'])[2]");
		clickByXpath("(//*[@id='6e2e1aa2-3972-48cc-a3d8-42bb0b6343c6'])[2]");
		waitUntilElementVisisble("//*[@class='button main dtmEditGeofenceSetBoundaries']");
		clickByXpath("//*[@class='button main dtmEditGeofenceSetBoundaries']");
		waitUntilElementVisisble("(//*[@title='Save Geofence Alert'])[1]");
		enterByXpathJSExecutor("(//*[@name='searchLocation'])[1]", enterLocation);  //orange near Irvine, California
		clickByXpath("(//*[@title='Save Geofence Alert'])[1]");
		waitUntilElementVisisble("(//*[contains(text(),'Close')])[2]");
		return this;
	}
	
	
	public P11_MyCarZone deleteGeoFenceAlert() {
		waitUntilElementVisisble("(//*[@id='6e2e1aa2-3972-48cc-a3d8-42bb0b6343c6'])[2]");
		clickByXpath("(//*[@id='6e2e1aa2-3972-48cc-a3d8-42bb0b6343c6'])[2]");
		waitUntilElementVisisble("//*[@class='button main dtmEditGeofenceSetBoundaries']");
		clickByXpath("//*[@title='Delete Geofence Alert']");
		waitUntilElementVisisble("//*[@title='Confirm Delete Geofence Alert']");
		clickByXpath("//*[@title='Confirm Delete Geofence Alert']");
		//waitUntilElementVisisble("(//*[contains(text(),'Close')])[2]");
		return this;
	}
	
	
	public P11_MyCarZone curfewAlerts(String alertName) {
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='CREATE ALERT']");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='Curfew Alert']");
		waitElementToBeClickableXpathFW();
		enterByName("curfewName", alertName);    
		waitElementToBeClickableXpathFW();
		//clickByXpathJavascriptExecutor("(//*[text()='Su'])[3]");
		clickByXpath("//*[@class='checkbox checkbox-round'][1]");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='Save Curfew Alert']");
		waitUntilElementVisisble("(//*[@class='close'])[12]");
		return this;	
	}
	
	
	public P11_MyCarZone updateCurfewAlerts() throws InterruptedException {
		waitUntilElementVisisble("(//*[@class='icon-settings'])[3]");
		clickByXpathJavascriptExecutor("(//*[@class='icon-settings'])[3]");
		waitUntilElementVisisble("(//*[@class='icon-close'])[5]");
		//clickByXpath("(//*[text()='Tu'])[3]");
		clickByXpath("(//*[@class='checkbox checkbox-round'][3])[1]");
		Thread.sleep(10000);
		waitUntilElementVisisble("(//*[contains(text(),'Save')])[1]");
		clickByXpathJavascriptExecutor("(//*[contains(text(),'Save')])[1]");   // (//*[@title='Save Curfew Alert'])[1]
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this;
	}
	
	
	public P11_MyCarZone deleteCurfewAlerts() throws InterruptedException {
		waitUntilElementVisisble("(//*[@class='icon-settings'])[3]");
		clickByXpathJavascriptExecutor("(//*[@class='icon-settings'])[3]");
		waitUntilElementVisisble("(//*[contains(text(),'Save')])[1]");
		clickByXpath("//*[@title='Delete Curfew Alert']");
		//waitUntilElementVisisble("//*[contains(text(),' Are you sure you want to delete this? ')]");
		Thread.sleep(10000);
		waitUntilElementVisisble("//*[@title='Confirm Delete Curfew Alert']");
		clickByXpathJavascriptExecutor("//*[@title='Confirm Delete Curfew Alert']");
		//clickByXpath("//*[@title='Confirm Delete Curfew Alert']");
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this;
	}
	
	
	
	public P11_MyCarZone updateSpeedAlert() {
		scrollDownJavaScriptExecutor("//*[@class='icon-alert-speed']");
		waitUntilElementVisisble("//*[@class='icon-alert-speed']");
		clickByXpathJavascriptExecutor("//*[@class='icon-alert-speed']");
		waitUntilElementVisisble("(//*[@class='down'])[1]");
		clickByXpath("(//*[@class='down'])[1]");
		clickByXpath("(//*//*[@title='Save Speed Alert'])[1]");
		waitUntilElementVisisble("(//*[@class='close'])[10]");
		return this;
	}

	
	//-----------------------------------------------------------------------------------
		
	
	public P11_MyCarZone verifyAlertsPresent() {
		waitElementToBeClickableXpathFW();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='my-car-zone-alert-area-header']/h3"));
		 for (WebElement alerts : findElements)
         {
			 if (alerts.getText().contains("SPEED ALERTS") || alerts.getText().contains("GEO FENCE ALERTS") || alerts.getText().contains("CURFEW ALERTS")) {
				 reportStep(alerts.getText(), "PASS");
			}
			 else {
				 reportStep("Actual text not matching with the expected text "+alerts.getText(), "FAIL");
			}
            }
		return this;	
	}
	/**
	 
	 *  Description: verify to create more than 6 alert in geo fence
*/
	public P11_MyCarZone verifyAbleToCreateGeoFenceAlertMoreThanSix() {
		waitUntilElementVisisble("//span[@title='CREATE ALERT']");
		clickByXpath("//span[@title='CREATE ALERT']");
		waitUntilElementVisisble("//li[@class='dtmGeo-fence']");
		reportStep("To check whether maximum alerts is created", "Info");
		getTextByXpath("//li[@class='dtmGeo-fence']/em");       
		return this;	
	}
	/**
	 
	 *  Description: verify geofence toggle button
	 */
	public P11_MyCarZone verifyAbleToModifyGeoFenceAlertToggleButton() {
		waitUntilElementVisisble("//span[@title='CREATE ALERT']");
		clickByName("toggleGeofence");
//		reportStep("To check whether maximum alerts is created", "Info");
//		getTextByXpath("//li[@class='dtmGeo-fence']/em");       
		return this;	
	}
	
	/**
	 
	 *  Description: create duplicate alert for geo fence
	 */
	public P11_MyCarZone createDuplicateGeoFenceAlert(String alertName) {
		waitUntilElementVisisble("//span[@title='CREATE ALERT']");
		clickByXpath("//span[@title='CREATE ALERT']");
		waitUntilElementVisisble("//li[@class='dtmGeo-fence']");
		clickByXpath("//li[@class='dtmGeo-fence']");
		enterByName("geofenceName", alertName);
		clickByXpath("//span[@title='Next: Set Boundaries']");
		clickByXpathJavascriptExecutor("//div[@id='up1']//following::span[@title='Save Geofence Alert']");
     
		return this;	
	}
	
	/**
	 
	 *  Description: create duplicate alert for Curfew 
	 */
	public P11_MyCarZone createDuplicateCurfewAlertAndVerify(String alertName) {
		waitUntilElementVisisble("//span[@title='CREATE ALERT']");
		clickByXpath("//span[@title='CREATE ALERT']");
		waitUntilElementVisisble("//li[@class='ddtmCurfew']");
		clickByXpath("//li[@class='dtmCurfew']");
		enterByName("curfewName", alertName);
		clickByName("tuesday");
		clickByName("wednesday");
		clickByName("thursday");
		selectVisibileTextByXPath("//*[normalize-space()='Start Time']//following::select", "10:30AM");
		clickByXpathJavascriptExecutor("//div[@id='up1']//following::span[@title='Save Geofence Alert']");
		clickByXpath("//span[@title='Save Curfew Alert']");
		return this;	
	}

}


