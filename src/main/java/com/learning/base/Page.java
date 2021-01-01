package com.learning.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.learning.utilities.ExcelReader;
import com.learning.utilities.ExtentManager;
import com.learning.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * WebDriver, Properties, 
 * Logs - OR, Config, 
 * Waits - Implicit and Explicit
 * ExtentReports, DB, Excel, Mail, ReportNG,
 * Jenkins
 * 
 */

public class Page {

	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String reportingPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\";

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	// devpinoyLogger = Standard name
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static String browser;

	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\learning\\excel\\testdata.xlsx");

	public static WebDriverWait wait;

	// static - you won't get parallel execution
	protected static WebDriver driver;
	public static TopMenu menu;

	public Page() {

		if (driver == null) {

			loadPropertiesFiles();
			handleBrowserValueFromJekninsOrPropetiesFile();
			initiateDriver();

			// log.debug(browser.toUpperCase() + " launched !!!!");

			String url = config.getProperty("testsiteurl");
			// log.debug("Navigated to: " + url);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 5);

			menu = new TopMenu(driver);
			/*
			 * driver.get("https://www.zoho.com/"); driver.manage().window().maximize();
			 * 
			 * // Implicit wait driver.manage().timeouts().implicitlyWait(10,
			 * TimeUnit.SECONDS);
			 */
		}
	}

	private void initiateDriver() {
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			initiateFireFoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			initiateChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			initiateEdgeDriver();
		}

	}

	private void initiateEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	private void initiateFireFoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	private void handleBrowserValueFromJekninsOrPropetiesFile() {

		// Jenkins Browser filter configuration
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			// browser value from Jenkins
			browser = System.getenv("browser");
		} else {
			// browser value from config.properties file
			browser = config.getProperty("browser");
		}

		// Setting the value of browser parameter in config.properties file
		config.setProperty("browser", browser);
	}

	private void loadPropertiesFiles() {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\com\\learning\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\com\\learning\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.debug("OR file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initiateChromeDriver() {
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		driver = new ChromeDriver(options);

		// driver = new ChromeDriver();
	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src="
					+ Utilities.screenshotName + " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

	}

	public static void click(String locator) {
		System.out.println("==========CLICK========");
		System.out.println("locator: " + locator);
		System.out.println("Locator Value: " + OR.getProperty(locator));
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking on : " + locator);
		log.debug("Clicking on element: " + locator);
	}

	public static void type(String locator, String value) {
		System.out.println("==========TYPE========");
		System.out.println("locator: " + locator);
		System.out.println("Locator Value: " + OR.getProperty(locator));
		System.out.println("value: " + value);

		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing in : " + locator + " and entered value: " + value);
		log.debug("Typing in and Element: " + locator + " and entered value: " + value);
	}

	static WebElement dropdown;

	public static void select(String locator, String value) {

		if (locator.endsWith("_css")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_xpath")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_id")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		} else {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}

		dropdown.sendKeys(value);
		/*
		 * Select select = new Select(dropdown); select.selectByVisibleText(value);
		 */
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as: " + value);
		log.debug("Selecting from dropdown : " + locator + " value as: " + value);

	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void quit() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
