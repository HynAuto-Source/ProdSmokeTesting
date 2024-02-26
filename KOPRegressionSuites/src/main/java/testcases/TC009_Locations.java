package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import pages.P9_Locations;
import wrappers.KMABase;

public class TC009_Locations extends KMABase{
	
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void LocationsSearchIsPresent(String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripTags) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.searchIsPresent_5754511(); 
	}
	
	
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void LocationsVehicleCurrentLocation(String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripTags) throws InterruptedException {
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.vehicleCurrentLocation();
	}

	@Test(priority=3, dataProvider="fetchData")
	public void LocationsSavePOI(String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripTags) throws InterruptedException {
	
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.savePOI(locationPOI);
	}
	
	@Test(priority=4,dataProvider="fetchData")
	public void LocationsDeletePOI(String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripTags) throws InterruptedException {
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleModel)
	.clickLocations()
	.deletePOI();
}
	
	
	@Test(priority=5, dataProvider="fetchData")
	public void LocationsSavePOISendToVehiclenDelete (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripTags) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.savePOIAddnSendToVehicle(locationPOI)
		.deletePOI();
		
	}
	
	
	
	@Test(priority=6, dataProvider="fetchData")
	public void LocationsAddTags (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripType) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.clickMyTrips()
		.selectDateType()
		.addTags(tripType);	
	}
	
	
	@Test(priority=7, dataProvider="fetchData")
	public void deleteTheTags (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripType) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.clickMyTrips()
		.selectDateType()
		.deleteTags();
	}
	
	
	@Test(priority=8, dataProvider="fetchData")
	public void LocationsMergeTrips (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripType) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.clickMyTrips()
		.selectDateType()
		.mergeTrips();		
	}
	
	
	
	@Test(priority=9, dataProvider="fetchData")
	public void LocationsAddTagsForMergedTrips (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripType) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.clickMyTrips()
		.selectDateType()
		.addTagsForMergedTrips(tripType);
	}
	
	
	@Test(priority=10, dataProvider="fetchData")
	public void deleteTheTagsForMergedTrip (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripType) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.clickMyTrips()
		.selectDateType()
		.deleteTagsForMergedTrip();
	}
	
	
	@Test(priority=11, dataProvider="fetchData")
	public void LocationsUnmergeTrips (String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripType) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel)
		.clickLocations()
		.clickMyTrips()
		.selectDateType()
		.unMergeTrips();	
	}
	
	
	
	//------------------------------------------------
	
	//TC_63
	@Test(priority=1, dataProvider="fetchData")
	public void getCurrentLocations(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleName)
		.clickOnLeftPanelOption(option);
		
		new P9_Locations(driver, test)
		.vehicleCurrentLocation();
	}
	
	//TC_64
		@Test(priority=2, dataProvider="fetchData")
		public void verifyAddPOIs(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
			new P2_Login(driver,test)
			
			.clickSignIn()
			.enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
			.pickTheCar(vehicleName)
			.clickOnLeftPanelOption(option);
			
			new P9_Locations(driver, test)
			.enterValueInLoactionSearchBox(pois)
			.clickAddToPois(pois)
			.deletePois();
		}
		
		//TC_65
				@Test(priority=3, dataProvider="fetchData")
				public void verifyAddAndSendToVehicle(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.enterValueInLoactionSearchBox(shell)
					.clickAddAndSendToVehicle(shell)
					.deletePois();
				}
				
				//TC_66
				@Test(priority=4, dataProvider="fetchData")
				public void updateNotes(String emailId, String pwdLogin, String vehicleName, String option, String pois , String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.enterValueInLoactionSearchBox(shell)
					.clickAddAndSendToVehicle(shell)
					.clickShellPois()
					.enterValueInAddNotes(pois)
					.clickDeletePois();
				}
				
				//TC_67
				@Test(priority=5, dataProvider="fetchData")
				public void verifyDeletePOIs(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.enterValueInLoactionSearchBox(pois)
					.clickAddToPois(pois)
					.deletePois();
				}
				
				//TC_68
				@Test(priority=6, dataProvider="fetchData")
				public void verifyTripDetails(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.clickMyTrips()
					.selectDateRange(date)
					.getTripDetails();
				}
				
				//TC_69
				@Test(priority=6, dataProvider="fetchData")
				public void verifyTripChange(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.clickMyTrips()
					.selectDateRange(date)
					.changeTripTypeAndVerify(tripType);
				}
				
				//TC_70
				@Test(priority=6, dataProvider="fetchData")
				public void mergeTwoTrips(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.clickMyTrips()
					.selectCustomDateRange(customDate)
					.mergeTrips();
				}
				
				//TC_71
				@Test(priority=6, dataProvider="fetchData")
				public void verifyTags(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.clickMyTrips()
					.selectDateRange(date)
					.addTags(tagInfo);
				}
				
				//TC_72
				@Test(priority=6, dataProvider="fetchData")
				public void unMergeTrips(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.clickMyTrips()
					.selectCustomDateRange(customDate)
					.mergeTrips();
				}
				
				//TC_73
				@Test(priority=6, dataProvider="fetchData")
				public void exportTripDetails(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.clickMyTrips()
					.selectCustomDateRange(customDate)
					.exportTripDetails();
				}
				
				//TC_196
				@Test(priority=6, dataProvider="fetchData")
				public void verify360viewSection(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.click360View();
				}
				
				//TC_197
				@Test(priority=6, dataProvider="fetchData")
				public void verifyGalleryDropDown(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.click360View()
					.clickGalleryDropDown();
				}
				
				//TC_198
				@Test(priority=6, dataProvider="fetchData")
				public void verifyCollapseAllOption(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.click360View()
					.verifyCollapseAllOption();
				}
				
				//TC_199
				@Test(priority=6, dataProvider="fetchData")
				public void verifyTakePicOption(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.click360View()
					.verifyTakePicOption();
				}
				
				//TC_200
				@Test(priority=6, dataProvider="fetchData")
				public void verifyDeleteGalleryFunction(String emailId, String pwdLogin, String vehicleName, String option, String pois, String date, String tripType, String tagInfo, String shell, String customDate) throws InterruptedException {
					new P2_Login(driver,test)
					
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheCar(vehicleName)
					.clickOnLeftPanelOption(option);
					
					new P9_Locations(driver, test)
					.click360View()
					.deleteGallery();
				}
				
				
}

