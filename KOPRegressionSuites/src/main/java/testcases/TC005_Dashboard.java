package testcases;

import org.testng.annotations.Test;
import pages.P2_Login;
import pages.P9_Locations;
import wrappers.KMABase;

public class TC005_Dashboard extends KMABase {
	
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void DashboardClickDoorUnLock(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName)
	.clickDoorUnLock();
	
	}
	
	@Test(priority=2, dataProvider="fetchData")
	public void DashboardClickDoorLock(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName)
	.clickDoorlock();
	
	}
	
	@Test(priority=3, dataProvider="fetchData")
	public void DashboardClickRemoteClimateStartStop(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName)
	.clickRemoteStart()
	.clickRemoteStop();
	}
	

	
/*	@Test(priority=5, dataProvider="fetchData")
	public void dashboard_5754554(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleModel)
	.clickRemoteStartWithHeatedAccessories()
	.clickRemoteStop();
	}*/
	
	
	
	
	@Test(priority=4, dataProvider="fetchData")
	public void DashboardClickMasterRefresh(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName)
	.clickMasterRefresh();
	}
	
	@Test(priority=5, dataProvider="fetchData")
	public void DashboardLastRefreshExist(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName)
	.lastRefresh();
		
	}
	
	
	@Test(priority=6, dataProvider="fetchData")
	public void DashboardClickRemoteClimateStartWithToggles(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName)
	.clickRemoteStartWithToggles()
	.clickRemoteStop();
	}
	
	//---------------------------------------------------------
	
	//Tc_31
		@Test(priority=7, dataProvider="fetchData")
		public void verifyDoorTile(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
			
	        new P2_Login(driver, test)
	        
	    	.clickSignIn()
	    	.enterLoginEmailId(emailId)
	    	.enterLoginPassword(pwdLogin)
	    	.clkSignIn()
		    .pickTheCar(vehicleName)
		    .verifyFeaturesInDoorTile();
		}
		
		//Tc_32
        @Test(priority=8, dataProvider="fetchData")
        public void verifyToastsMessageForDoorLockUnlock(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{

            new P2_Login(driver, test)

            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheCar(vehicleName)
            .verifyToastMessageForDoorLockUnlock();
        }
        //Tc_33
        @Test(priority=9, dataProvider="fetchData")
        public void verifyStatusForDoorLockUnlockInRemote(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{

            new P2_Login(driver, test)

            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheCar(vehicleName)
            .clickDoorLockUnlockAndVerifyRemoteSection(remoteOption);
        }
        
//      Tc_35

      @Test(priority=10, dataProvider="fetchData")

      public void stopClimateAndverifyToastMessage(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{

          new P2_Login(driver, test)

          .clickSignIn()
          .enterLoginEmailId(emailId)
          .enterLoginPassword(pwdLogin)
          .clkSignIn()
          .pickTheCar(vehicleName)
          .stopClimateFromDasboard()
          .stopClimateAndverifyToastMessage();

      }

//    Tc_34

    @Test(priority=11, dataProvider="fetchData")

    public void verifyClimateIsOffInRemote(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{

        new P2_Login(driver, test)
        .clickSignIn()
        .enterLoginEmailId(emailId)
        .enterLoginPassword(pwdLogin)
        .clkSignIn()
        .pickTheCar(vehicleName)
        .stopClimateFromDasboard()
        .verifyClimateIsOffInRemote(remoteOption);
    }

      //Tc_36

              @Test(priority=12, dataProvider="fetchData")

              public void verifyVehicleStatusForMaintenance(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifyVechileStatusForMaintenance();
              }

             // TC_37

              @Test(priority=14, dataProvider="fetchData")

              public void verifyVehicleFuelRangeAndStationNearBy(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifyFuelRange();
              }
              
              // TC_38
              @Test(priority=15, dataProvider="fetchData")
              public void verifyFindGasStationLocationNearBy(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifyFindGasStationLocation();
              
              }
                         
              // TC_40
              @Test(priority=16, dataProvider="fetchData")
              public void verifyDoorAndWindowsSubmodules(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifyDoorAndWindowsSubmodules(doorSubmodules);
              }
              // TC_41
              @Test(priority=17, dataProvider="fetchData")
              public void verifyLightSubmodulesSection(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifyLightSubmodules(lightsModule);
              }
              // TC_42
              @Test(priority=18, dataProvider="fetchData")
              public void verifyFluidsSubmodules(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifyFluidsSubmodules(fluidsModules);
              }
              // TC_43
              @Test(priority=19, dataProvider="fetchData")
              public void verifySmartKeySection(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .verifySmartKeySection();
              }
//              Tc_44
              @Test(priority=20, dataProvider="fetchData")
              public void verifyVehicleStatusPopupCloseButton(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                  new P2_Login(driver, test)
                  .clickSignIn()
                  .enterLoginEmailId(emailId)
                  .enterLoginPassword(pwdLogin)
                  .clkSignIn()
                  .pickTheCar(vehicleName)
                  .clickOnMaintanceVehicleStatus()
                  .closePopUpAndVerifyForVechileStatus();
              }

//            Tc_39
            @Test(priority=21, dataProvider="fetchData")
            public void verifyDiagnosticIssue(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickOnMaintanceVehicleStatus()
                .verifyDiagnosticIssue();
            }
            
           //Tc_137
            @Test(priority=22, dataProvider="fetchData")
            public void verifyCheckOutWhatsAround(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .verifyCheckWhatsAroundOption();
            }
            
            //Tc_138
            @Test(priority=23, dataProvider="fetchData")
            public void verifyViewAndTakePicOptions(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .verifyViewAndTakePicOption();
            }
            
            //Tc_139
            @Test(priority=24, dataProvider="fetchData")
            public void clickTakePicOption(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .verifyViewAndTakePicOption();
            }
            
            //Tc_140
            @Test(priority=25, dataProvider="fetchData")
            public void clickViewOptionAndVerifyLocationPage(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickViewOption();
            }
            
            //Tc_141
            @Test(priority=26, dataProvider="fetchData")
            public void verifyRecentlyCapturedPics(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickViewOption();
                
                new P9_Locations(driver, test)
                .clickGalleryDropDown();
            }
            
            //Tc_164
            @Test(priority=27, dataProvider="fetchData")
            public void verifyVehicleInformationPopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon();
            }
            
            //Tc_165
            @Test(priority=28, dataProvider="fetchData")
            public void verifyVinNumberInVehicleInfoPopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .verifyVinNumberVehicleInformation();
            }
            
            //Tc_166
            @Test(priority=29, dataProvider="fetchData")
            public void updateNickName(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .updateNickName(vehicleName);
            }
            
            //Tc_167
            @Test(priority=30, dataProvider="fetchData")
            public void changeDealer(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .changeDealer(zipCode);
            }
            
            //Tc_168
            @Test(priority=31, dataProvider="fetchData")
            public void verifyGetDirections(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .clickGetDirection();
            }
            
            //Tc_169
            @Test(priority=32, dataProvider="fetchData")
            public void clickCreateCustomField(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .clickCreateCustomField();
            }
            
            //Tc_170
            @Test(priority=33, dataProvider="fetchData")
            public void createCustomField(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .createCustomField(fieldLabel, helperText);
            }
            
          //Tc_172
            @Test(priority=34, dataProvider="fetchData")
            public void verifyCreateCustomField(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .clickCreateCustomField()
                .verifyCreateFieldBtnDisabled("");
            }

            //Tc_173
            @Test(priority=35, dataProvider="fetchData")
            public void verifyCreateCustomFieldBtnEnabled(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .clickCreateCustomField()
                .verifyCreateFieldBtnEnabled("test", "testing");
            }
            
            //Tc_174
            @Test(priority=36, dataProvider="fetchData")
            public void verifyCustomFields(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .clickCreateCustomField();
            }
            
            //TC-175
            @Test(priority=37, dataProvider="fetchData")
            public void closeInformationIconPopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .closeVehicleInformationIcon();
            }
            
            //TC-176
            @Test(priority=38, dataProvider="fetchData")
            public void removeNickName(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModule, String zipCodes, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .removeNickName();
            }
            
            //TC-177
            @Test(priority=39, dataProvider="fetchData")
            public void clickPrintIcon(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModule, String zipCodes, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickVehicleInformationIcon()
                .clickPrintIcon();
            }
            
            //Tc_178
            @Test(priority=40, dataProvider="fetchData")
            public void clickAndVerifyAccountsDropdown(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickAccountsDropDown();
            }

            //Tc_179
            @Test(priority=41, dataProvider="fetchData")
            public void verifyNavigateToSettings(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickAccountsDropDown()
                .goToSettings();
            }

            //Tc_180
            @Test(priority=42, dataProvider="fetchData")
            public void verifyNavigateToDriverPreference(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickAccountsDropDown()
                .goToDriverPreferences();
            }
            
            //Tc_181
            @Test(priority=43, dataProvider="fetchData")
            public void verifyLogout(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickAccountsDropDown()
                .clickLogout();
            }
            
            //Tc_182
            @Test(priority=44, dataProvider="fetchData")
            public void verifyNotificationIcon(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickNotificationIcon();
            }
            
            //Tc_183
            @Test(priority=45, dataProvider="fetchData")
            public void verifySeeAllNotifications(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickNotificationIcon()
                .verifySeeAllNotifications();
            }
            
            //Tc_184
            @Test(priority=46, dataProvider="fetchData")
            public void verifyAllAndRemoteCategory(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickNotificationIcon()
                .verifySeeAllNotifications()
                .verifyAllAndRemoteCategory();
            }
            
            //Tc_185
            @Test(priority=47, dataProvider="fetchData")
            public void verifyAllNotificationsCategory(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickNotificationIcon()
                .verifySeeAllNotifications()
                .verifyAllNotificationsCategory();
            }
            
            //Tc_186
            @Test(priority=48, dataProvider="fetchData")
            public void verifyRemoteNotificationsCategory(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickNotificationIcon()
                .verifySeeAllNotifications()
                .verifyRemoteNotificationsCategory();
            }
            
            //Tc_187
            @Test(priority=49, dataProvider="fetchData")
            public void verifyMakeAnAppointmentClickable(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickMakeAnAppointment();
            }
            
          //Tc_188
            @Test(priority=50, dataProvider="fetchData")
            public void verifyMakeAnAppointmentPopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickMakeAnAppointment();
            }
            
            //Tc_189
            @Test(priority=51, dataProvider="fetchData")
            public void verifySelectNearbyDealer(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                new P2_Login(driver, test)
                .clickSignIn()
                .enterLoginEmailId(emailId)
                .enterLoginPassword(pwdLogin)
                .clkSignIn()
                .pickTheCar(vehicleName)
                .clickMakeAnAppointment()
                .clickSelectNearbyDealerLink();
            }
            
            //Tc_190
                      @Test(priority=52, dataProvider="fetchData")
                      public void verifySelectVehicleRepairRadioButton(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                          new P2_Login(driver, test)
                          .clickSignIn()
                          .enterLoginEmailId(emailId)
                          .enterLoginPassword(pwdLogin)
                          .clkSignIn()
                          .pickTheCar(vehicleName)
                          .clickMakeAnAppointment()
                          .checkVehicleRepairRadioButton();
                      }


                      //Tc_191
                      @Test(priority=53, dataProvider="fetchData")
                      public void verifySelectMaintenanceRadioButton(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                          new P2_Login(driver, test)
                          .clickSignIn()
                          .enterLoginEmailId(emailId)
                          .enterLoginPassword(pwdLogin)
                          .clkSignIn()
                          .pickTheCar(vehicleName)
                          .clickMakeAnAppointment()
                          .checkMaintenanceRadioButton();
                      }


                      //Tc_192

                      @Test(priority=54, dataProvider="fetchData")

                      public void verifySelectOtherRadioButton(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                          new P2_Login(driver, test)
                          .clickSignIn()
                          .enterLoginEmailId(emailId)
                          .enterLoginPassword(pwdLogin)
                          .clkSignIn()
                          .pickTheCar(vehicleName)
                          .clickMakeAnAppointment()
                          .checkOtherRadioButton();
                      }

                      //Tc_193
                      @Test(priority=55, dataProvider="fetchData")
                      public void verifyRequestAppointmentButton(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                          new P2_Login(driver, test)
                          .clickSignIn()
                          .enterLoginEmailId(emailId)
                          .enterLoginPassword(pwdLogin)
                          .clkSignIn()
                          .pickTheCar(vehicleName)
                          .clickMakeAnAppointment()
                          .checkOtherRadioButton()
                          .clickRequestAppointmentButton();
                          
                      }
                      
                      //Tc_194
                      @Test(priority=56, dataProvider="fetchData")
                      public void verifyRequestAppointment(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                          new P2_Login(driver, test)
                          .clickSignIn()
                          .enterLoginEmailId(emailId)
                          .enterLoginPassword(pwdLogin)
                          .clkSignIn()
                          .pickTheCar(vehicleName)
                          .clickMakeAnAppointment()
                          .selectNearbyDealer(zipCode)
                          .checkVehicleRepairRadioButton()
                          .clickRequestAppointmentButton()
                          .requestAppointment();
                          
                      }
                      
                      //Tc_195
                      @Test(priority=57, dataProvider="fetchData")
                      public void closemakeAnAppointmentPopup(String emailId, String pwdLogin,String vehicleName,String remoteOption,String doorSubmodules,String lightsModule,String fluidsModules, String zipCode, String fieldLabel, String helperText) throws InterruptedException{
                          new P2_Login(driver, test)
                          .clickSignIn()
                          .enterLoginEmailId(emailId)
                          .enterLoginPassword(pwdLogin)
                          .clkSignIn()
                          .pickTheCar(vehicleName)
                          .clickMakeAnAppointment()
                          .closeMakeAnAppointmentpopup();
                          
                      }

}

	