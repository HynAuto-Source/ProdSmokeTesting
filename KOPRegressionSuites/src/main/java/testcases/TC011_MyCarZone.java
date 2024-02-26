package testcases;

import org.testng.annotations.Test;

import pages.P11_MyCarZone;
import pages.P2_Login;
import wrappers.KMABase;

public class TC011_MyCarZone extends KMABase {
	
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void geoFenceAlert(String emailId, String pwdLogin, String vehicleModel, String alertName, String locationName) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.geoFenceAlerts(alertName, locationName);
		
	}
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void updateGeoFenceAlert(String emailId, String pwdLogin, String vehicleModel, String enterLocation) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.updateGeoFenceAlerts(enterLocation);
	}
	
	
	@Test(priority=3, dataProvider="fetchData")
	public void deleteGeoFenceAlert(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.deleteGeoFenceAlert();
	}
	
	
	@Test(priority=4, dataProvider="fetchData")
	public void curfewAlert(String emailId, String pwdLogin, String vehicleModel, String alertName) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.curfewAlerts(alertName);
	}
	
	
	
	@Test(priority=5, dataProvider="fetchData")
	public void updateCurfewAlert(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.updateCurfewAlerts();
	
 }
	

	@Test(priority=6, dataProvider="fetchData")
	public void deleteCurfewAlert(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.deleteCurfewAlerts();
 }
	
	@Test(priority=7, dataProvider="fetchData")
	public void updateCurfewAlertMCZ(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMyCarZone()
		.updateSpeedAlert();
 }
	
	//------------------------------------
	
	//TC_80
	@Test(priority=1, dataProvider="fetchData")
	public void verifyAbleToModifyGeoFenceAlertToggleButton(String emailId, String pwdLogin, String vehicleModel, String module) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
	    .clickOnLeftPanelOption(module);
		
		new P11_MyCarZone(driver, test)
		.verifyAbleToModifyGeoFenceAlertToggleButton();
		
		
	}
	//TC-83
	@Test(priority=2, dataProvider="fetchData")
	public void verifyAbleToCreateGeoFenceAlertMoreThanSix(String emailId, String pwdLogin, String vehicleModel, String module) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
	    .clickOnLeftPanelOption(module);
		
		new P11_MyCarZone(driver, test)
		.verifyAbleToCreateGeoFenceAlertMoreThanSix();
		
  }
	//TC-82
	@Test(priority=3, dataProvider="fetchData")
	public void createDuplicateGeoFenceAlert(String emailId, String pwdLogin, String vehicleModel, String module) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
	    .clickOnLeftPanelOption(module);
		
		new P11_MyCarZone(driver, test)
		.createDuplicateGeoFenceAlert(module);		
	}
	//Tc-84
	@Test(priority=4, dataProvider="fetchData")
	public void createDuplicateCurfewAlertAndVerify(String emailId, String pwdLogin, String vehicleModel, String module) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
	    .clickOnLeftPanelOption(module);
		
		new P11_MyCarZone(driver, test)
		.createDuplicateCurfewAlertAndVerify(module);		
	}
	

}
