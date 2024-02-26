package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import wrappers.KMABase;

public class TC006_VehicleStatus extends KMABase{

	
	
	@Test(priority=1, dataProvider="fetchData")
	public void VehicleStatusVerifyTheVehicleName(String emailId, String pwdLogin, String vehicleModel, String nameOfTheVehicle) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleModel)
	.clickVehicleStatus()
	.verifyVehicleName(nameOfTheVehicle);
	
	}
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void nearByGasStation(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleModel)
	.clickVehicleStatus()
	.verifyNearByGasStation();
	
	}
	
	
	@Test(priority=3, dataProvider="fetchData")
	public void nearByChargingStation(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleModel)
	.clickVehicleStatus()
	.verifyNearByChargingStation();
	
	}
	
	//-------------------------------------------------
	
	/*
	 * @Test(priority=1, dataProvider="fetchData") public void
	 * VehicleStatusVerifyTheVehicleName(String emailId, String pwdLogin, String
	 * vehicleModel, String nameOfTheVehicle) throws InterruptedException{
	 * 
	 * new P2_Login(driver, test)
	 * 
	 * .clickSignIn() .enterLoginEmailId(emailId) .enterLoginPassword(pwdLogin)
	 * .clkSignIn() .pickTheCar(vehicleModel);
	 * 
	 * }
	 */
	}
