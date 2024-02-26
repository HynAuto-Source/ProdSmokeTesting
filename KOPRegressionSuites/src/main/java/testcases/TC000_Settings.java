package testcases;

import org.testng.annotations.Test;

import pages.P0_Settings;
import pages.P2_Login;
import wrappers.KMABase;

public class TC000_Settings extends KMABase{
	

	@Test(groups= {"Smoke"}, priority=1, dataProvider="fetchData")
	public void personalDetails(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickVechiles()
	.clickAccount()
	.clickSettings()
	.updatePersonalDetails(address, zipCode);
	}
	
	
	@Test(groups= {"Smoke"}, priority=2, dataProvider="fetchData")
	public void phoneNumberVerified(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.phoneNumberVerified();
	}
	
	
	
	@Test(groups= {"Smoke"}, priority=3, dataProvider="fetchData")
	public void settingsChangePassword(String emailId, String pwdLogin, String currentPassword, String newPassword, String confirmPassword, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.securityChangePassword(currentPassword, newPassword, confirmPassword);
	}
	
	
	
	@Test(groups= {"Smoke"}, priority=4, dataProvider="fetchData")
	public void settingsUpdatePIN(String emailId, String pwdLogin, String currentPIN, String newPIN, String confirmNewPIN, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.settingsUpdatePIN(currentPIN, newPIN, confirmNewPIN);
	}
	
	
	
	@Test(groups= {"Smoke"}, priority=5, dataProvider="fetchData")
	public void settingsUpdatePINWithPassword(String emailId, String pwdLogin, String currentPasswordResetPIN , String newPINRP, String confirmNewPINRP, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.settingsUpdatePINWithPassword(currentPasswordResetPIN, newPINRP, confirmNewPINRP);
	}
	
	
	@Test(groups= {"Smoke"}, priority=6, dataProvider="fetchData")
	public void settingsCPEnableToggle(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.settingsCPenableSMStoggle();
	}
	
	
	@Test(groups= {"Smoke"}, priority=7, dataProvider="fetchData")
	public void settingsCPTurnOffToggle(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.settingsCPdisabledSMStoggle();
	}
	
	@Test(groups= {"Smoke"}, priority=8, dataProvider="fetchData")
	public void settingsKiaConnectNotificationAlertsTurnOff(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.settingsKiaConnectNotificationAlertsTurnOff();
	}
	
	
	@Test(groups= {"Smoke"}, priority=8, dataProvider="fetchData")
	public void settingsKiaConnectNotificationAlertsTurnOn(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickSettings()
	.settingsKiaConnectNotificationAlertsTurnOn();
	}
	
	//-----------------------------------------------------
	
	//TC_91
	@Test(groups= {"Regression"}, priority=1, dataProvider="fetchData")
	public void updatePersonalDetails(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.goToSettings();
	
	new P0_Settings(driver, test)
	.updatePersonalDetails(address, zipCode);
	}	
	
	//TC_92
		@Test(groups= {"Regression"}, priority=1, dataProvider="fetchData")
		public void updateStateValue(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)	
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.goToSettings();
		
