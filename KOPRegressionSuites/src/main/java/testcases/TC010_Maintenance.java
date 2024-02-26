package testcases;

import org.testng.annotations.Test;

import pages.P10_Maintenance;
import pages.P2_Login;
import wrappers.KMABase;

public class TC010_Maintenance extends KMABase{
	
	
	

	@Test(priority=1, dataProvider="fetchData")
	public void checkNextMaintenanceMiles(String emailId, String pwdLogin, String vehicleModel, String expectedValue) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.nextServiceMiles(expectedValue);
	}
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void completeMilestone(String emailId, String pwdLogin, String vehicleModel, String serviceLocation, String serviceNotes) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.completeMilestone(serviceLocation, serviceNotes);
	}
	
	
	
	@Test(priority=3, dataProvider="fetchData")
	public void updateMilestone(String emailId, String pwdLogin, String vehicleModel, String serviceLocation, String serviceNotes) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.updateMilestone(serviceLocation, serviceNotes);
	}
	
	
	@Test(priority=4, dataProvider="fetchData")
	public void incompleteMilestone(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.incompleteMilestone();
	}
	
	

	@Test(priority=5, dataProvider="fetchData")
	public void chooseAdealer(String emailId, String pwdLogin, String vehicleModel, String dealerDetails, String dealerName) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.chooseDealer(dealerDetails, dealerName);
	}
	
	@Test(priority=6, dataProvider="fetchData")
	public void updateAdealer(String emailId, String pwdLogin, String vehicleModel, String dealerDetails, String dealerName) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.updateDealer(dealerDetails, dealerName);
	}
	
	@Test(priority=7, dataProvider="fetchData")  // This is iframe
	public void requestDealerAppointments(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickMaintenance()
		.requestDealerAppointment();
	}
	
	//--------------------------
	    //Tc_74
	    @Test(priority=1, dataProvider="fetchData", groups = {"Run"})
	    public void verifyGearIcon(String emailId, String pwdLogin, String vehicleModel, String maintenanceTab,String dealercode) throws InterruptedException {

	        new P2_Login(driver,test)
	        .clickSignIn()
	        .enterLoginEmailId(emailId)
	        .enterLoginPassword(pwdLogin)
	        .clkSignIn()
	        .pickTheCar(vehicleModel)
	        .clickOnMaintenanceTab(maintenanceTab);

	        new P10_Maintenance(driver, test)
	        .verifyGearIcon();

	    }

	    //Tc_75
	    @Test(priority=36, dataProvider="fetchData", groups = {"Run"})
        public void verifyRequestDealerAppointment(String emailId, String pwdLogin,String vehicleName,String maintenance, String zipCode) throws InterruptedException{
            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheCar(vehicleName)
            .clickOnLeftPanelOption(maintenance)
            .clickMakeAnAppointment()
            .selectNearbyDealer(zipCode)
            .checkVehicleRepairRadioButton()
            .clickRequestAppointmentButton()
            .requestAppointment();
        }

	    //Tc_76

	    @Test(priority=2, dataProvider="fetchData", groups = {"Run"})
	    public void clickAndVerifyGearIcon(String emailId, String pwdLogin, String vehicleModel, String maintenanceTab,String dealercode) throws InterruptedException {
	       
	    	new P2_Login(driver,test)
	        .clickSignIn()
	        .enterLoginEmailId(emailId)
	        .enterLoginPassword(pwdLogin)
	        .clkSignIn()
	        .pickTheCar(vehicleModel)
	        .clickOnMaintenanceTab(maintenanceTab);

	        new P10_Maintenance(driver, starttest)
	        .clickAndVerifyGearIcon();
 }
	    
	          //Tc_77
	     @Test(priority=3, dataProvider="fetchData", groups = {"dontRun"})
	     public void searchDealerDetails(String emailId, String pwdLogin, String vehicleModel, String maintenanceTab,String dealercode) throws InterruptedException {
	             
	    	 new P2_Login(driver,test)

	              .clickSignIn()
	              .enterLoginEmailId(emailId)
	              .enterLoginPassword(pwdLogin)
	              .clkSignIn()
	              .pickTheCar(vehicleModel)
	              .clickOnMaintenanceTab(maintenanceTab);

	              new P10_Maintenance(driver, test)
	              .clickAndVerifyGearIcon()
	              .searchDealerDetails(dealercode);

	          }

	          

	          //Tc_78
	     @Test(priority=4, dataProvider="fetchData", groups = {"dontRun"})
	     public void verifyUseThisDealerEnable(String emailId, String pwdLogin, String vehicleModel, String maintenanceTab,String dealercode) throws InterruptedException {

	           new P2_Login(driver,test)
	              .clickSignIn()
	              .enterLoginEmailId(emailId)
	              .enterLoginPassword(pwdLogin)
	              .clkSignIn()
	              .pickTheCar(vehicleModel)
	              .clickOnMaintenanceTab(maintenanceTab);

	              new P10_Maintenance(driver, test)
	              .clickAndVerifyGearIcon()
	              .checkUseThisDealerEnable(dealercode);

	          }

	          //Tc-79
	       @Test(priority=5, dataProvider="fetchData", groups = {"dontRun"})
	       public void checkCollapseAllAndExpandForMiles(String emailId, String pwdLogin, String vehicleModel, String maintenanceTab,String dealercode) throws InterruptedException {
	              
	    	   new P2_Login(driver,test)
	              .clickSignIn()
	              .enterLoginEmailId(emailId)
	              .enterLoginPassword(pwdLogin)
	              .clkSignIn()
	              .pickTheCar(vehicleModel)
	              .clickOnMaintenanceTab(maintenanceTab);

	           new P10_Maintenance(driver, test)
	              
	              .checkMilesCollapseAllAndExpand();

	          }
}

