package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import wrappers.KMABase;

public class TC002_Login extends KMABase {

	
	
	@Test(priority=1)
	public void verifySignInIsDisplayed() {
		new P2_Login(driver, test)
		.clickSignIn();
	}
	
	
	@Test(priority=2, dataProvider="fetchData")
	public void verifyLoginIn(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
	new P2_Login(driver, test)
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn();	
	}
	
	@Test(priority=3)
	public void verifyForgotPassword() throws InterruptedException{
	new P2_Login(driver, test)
	.clickSignIn()
	.clickForgotPassword();
	}
	
	
	@Test(priority=4, dataProvider="fetchData")
	public void verifyRememberMecheckbox(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.rememberMe()
	.clkSignIn()
	.clickAccount()
	.clickLogout()
	.clickSignIn()
	.verifyEmailIdExists()
	.enterLoginPassword(pwdLogin)
	.clkSignIn();			// In this case, only email id is saved 
	
}
	

	@Test(priority=5, dataProvider="fetchData", enabled = false)
	public void verifySignInButtonEnabled(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
		
	new P2_Login(driver, test)
	.clickSignIn()
	.verifySignInEnable();
}
	

	@Test(priority=6,dataProvider="fetchData")
	public void verifyLogout(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)
	.enterLoginPassword(pwdLogin)
	.clkSignIn()
	.clickAccount()
	.clickLogout();	
	}
	
	//-------------------------------------------------
	
	//TC_3
	@Test(priority=7, enabled=true)
	public void verifyCreateAccountPopup() {
	new P2_Login(driver, test)
	.clickSignIn()
	.clickCreateAccount();	
			}
			
		
	//TC_5
	@Test(priority=8, dataProvider="fetchData",dataProviderClass=KMABase.class ,enabled = true)
	public void verifySignInButtonFunctionality(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) {
	new P2_Login(driver, test)
	.clickSignIn()
	.verifySignButtonIsEnable(emailId, pwdLogin);
		}
		
	//TC_6
	@Test(priority=9, dataProvider="fetchData",dataProviderClass=KMABase.class ,enabled = true)
	public void verifyInvalidEmailAndPassword(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException {
	new P2_Login(driver, test)
	.clickSignIn()
	.enterLoginEmailId(invalidEmailId)
	.enterLoginPassword(invalidPwdLogin)
	.verifyInvalidUserIdPasswordErrorMsg();
		}
				
	//TC_7
	@Test(priority=10, dataProvider="fetchData",dataProviderClass=KMABase.class ,enabled = true)
	public void verifyInvalidEmailAndValidPassword(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException  {
	new P2_Login(driver, test)
	.clickSignIn()
	.enterLoginEmailId(invalidEmailId)
	.enterLoginPassword(pwdLogin)
	.verifyInvalidUserIdPasswordErrorMsg();
		}
	
	//TC_8
	@Test(priority=11, enabled = true)
	public void verifySignInWithoutEnteringEmailAndPassword() throws InterruptedException  {
	new P2_Login(driver, test)
	.clickSignIn()
	.verifySignButtonIsDisable("", "");
		}
	
	//TC_9
	@Test(priority=12, dataProvider="fetchData",dataProviderClass=KMABase.class, enabled = true)
	public void verifySignInWithoutEnteringEmailId(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException  {
	new P2_Login(driver, test)
	.clickSignIn()
	.verifySignButtonIsDisable("", pwdLogin);
		}
	
	//TC_10
		@Test(priority=13, dataProvider="fetchData",dataProviderClass=KMABase.class, enabled = true)
		public void verifySignInWithoutEnteringPassword(String emailId, String pwdLogin,String vinNumber,String year, String vehicleName, String nickName, String invalidEmailId, String invalidPwdLogin) throws InterruptedException  {
		new P2_Login(driver, test)
		.clickSignIn()
		.verifySignButtonIsDisable(emailId, "");
			}
}
