package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {

	public AddressBookPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Address Book")
	WebElement lnkAddressBook;

	@FindBy(linkText = "New Address")
	WebElement lnkNewAddress;

	@FindBy(xpath = "//*[@id='content']/h2[1]")
	WebElement labelAddAddress;

	@FindBy(xpath = "//div[@id=\"content\"]/h2")
	WebElement lblAddrsBookEntrys;

	public void clickAddressBook() {
		lnkAddressBook.click();
	}

	public void clickNewAddress() {
		lnkNewAddress.click();
	}

	public boolean IsAddAddressPageExists() {
		try {
			return labelAddAddress.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean IsAddressBookPageExists() {
		try {
			return lblAddrsBookEntrys.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
