package testcases;


import org.testng.annotations.Test;

import pages.P12_KIAConnectSubscription;
import pages.P2_Login;
import wrappers.KMABase;

public class TC014_KIAConnectSubscriptionStaging extends KMABase {
	
	
	//TC-108
	@Test(priority=1, dataProvider="fetchData")
	public void verifyUpgradeMonthlySubscriptionToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheEV6Car(vehicleModel)
		.clickOnKiaSubcriptions(subcriptionOption);
		
		new P12_KIAConnectSubscription(driver, test)
	
		.verifyUpgradeMonthlySubscriptionToPlusPackage(PlusMonthly);
	}
	
	//Tc-109
	@Test(priority=2, dataProvider="fetchData")
	public void verifyDowngradeMonthlySubscriptionToCarePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheEV6Car(vehicleModel)
		.clickOnKiaSubcriptions(subcriptionOption);
		
		new P12_KIAConnectSubscription(driver, test)
	
		.verifyDowngradeMonthlySubscriptionToCarePackage(careMonthly);
	}
	
	//Tc-110
		@Test(priority=3, dataProvider="fetchData")
		public void verifyUpgradeAnnualSubscriptionToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {
			
			new P2_Login(driver, test)

			.clickSignIn().enterLoginEmailId(emailId)
			.enterLoginPassword(pwdLogin)
			.clkSignIn()
		    .pickTheEV6Car(vehicleModel)
		    .clickOnKiaSubcriptions(subcriptionOption);

			new P12_KIAConnectSubscription(driver, test)

		    .verifyUpgradeAnnualSubscriptionToPlusPackage(annualPlus);
		}
