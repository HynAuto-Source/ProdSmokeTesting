package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P6_VehicleStatus extends KMABase {
	
	public P6_VehicleStatus(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test =test;
		waitUntilElementVisisble("//*[@class='icon-info']");
		if(!verifyTitle("Dashboard")){
			reportStep("This is not Dashboard Page", "FAIL");	
		}		
	}
	
	
	
	public P6_VehicleStatus verifyNearByChargingStation() {
		waitUntilElementVisisble("//*[@style='text-align: center;']/strong");
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Find Charging Station Nearby']")).isDisplayed());
		return this;
	}
	
	//----------------------
	
	public P6_VehicleStatus verifyVehicleName(String nameOfTheVehicle) {		
		verifyTextByXpath("//*[@style='text-align: center;']/strong", nameOfTheVehicle);
		return this;
	}
	
	
	
	public P6_VehicleStatus verifyNearByGasStation() {
		waitUntilElementVisisble("//*[@style='text-align: center;']/strong");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Find Gas Station')]")).isDisplayed());
		return this;
	}

}
