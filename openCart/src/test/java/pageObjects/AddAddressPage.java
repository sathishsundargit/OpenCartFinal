package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

	public void selCountry() {
		Select dropDownCtry = new Select(drpdwnCountry);
		dropDownCtry.selectByVisibleText("Algeria");
	}

	public void selZone() {
		Select dropZone = new Select(drpRegion);
		dropZone.selectByVisibleText("Biskra");
	}

	public void clickCont() {
		btnContinue.click();
	}
}