//		TC-111
		@Test(priority=4, dataProvider="fetchData")
        public void verifyDowngradeAnnualSubscriptionToCarePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

			new P2_Login(driver, test)
					.clickSignIn()
					.enterLoginEmailId(emailId)
					.enterLoginPassword(pwdLogin)
					.clkSignIn()
					.pickTheEV6Car(vehicleModel)
					.clickOnKiaSubcriptions(subcriptionOption);

			new P12_KIAConnectSubscription(driver, test)
					.verifyDowngradeAnnualSubscriptionToCarePackage(annualCare);

        }
	
		//TC-112
		@Test(priority=5, dataProvider="fetchData")
        public void cancelThePackageForMonthlySubcription(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {
            new P2_Login(driver, test)

            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)

            .verifyUpgradeMonthlySubscriptionToPlusPackage(PlusMonthly)
            .clickAndVerifyAccountOverview()
            .cancelThePackageForMonthlySubcription(litePack);

        }
		
        //TC-113

        @Test(priority=6, dataProvider="fetchData")

        public void verifyUpgradeMonthlySubscriptionLiteToCarePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)

            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlySubscriptionLiteToCarePackage(careMonthly,litePack);

        }

        //TC-114

        @Test(priority=7, dataProvider="fetchData")
        public void verifyUpgradeMonthlySubscriptionCareToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlySubscriptionCareToPlusPackage(PlusMonthly);

        }

        //TC-115

        @Test(priority=8, dataProvider="fetchData")
        public void verifyUpgradeMonthlySubscriptionPlusToUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlySubscriptionPlusToUltimatePackage(ultimateMonthly);

        }
        //Tc-116
        @Test(priority=9, dataProvider="fetchData")
        public void verifyUpgradeMonthlySubscriptionUltimateToCareAnnualPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlySubscriptionUltimateToCareAnnualPackage(annualCare);

        }
        //TC-117
        @Test(priority=10, dataProvider="fetchData")
        public void verifyUpgradeAnnualSubscriptionCareToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeAnnualSubscriptionCareToPlusPackage(annualPlus);

        }
        //TC-118
        @Test(priority=11, dataProvider="fetchData")
        public void verifyUpgradeAnnualSubscriptionPlusToUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeAnnualSubscriptionPlusToUltimatePackage(annualUltimate);

        }
        //TC-119
        @Test(priority=12, dataProvider="fetchData")
        public void cancelThePackageForAnnualSubcription(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .cancelThePackageForAnnualSubcription(litePack);

        }
        //TC-120
        @Test(priority=13, dataProvider="fetchData")
        public void verifyUpgradeMonthlySubscriptionLiteToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlySubscriptionLiteToPlusPackage(PlusMonthly);

        }
        
        //TC-121
        @Test(priority=14, dataProvider="fetchData")
        public void verifyUpgradeMonthlySubscriptionLiteToUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlySubscriptionLiteToUltimatePackage(ultimateMonthly,litePack);

        }
        //TC-122
        @Test(priority=15, dataProvider="fetchData")
        public void verifyUpgradeAnnualSubscriptionLiteToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeAnnualSubscriptionLiteToPlusPackage(annualPlus,litePack);

        }
        //TC-123
        @Test(priority=16, dataProvider="fetchData")
        public void verifyUpgradeAnnualSubscriptionLiteToUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeAnnualSubscriptionLiteToUltimatePackage(annualUltimate,litePack);

        }
        //TC-124
        @Test(priority=17, dataProvider="fetchData")
        public void verifyDowngradeAnnualSubscriptionUltimateToMonthlyPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowngradeAnnualSubscriptionUltimateToMonthlyPlusPackage(PlusMonthly);

        }
        //TC-125
        @Test(priority=18, dataProvider="fetchData")
        public void verifyDowngradeMonthlySubscriptionPlusToCarePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowngradeMonthlySubscriptionPlusToCarePackage(careMonthly);

        }
        //TC-126
        @Test(priority=19, dataProvider="fetchData")
        public void verifyUpgradeMonthlyCareToAnnualUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyUpgradeMonthlyCareToAnnualUltimatePackage(annualUltimate);

        }
        //Tc-127
        @Test(priority=20, dataProvider="fetchData")
        public void verifyDowndgradeAnnualUltimateToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowndgradeAnnualUltimateToPlusPackage(annualPlus);

        }
        //TC-128
        @Test(priority=21, dataProvider="fetchData")
        public void verifyDowndgradeAnnualPlusToCarePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowndgradeAnnualPlusToCarePackage(annualCare);

        }
      //TC-129
        @Test(priority=22, dataProvider="fetchData")
        public void verifyDowndgradeAnnualCareToMonthlyUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowndgradeAnnualCareToMonthlyUltimatePackage(ultimateMonthly);

        }
      //TC-130
        @Test(priority=23, dataProvider="fetchData")
        public void verifyDowndgradeMonthlySubscriptionUltimateToPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowndgradeMonthlySubscriptionUltimateToPlusPackage(PlusMonthly);

        }
        //TC-131
        @Test(priority=24, dataProvider="fetchData")
        public void verifyDowndgradeMonthlySubscriptionPlusToCarePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyDowndgradeMonthlySubscriptionPlusToCarePackage(careMonthly);

        }
        //TC-132
        @Test(priority=25, dataProvider="fetchData")
        public void cancelTheMonthlySubcriptionFromCareToLite(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .cancelTheMonthlySubcriptionFromCareToLite(litePack);

        }
      //TC-133
        @Test(priority=26, dataProvider="fetchData")
        public void cancelTheUltimateMonthlySubcription(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .cancelTheUltimateMonthlySubcription(ultimateMonthly,litePack);

        }
      //TC-134
        @Test(priority=27, dataProvider="fetchData")
        public void cancelTheAnnualPlusPackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .cancelTheAnnualPlusPackage(annualPlus,litePack);

        }
      //TC-135
        @Test(priority=28, dataProvider="fetchData")
        public void cancelTheAnnualUltimatePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .cancelTheAnnualUltimatePackage(annualUltimate,litePack);

        }
        //TC-136
        @Test(priority=29, dataProvider="fetchData")
        public void verifyAbleToSubscribePackage(String emailId, String pwdLogin, String vehicleModel,String subcriptionOption,String PlusMonthly,String careMonthly,String ultimateMonthly,String annualPlus,String annualCare,String annualUltimate,String litePack) throws InterruptedException {

            new P2_Login(driver, test)
            .clickSignIn()
            .enterLoginEmailId(emailId)
            .enterLoginPassword(pwdLogin)
            .clkSignIn()
            .pickTheEV6Car(vehicleModel)
            .clickOnKiaSubcriptions(subcriptionOption);

            new P12_KIAConnectSubscription(driver, test)
            .verifyAbleToSubscribePackage(annualUltimate);

        }
}
