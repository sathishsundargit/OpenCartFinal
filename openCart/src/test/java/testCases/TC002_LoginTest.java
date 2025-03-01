package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verifyLogin() {

		logger.info("***** Starting TC002 Login Test *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			logger.info("Validating the MyAccount message ");
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetmsg = macc.IsMyAccountPageExists();
			// Assert.assertEquals(targetmsg, true, "LoginPassed");
			Assert.assertTrue(targetmsg);
			// macc.clickLogout();

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finished TC002 Login Test *****");
	}

}
