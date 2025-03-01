package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {

//We created object(hp) for the Home page to access those variables and methods.
//The reason for passing driver in the object creation because HomePage has constructor and 
//that parameterized constructor will need value and we are passing here.
		logger.info("***** Starting TC001 Account Registration Test *****");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickRegister();
			logger.info("Clicked on Register link");
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info("Providing Customer details...");

			regPage.setFirstName(randomString());
			regPage.setLastName(randomString());
			regPage.setEmail(randomString() + "@gmail.com");
			regPage.setTelephone(randomNumber());
			String passWord = randomAlphaNumeric();
			regPage.setPassword(passWord);
			regPage.setConfirmPassword(passWord);
			regPage.setPrivacyPolicy();
			regPage.clickContinue();
			logger.info("Validating expected message");
			String confmsg = regPage.getConfirmationMessage();
			// Below is the hard assertion.If the below step has failed then remaining steps
			// will not be executes.To capture the debug logs we are commenting the hard
			// assertion.
			if (confmsg.equals("Your Account Has Been Created!")) {
				// we are expecting true hence we passed true
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed ");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("******** Finished TC001_AccountRegistrationTest ********");
	}

}
