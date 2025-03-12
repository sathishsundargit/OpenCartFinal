package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends BasePage {

	public ComponentsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Components")
	WebElement linkComponents;

	@FindBy(linkText = "Monitors (2)")
	WebElement linkMonitors;

	@FindBy(xpath = "//div[@id =\"content\"]/h2")
	WebElement lblMonitor;

	public void clickComp() {
		linkComponents.click();
	}

	public void clickMonitors() {
		linkMonitors.click();
	}

	public boolean isMonitorPageExists() {

		try {
			return lblMonitor.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
