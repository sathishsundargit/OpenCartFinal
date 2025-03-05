package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAddressPage extends BasePage {

	public AddAddressPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement txtFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtLastName;

	@FindBy(id = "input-address-1")
	WebElement txtAddress;

	@FindBy(id = "input-city")
	WebElement txtCity;

	@FindBy(id = "input-postcode")
	WebElement txtPostCode;

	@FindBy(id = "input-country")
	WebElement drpdwnCountry;

	@FindBy(id = "input-zone")
	WebElement drpRegion;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement btnContinue;

	public void setFirstNameAdd(String fNameAdd) {
		txtFirstName.sendKeys(fNameAdd);
	}

	public void setLastNameAdd(String lNameAdd) {
		txtLastName.sendKeys(lNameAdd);
	}

	public void setAddressAdd(String addrs) {
		txtAddress.sendKeys(addrs);
	}

	public void setCityAdd(String cityAdd) {
		txtCity.sendKeys(cityAdd);
	}

	public void setPostCode(String pCodeAdd) {
		txtPostCode.sendKeys(pCodeAdd);
	}

	// Below are the Static method
	/*
	 * public void selCountry() { Select dropDownCtry = new Select(drpdwnCountry);
	 * dropDownCtry.selectByVisibleText("Algeria"); }
	 * 
	 * public void selZone() { Select dropZone = new Select(drpRegion);
	 * dropZone.selectByVisibleText("Biskra"); }
	 */

	// Below are the dynamic method.

	public void safeSelectCountry(String countryName) {
		try {
			// Wait until the country dropdown is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(drpdwnCountry));

			Select selectCountry = new Select(drpdwnCountry);
			List<WebElement> countryOptions = selectCountry.getOptions();

			for (WebElement option : countryOptions) {
				if (option.getText().equalsIgnoreCase(countryName)) {
					selectCountry.selectByVisibleText(countryName);
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element went stale, retrying...");
			// Re-find the element and retry selecting the country
			WebElement countryDropdown = driver.findElement(By.id("input-country"));
			Select selectCountry = new Select(countryDropdown);
			List<WebElement> countryOptions = selectCountry.getOptions();

			for (WebElement option : countryOptions) {
				if (option.getText().equalsIgnoreCase(countryName)) {
					selectCountry.selectByVisibleText(countryName);
					break;
				}
			}
		}
	}

	public void safeSelectZone(String zoneName) {
		try {
			// Wait until the zone dropdown is visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(drpRegion));

			Select selectZone = new Select(drpRegion);
			List<WebElement> zoneOptions = selectZone.getOptions();

			for (WebElement option : zoneOptions) {
				if (option.getText().equalsIgnoreCase(zoneName)) {
					selectZone.selectByVisibleText(zoneName);
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element went stale, retrying...");
			// Re-find the element and retry selecting the zone
			WebElement zoneDropdown = driver.findElement(By.id("input-zone"));
			Select selectZone = new Select(zoneDropdown);
			List<WebElement> zoneOptions = selectZone.getOptions();

			for (WebElement option : zoneOptions) {
				if (option.getText().equalsIgnoreCase(zoneName)) {
					selectZone.selectByVisibleText(zoneName);
					break;
				}
			}
		}
	}

	public void clickCont() {
		btnContinue.click();
	}
}
