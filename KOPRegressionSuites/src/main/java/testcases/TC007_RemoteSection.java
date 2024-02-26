package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import pages.P5_Dashboard;
import pages.P7_RemoteSection;
import wrappers.KMABase;

public class TC007_RemoteSection extends KMABase {

	
	
	@Test(priority=1, dataProvider="fetchData")
	public void RemoteSectionDoorUnlockRS(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
		.clickRemote()
		.clickDoorUnLockRS(); 		
	}
	
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void RemoteSectionDoorLock(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
		.clickRemote()
		.clickDoorLockRS();
	}
		
	@Test(priority=3,dataProvider="fetchData")
	public void RemoteSectionClimateStart(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
		.clickRemote()
		.clickRemoteStartRS();
		
	}
		
	
	@Test(priority=4,dataProvider="fetchData")
	public void RemoteSectionClimateStop(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
		.clickRemote()
		.clickRemoteStopRS();
		
	}
	
	//------------------------------------------
	
	//TC_49
    @Test(priority=1, dataProvider="fetchData")
    public void ClimateControl(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

        new P2_Login(driver, test)

        .clickSignIn()
        .enterLoginEmailId(emailId)    
        .enterLoginPassword(pwdLogin)
        .clkSignIn()
        .pickTheCar(vehicleName)
        .clickOnLeftPanelOption(remoteOption);

        new P7_RemoteSection(driver, test)

        .clickRemoteStart()
        .increaseTemperature(temperature)
        .heatedAndVentilatedSeats()
        .enableDefrostAndSteeringToggle()
        .activateClimate()
        .stopClimate();
    }

    //TC_50
    @Test(priority=2,  dataProvider="fetchData")
    public void verifyHeatedAndVentilatedSeats(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException{
    new P2_Login(driver, test)
    .clickSignIn()
    .enterLoginEmailId(emailId)    
    .enterLoginPassword(pwdLogin)
    .clkSignIn()
    .pickTheCar(vehicleName)
    .clickOnLeftPanelOption(remoteOption);

    new P7_RemoteSection(driver, test)
    .clickRemoteStart()
    .heatedAndVentilatedSeats();
    }    

    //TC_51
    @Test(priority=3,  dataProvider="fetchData")
    public void climateStopCall(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

        new P2_Login(driver, test)

        .clickSignIn()
        .enterLoginEmailId(emailId)    
        .enterLoginPassword(pwdLogin)
        .clkSignIn()
        .pickTheCar(vehicleName)
        .clickOnLeftPanelOption(remoteOption);

        new P7_RemoteSection(driver, test)
        .clickRemoteStart()
        .heatedAndVentilatedSeats()
        .enableDefrostAndSteeringToggle()
        .stopClimate();
    }

    //TC_52
    @Test(priority=4, dataProvider="fetchData")
    public void verifyClimateOnChangeStatusInDashboard(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

        new P2_Login(driver, test)

        .clickSignIn()
        .enterLoginEmailId(emailId)    
        .enterLoginPassword(pwdLogin)
        .clkSignIn()
        .pickTheCar(vehicleName)
        .clickOnLeftPanelOption(remoteOption);

        new P7_RemoteSection(driver, test)
        .clickRemoteStart()
        .increaseTemperature(temperature)
        .heatedAndVentilatedSeats()
        .enableDefrostAndSteeringToggle()
        .activateClimate()
        .clickOnLeftMenuOption(dashboardOption);

        new P5_Dashboard(driver, test)
        .ClickOnSetYourClimate()
        .verifyStartStopClimateButton(stopClimate);
    }

 

    //TC_53
    @Test(priority=5,  dataProvider="fetchData")
    public void verifyClimateStopChangeStatusInDashboard(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

        new P2_Login(driver, test)

        .clickSignIn()
        .enterLoginEmailId(emailId)    
        .enterLoginPassword(pwdLogin)
        .clkSignIn()
        .pickTheCar(vehicleName)
        .clickOnLeftPanelOption(remoteOption);

        new P7_RemoteSection(driver, test)

        .clickRemoteStart()
        .heatedAndVentilatedSeats()
        .enableDefrostAndSteeringToggle()
        .stopClimate()
        .clickOnLeftMenuOption(dashboardOption);

        new P5_Dashboard(driver, test)
        .ClickOnSetYourClimate()
        .verifyStartStopClimateButton(startClimate);

    }

    //TC_45
        @Test(priority=6,  dataProvider="fetchData")
        public void verifySecurityTabFeatures(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

            new P2_Login(driver, test)

            .clickSignIn()
            .enterLoginEmailId(emailId)    
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheCar(vehicleName)
            .clickOnLeftPanelOption(remoteOption);

            new P7_RemoteSection(driver, test)
            .verifyRemoteSecurityPage();
        }

 

    //TC_46
        @Test(priority=7, dataProvider="fetchData")
        public void performRemoteDoorLock(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

            new P2_Login(driver, test)

            .clickSignIn()
            .enterLoginEmailId(emailId)    
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheCar(vehicleName)
            .clickOnLeftPanelOption(remoteOption);

            new P7_RemoteSection(driver, test)
            .clickRemoteDoorLockInRS();
        }

    //TC_47
        @Test(priority=8, dataProvider="fetchData")
        public void performRemoteDoorUnLock(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)    
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheCar(vehicleName)
            .clickOnLeftPanelOption(remoteOption);

            new P7_RemoteSection(driver, test)
            .clickRemoteDoorUnLockInRS();
                }
        
      //TC_48
      @Test(priority=9,dataProvider="fetchData")
      public void verifyCloseOptionInToastMessage(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature,String dashboardOption, String startClimate, String stopClimate) throws InterruptedException {
                                  
          new P2_Login(driver, test)
                                  
          .clickSignIn()
          .enterLoginEmailId(emailId)    
          .enterLoginPassword(pwdLogin)
          .clkSignIn()
          .pickTheCar(vehicleName)
          .clickOnLeftPanelOption(remoteOption);
                                  
          new P7_RemoteSection(driver, test)
          .clickRemoteDoorLockInRS()
          .clickRemoteDoorUnLockInRS();
          
                      }
}