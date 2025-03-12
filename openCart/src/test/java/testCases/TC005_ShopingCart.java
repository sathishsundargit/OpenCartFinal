package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComponentsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_ShopingCart extends BaseClass {

	@Test(groups = { "checkFeature" })
	public void verifyShoppingCart() {

		logger.info("Launched Componnets Page");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			ComponentsPage comp = new ComponentsPage(driver);
			comp.clickComp();
			comp.clickMonitors();

			boolean trgMoniPage = comp.isMonitorPageExists();
			Assert.assertTrue(trgMoniPage, "Monitor page is displayed");

			BaseClass bc = new BaseClass();
			bc.scrollPage();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
