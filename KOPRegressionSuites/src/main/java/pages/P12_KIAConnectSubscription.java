package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P12_KIAConnectSubscription extends KMABase {

	public P12_KIAConnectSubscription(WebDriver driver, ExtentTest test) throws InterruptedException {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Kia Connect Subscription")) {
			reportStep("This is not Kia Connect Subscription Page", "FAIL");
		}
	}

	public P12_KIAConnectSubscription UpgradePackageToUltimateAnnually() throws InterruptedException {
		waitUntilElementVisisble("//*[contains(text(),' Update Package')]");
		clickByXpath("//*[contains(text(),' Update Package')]");
		//// *[@class='form-check form-check-inline']/label
		clickByXpath("(//*[text()='Annual Subscription'])[2]");
		clickByXpath("(//*[text()='Select Package'])[4]");
		clickByXpath("//*[contains(text(),'PROCEED')]");
		waitUntilElementVisisble("//*[contains(text(),'Package Review')]");
		clickByXpath("//*[@id='custom-control-label']");
		clickByXpath("(//*[@class='custom-control-label'])[2]");
		clickByXpath("//*[contains(text(),'I Agree')]");
		waitUntilElementVisisble("//*[contains(text(),'Thank you for your order!')]");
		return new P12_KIAConnectSubscription(driver, test);
	}

	//-------------------------------
	public P12_KIAConnectSubscription clickAndVerifyGetKiaConnect() {

		waitUntilElementVisisble("//button[@name='Get Kia Connect']");
		clickByXpathJavascriptExecutor("//button[@name='Get Kia Connect']");
		waitUntilElementVisisble("//div[@id='subscriptionId']//h2");
		getSuccessMsgByXpath("//div[@id='subscriptionId']//h2");
		return this;
	}

	public P12_KIAConnectSubscription clickAndVerifyAccountOverview() {

		clickByXpathJavascriptExecutor("//a[@id='accountOverview']");
		waitUntilElementVisisble("//*[@class='acc_review']");
		reportStep("As expected,able to view account overview", "Pass");
		return this;
	}

	/**
	 * Description: method to verify monthly subscription
	 * 
	 */

	public P12_KIAConnectSubscription clickAndVerifyMonthlySubscription() {

		waitUntilElementVisisble("//button[@name='Get Kia Connect']");

		clickByXpathJavascriptExecutor("//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//div[@id='subscriptionId']//h2");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		if (driver.findElement(By.xpath("//h4[normalize-space()='CARE']//following::span[contains(text(),'monthly')]"))
				.isDisplayed()) {

			reportStep("As expected, monthly subcription is clickable and annual package change into monthly", "Pass");

		} else {

			reportStep("Monthly subscription is not clicked", "Fail");

		}

		return this;

	}

	/**
	 * 
	
	 * 
	 * Description: method to verify Annual subscription
	 * 
	 */

	public P12_KIAConnectSubscription clickAndVerifyAnnualSubscription() {

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		if (driver.findElement(By.xpath("//h4[normalize-space()='CARE']//following::span[contains(text(),'annually')]"))
				.isDisplayed()) {

			reportStep("As expected,Annual subcription is clickable and monthly package change into annually", "Pass");

		} else {

			reportStep("Annual subscription is not clicked", "Fail");

		}

		return this;

	}

	/**
	 * 
	
	 * 
	 * Description: method to upgrade monthly to plus package
	 * 
	 */

	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionToPlusPackage(String plusMonthly) {

		getTextByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[normalize-space()='Update Package']|//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(plusMonthly)) {
			reportStep("As expected,upgrade the care package to plus package for monthly subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}

	/** 
	 * Description: method to downgrade monthly to care package
	 */

	public P12_KIAConnectSubscription verifyDowngradeMonthlySubscriptionToCarePackage(String careMon) {

		getTextByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in care package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(careMon)) {
			reportStep("As expected,Downgrade the plus package to care package for monthly subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}

		return this;

	}

	/** 
	 * Description: method to upgrade annual subscription to plus package
	 * 
	 */

	public P12_KIAConnectSubscription verifyUpgradeAnnualSubscriptionToPlusPackage(String annualPlus) {

		getTextByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[normalize-space()='Update Package']|//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");

		waitUntilElementVisisble("//*[@id='packageDetails']");
		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualPlus)) {
			reportStep("As expected,Upgrade the care package to plus package for Annual subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}

		return this;

	}

	/**
	 * 
	
	 * 
	 * Description: method to downgrade annual subscription to care package
	 * 
	 */

	public P12_KIAConnectSubscription verifyDowngradeAnnualSubscriptionToCarePackage(String annualCare) {

		getTextByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[normalize-space()='Update Package']|//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Care package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		reportStep("Downgrade the package to plus package for Annual subscription", "info");


		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualCare)) {
			reportStep("As expected,Upgrade the care package to plus package for Annual subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}

		return this;

	}

	/**
	 Description: method to verify to cancel subscription
	 */
	public P12_KIAConnectSubscription cancelThePackageForMonthlySubcription(String litePack) {
		clickByXpath("//a[@class='dtmCancelSubscription']");
		clickByXpath("//*[@name='Cancel Subscription - YES']");
		waitUntilElementVisisble("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpath("//*[@name='Cancel Subscription - YES - Confirm']");
		waitUntilElementDisappears("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(litePack)) {
			reportStep("As expected,Sucessfully cancel the subricption to Lite package", "Pass");
		}else {
			reportStep("Fail to cancel the package", "fail");
		}

		return this;
	}

	/**
	
	 * Description: method to upgrade monthly Lite to Care package 
	 */

	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionLiteToCarePackage(String monthlyCare,String litePack) {

		if (isElementVisibility("//button[normalize-space()='Update Package']")) {

			clickAndVerifyAccountOverview();

			cancelThePackageForMonthlySubcription(litePack);

			waitUntilElementVisisble("//button[@name='Get Kia Connect']");

			clickByXpath("//button[@name='Get Kia Connect']");

			waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

			clickByXpath("//input[@id='switchbill_monthly']/following::label");

			clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

			reportStep("Select package is clicked in Care package", "pass");

			scrollToElement("//button[@class='dtmProceed']");

			clickByXpath("//button[@class='dtmProceed']");

			waitUntilElementVisisble("//*[@class='pack_detail']");

			scrollToElement("//label[contains(text(),'Cancel subscription')]");

			clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

			clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

			reportStep("Checkboxes for Terms and policy is selected ", "Pass");

			clickByXpath("//button[@name='I AGREE']");
			
			waitUntilElementVisisble("//*[@id='packageDetails']");

			scrollToElement("//*[@id='packageDetails']");

			clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

			waitUntilElementVisisble("//*[@class='current-package']//p");

			String text = getTextByXpath1("//*[@class='current-package']//p").trim();
			if (text.contains(monthlyCare)) {
				reportStep("As expected,Upgrade the Lite package to Care package for monthly subscription", "Pass");
			}else {
				reportStep("Fail to update the package", "fail");
			}


		} else {

			clickByXpath("//button[@name='Get Kia Connect']");

			waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

			clickByXpath("//input[@id='switchbill_monthly']/following::label");

			clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

			reportStep("Select package is clicked in Care package", "pass");

			scrollToElement("//button[@class='dtmProceed']");

			clickByXpath("//button[@class='dtmProceed']");

			waitUntilElementVisisble("//*[@class='pack_detail']");

			scrollToElement("//label[contains(text(),'Cancel subscription')]");

			clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

			clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

			reportStep("Checkboxes for Terms and policy is selected ", "Pass");

			clickByXpath("//button[@name='I AGREE']");
			
			waitUntilElementVisisble("//*[@id='packageDetails']");

			scrollToElement("//*[@id='packageDetails']");

			clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

			waitUntilElementVisisble("//*[@class='current-package']//p");

			String text = getTextByXpath1("//*[@class='current-package']//p").trim();
			if (text.contains(monthlyCare)) {
				reportStep("As expected,Upgrade the Lite package to Care package for monthly subscription", "Pass");
			}else {
				reportStep("Fail to update the package", "fail");
			}
		}

		return this;

	}

	/**
	
	 * Description: method to upgrade monthly care to Plus package
	 */

	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionCareToPlusPackage(String plusMonthly) {

		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");

		waitUntilElementVisisble("//*[@id='packageDetails']");
		
		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		waitUntilElementVisisble("//*[@class='current-package']//p");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(plusMonthly)) {
			reportStep("As expected,Upgrade care package to plus package for monthly subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;
	}

	/**
	
	 * Description: method to upgrade monthly plus to ultimate package 
	 */
	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionPlusToUltimatePackage(String ultimateMonthly) {

		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");

		waitUntilElementVisisble("//*[@id='packageDetails']");
		
		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
        waitUntilElementVisisble("//*[@class='current-package']//p");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(ultimateMonthly)) {
			reportStep("As expected,Upgrade Plus package to ultimate package for monthly subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}
	/**
	
	 * Description: method to upgrade monthly ultimate to care annual package 
	 */
	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionUltimateToCareAnnualPackage(String annualCare) {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");
		reportStep("As expected Annual subscription is selected", "Pass");

		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in care package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");


		waitUntilElementVisisble("//*[@class='current-package']//p");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualCare)) {
			reportStep("As expected,Upgrade the monthly ultimate package to annual care subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	/**
	
	 * Description: method to upgrade monthly ultimate to care annual package 
	 */
//	public P12_KIAConnectSubscription verifyUpgradeSubscriptionUltimateToCareMonthlyPackage() {
//		
//		getSuccessMsgByXpath("//*[@class='current-package']//p");
//
//		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");
//
//		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");
//
//		clickByXpath("//input[@id='switchbill_annual']/following::label");
//		reportStep("As expected Annual subscription is selected", "Pass");
//
//		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");
//
//		reportStep("Select package is clicked in care package", "pass");
//
//		scrollToElement("//button[@class='dtmProceed']");
//
//		clickByXpath("//button[@class='dtmProceed']");
//
//		waitUntilElementVisisble("//*[@class='pack_detail']");
//
//		scrollToElement("//label[contains(text(),'Cancel subscription')]");
//
//		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");
//
//		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");
//
//		reportStep("Checkboxes for Terms and policy is selected ", "Pass");
//
//		clickByXpath("//button[@name='I AGREE']");
//		
//		waitUntilElementVisisble("//*[@id='packageDetails']");
//
//		scrollToElement("//*[@id='packageDetails']");
//
//		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
//
//		reportStep("Upgrade Plus package from monthly ultimate package to annual care subscription", "info");
//
//		waitUntilElementVisisble("//*[@class='current-package']//p");
//
//		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
//		if (text.contains(annualCare)) {
//			reportStep("As expected,Upgrade the care package to plus package for Annual subscription", "Pass");
//		}else {
//			reportStep("Fail to update the package", "fail");
//		}
//
//
//		return this;
//
//	}
	
	/**
	
	 * Description: method to upgrade Annual care to Plus package
	 */

	public P12_KIAConnectSubscription verifyUpgradeAnnualSubscriptionCareToPlusPackage(String annualPlus) {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");
		
		reportStep("As expected Annual subscription is selected", "Pass");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		waitUntilElementVisisble("//*[@class='current-package']//p");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualPlus)) {
			reportStep("As expected,Upgrade care package to plus package for Annual subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}

	/**
	
	 * Description: method to upgrade Annual plus to ultimate package 
	 */
	public P12_KIAConnectSubscription verifyUpgradeAnnualSubscriptionPlusToUltimatePackage(String annualUltimate) {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");
		
		reportStep("As expected Annual subscription is selected", "Pass");
		
		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		waitUntilElementVisisble("//*[@class='current-package']//p");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualUltimate)) {
			reportStep("As expected,Upgrade Plus package to ultimate package for Annual subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	
	/**
	 Description: method to verify to cancel Annual subscription
	 */
	public P12_KIAConnectSubscription cancelThePackageForAnnualSubcription(String litePack) {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");
		clickAndVerifyAccountOverview();		
		clickByXpath("//a[@class='dtmCancelSubscription']");
		clickByXpath("//*[@name='Cancel Subscription - YES']");
		waitUntilElementVisisble("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpath("//*[@name='Cancel Subscription - YES - Confirm']");
//		waitUntilElementDisappears("//*[@name='Cancel Subscription - YES - Confirm']");
		waitUntilElementVisisble("//button[@class='footbutton btn btn-danger']");
		clickByXpath("//button[@class='footbutton btn btn-danger']");
		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(litePack)) {
			reportStep("As expected,Sucessfully cancel the subricption to Lite package", "Pass");
		}else {
			reportStep("Fail to cancel the package", "fail");
		}

		return this;

	}
	
	/**
	 
	 * Description: method to upgrade monthly lite to ultimate package
	 * @throws InterruptedException 
	 */

	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionLiteToUltimatePackage(String ultimateMonthly,String litePack) throws InterruptedException {

		cancelThePackageForAnnualSubcription(litePack);
		waitUntilElementVisisble("//button[@name='Get Kia Connect']");
		pageRefresh();
		waitUntilElementVisisble("//button[@name='Get Kia Connect']");

		clickByXpathJavascriptExecutor("//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(ultimateMonthly)) {
			reportStep("As expected,Upgrade the Lite package to Ultimate package for monthly subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}

	/**
	 
	 * Description: method to upgrade monthly lite to plus package
	 */

	public P12_KIAConnectSubscription verifyUpgradeMonthlySubscriptionLiteToPlusPackage(String plusMonthly) {

		getSuccessMsgByXpath("//*[@class='current-package']//p");

		clickByXpath("//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in PLus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(plusMonthly)) {
			reportStep("As expected,Upgrade the Lite package to Plus package for monthly subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}
	
	/**
	 
	 * Description: method to upgrade annually lite to plus package
	 */

	public P12_KIAConnectSubscription verifyUpgradeAnnualSubscriptionLiteToPlusPackage(String annualPlus,String litePack) throws InterruptedException {

		cancelThePackageForAnnualSubcription(litePack);
		waitUntilElementVisisble("//button[@name='Get Kia Connect']");
		pageRefresh();
		waitUntilElementVisisble("//button[@name='Get Kia Connect']");

		clickByXpathJavascriptExecutor("//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualPlus)) {
			reportStep("As expected,Upgrade the Lite package to Plus package for annual subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}

	/**
	 
	 * Description: method to upgrade annually lite to Ultimate package
	 */

	public P12_KIAConnectSubscription verifyUpgradeAnnualSubscriptionLiteToUltimatePackage(String annualUltimate,String litePack) throws InterruptedException {

		cancelThePackageForAnnualSubcription(litePack);
		waitUntilElementVisisble("//button[@name='Get Kia Connect']");
		pageRefresh();
		waitUntilElementVisisble("//button[@name='Get Kia Connect']");

		clickByXpathJavascriptExecutor("//button[@name='Get Kia Connect']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualUltimate)) {
			reportStep("As expected,Upgrade the Lite package to Ultimate package for annual subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;
	}
	/**
	 
	 * Description: method to downgrade annually ultimate to monthly plus package
	 */

	public P12_KIAConnectSubscription verifyDowngradeAnnualSubscriptionUltimateToMonthlyPlusPackage(String plusMonthly) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(plusMonthly)) {
			reportStep("As expected,Upgrade the Annual ultimate package to monthly Plus subscription", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}
	/**
	 
	 * Description: method to downgrade monthly subscription Plus to Care package
	 */

	public P12_KIAConnectSubscription verifyDowngradeMonthlySubscriptionPlusToCarePackage(String careMonthly) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in care package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(careMonthly)) {
			reportStep("As expected,Upgrade the monthly subscription plus to care package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	/**
	 
	 * Description: method to upgrade monthly care package to annual package
	 */

	public P12_KIAConnectSubscription verifyUpgradeMonthlyCareToAnnualUltimatePackage(String annualUltimate) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualUltimate)) {
			reportStep("As expected,Upgrade the monthly subscription care to annual ultimate package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	
	/**
	 
	 * Description: method to downgrade annual ultimate to plus package
	 */

	public P12_KIAConnectSubscription verifyDowndgradeAnnualUltimateToPlusPackage(String annualPlus) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in Plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualPlus)) {
			reportStep("As expected,Downgrade the annual subscription ultimate to plus package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	
	/**
	 
	 * Description: method to downgrade annual plus to care package
	 */

	public P12_KIAConnectSubscription verifyDowndgradeAnnualPlusToCarePackage(String annualCare ) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in care package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(annualCare)) {
			reportStep("As expected,Downgrade the annual subscription plus to care package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	/**
	 
	 * Description: method to downgrade annual care to monthly ultimate package
	 */

	public P12_KIAConnectSubscription verifyDowndgradeAnnualCareToMonthlyUltimatePackage(String ultimateMonthly) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(ultimateMonthly)) {
			reportStep("As expected,Downgrade the annual subscription care to monthly ultimate package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	/**
	 
	 * Description: method to downgrade monthly ultimate to Plus package
	 */

	public P12_KIAConnectSubscription verifyDowndgradeMonthlySubscriptionUltimateToPlusPackage(String plusMonthly) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='PLUS']//following::button[@title='Completed']");

		reportStep("Select package is clicked in plus package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(plusMonthly)) {
			reportStep("As expected,Downgrade the monthly subscription ultimate to plus package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}
		return this;

	}
	/**
	 
	 * Description: method to downgrade monthly Plus to care package
	 */

	public P12_KIAConnectSubscription verifyDowndgradeMonthlySubscriptionPlusToCarePackage(String careMonthly) throws InterruptedException {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");

		waitUntilElementVisisble("//button[normalize-space()='Update Package']");

		clickByXpathJavascriptExecutor("//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//h4[normalize-space()='CARE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in care package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");
		
		waitUntilElementVisisble("//*[@id='packageDetails']");

		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(careMonthly)) {
			reportStep("As expected,Downgrade the monthly subscription plus to care package", "Pass");
		}else {
			reportStep("Fail to update the package", "fail");
		}


		return this;

	}
	
	/**
	 Description: method to verify to cancel monthly subscription
	 */
	public P12_KIAConnectSubscription cancelTheMonthlySubcriptionFromCareToLite(String litePack) {
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");
		clickAndVerifyAccountOverview();		
		clickByXpath("//a[@class='dtmCancelSubscription']");
		clickByXpath("//*[@name='Cancel Subscription - YES']");
		waitUntilElementVisisble("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpath("//*[@name='Cancel Subscription - YES - Confirm']");
//		waitUntilElementDisappears("//*[@name='Cancel Subscription - YES - Confirm']");
		waitUntilElementVisisble("//button[@class='footbutton btn btn-danger']");
		clickByXpath("//button[@class='footbutton btn btn-danger']");
		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(litePack)) {
			reportStep("As expected,Sucessfully cancel the subricption to Lite package", "Pass");
		}else {
			reportStep("Fail to cancel the package", "fail");
		}


		return this;

	}
	
	/**
	 Description: method to cancel monthly subscription
	 * @throws InterruptedException 
	 */
	public P12_KIAConnectSubscription cancelTheUltimateMonthlySubcription(String ultimateMonthly,String litePack) throws InterruptedException {
		
		verifyUpgradeMonthlySubscriptionPlusToUltimatePackage(ultimateMonthly);
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");
		clickAndVerifyAccountOverview();		
		clickByXpath("//a[@class='dtmCancelSubscription']");
		clickByXpath("//*[@name='Cancel Subscription - YES']");
		waitUntilElementVisisble("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpath("//*[@name='Cancel Subscription - YES - Confirm']");
		waitUntilElementVisisble("//button[@class='footbutton btn btn-danger']");
		clickByXpath("//button[@class='footbutton btn btn-danger']");
		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(litePack)) {
			reportStep("As expected,Sucessfully cancel the subricption to Lite package", "Pass");
		}else {
			reportStep("Fail to cancel the package", "fail");
		}

		return this;

	}
	/**
	 Description: method to cancel annual plus subscription
	 * @throws InterruptedException 
	 */
	public P12_KIAConnectSubscription cancelTheAnnualPlusPackage(String annualPlus,String litePack) throws InterruptedException {
		
		verifyUpgradeAnnualSubscriptionToPlusPackage(annualPlus);
		
		getSuccessMsgByXpath("//*[@class='current-package']//p");
		clickAndVerifyAccountOverview();		
		clickByXpath("//a[@class='dtmCancelSubscription']");
		clickByXpath("//*[@name='Cancel Subscription - YES']");
		waitUntilElementVisisble("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpath("//*[@name='Cancel Subscription - YES - Confirm']");
		waitUntilElementVisisble("//button[@class='footbutton btn btn-danger']");
		clickByXpath("//button[@class='footbutton btn btn-danger']");
		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(litePack)) {
			reportStep("As expected,Sucessfully cancel the subricption to Lite package", "Pass");
		}else {
			reportStep("Fail to cancel the package", "fail");
		}

		return this;

	}
	/**
	 Description: method to cancel annual ultimate subscription
	 * @throws InterruptedException 
	 */
	public P12_KIAConnectSubscription cancelTheAnnualUltimatePackage(String annualUltimate,String litePack) throws InterruptedException {
		
		verifyUpgradeAnnualSubscriptionPlusToUltimatePackage(annualUltimate);
		getSuccessMsgByXpath("//*[@class='current-package']//p");
		clickAndVerifyAccountOverview();		
		clickByXpath("//a[@class='dtmCancelSubscription']");
		clickByXpath("//*[@name='Cancel Subscription - YES']");
		waitUntilElementVisisble("//*[@name='Cancel Subscription - YES - Confirm']");
		clickByXpath("//*[@name='Cancel Subscription - YES - Confirm']");
		waitUntilElementVisisble("//button[@class='footbutton btn btn-danger']");
		clickByXpath("//button[@class='footbutton btn btn-danger']");
		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");
		String text = getTextByXpath1("//*[@class='current-package']//p").trim();
		if (text.contains(litePack)) {
			reportStep("As expected,Sucessfully cancel the subricption to Lite package", "Pass");
		}else {
			reportStep("Fail to cancel the package", "fail");
		}
		return this;

	}
	
	/**
	 * Description: method to upgrade monthly plus to ultimate package 
	 */
	public P12_KIAConnectSubscription verifyAbleToSubscribePackage(String annualUltimate) {

		clickByXpath("//button[@name='Get Kia Connect']|//button[normalize-space()='Update Package']");

		waitUntilElementVisisble("//input[@id='switchbill_monthly']/following::label");

		clickByXpath("//input[@id='switchbill_annual']/following::label");

		clickByXpath("//h4[normalize-space()='ULTIMATE']//following::button[@title='Completed']");

		reportStep("Select package is clicked in ultimate package", "pass");

		scrollToElement("//button[@class='dtmProceed']");

		clickByXpath("//button[@class='dtmProceed']");

		waitUntilElementVisisble("//*[@class='pack_detail']");

		scrollToElement("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'Cancel subscription')]");

		clickByXpathJavascriptExecutor("//label[contains(text(),'button below')]");

		reportStep("Checkboxes for Terms and policy is selected ", "Pass");

		clickByXpath("//button[@name='I AGREE']");

		waitUntilElementVisisble("//*[@id='packageDetails']");
		
		scrollToElement("//*[@id='packageDetails']");

		clickByXpathJavascriptExecutor("//*[@id='packageDetails']");

		reportStep("Upgrade  package to ultimate package for Annual subscription", "info");

		waitUntilElementVisisble("//*[@class='current-package']//p");
        verifyTextContainsByXpath("//*[@class='current-package']//p", annualUltimate);
		return this;
	}
	
	
}