package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

// We are creating HomePage Constructor in this class to initiate driver and using super keyword to 
	// invoke the constructor from the Parent class.

	public HomePage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement lnkRegister;

	@FindBy(linkText = "Login")
	WebElement linkLogin;

	public void clickMyAccount() {
		lnkMyAccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		linkLogin.click();
	}
}
