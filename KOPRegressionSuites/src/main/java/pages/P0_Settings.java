package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P0_Settings extends KMABase {
	
	public P0_Settings(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test =test;
		
		
		waitUntilElementVisisble("//*[@class='personal-tab active']");
		if(!verifyTitle("Settings")){
			reportStep("This is not Kia Owners Portal", "FAIL");	
		}		
	}
	
	
	public P0_Settings phoneNumberVerified() {
		waitUntilElementVisisble("//*[text()='First Name ']");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='badge verified']")).isDisplayed());
		waitElementToBeClickableXpathFW();
		return this;
	}

	
	public P0_Settings securityChangePassword(String currentPassword, String newPassword, String confirmPassword) throws InterruptedException {
		
		waitUntilElementVisisble("//*[@class='personal-tab active']");
		clickByXpathJavascriptExecutor("//*[@class='security-tab']");
		waitUntilElementVisisble("//*[text()='CHANGE PASSWORD']");
		enterByXpath("//*[@name='oldPassword']", currentPassword);
		enterByXpath("//*[@id='newPwdInput']", newPassword);
		enterByXpath("//*[@name='confirmNewPwd']", confirmPassword);
		waitUntilElementVisisble("//*[@title='CHANGE PASSWORD']");
		clickByXpathJavascriptExecutor("//*[@title='CHANGE PASSWORD']");		
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this; 
	}
	
	
	
	public P0_Settings settingsUpdatePIN(String currentPIN, String newPIN, String confirmNewPIN) {
		waitUntilElementVisisble("//*[@class='personal-tab active']");
		clickByXpathJavascriptExecutor("//*[@class='security-tab']");
		waitUntilElementVisisble("//*[text()='CHANGE 4-DIGIT PIN']");
		enterByXpath("//*[@name='currentPin']", currentPIN);
		enterByXpath("//*[@id='pinValueNew']", newPIN);
		enterByXpath("//*[@id='pinValueConfirm']", confirmNewPIN);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("(//*[@type='submit'])[3]");
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}
	
	
	public P0_Settings settingsUpdatePINWithPassword(String currentPasswordResetPIN, String newPINRP, String confirmNewPINRP) {
		waitUntilElementVisisble("//*[@class='personal-tab active']");
		clickByXpathJavascriptExecutor("//*[@class='security-tab']");	
		waitUntilElementVisisble("//*[text()='forgot pin?']");
		clickByXpathJavascriptExecutor("//*[text()='forgot pin?']");
		enterByXpath("//*[@name='currPassword']", currentPasswordResetPIN);
		enterByXpath("//*[@id='pinValueNew']", newPINRP);
		enterByXpath("//*[@id='pinValueConfirm']", confirmNewPINRP);
		clickByXpathJavascriptExecutor("(//*[@type='submit'])[3]");
		waitUntilElementVisisble("(//*[@class='close'])[6]");		
		return this;
	} 
	
	
	
	public P0_Settings settingsCPenableSMStoggle() throws InterruptedException {
		waitUntilElementVisisble("(//*[contains(text(),'Communication Preferences')])[1]");
		clickByXpath("(//*[contains(text(),'Communication Preferences')])[1]");
		waitElementToBeClickableXpathFW();
		clickByXpath("(//*[@class='w-100 d-inline-block'])[1]");
		scrollDownJavaScriptExecutor("//*[text()='SAVE CHANGES']");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[text()='SAVE CHANGES']");
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}
	
	
	public P0_Settings settingsCPdisabledSMStoggle() throws InterruptedException {
		waitUntilElementVisisble("(//*[contains(text(),'Communication Preferences')])[1]");
		clickByXpath("(//*[contains(text(),'Communication Preferences')])[1]");
		waitElementToBeClickableXpathFW();
		clickByXpath("(//*[@class='w-100 d-inline-block'])[1]");
		scrollDownJavaScriptExecutor("//*[text()='SAVE CHANGES']");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[text()='SAVE CHANGES']");
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}
	
	
	
	public P0_Settings settingsKiaConnectNotificationAlertsTurnOff() {
		waitUntilElementVisisble("//*[contains(text(),'KIA Connect Notifications')]");
		clickByXpath("//*[contains(text(),'KIA Connect Notifications')]");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']");
		waitElementToBeClickableXpathFW();
		clickByXpath("(//*[contains(text(),'All On/Off')])[2]");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']");
		/*clickByXpath("//*[contains(text(),'KIA CONNECT MESSAGES')]");
		waitUntilElementVisisble("(//*[contains(text(),'All On/Off')])[3]");
		clickByXpath("(//*[contains(text(),'All On/Off')])[3]");*/
		clickByXpath("//*[contains(text(),' Save')]");
		waitUntilElementVisisble("(//*[contains(text(),'Close')])[2]");		
		return this;
	}
	
	
	public P0_Settings settingsKiaConnectNotificationAlertsTurnOn() {
		waitUntilElementVisisble("//*[contains(text(),'KIA Connect Notifications')]");
		clickByXpath("//*[contains(text(),'KIA Connect Notifications')]");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']");
		waitElementToBeClickableXpathFW();
		clickByXpath("(//*[contains(text(),'All On/Off')])[2]");
		waitElementToBeClickableXpathFW();
		clickByXpath("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']");
		waitElementToBeClickableXpathFW();
		/*clickByXpath("//*[contains(text(),'KIA CONNECT MESSAGES')]");
		waitUntilElementVisisble("(//*[contains(text(),'All On/Off')])[3]");
		clickByXpath("(//*[contains(text(),'All On/Off')])[3]");*/
		clickByXpath("//*[contains(text(),' Save')]");
		waitUntilElementVisisble("(//*[contains(text(),'Close')])[2]");		
		return this;
	}
	
	
	//----------------------------------------------------
	
	public P0_Settings updatePersonalDetails(String address, String zipCode) {
		waitUntilElementVisisble("//*[text()='First Name ']");
	
		enterByXpath("//*[@name='addressLine1']", address);
		waitElementToBeClickableXpathFW();
		enterByXpath("//*[@id='personal_zipcode']", zipCode);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//div[@class='modal-settings']//*[@type='submit']");
		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
		verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "Changes saved. Changes may take up to 24 hours to be reflected in all systems.");
		waitUntilElementVisisble("//div[@class='alerts']//p[contains(text(),'Changes saved.')]/following-sibling::div/button");
		return this;
	}
	
	public P0_Settings verifySecurityTab() {
		waitUntilElementVisisble("//*[text()='First Name ']");
		reportStep("Verifying security tab is present", "INFO");
		isElementPresent("//a[@class='security-tab']");
		return this;
	}
	
	public P0_Settings clickSecurityTab() {
		waitUntilElementVisisble("//*[text()='First Name ']");
		reportStep("Verifying security tab is present", "INFO");
		clickByXpathJavascriptExecutor("//a[@class='security-tab']");
		return this;
	}
	
	public P0_Settings verifyChangeInvalidPassword(String password, String invalidPassword) {
		waitUntilElementVisisble("//*[text()='CHANGE PASSWORD']");
	
		enterByXpath("//*[@name='oldPassword']", password);
		waitElementToBeClickableXpathFW();
		enterByXpath("//*[@id='newPwdInput']", invalidPassword);
		waitUntilElementVisisble("//span[@class='inline-validator create-password-validator help-text-icon show']");
		isElementPresent("//span[@class='inline-validator create-password-validator help-text-icon show']");
		return this;
	}
	
	/**
     
     * Description: Verify Change Password button is Disabled
     */
    public P0_Settings verifyChangePwdButtonIsDisable(String password, String invalidPassword){

    	enterByXpath("//*[@name='oldPassword']", password);
    	waitElementToBeClickableXpathFW();
		enterByXpath("//*[@id='newPwdInput']", invalidPassword);

            String disableChk=driver.findElement(By.xpath("//div[@class='modal-actions']//button[@title='CHANGE PASSWORD']")).getAttribute("class");
            if (disableChk.contains("disabled")) {
                reportStep("As expected 'Change Password' button is disabled", "Pass");

            }else {
                reportStep("Change Password button is Enabled", "Fail");
            }
        return this;
    }
    
    /**
     
     * Description: Verify Change Password button is Enabled
     */
    public P0_Settings verifyChangePwdButtonIsEnabled(String password){

    	enterByXpath("//*[@name='oldPassword']", password);
    	waitElementToBeClickableXpathFW();
		enterByXpath("//*[@id='newPwdInput']", password);
		enterByXpath("//*[@name='confirmNewPwd']", password);

            String disableChk=driver.findElement(By.xpath("//div[@class='modal-actions']//button[@title='CHANGE PASSWORD']")).getAttribute("class");
            if (!disableChk.contains("disabled")) {
                reportStep("As expected 'Change Password' button is Enabled", "Pass");

            }else {
                reportStep("Change Password button is Disabled", "Fail");
            }
        return this;
    }
    
    /**
     
     * Description: Verify Password should match
     */
    public P0_Settings verifyChangePwdShouldMatchErrorMsg(String password, String NewPwd, String diffPwd){

    	 reportStep("Entering old Password", "INFO");
    	enterByXpath("//*[@name='oldPassword']", password);
    	waitElementToBeClickableXpathFW();
    	
    	reportStep("Entering New Password", "INFO");
		enterByXpath("//*[@id='newPwdInput']", NewPwd);
		
		reportStep("Entering Different Password", "INFO");
		enterByXpath("//*[@name='confirmNewPwd']", diffPwd);

		clickByXpathJavascriptExecutor("//button[@title='CHANGE PASSWORD']");
		waitUntilElementVisisble("//span[@class='error-message-inner']");
		
          verifyTextByXpath("//span[@class='error-message-inner']", "Password should match");
        return this;
    }
    
    /**
     
     * Description: Verify Old Password Mismatch Error Message
     */
    public P0_Settings verifyOldPasswordMismatchErrorMsg(String diffPwd, String NewPwd){

    	 reportStep("Entering old Password", "INFO");
    	enterByXpath("//*[@name='oldPassword']", diffPwd);
    	waitElementToBeClickableXpathFW();
    	
    	reportStep("Entering New Password", "INFO");
		enterByXpath("//*[@id='newPwdInput']", NewPwd);
		
		reportStep("Entering Different Password", "INFO");
		enterByXpath("//*[@name='confirmNewPwd']", NewPwd);

		clickByXpathJavascriptExecutor("//button[@title='CHANGE PASSWORD']");
		waitUntilElementVisisble("//div[@class='alert alert-failed alert-dismissible in']/p");
		
          verifyTextByXpath("//div[@class='alert alert-failed alert-dismissible in']/p	", "Incorrect Old Password.");
        return this;
    }
    
    public P0_Settings verifyCommunicationPreferenceTab() {
        waitUntilElementVisisble("//*[text()='First Name ']");
        reportStep("Verifying communication preference tab is present", "INFO");
        isElementPresent("//a[@class='communication-tab']");
        return this;
    }

    public P0_Settings clickCommunicationPreferenceTab() {
        waitUntilElementVisisble("//*[text()='First Name ']");
        reportStep("Clicking Communication Preference tab", "INFO");
        clickByXpathJavascriptExecutor("//a[@class='communication-tab']");
        return this;
    }

     public P0_Settings verifyPhoneNumber() {
            waitUntilElementVisisble("//*[text()='News and Information']");
            reportStep("Verifying phone number in phone preference field", "INFO");
            scrollDownJavaScriptExecutor("//span/strong[text()=' Phone Preferences']");
            String smsNum = driver.findElement(By.xpath("//span[text()=' Send SMS Message to:']/../cp-select/div/select/option")).getAttribute("value");
            reportStep("Successfully got the sms number "+smsNum, "PASS");
            String callNum = driver.findElement(By.xpath("//span[text()=' Call me at:']/../cp-select/div/select/option")).getAttribute("value");
            reportStep("Successfully got the Call me at number "+callNum, "PASS");
            if (smsNum.equals(callNum)) {
            	reportStep("Both SMS number and call number are matching ", "PASS");
			} else {
				reportStep("SMS number and call number are mismatching ", "FAIL");
			}
            
            return this;
        }

     public P0_Settings verifyLanguageDropdown() {
            waitUntilElementVisisble("//*[text()='News and Information']");
            reportStep("Verifying languages in language dropdown", "INFO");
            scrollDownJavaScriptExecutor("//span[text()='Additional Language Option']");
            clickByXpath("//div/span[text()='Additional Language Option']/..//select[@class='phone-prefSelect form-control']");
            List<WebElement> findElements = driver.findElements(By.xpath("//div/span[text()='Additional Language Option']/..//select[@class='phone-prefSelect form-control']/option/span"));
            for (WebElement languages : findElements)
             {
            	 if (languages.getText().contains("Korean") || languages.getText().contains("Spanish") || languages.getText().contains("English")) {
    				 reportStep(languages.getText(), "PASS");
    			}
    			 else {
    				 reportStep("Actual text not matching with the expected text "+languages.getText(), "FAIL");
    			}
                }
            return this;
        }
     
     public P0_Settings verifyKiaConnectNotificationTab() {
         waitUntilElementVisisble("//*[text()='First Name ']");
         reportStep("Verifying Kia Connect Notification tab is present", "INFO");
         isElementPresent("//a[@class='notification-tab']");
         clickByXpathJavascriptExecutor("//a[@class='notification-tab']");
         waitUntilElementVisisble("//*[text()='Notification settings for']");
         reportStep("Verifying Kia Connect Notification options are present", "INFO");
         isElementPresent("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']");
         verifyTextByXpath("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']", "MAINTENANCE & DIAGNOSTICS ALERTS");
         return this;
     }
     
     public P0_Settings verifyKiaConnectNotificationOptions() {
         waitUntilElementVisisble("//*[text()='Notification settings for']");
         reportStep("Verifying Kia Connect Notification options are present", "INFO");
         isElementPresent("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']");
         verifyTextByXpath("//*[text()='MAINTENANCE & DIAGNOSTICS ALERTS']", "MAINTENANCE & DIAGNOSTICS ALERTS");
         isElementPresent("//*[text()='KIA CONNECT MESSAGES']");
         verifyTextByXpath("//*[text()='KIA CONNECT MESSAGES']", "KIA CONNECT MESSAGES");
         isElementPresent("//*[text()='REMOTE ALERTS']");
         verifyTextByXpath("//*[text()='REMOTE ALERTS']", "REMOTE ALERTS");
         isElementPresent("//*[text()='MY CAR ZONE ALERTS']");
         verifyTextByXpath("//*[text()='MY CAR ZONE ALERTS']", "MY CAR ZONE ALERTS");
         return this;
     }
     
     public P0_Settings clickKiaConnectNotificationTab() {
    	 waitUntilElementVisisble("//*[text()='First Name ']");
         reportStep("Clicking Kia Connect Notification Tab", "INFO");
         clickByXpathJavascriptExecutor("//a[@class='notification-tab']");
         return this;
     }
     public P0_Settings updateStateValue(String state) {
 		waitUntilElementVisisble("//*[text()='First Name ']");
 	
 		List<WebElement> findElements = driver.findElements(By.xpath("//li[@class='more-margin half wider mobile-full state']//option"));
 		for (WebElement webElement : findElements) {
 			String text = webElement.getText();
			if (text.equalsIgnoreCase(state)) {
				webElement.click();
				break;
			}
		}
 		clickByXpathJavascriptExecutor("//div[@class='modal-settings']//*[@type='submit']");
		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']/p");
		verifyTextByXpath("//div[@class='alert alert-success alert-dismissible in']/p", "Changes saved. Changes may take up to 24 hours to be reflected in all systems.");
		waitUntilElementVisisble("//div[@class='alerts']//p[contains(text(),'Changes saved.')]/following-sibling::div/button");
 		return this;
 	}
	
     public P0_Settings clickBackButton() {
    	 clickByXpathJavascriptExecutor("//div[@class='settings-back-button']");
    	 waitUntilElementVisisble("//div[@id='my-vehicle-view']//h1");
    	 verifyTextContainsByXpath("//div[@id='my-vehicle-view']//h1", "My Vehicles");
    	 return this;
     }
}
