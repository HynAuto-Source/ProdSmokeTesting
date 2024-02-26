package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P14_ReferenceMaterial extends KMABase {
	
	public P14_ReferenceMaterial(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test= test; 
		
		if(!verifyTitle("Reference Material"))
			reportStep("This is not Reference material Page", "FAIL");
	}
	
	/**
      Description: method to verify reference material screen
     */
    public P14_ReferenceMaterial clickAndVerifyReferenceMaterialTab() {

        if (driver.findElement(By.xpath("//*[@class='RMDisclaimer']")).isDisplayed()) {
        	reportStep("As expected, navigate to Reference Material screen", "pass");
        } else {
            reportStep("Reference Material screen not present", "Fail");
        }
        return this;

    }
    /**
      Description: method to List and grid view
     */
    public P14_ReferenceMaterial verifyListAndGridView() throws InterruptedException {
 		
 		clickByXpath("//*[@class='switch-view-grid']");	
 		waitUntilElementVisisble("//*[@class='switch-view-grid active']");
 		if (driver.findElement(By.xpath("//*[@class='switch-view-grid active']")).isDisplayed()) {
 			reportStep("As expected, Documents is displayed in grid view ", "Pass");	
 		}else {
 			reportStep("As expected,grid view  not displayed", "fail");
 		}
 		clickByXpath("//*[@class='switch-view-list']");	
 		waitUntilElementVisisble("//*[@class='switch-view-list active']");
 		if (driver.findElement(By.xpath("//*[@class='switch-view-list active']")).isDisplayed()) {
 			reportStep("As expected, Documents is displayed in List view ", "Pass");	
 		}else {
 			reportStep("As expected,list view not displayed", "Fail");
 		}
 		return this;
 	}
	
    
	/**
      Description: method to verify manual documents through search
     */
    public P14_ReferenceMaterial searchManualDocuments(String vehicleName) {

        enterByName("manuals-text-filter", vehicleName);
        if (driver.findElement(By.xpath("//*[@title='2023 Telluride Features and Functions Guide']")).isDisplayed()) {
        	reportStep("As expected, Documents is displayed through search", "Pass");
        	
        } else {
        	reportStep("As expected, Documents is not displayed through search", "fail");
        }
        return this;
    }
	/**
      Description: method to verify manual documents through search
     */
    public P14_ReferenceMaterial searchInvalidVechileManualDocuments(String invalidCarName) {

        enterByName("manuals-text-filter", invalidCarName);
        if (driver.findElement(By.xpath("//*[@class='no-results-found show']")).isDisplayed()) {
        	getSuccessMsgByXpath("//*[@class='no-results-found show']");
        } else {
        	reportStep(" Documents is displayed through search", "fail");
        }
        return this;
    }
    /**
      Description: method to verify manual documents through search
     */
    public P14_ReferenceMaterial clickAndVerifyPdf(String url) {

        clickByXpath("//*[@class='file-thumb']");
        switchToLastWindow();
        verifyUrl(url);
        return this;
    }
    /**
      Description: method to List and grid view for video
     */
    public P14_ReferenceMaterial verifyListAndGridViewInVideos() throws InterruptedException {
 		
    	clickByXpath("//a[@class='videos']");
 		clickByXpath("//*[@class='switch-view-grid']");	
 		waitUntilElementVisisble("//*[@class='switch-view-grid active']");
 		if (driver.findElement(By.xpath("//*[@class='switch-view-grid active']")).isDisplayed()) {
 			reportStep("As expected, Videos is displayed in grid view ", "Pass");	
 		}else {
 			reportStep("As expected,grid view  not displayed", "fail");
 		}
 		clickByXpath("//*[@class='switch-view-list']");	
 		waitUntilElementVisisble("//*[@class='switch-view-list active']");
 		if (driver.findElement(By.xpath("//*[@class='switch-view-list active']")).isDisplayed()) {
 			reportStep("As expected, Videos is displayed in List view ", "Pass");	
 		}else {
 			reportStep("As expected,list view not displayed", "Fail");
 		}
 		return this;
 	}
    /**
      Description: method to verify video is opening 
     */
    public P14_ReferenceMaterial clickAndVerifyVideo(String url) {

    	clickByXpath("//a[@class='videos']");
        clickByXpath("//*[@class='video-thumb']");
        verifyUrl(url);
        return this;
    }
    
    /**
      Description: method to verify warranty page info
     */
    public P14_ReferenceMaterial clickAndVerifyWarrantyInfo() {

    	clickByXpath("//a[@class='warranty']");
    	waitUntilElementVisisble("//div[@class='warranty-onboarding']");
    	if (driver.findElement(By.xpath("//div[@class='warranty-onboarding']")).isDisplayed()) {
 			reportStep("As expected, redirected to warranty info page", "Pass");	
 		}else {
 			reportStep("Fail to redirected to respective page", "Fail");
 		}
        return this;
    }
    /**
      Description: method to Original owner is selected
     */
    public P14_ReferenceMaterial verifyOriginalOwnerIsSelected() {

    	clickByXpath("//a[@class='warranty']");
    	waitUntilElementVisisble("//div[@class='warranty-onboarding']");
    	if (driver.findElement(By.xpath("//input[@title='Original Owner']")).isSelected()) {
 			reportStep("As expected,Original owner is selected by default", "Pass");	
 		}else {
 			reportStep("Original owner is not selected", "Fail");
 		}
        return this;
    }
    /**
      Description: method to Original and subsequent owner
     */
    public P14_ReferenceMaterial verifyOriginalOwnerAndSubsquentOwner() {

    	clickByXpath("//a[@class='warranty']");
    	waitUntilElementVisisble("//div[@class='warranty-onboarding']");
    	reportStep("Original owner is selected", "info");
        clickByXpathJavascriptExecutor("//input[@value='Continue']");
        waitUntilElementVisisble("//div[@class='page-view-header']/h2");
        getTextByXpath("//div[@class='page-view-header']/h2");
        reportStep("Change to subsequent owner", "info");
	    clickByXpath("//div[@class='page-view-header']/h2/a");
	    waitUntilElementVisisble("//div[@class='page-view-header']/h2");
	    getTextByXpath("//div[@class='page-view-header']/h2");
        return this;
    }
    
    /**
      Description: method to verify kia connect
     */
    public P14_ReferenceMaterial clickAndVerifyKiaConnect() {

    	clickByXpath("//a[@class='uvo']");
    	waitUntilElementVisisble("//h2[normalize-space()='Kia connect FAQ']");
    	if (driver.findElement(By.xpath("//h2[normalize-space()='Kia connect FAQ']")).isDisplayed()) {
 			reportStep("As expected, able to click kia connect", "Pass");	
 		}else {
 			reportStep("kia connect is not clickable", "Fail");
 		}
        return this;
    }
    
    /**
      Description: method to verify Apps is select default
     */
    public P14_ReferenceMaterial verifyAppsIsSelected() {

    	if (driver.findElement(By.xpath("//strong[contains(text(),'Utilize your Android')]")).isDisplayed()) {
 			reportStep("As expected, Apps is selected by default", "Pass");	
 		}else {
 			reportStep("By default Apps is not selected", "Fail");
 		}
        return this;
    }
    /**
      Description: method to verify Kia connect option
     */
    public P14_ReferenceMaterial verifyoptionIsSelected(String option) {
    	
        waitUntilElementVisisble("//a[@title='"+option+"']");
    	clickByXpathJavascriptExecutor("//a[@title='"+option+"']");
    	if (driver.findElement(By.xpath("//a[@class='dtmRefMarterialUvo active'][@title='"+option+"']")).isDisplayed()) {
 			reportStep("As expected, "+option+" is clicked and relevant document is displayed", "Pass");	
 		}else {
 			reportStep(option+" is  not clicked", "Fail");
 		}
        return this;
    }
  
}
