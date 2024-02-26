package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

//	public RemoteWebDriver driver;
	public WebDriver driver;
	public Wait<WebDriver> wait;

	protected static Properties prop;
	public String sUrl, primaryWindowHandle, sHubUrl, sHubPort,StageURL;

	// -------------------------------------------------Selenium
	// Grid---------------------------------------------------------------

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
			StageURL = prop.getProperty("STURL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// ----------------------------------------------------Load
	// Objects---------------------------------------------------------------

	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ----------------------------------------------------UnLoad
	// Objects---------------------------------------------------------------

	public void unloadObjects() {
		prop = null;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------

	public void invokeApp(String browser) {
		invokeApp(browser, false);

	}

	public void invokeApp(String browser,String stURL) {
		invokeApp(browser, false, StageURL);

	}

	public void invokeApp(String browser, boolean bRemote) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--disable-dev-shm-usage");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions ed = new EdgeOptions();
				ed.addArguments("--no-sandbox");
				ed.addArguments("--remote-allow-origins=*");
				ed.addArguments("--disable-dev-shm-usage");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(ed);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(sUrl);
			primaryWindowHandle = driver.getWindowHandle();
			reportStep("The browser:" + browser + " launched successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}
	public void invokeApp(String browser, boolean bRemote,String stURL) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions ch = new ChromeOptions();
				ch.addArguments("--no-sandbox");
				ch.addArguments("--remote-allow-origins=*");
				ch.addArguments("--disable-dev-shm-usage");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(ch);
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions ed = new EdgeOptions();
				ed.addArguments("--no-sandbox");
				ed.addArguments("--remote-allow-origins=*");
				ed.addArguments("--disable-dev-shm-usage");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(ed);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(stURL);
			primaryWindowHandle = driver.getWindowHandle();
			reportStep("The browser:" + browser + " launched successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}
	// This method will wait until element is visible

	public void waitUntilInvisibilityOfElementLocated(String xpath) {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public void waitUntilElementVisisble(String xpath) {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(120))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public void waitVisibilityOfElementLocatedByXpath(String xpath) {
		try {

			new WebDriverWait(driver, Duration.ofSeconds(120))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public void waitVisibilityOfElementLocatedByName(String name) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(120))
					.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public void waitVisibilityOfElementLocatedByID(String id) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(120))
					.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public void waitelementToBeClickableByXpath(String xpath) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(120))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public String readableReport(String methodName) {

		String space = "";
		String firstletter = String.valueOf(methodName.charAt(0));
		for (int i = 0; i < methodName.length(); i++) {
			char alphabet = methodName.charAt(i);
			if (alphabet >= 'A' && alphabet <= 'Z') {
				space = space + " " + alphabet;
			} else {
				space = space + alphabet;
			}
		}
		String h = space.replaceFirst(firstletter, firstletter.toUpperCase());
		return h;
	}

	// Fluent Wait
	public void waitElementToBeClickableXpathFW() {
		try {
			 wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}

	public void waitUntilElementDisappears(String xpath) {

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.invisibilityOf(element));
			reportStep("Waiting till the element disappears", "PASS");

		} catch (Exception e) {
			reportStep("Failed to wait until element disappears due to exception ", "FAIL");
		}

	}

	// ------------------------------------------------------Enter-------------------------------------

	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);

			reportStep("The data were entered successfully into the field :", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data could not be entered into the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering the data into the field :", "FAIL");
		}
	}

	// This method will enter the value to the text field using name attribute to
	// locate

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			reportStep("The data were entered successfully into the field :", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data could not be entered into the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering the data into the field :", "FAIL");
		}

	}

	// This method will enter the value to the text field and press enter
	// locate

	public void enterByXpathAndClickEnter(String xpathValue, String data) {
		try {
			System.out.println("a");
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			driver.findElement(By.xpath(xpathValue)).sendKeys(Keys.ENTER);
			reportStep("The data were entered successfully into the field :", "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data could not be entered into the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering the data into the field :", "FAIL");
		}

	}

	// This method will enter the value to the text field using name attribute to
	// locate

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			reportStep("The data were entered successfully into the field :", "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data could not be entered into the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering the data into the field :", "FAIL");
		}

	}

	// --------------------------------------------This method will verify the page
	// title of the browser---------------------------------------------

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(title)) {
				reportStep("The title of the page matches with the expected value :", "PASS");
				bReturn = true;
			} else
				System.out.println();
			reportStep("The title of the page did not match the expected value :", "SUCCESS");

		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	// This method will verify the given text matches in the element text

	public void verifyTextByXpath(String xpath, String text) {
		try {
			String sText = driver.findElement(By.xpath(xpath)).getText();
			reportStep("Successfully got the text :" + sText, "PASS");
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text matched with the expected value :"+sText, "PASS");
			} else {
				reportStep("The text did not matched with the expected value :"+sText, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	// This method will verify the given text is available in the element text

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String sText = driver.findElement(By.xpath(xpath)).getText();
			if (sText.contains(text)) {
				reportStep("The text matched with the expected value :", "PASS");
			} else {
				reportStep("The text did not matched with the expected value :"+sText, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	// This method will verify the given text is available in the element text

		public void verifyText(String actText, String expText) {
			try {
				if (actText.contains(expText)) {
					reportStep("The text matched with the expected value :", "PASS");
				} else {
					reportStep("The text did not matched with the expected value :", "FAIL");
				}
			} catch (Exception e) {
				reportStep("Unknown exception occured while verifying the title", "FAIL");
			}
		}

	// This method will verify the given text is available in the element text

	public void verifyTextById(String id, String text) {
		try {
			String sText = driver.findElement(By.id(id)).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text matched with the expected value :", "PASS");
			} else {
				reportStep("The text did not matched with the expected value :", "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	// This method will verify the given text is available in the element text

	public void verifyTextContainsById(String id, String text) {
		try {
			String sText = driver.findElement(By.id(id)).getText();
			if (sText.contains(text)) {
				reportStep("The text matched with the expected value :", "PASS");
			} else {
				reportStep("The text did not matched with the expected value :", "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	// This method will close all the browsers

	public void closeAllBrowsers() {
		try {
			// closeBrowser();
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "WARN");
		}

	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "WARN");
		}
	}

	// This method will click the element using id as locator

	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
			reportStep("The element with the id attribute has been clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element identified by the ID attribute could not be clicked.", "FAIL");
		}
	}

	// This method will click the element using id as locator

	public void clickByClassName(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with the class Name attribute has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element identified by the class Name attribute could not be clicked.", "FAIL");
		}
	}

	// This method will click the element using name as locator

	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			reportStep("The element with the name attribute has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element identified by the name attribute could not be clicked.", "FAIL");
		}
	}

	// This method will click the element using link name as locator

	public void clickByLink(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with the linkText has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element identified by the linkText could not be clicked.", "FAIL");
		}
	}

	// This method will click the element using xpath as locator

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();

			reportStep("The element with the xpath has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with the xpath could not be clicked.", "FAIL");
		}
	}

	// This method will click the element using xpath as locator

	public void clickByXpathAndAcceptAlert(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			acceptAlert();

			reportStep("The element with the xpath has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with the xpath could not be clicked.", "FAIL");
		}
	}

	public void clickByXpathWithCondition(String status, String xpathVal) {

		try {

			if (status.equalsIgnoreCase("REQUESTED")) {
				driver.findElement(By.xpath(xpathVal)).click();
			}

			reportStep("The element with the xpath has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with the xpath could not be clicked.", "FAIL");
		}
	}

	// -------------------------------------Java script
	// Executor---------------------------------------------------------------------------

	public void clickByXpathJavascriptExecutor(String xpathVal) {

		try {
			JavascriptExecutor ex = (JavascriptExecutor) driver;
			ex.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathVal)));

			reportStep("The element with the JS-Xpath attribute has been clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with the JS-Xpath attribute could not be clicked.", "FAIL");
		}
	}

	public void enterByXpathJavascriptExecutor(String xpathVal, String searchKeyword) {

		try {
			JavascriptExecutor ex = (JavascriptExecutor) driver;
			ex.executeScript("arguments[0].value=searchKeyword;", driver.findElement(By.xpath(xpathVal)));

			reportStep("The data were entered successfully into the field.", "PASS");
		} catch (Exception e) {
			reportStep("The data could not be entered into the field.", "FAIL");
		}
	}

	public void enterByXpathJavascriptExecutor(String xpathVal, int searchKeyword) {

		try {
			JavascriptExecutor ex = (JavascriptExecutor) driver;
			ex.executeScript("arguments[0].value=searchKeyword;", driver.findElement(By.xpath(xpathVal)));

			reportStep("The data were entered successfully into the field.", "PASS");
		} catch (Exception e) {
			reportStep("The data could not be entered into the field.", "FAIL");
		}
	}

	public void enterByXpathJSExecutor(String locatorValue, String values) {

		try {
			JavascriptExecutor ex = (JavascriptExecutor) driver;
			WebElement enterValues = driver.findElement(By.xpath(locatorValue));
			ex.executeScript("arguments[0].value=arguments[1];", enterValues, values);
			enterValues.sendKeys(Keys.ENTER);

		} catch (NoSuchElementException e) {
			reportStep("The data could not be entered into the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering the data into the field :", "FAIL");
		}
	}

	/*
	 * public void getTextByXpathJavascriptExecutor() {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver; String sText =
	 * js.executeScript("return document.documentElement.innerText;").toString();
	 * System.out.println(sText);
	 * 
	 * }
	 */

	// ----------------------------------------------------------------------------------------------------------------
	public void clickByXpathCheck(String xpathVal) {

		if (!driver.findElement(By.xpath(xpathVal)).isSelected()) {
			driver.findElement(By.xpath(xpathVal)).click();
		}

	}

	// ----------------------------------------------------------------------------------------------------------------

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with the link name has been clicked.", "PASS", false);
		} catch (Exception e) {
			reportStep("The element with the link name could not be clicked.", "FAIL");
		}

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElement(By.xpath(xpathVal)).click();

			reportStep("The element with the xpath has been clicked.", "PASS", false);
		} catch (Exception e) {
			reportStep("The element with the xpath could not be clicked.", "FAIL");
		}
	}

	// This method will mouse over on the element using xpath as locator

	public void mouseOverByXpath(String xpathVal) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouseover by the xpath has been performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by the xpath could not be performed.", "FAIL");
		}
	}

	// This method will mouse over on the element using link name as locator

	public void mouseOverByLinkText(String linkName) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by the link has been performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by the link could not be performed.", "FAIL");
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------

	// This method will return the text of the element using xpath as locator

	public String getTextByXpath(String xpathVal) {
		String bReturn = "";
		try {
			bReturn = driver.findElement(By.xpath(xpathVal)).getText();
			reportStep("Successfully got the text :" + bReturn, "PASS");
		} catch (Exception e) {
			reportStep("The element with the xpath could not be found and captured.", "FAIL");
		}
		return bReturn;
	}

	public String getTextByXpath1(String xpathVal) {
		String id = null;
		try {
			id = driver.findElement(By.xpath(xpathVal)).getText();
			// System.out.println(id);
		} catch (NoSuchElementException e) {
			System.err.println("The Element could not be found to get the text");
		} finally {
			takeSnap();
		}
		return id;
	}

	// This method will return the text of the element using id as locator

	public String getTextById(String idVal) {
		String bReturn = "";
		try {
			return driver.findElement(By.id(idVal)).getText();
		} catch (Exception e) {
			reportStep("The element with the id attribute could not be found.", "FAIL");
		}
		return bReturn;
	}

	// ----------------------------------------------------------------------Select
	// Method-----------------------------------------------------------------------

	// This method will select the drop down value using id as locator

	public void selectVisibileTextById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			;
			reportStep("The element with the id attribute has been selected with the value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The element with the id attribute could not be selected.", "FAIL");
		}
	}

	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			;
			reportStep("The element with the xpath has been selected with the value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The element with the xpath could not be selected.", "FAIL");
		}
	}

	public void selectIndexById(String id, int value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByIndex(value);
			reportStep("The element with the id has been selected with the index value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The element with the id could not be selected.", "FAIL");
		}
	}

	// ------------------------------------------------------------- Window
	// ----------------------------------------------------------------

	// This method will switch to the parent Window

	public void switchToParentWindow() {
		try {

			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	// This method will move the control to the last window

	public void clearbyId(String Id) {
		try {
			driver.findElement(By.id(Id)).clear();
			System.out.println("The existing value has been cleared successfully");
		} catch (NoSuchElementException e) {
			System.err.println("Unable to find the element to clear the value");

		} finally {
			takeSnap();
		}

	}

	public void clearbyXpath(String xpathValue) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(Keys.TAB);
			System.out.println("The existing value has been cleared successfully");
		} catch (NoSuchElementException e) {
			System.err.println("Unable to find the element to clear the value");

		} finally {
			takeSnap();
		}

	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}

	// -------------------------------------------------------Alerts-------------------------------------------------------------

	// This method will accept the alert opened

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	// This method will return the text of the alert

	public String getAlertText() {
		String text = null;
		try {
			driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not get the text.", "FAIL");
		}
		return text;

	}

	public void enterValuesInAlert(String enterValues) {
		try {
			driver.switchTo().alert().sendKeys(enterValues);
			;
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be dismissed.", "FAIL");
		}
	}

	// This method will dismiss the alert opened

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be dismissed.", "FAIL");
		}

	}

	public void testData() {
		try {
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	// This method will take snapshot of the browser

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 9000000000L) + 100000000L;
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	// -------------------------------------------------------------------------------------------------------------------
	public void pageRefresh() {
		
		driver.navigate().refresh();
	}

	// -------------------------------------------Dashboard----------------------------------------------------------------

	public void pickTheCar(String xpathValue, String textValue, String xpathValues) {

		List<WebElement> vehiclesList = driver.findElements(By.xpath(xpathValue));

		for (WebElement listOfVehicles : vehiclesList) {
			String totalVehicles = listOfVehicles.getText().trim();
			// System.out.println("Vehicles available in this account = " + totalVehicles);

			if (totalVehicles.equalsIgnoreCase(textValue)) {
				clickByXpathJavascriptExecutor(xpathValues);
//				driver.findElement(By.xpath(xpathValues)).click();
				break;
			}
		}
	}

	public void pickThePrimaryDriverAccount(String xpathValue, String textValue, String xpathValues) {

		List<WebElement> vehiclesList = driver.findElements(By.xpath(xpathValue));

		for (WebElement listOfVehicles : vehiclesList) {
			String totalVehicles = listOfVehicles.getText().trim();
			// System.out.println("Vehicles available in this account = " + totalVehicles);

			if (totalVehicles.equalsIgnoreCase(textValue)) {
				driver.findElement(By.xpath(xpathValues)).click();
				break;
			}
		}
	}

	public void clickOnLeftMenu(String textValue) {

		List<WebElement> vehiclesList = driver.findElements(By.xpath("//ul[@class='nav-app-menu']//a"));

		for (WebElement listOfVehicles : vehiclesList) {
			String totalVehicles = listOfVehicles.getText().trim();
			// System.out.println("Vehicles available in this account = " + totalVehicles);

			if (totalVehicles.equalsIgnoreCase(textValue)) {
				driver.findElement(By.xpath("//*[text()='" + textValue + "']")).click();
//				acceptAlert();
				break;
			}
		}
	}

	// -----------------------------------------------
	
	public void HandlingToastMessage(String xpathValue, String xpathClose, String remoteUnlockStatus, String remoteLockStatus, String remoteFailedStatus, String remotePrecondition, String nullValue) {
		
		//List<WebElement> toastMessage = driver.findElements(By.xpath(xpathValue)); 
		
		String toastMessage = driver.findElement(By.xpath(xpathValue)).getText();
		/*for (WebElement notificationMessage : toastMessage) {
			String remoteActionStatus = notificationMessage.getText().trim();*/
			
			if(toastMessage.equalsIgnoreCase(remoteUnlockStatus)) {
				System.out.println("Remote Actions Alert Message is = "+ toastMessage +" - Success");
				driver.findElement(By.xpath(xpathClose)).click();  
				
			} else if(toastMessage.equalsIgnoreCase(remoteLockStatus)) {
				System.out.println("Remote Actions Alert Message is = "+ toastMessage +" - Success");	
				driver.findElement(By.xpath(xpathClose)).click();	
			
			} else if(toastMessage.equalsIgnoreCase(remoteFailedStatus)) {
				System.out.println("Remote Actions Alert Message is = "+ toastMessage +" - Failed");	
				driver.findElement(By.xpath(xpathClose)).click();	
				
			} else if(toastMessage.equalsIgnoreCase(remotePrecondition)) {
				System.out.println("Remote Actions Alert Message is = "+ toastMessage +" - Doors should be locked properly or Another request is in-progress");	
				driver.findElement(By.xpath(xpathClose)).click();
			
			} else if(toastMessage.equalsIgnoreCase(nullValue)) {
				System.out.println("Remote Actions Alert Message is = "+ toastMessage +" - Blank Notification is displayed");	
				driver.findElement(By.xpath(xpathClose)).click();
			}		
}
	
	
	//-------------------------------------------------

	public void doubleClick(String xpathValue) {
		try {
			/*
			 * WebElement fromLocation = driver.findElement(By.xpath(fromLocator));
			 * WebElement toLocation = driver.findElement(By.xpath(toLocator));
			 */
			Actions actionClass = new Actions(driver);
			// actionClass.dragAndDrop(fromLocation, toLocation);
			WebElement elementDoubleClick = driver.findElement(By.xpath(xpathValue));
			actionClass.doubleClick(elementDoubleClick).build().perform();

			reportStep("The data were entered successfully into the field :", "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data could not be entered into the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering the data into the field :", "FAIL");
		}
	}

	// -----------------------------------------------

	// CSS Selector:

	public void clickByCSSTagClass(String cssTagName) {
		try {
			driver.findElement(By.cssSelector(cssTagName)).click();
			reportStep("The element with the id attribute has been clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element identified by the ID attribute could not be clicked.", "FAIL");
		}
	}

	public void clicknEnterByCSSTagClass(String cssTagName, String tripTags) {
		try {
			WebElement enterInput = driver.findElement(By.cssSelector(cssTagName));
			enterInput.sendKeys(tripTags);
			enterInput.sendKeys(Keys.ENTER);
			reportStep("The element with the id attribute has been clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element identified by the ID attribute could not be clicked.", "FAIL");
		}
	}

	public void enterByCSSselector(String cssTagName, String tripTags) {
		try {
			WebElement enterInput = driver.findElement(By.cssSelector(cssTagName));
			enterInput.sendKeys(tripTags);
			enterInput.sendKeys(Keys.ENTER);
			reportStep("The element with the id attribute has been clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element identified by the ID attribute could not be clicked.", "FAIL");
		}
	}

	// -----------------------------------------------

	// Scroll Down - java script executor:

	public void scrollDownJavaScriptExecutor(String xpathVal) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathVal));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			reportStep("The element identified by the ID attribute could not be clicked.", "FAIL");
		}
	}

	
	public void scrollToWebElement(String xpathVal) {
		WebElement element = driver.findElement(By.xpath(xpathVal));
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";

		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
	}

	
	public boolean isElementPresent(String xpathVal) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathVal));
			if (element.isDisplayed()) {
				reportStep("The element is displayed :", "PASS");
			} else {
				reportStep("The element is not displayed :", "FAIL");
			}
		} catch (Exception e) {
			reportStep("The element with the xpath is not present.", "FAIL");
		}
		return true;
	}
	
	

	public boolean isElementNotPresent(String xpathVal) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathVal));
			if (element.isDisplayed()) {
				reportStep("The element is displayed :", "FAIL");
			} else {
				reportStep("The element is not displayed :", "PASS");
			}
		} catch (Exception e) {
			reportStep("The element with the xpath is not present.", "FAIL");
		}
		return true;
	}

	
	
	public String getSuccessMsgByXpath(String xpathVal) {
		String msg = null;
		try {
			msg = driver.findElement(By.xpath(xpathVal)).getText();
			reportStep("Successfully got the success message : " + msg, "PASS");
		} catch (NoSuchElementException e) {
			System.err.println("The Element could not be found to get the text");
		} finally {
			takeSnap();
		}
		return msg;
	}


	public void scrollToElement(String xpath) {
		if (isElementPresent(xpath)) {
			WebElement element = driver.findElement(By.xpath(xpath));
			Actions scrollToElement = new Actions(driver);
			scrollToElement.moveToElement(element, 0, 0).build().perform();
			// scrollToElement.moveToElement(element).build().perform();
		}
	}

	
	public boolean isElementVisibility(String xpathVal) {
		boolean flag = driver.findElements(By.xpath(xpathVal)).size() > 0;
		return flag;
	}

	public void waitTime(int scnds) {

		try {
			int time = scnds + 000;
			Thread.sleep(time);
			reportStep("The element has been found.", "PASS");
		} catch (Exception e) {
			reportStep("The element was not found.", "FAIL");
		}
	}
	
	
	
	
	public void verifyUrl(String xpath) {
		try {
		String url=driver.getCurrentUrl();
	     if (url.equalsIgnoreCase(xpath)) {
			reportStep("As expected, click and redirect to the particular pdf", "Pass");
		}else {
			reportStep("Failed to click", "Fail");
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	}
	
//	public static boolean isClickable(WebElement webe)      
//	{
//	    try
//	    {
//	    	new WebDriverWait(driver, Duration.ofSeconds(25))
//			.until(ExpectedConditions.elementToBeClickable(webe));
//	        return true;
//	    }
//	    catch (Exception e)
//	    {
//	        return false;
//	    }
//	}
	
	
	public void chooseTheDealer(String xpathValue, String textValue, String xpathValues) {
		
		List<WebElement> dealersListList = driver.findElements(By.xpath(xpathValue)); 
		
		for (WebElement totalNoOfDealers : dealersListList) {
			String totalVehicles = totalNoOfDealers.getText().trim();
			//System.out.println("Vehicles available in this account = " + totalVehicles);
			
			if(totalVehicles.equalsIgnoreCase(textValue)){
				driver.findElement(By.xpath(xpathValues)).click();  
				break;
			} 
		}		
	}

}
