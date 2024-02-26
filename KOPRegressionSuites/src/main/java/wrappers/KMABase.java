package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import org.testng.ITestContext;
import org.testng.ITestResult;

import utils.DataInputProvider;

public class KMABase extends GenericWrappers {
	
	public String browserName;
	public String dataSheetName;	
	public int count;	


	@BeforeSuite
	public void beforeSuite() {
		startResult();   
	}
	
	
	@Parameters({"browser","testCaseName", "testDescription", "category", "authors"})
	@BeforeTest
	public void beforeTest(String browserName, String testCaseName, String testDescription, String category, String author){
		loadObjects();  	
		startTest(testCaseName, testDescription);
		count=0;
		
	}
	
	
	@Parameters({"browser","testCaseName", "testDescription", "category", "authors","env"})
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestResult result,String browserName, String testCaseName, String testDescription, String category, String authors, String env) {
		count=count+1;
		testCaseName=result.getMethod().getMethodName();
		String name = readableReport(testCaseName);
		test = startTestCase(count+"."+name);
		test.assignCategory(category);
		test.assignAuthor(authors);
		if (env.equalsIgnoreCase("staging")) {
			invokeApp(browserName,"");	
		}else {
			invokeApp(browserName);
		}
		
	}
	@AfterTest
	public void afterTest() throws InterruptedException{
		endTest();
		unloadObjects();  
	}
	@AfterSuite
	public void afterSuite() {
		endResult();
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException{
		endTestcase(); 
		starttest.appendChild(test);
		closeAllBrowsers();
	
		}
	
	@DataProvider(name="fetchData")	
	public Object[][] getData(ITestContext context){
		String dataSheetName = context.getCurrentXmlTest().getParameter("dataSheetName");
		return DataInputProvider.getAllSheetData("./data/"+dataSheetName+".xlsx");		
	}	
	
}






