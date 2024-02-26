package testcases;

import org.testng.annotations.Test;
import pages.P2_Login;
import wrappers.KMABase;

public class TC004_MyVehicles extends KMABase {
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void myVehiclesPickTheVehicle(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.pickTheCar(vehicleName);
	}
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void myVehiclesClickAddvehicle(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAddVehicle();
	
	}
	
	
	//-------------------------------------------------------------

	//Tc_11
	@Test(priority=3, dataProvider="fetchData")
	public void verifyMyVehicleOptions(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
		
        new P2_Login(driver, test)
        
    	.clickSignIn()
    	.enterLoginEmailId(emailId)
    	.enterLoginPassword(pwdLogin)
    	.clkSignIn()
	    .verifyMyVechileScreen();
	}
	
	//Tc_13
	@Test(priority=4, dataProvider="fetchData")
	public void verifyNoVechileMatchedForThisSearchPopup(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
	  
		new P2_Login(driver, test)
    	.clickSignIn()
    	.enterLoginEmailId(emailId)
    	.enterLoginPassword(pwdLogin)
    	.clkSignIn()
        .enterInvalidDataInSearchBox();
	}
	
      //Tc_12
    	@Test(priority=5, dataProvider="fetchData")
    	public void clickAddVechileButton(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	    new P2_Login(driver, test)
    		
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .clickAddVechilesButton();
       
    	}  	
    	//Tc_14
    	@Test(priority=6, dataProvider="fetchData",dataProviderClass=KMABase.class ,enabled = true)
    	public void verifyAddVechileButton(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	    new P2_Login(driver, test)
    		
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .VerifyAddVechilesButton();
       
    	}

    	//Tc15
    	@Test(priority=7, dataProvider="fetchData")
    	public void enterVinField(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .VerifyAddVechilesButton()
	        .enterVinNumber(vinNumber);
    	}
    	
    	//TC_16
    	@Test(priority=8, dataProvider="fetchData" )
    	public void validateVerifyVinIsDisable(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .VerifyAddVechilesButton()
    		.verifyVinButtonIsDisable();
    	} 
    	
    	//TC17
    	@Test(priority=9, dataProvider="fetchData")
    	public void verifyVinButtonIsEnabled(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .VerifyAddVechilesButton()
	        .verifyVinButton(vinNumber);
    	}
    	//TC 19
    	@Test(priority=10, dataProvider="fetchData")
    	public void enterInvalidVinNumber(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .VerifyAddVechilesButton()
    		.verifyInvalidVinNumber(vinNumber);
    	}  
    	//TC 18
    	@Test(priority=11, dataProvider="fetchData")
    	public void verifyWhereCanIFindVin(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .VerifyAddVechilesButton()
	        .verifyWhereICanFindVin();
 
    	} 
    	//TC 21
      	@Test(priority=12, dataProvider="fetchData")
    	public void searchByYear(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .verifysearchBoxByYear(year);
    	}
      	
       //TC 20
      	@Test(priority=13, dataProvider="fetchData")
    	public void searchByModel(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .verifysearchBoxByModel(vehicleName);
    	}
      	
       //TC 22
      	@Test(priority=14, dataProvider="fetchData")
    	public void searchByNickName(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .verifysearchBoxByNickName(nickName);
    	}
        //TC 23
      	@Test(priority=15, dataProvider="fetchData")
    	public void selectTheCar(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
    	  
    		new P2_Login(driver, test)
        	.clickSignIn()
        	.enterLoginEmailId(emailId)
        	.enterLoginPassword(pwdLogin)
        	.clkSignIn()
	        .searchVehicleName(vehicleName)
	        .selectTheCar();
    	}
        //TC 24
  	@Test(priority=16, dataProvider="fetchData")
	public void verifyCheckBox(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
	  
		new P2_Login(driver, test)
    	.clickSignIn()
    	.enterLoginEmailId(emailId)
    	.enterLoginPassword(pwdLogin)
    	.clkSignIn()
        .verifyCheckboxOnCar();
	}
     //Tc_25
  	@Test(priority=17, dataProvider="fetchData")
	public void verifyCancelButton(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
	  
		new P2_Login(driver, test)
    	.clickSignIn()
    	.enterLoginEmailId(emailId)
    	.enterLoginPassword(pwdLogin)
    	.clkSignIn()
        .verifyCheckboxOnCar()
		.clickAndVerifyCancelButton();
	}
//  	Tc_27
  	@Test(priority=18, dataProvider="fetchData")
	public void verifySettingsButtonIncar(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
	  
		new P2_Login(driver, test)
    	.clickSignIn()
    	.enterLoginEmailId(emailId)
    	.enterLoginPassword(pwdLogin)
    	.clkSignIn()
        .checkSettingsButton();
	}
  	
  	//Tc29
 	@Test(priority=19, dataProvider="fetchData")
	public void verifyGridView(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
	  
		new P2_Login(driver, test)
    	.clickSignIn()
    	.enterLoginEmailId(emailId)
    	.enterLoginPassword(pwdLogin)
    	.clkSignIn()
        .verifyGrid();
	}
 	//Tc30
 	 	@Test(priority=20, dataProvider="fetchData")
 		public void  viewVehicleDetailInListView(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
 		  
 			new P2_Login(driver, test)
 	    	.clickSignIn()
 	    	.enterLoginEmailId(emailId)
 	    	.enterLoginPassword(pwdLogin)
 	    	.clkSignIn()
 	        .verifyVehicleListByhamburgerIcon();
 		}
 	 	
 	 	//Tc28
 	 	@Test(priority=21, dataProvider="fetchData")
 		public void  verifyMapIcon(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
 		  
 			new P2_Login(driver, test)
 	    	.clickSignIn()
 	    	.enterLoginEmailId(emailId)
 	    	.enterLoginPassword(pwdLogin)
 	    	.clkSignIn()
 	        .verifyMap();
 		}
 	 	//TC-26
 	 	@Test(priority=22, dataProvider="fetchData")
 		public void  verifyDeleteButtonIsEnabled(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName,String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
 		  
 			new P2_Login(driver, test)
 	    	.clickSignIn()
 	    	.enterLoginEmailId("sson@mailinator.com")
 	    	.enterLoginPassword(pwdLogin)
 	    	.clkSignIn()
 	        .verifyDeleteButtonIsEnabled();
 		}
}
