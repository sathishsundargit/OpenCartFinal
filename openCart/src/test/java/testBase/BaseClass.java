package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver; // To avoid conflict of creating two driver instance,so we made it as common so
									// we have used it in ExtentReport
	public Logger logger;
	public Properties p;

	@Parameters({ "os", "browser" })
	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	// We are receiving the browser name in br variable from master.xml file
	public void setup(String os, String br) throws IOException, InterruptedException {

		// To Read the config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		// To load the config.properties file
		p = new Properties();
		p.load(file);

		// getLogger method looks for class name to be passed as input because it
		// supposed to
		// be know which class name that logs should get generate. Therefore,we passed
		// this.getClass() method it will be dynamic and applies to all classes which
		// extends the BaseClass.That class name will store in the getLogger and move it
		// to logger variable and we used in all the classes.
		logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name ");
			// If return method executed then it wont execute the remaining steps because
			// what is the use if browser itself not valid.
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));

		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		// This ensures that the driver object is not null. It prevents
		// NullPointerException if the driver is uninitialized or already closed.
		if (driver != null) {
			// Duration.ofSeconds(10) waits for up to 10 seconds before throwing a
			// TimeoutException if the condition is not met.
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			/*
			 * Here’s what happens:
			 * 
			 * wait.until() waits until the provided condition is true. * Lambda Expression
			 * (webDriver -> {}): This is a concise way to pass a custom condition.
			 * 
			 * (JavascriptExecutor): Converts the WebDriver instance to JavascriptExecutor
			 * (an interface for executing JavaScript in the browser).
			 * 
			 * executeScript("return document.readyState"):
			 * 
			 * Executes a small piece of JavaScript in the browser. document.readyState is a
			 * property that tells the loading state of a webpage. It can have three
			 * possible values: "loading": Document is still loading. "interactive": DOM is
			 * parsed but sub-resources (like images) are still loading. "complete": Page
			 * and all resources (CSS, images, etc.) are fully loaded. Condition: It waits
			 * until document.readyState is "complete".
			 * 
			 * ✅ Why do we need this?
			 * 
			 * It ensures that the page is fully loaded before we attempt to quit the
			 * browser. This helps prevent issues where the driver tries to quit while the
			 * page is still loading
			 */
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
					.equals("complete"));

			/*
			 * driver.quit(): Closes all open browser windows and ends the WebDriver
			 * session. Use driver.quit() instead of driver.close() because: driver.close()
			 * closes only one window. driver.quit() completely shuts down the browser.
			 */
			driver.quit();
			System.out.println("Browser closed successfully");
		}

	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);

		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		String genearatedAlpNum = RandomStringUtils.randomAlphanumeric(6);
		return genearatedAlpNum;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;

	}

	public void scrollPage() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

	}
}
