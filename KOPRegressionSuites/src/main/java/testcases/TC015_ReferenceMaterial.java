package testcases;

import org.testng.annotations.Test;

import pages.P14_ReferenceMaterial;
import pages.P2_Login;
import wrappers.KMABase;

public class TC015_ReferenceMaterial extends KMABase {

		
	//TC_142
	@Test(priority=1, dataProvider="fetchData")
	public void clickAndVerifyReferenceMaterialTab(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyReferenceMaterialTab();
	}
	//Tc-143
	@Test(priority=2, dataProvider="fetchData")
	public void verifyListAndGridView(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.verifyListAndGridView();
	}
	//Tc-144
	@Test(priority=3, dataProvider="fetchData")
	public void searchManualDocuments(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.searchManualDocuments(validCarName);
	}
	//TC-145
	@Test(priority=4, dataProvider="fetchData")
	public void searchInvalidVechileManualDocuments(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.searchInvalidVechileManualDocuments(invalidCarName);
	}
	//Tc-146
	@Test(priority=5, dataProvider="fetchData")
	public void clickAndVerifyPdf(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyPdf(url);
	}
	//Tc-147
	@Test(priority=6, dataProvider="fetchData")
	public void verifyListAndGridViewInVideos(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.verifyListAndGridViewInVideos();
	}
	//TC_150
	@Test(priority=7, dataProvider="fetchData")
	public void clickAndVerifyVideo(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyVideo(videoUrl);
	}
	//TC-151
	@Test(priority=8, dataProvider="fetchData")
	public void clickAndVerifyWarrantyInfo(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyWarrantyInfo();
	}
	//TC-152
	@Test(priority=9, dataProvider="fetchData")
	public void verifyOriginalOwnerIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.verifyOriginalOwnerIsSelected();
	}
	//Tc-153
	@Test(priority=10, dataProvider="fetchData")
	public void verifyOriginalOwnerAndSubsquentOwner(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.verifyOriginalOwnerAndSubsquentOwner();
	}
	//Tc-154
	@Test(priority=11, dataProvider="fetchData")
	public void clickAndVerifyKiaConnect(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect();
	}
	//Tc-155
	@Test(priority=12, dataProvider="fetchData")
	public void verifyAppsIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyAppsIsSelected();
	}
	//TC-156
	@Test(priority=13, dataProvider="fetchData")
	public void verifyConnectivityOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(connectivity);
	}
	//TC-157
	@Test(priority=14, dataProvider="fetchData")
	public void verifyConvenienceOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(convenience);
	}
	//TC-158
	@Test(priority=15, dataProvider="fetchData")
	public void verifyEmergencyAssistanceOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(emergencyAssistance);
	}
	//TC-159
	@Test(priority=16, dataProvider="fetchData")
	public void verifyGettingStartedOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(gettingStarted);
	}
	//TC-160
	@Test(priority=17, dataProvider="fetchData")
	public void verifyMaintenanceOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(maintenance);
	}
	//TC-161
	@Test(priority=18, dataProvider="fetchData")
	public void verifyMultimediaOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(multimedia);
	}
	//TC-162
	@Test(priority=19, dataProvider="fetchData")
	public void verifyMyCarZoneOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(myCarZone);
	}
	//TC-163
	@Test(priority=20,dataProvider="fetchData")
	public void verifyNavigationOptionIsSelected(String emailId, String pwdLogin, String vehicleModel,String referenceMaterial,String validCarName,String invalidCarName,String url,String videoUrl,String connectivity,String convenience,String emergencyAssistance,String gettingStarted,String maintenance,String multimedia,String myCarZone,String navigation) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickOnReferenceMaterialTab(referenceMaterial);
		
		new P14_ReferenceMaterial(driver, test)
		.clickAndVerifyKiaConnect()
		.verifyoptionIsSelected(navigation);
	}	
}
