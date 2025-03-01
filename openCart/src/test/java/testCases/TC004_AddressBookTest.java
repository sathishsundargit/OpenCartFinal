package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddAddressPage;
import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC004_AddressBookTest extends BaseClass {
	@Test(groups = { "Master" })
	public void verifyAddressBook() {

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			AddressBookPage abp = new AddressBookPage(driver);
			abp.clickAddressBook();
			abp.clickNewAddress();

			boolean targetPage = abp.IsAddAddressPageExists();
			Assert.assertTrue(targetPage);

			AddAddressPage aadp = new AddAddressPage(driver);
			aadp.setFirstNameAdd(randomString());
			aadp.setLastNameAdd(randomString());
			aadp.setAddressAdd(randomAlphaNumeric());
			aadp.setCityAdd(randomString());
			aadp.setPostCode(randomNumber());
			aadp.selCountry();
			aadp.selZone();
			aadp.clickCont();

			boolean AddEntryPage = abp.IsAddressBookPageExists();
			Assert.assertTrue(AddEntryPage);

		} catch (Exception e) {
			Assert.fail();
		}

	}

}
