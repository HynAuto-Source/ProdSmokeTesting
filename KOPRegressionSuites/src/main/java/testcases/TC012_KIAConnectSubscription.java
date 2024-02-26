package testcases;


import org.testng.annotations.Test;

import pages.P12_KIAConnectSubscription;
import pages.P2_Login;
import wrappers.KMABase;

public class TC012_KIAConnectSubscription extends KMABase {
	
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void updateUltimatePackageToAnnually(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickKIAConnectSUbscription()
		.UpgradePackageToUltimateAnnually();	
	}
	
	//----------------------------------------
	
	//TC-104
	@Test(priority=1, dataProvider="fetchData")
	public void clickAndVerifyGetKiaConnect(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnKiaSubcriptions(subcriptionOption);
		
		new P12_KIAConnectSubscription(driver, test)
		
		.clickAndVerifyGetKiaConnect();		
	}
	//TC-105
	@Test(priority=2, dataProvider="fetchData")
	public void clickAndVerifyAccountOverview(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnKiaSubcriptions(subcriptionOption);
		
		new P12_KIAConnectSubscription(driver, test)
		
		.clickAndVerifyAccountOverview();		
	}
	
	//TC-106
	@Test(priority=3, dataProvider="fetchData")
	public void clickAndVerifyMonthlySubscription(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnKiaSubcriptions(subcriptionOption);
		
		new P12_KIAConnectSubscription(driver, test)
		
		.clickAndVerifyMonthlySubscription();		
	}
	//TC-107
	@Test(priority=4, dataProvider="fetchData")
	public void clickAndVerifyAnnualSubscription(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnKiaSubcriptions(subcriptionOption);
		
		new P12_KIAConnectSubscription(driver, test)
		
		.clickAndVerifyMonthlySubscription()
		.clickAndVerifyAnnualSubscription();
	}
}