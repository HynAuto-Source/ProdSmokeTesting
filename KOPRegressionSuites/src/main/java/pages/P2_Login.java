package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P2_Login extends KMABase{

		public P2_Login(WebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test =test;
			waitUntilElementVisisble("//*[@id='header-signIn']");
			if(!verifyTitle("Kia Owners Portal")){
				reportStep("This is not Kia Owners Portal", "FAIL");	
			}		
		}
		
		
		
		public P2_Login verifySignInEnable() {
			//Assert.assertTrue(driver.findElement(By.id("//button[@title='Sign In Submit']")).isDisplayed());
			
			Assert.assertFalse(driver.findElement(By.id("//button[@title='Sign In Submit']")).isEnabled());
			return this;
		}
		
	
		
		public P2_Login rememberMe() {
			clickByXpath("(//*[@class='checkbox'])[1]");
			return this;
		}
		
		
		public P2_Login verifyEmailIdExists() {
			Assert.assertTrue(driver.findElement(By.name("userLoginId")).isDisplayed());
			return this;
		}
		
		
		//-------------------------------------------------------
		
		public P2_Login clickSignIn() {
			clickByXpath("//*[text()=' SIGN IN ']");
			Assert.assertTrue(driver.findElement(By.id("resetIconClick")).isDisplayed());
			return this;	
		}
		
		
		public P2_Login enterLoginEmailId(String emailId) {
			waitVisibilityOfElementLocatedByName("userLoginId");
			enterByName("userLoginId", emailId );
			return this;
		}		
		
		public P2_Login enterLoginPassword(String pwdLogin) throws InterruptedException{
			waitVisibilityOfElementLocatedByName("userLoginPwd");
			enterByName("userLoginPwd", pwdLogin);
			return this;
		}
			
		
		public P4_MyVehicles clkSignIn() throws InterruptedException{
			waitElementToBeClickableXpathFW();
			clickByXpath("//*[@class='button full main has-spinner sign-in']");
			return new P4_MyVehicles(driver, test);
		}
		
		
		/**
	    
	     * Description: Verify and click Forgot password Link
	     */
		public P2_Login clickForgotPassword() {
			reportStep("Click on forgot password", "INFO");
			clickByXpathJavascriptExecutor("//div[@class='form-footer']//a[@class='secondary2']");
			String text = getTextByXpath("//div[@class='reset-password-first']/strong");
			if (text.equalsIgnoreCase("FORGOT PASSWORD")) {
				reportStep("Successfully navigated to forgot password popup", "PASS");
			} else {
				reportStep("Failed to navigate to forgot password popup", "FAIL");
			}
			return this;	
		}
		
		/**
	    
	     * Description: Verify and Click Create Account
	     */
		public P2_Login clickCreateAccount() {
			reportStep("Click on Create Account", "INFO");
			clickByXpathJavascriptExecutor("//li[@class='create-account-tab']");
			String text = getTextByXpath("//li[@title='CREATE ACCOUNT']");
			if (text.equalsIgnoreCase("CREATE ACCOUNT")) {
				reportStep("Successfully navigated to Create Account popup", "PASS");
			} else {
				reportStep("Failed to navigate to Create Account popup", "FAIL");
			}
			return this;	
		}
		
		/**
	    
	     * Description: Verify SIGN IN button
	     */
		public P2_Login verifySignButtonIsEnable(String emailId, String pwdLogin){
				String disableChk=driver.findElement(By.xpath("//div[@class='form-footer']//button[@title='Sign In Submit']")).getAttribute("class");
				if (disableChk.contains("disabled")) {
					reportStep("As expected 'SIGN IN' button is disabled before entering values", "Pass");
					
				}else {
					reportStep("SIGN IN button is Enabled", "Fail");
				}
				enterByName("userLoginId", emailId );
				enterByName("userLoginPwd", pwdLogin);
				
				String disableChkAftInput=driver.findElement(By.xpath("//div[@class='form-footer']//button[@title='Sign In Submit']")).getAttribute("class");
				if (!disableChkAftInput.contains("disabled")) {
					reportStep("As expected 'SIGN IN' button is Enabled after entering values", "Pass");
					
				}else {
					reportStep("SIGN IN button is Disabled", "Fail");
				}
			return this;
		}
		
		/**
	    
	     * Description: Verify and click Forgot password Link
	     */
		public P2_Login verifyInvalidUserIdPasswordErrorMsg(){
			clickByXpath("//*[@class='button full main has-spinner sign-in']");
			 waitUntilElementVisisble("//span[@class='error-message']//span");
			String text = getTextByXpath("//span[@class='error-message']//span");
			if (text.equalsIgnoreCase("Invalid user ID or password")) {
				reportStep("Successfully got the error message "+text, "PASS");
			} else {
				reportStep("Invalid user ID or Passord didn't appears", "FAIL");
			}
			return this;	
		}
		
		/**
        
         * Description: Verify SIGN IN button is Disabled
         */
        public P2_Login verifySignButtonIsDisable(String emailId, String pwdLogin){

                enterByName("userLoginId", emailId );
                enterByName("userLoginPwd", pwdLogin);

                String disableChk=driver.findElement(By.xpath("//div[@class='form-footer']//button[@title='Sign In Submit']")).getAttribute("class");
                if (disableChk.contains("disabled")) {
                    reportStep("As expected 'SIGN IN' button is disabled before entering values", "Pass");

                }else {
                    reportStep("SIGN IN button is Enabled", "Fail");
                }
            return this;
        }
		
        public P5_Dashboard clkSignInSecondaryLogin() throws InterruptedException{

            clickByXpath("//*[@class='button full main has-spinner sign-in']");

            return new P5_Dashboard(driver, test);

            

        }
        
}
		