		new P0_Settings(driver, test)
		.updateStateValue(state)
		.clickBackButton();
		}	
	
	//TC_93
		@Test(groups= {"Regression"}, priority=2, dataProvider="fetchData")
		public void verifySecurityTab(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)	
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.goToSettings();
		
		new P0_Settings(driver, test)
		.verifySecurityTab();
		}	
		
		//TC_94
				@Test(groups= {"Regression"}, priority=3, dataProvider="fetchData")
				public void verifyChangeInvalidPassword(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
				new P2_Login(driver, test)
				
				.clickSignIn()
				.enterLoginEmailId(emailId)	
				.enterLoginPassword(pwdLogin)
				.clkSignIn()
				.goToSettings();
				
				new P0_Settings(driver, test)
				.clickSecurityTab()
				.verifyChangeInvalidPassword(pwdLogin, invalidPwd);
				}	
				
				//TC_95
				@Test(groups= {"Regression"}, priority=4, dataProvider="fetchData")
				public void verifyNullPasswordChange(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
				new P2_Login(driver, test)
				
				.clickSignIn()
				.enterLoginEmailId(emailId)	
				.enterLoginPassword(pwdLogin)
				.clkSignIn()
				.goToSettings();
				
				new P0_Settings(driver, test)
				.clickSecurityTab()
				.verifyChangePwdButtonIsDisable(pwdLogin, "");
				}	
				
				//TC_96
				@Test(groups= {"Regression"}, priority=5, dataProvider="fetchData")
				public void verifyChangePasswordEnabled(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
				new P2_Login(driver, test)
				
				.clickSignIn()
				.enterLoginEmailId(emailId)	
				.enterLoginPassword(pwdLogin)
				.clkSignIn()
				.goToSettings();
				
				new P0_Settings(driver, test)
				.clickSecurityTab()
				.verifyChangePwdButtonIsEnabled(pwdLogin);
				}	
				
				//TC_97
				@Test(groups= {"Regression"}, priority=6, dataProvider="fetchData")
				public void verifyNewPasswordMsgTxt(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
				new P2_Login(driver, test)
				
				.clickSignIn()
				.enterLoginEmailId(emailId)	
				.enterLoginPassword(pwdLogin)
				.clkSignIn()
				.goToSettings();
				
				new P0_Settings(driver, test)
				.clickSecurityTab()
				.verifyChangePwdShouldMatchErrorMsg(pwdLogin, pwdLogin, diffPwd);
				}	
				
				//TC_98
				@Test(groups= {"Regression"}, priority=7, dataProvider="fetchData")
				public void verifyOldPasswordMismatchErrorMsgTxt(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
				new P2_Login(driver, test)
				
				.clickSignIn()
				.enterLoginEmailId(emailId)	
				.enterLoginPassword(pwdLogin)
				.clkSignIn()
				.goToSettings();
				
				new P0_Settings(driver, test)
				.clickSecurityTab()
				.verifyOldPasswordMismatchErrorMsg(diffPwd, pwdLogin);
				}	
				
				   //TC_99
                @Test(groups= {"Regression"}, priority=2, dataProvider="fetchData")
                public void verifyCommunicationPreferenceTab(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
                new P2_Login(driver, test)

                .clickSignIn()
                .enterLoginEmailId(emailId)    
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .goToSettings();

                new P0_Settings(driver, test)
                .verifyCommunicationPreferenceTab();
                }    

                //TC_100
                @Test(groups= {"Regression"}, priority=2, dataProvider="fetchData")
                public void verifyPhonePreferenceField(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
                new P2_Login(driver, test)

                .clickSignIn()
                .enterLoginEmailId(emailId)    
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .goToSettings();

                new P0_Settings(driver, test)
                .clickCommunicationPreferenceTab()
                .verifyPhoneNumber();
                }    

                //TC_101
                @Test(groups= {"Regression"}, priority=2, dataProvider="fetchData")
                public void verifyLanguageDropDown(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
                new P2_Login(driver, test)

                .clickSignIn()
                .enterLoginEmailId(emailId)    
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .goToSettings();

                new P0_Settings(driver, test)
                .clickCommunicationPreferenceTab()
                .verifyLanguageDropdown();
                }  
                
         	   //TC_102
                @Test(groups= {"Regression"},priority=2, dataProvider="fetchData")
                public void verifyKiaConnectNotificationTab(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
                new P2_Login(driver, test)

                .clickSignIn()
                .enterLoginEmailId(emailId)    
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .goToSettings();

                new P0_Settings(driver, test)
                .verifyKiaConnectNotificationTab();
                }    
                
                //TC_103
                @Test(groups= {"Regression"},priority=2, dataProvider="fetchData")
                public void verifyKiaConnectNotificationOptions(String emailId, String pwdLogin, String address, String zipCode, String invalidPwd, String diffPwd, String state) throws InterruptedException{
                new P2_Login(driver, test)

                .clickSignIn()
                .enterLoginEmailId(emailId)    
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .goToSettings();

                new P0_Settings(driver, test)
                .clickKiaConnectNotificationTab()
                .verifyKiaConnectNotificationOptions();
                }    

}
	
	
	
	
	
