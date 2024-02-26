package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import pages.P8_Schedules;
import wrappers.KMABase;

public class TC008_Schedules extends KMABase{
	
	
	
	
	@Test(priority=1,dataProvider="fetchData")
	public void createNewSchedule(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickSchedules()
		.createNewSchedule();
}
	
	
	@Test(priority=2,dataProvider="fetchData")
	public void updateExistingSchedule(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickSchedules()
		.updateSchedule();
}
	
	
	@Test(priority=3, dataProvider="fetchData")
	public void enableParentToggle(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickSchedules()
		.enableParentToggle();
		
	}
	
	@Test(priority=4,dataProvider="fetchData")
	public void scheduleIsDisplayedRemoteSection(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickRemote()
		.remoteScheduleIsDisplayed();
		
	}
	

	
	@Test(priority=5, dataProvider="fetchData")
	public void deleteSchedule(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickSchedules()
		//.createNewSchedule()
		.deleteSchedule();
		
	}
	
	//---------------------------------------------------

	//TC_54
	@Test(priority=1,dataProvider="fetchData")
	public void verifyCreateClimateSchedulePopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
        .clickOnLeftPanelOption(remoteOption);
		
		new P8_Schedules(driver, test)
		.clickCreateSchedule();
}
	
	//TC_55
	@Test(priority=2,dataProvider="fetchData")
	public void verifyClimateScheduleButton(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
        .clickOnLeftPanelOption(remoteOption);
		
		new P8_Schedules(driver, test)
		.clickCreateSchedule()
        .verifyClimateSchedulesButton();
}
	
	//TC_56
		@Test(priority=3,dataProvider="fetchData")
		public void verifyClimateSchedulePopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
			
			new P2_Login(driver, test)
			
			.clickSignIn()
			.enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
			.pickTheCar(vehicleName)
	        .clickOnLeftPanelOption(remoteOption);
			
			new P8_Schedules(driver, test)
			.clickCreateSchedule()
	        .verifyClimateSchedulesPopup();
	}
		
		//TC_57
		@Test(priority=4,dataProvider="fetchData")
		public void verifyToggleOff(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
			
			new P2_Login(driver, test)
			
			.clickSignIn()
			.enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
			.pickTheCar(vehicleName)
	        .clickOnLeftPanelOption(remoteOption);
			
			new P8_Schedules(driver, test)
			.clickCreateSchedule()
			.clickClimateSchedulesButton()
			.setTemperature()
			.setScheduleDuration()
			.enableDefrostToggle()
			.selectDaysToBeActive()
			.setTiming()
			.clickTurnScheduleOnToggle()
	        .saveNewClimateSchedule()
	        .verifyScheduleActive()
	        .clickSecondSchedule()
			.deleteClimateSchedule();
	}
		
		//TC_58
				@Test(priority=5,dataProvider="fetchData")
				public void verifyActivationToggleTurnedOn(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
					
					new P2_Login(driver, test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
			        .clickOnLeftPanelOption(remoteOption);
					
					new P8_Schedules(driver, test)
					.clickCreateSchedule()
					.clickClimateSchedulesButton()
					.reduceTemperature(temperature)
					.enableDefrostToggle()
					.selectDaysToBeActive()
					.clickTurnScheduleOnToggle()
			        .saveNewClimateSchedule()
			        .verifyScheduleActive()
			        .clickSecondSchedule()
					.deleteClimateSchedule();
			}
		
		//TC_59
		@Test(priority=6,dataProvider="fetchData")
		public void editFirstSchedule(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
					
			new P2_Login(driver, test)
					
			.clickSignIn()
			.enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
			.pickTheCar(vehicleName)
	        .clickOnLeftPanelOption(remoteOption);
					
			new P8_Schedules(driver, test)
			.clickFirstSchedule()
			.reduceTemperature(temperature)
			.disableDefrostToggle()
			.saveClimateSchedule();
			}
		
		//TC_60
		@Test(priority=7,dataProvider="fetchData")
		public void editSecondSchedule(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
					
			new P2_Login(driver, test)
					
			.clickSignIn()
			.enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
			.pickTheCar(vehicleName)
	        .clickOnLeftPanelOption(remoteOption);
					
			new P8_Schedules(driver, test)
			.clickCreateSchedule()
			.clickClimateSchedulesButton()
			.reduceTemperature(temperature)
			.enableDefrostToggle()
			.selectAllDaysToBeActive()
			.clickTurnScheduleOnToggle()
	        .saveNewClimateSchedule()
	        .verifyScheduleActive()
			.clickSecondSchedule()
			.deactivateActivateDays("M")
			.deactivateActivateDays("Tu")
			.deleteClimateSchedule();
			}
		
		//TC_61
				@Test(priority=8,dataProvider="fetchData")
				public void deleteClimateSchedule(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
							
					new P2_Login(driver, test)
							
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
			        .clickOnLeftPanelOption(remoteOption);
							
					new P8_Schedules(driver, test)
					.clickCreateSchedule()
					.clickClimateSchedulesButton()
					.reduceTemperature(temperature)
					.enableDefrostToggle()
					.selectDaysToBeActive()
					.clickTurnScheduleOnToggle()
			        .saveNewClimateSchedule()
			        .verifyScheduleActive()
					.clickSecondSchedule()
					.deleteClimateSchedule();
					}
		
		//TC_62
		@Test(priority=9,dataProvider="fetchData")
		public void closeCreateClimateSchedulePopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String temperature) throws InterruptedException {
					
			new P2_Login(driver, test)
					
			.clickSignIn()
			.enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
			.pickTheCar(vehicleName)
	        .clickOnLeftPanelOption(remoteOption);
					
			new P8_Schedules(driver, test)
			.clickCreateSchedule()
			.clickClimateSchedulesButton()
			.reduceTemperature(temperature)
			.enableDefrostToggle()
			.selectDaysToBeActive()
			.clickTurnScheduleOnToggle()
	        .saveNewClimateSchedule()
	        .verifyScheduleActive()
			.clickSecondSchedule()
			.closeCreateClimateSchedulePopup()
			.clickSecondSchedule()
			.deleteClimateSchedule();
			}
}