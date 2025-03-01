package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	// Class variable
	WebDriver driver;

	// Below Constructor method will initiate the driver instance by the time of
	// creating object for BasePage.
	// We type this.driver because to tell the method that to assign local variable
	// value which will get it from the testcase
	// to Class Variable because local and Class Variable both are in the same name
	// so we need to differentiate.

	public BasePage(WebDriver driver) {

		this.driver = driver;
		// initElements is the method will derive from the PageFactory class and it will
		// initiate the driver locally for the elements which we are going to find out
		// using
		// @FindBy method.Becasue we can't find the webElement without the driver
		// instance.
		PageFactory.initElements(driver, this); // Mandatory for all the Page Object Class because it passes the driver.
	}

}
