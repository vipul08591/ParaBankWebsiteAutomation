package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountsPage;

public class AccountsTest extends BaseTest {

	@Test
	public void accountsOverviewTest() {
	    LoginPage login = new LoginPage(driver);
	    login.login("john", "demo");

	    AccountsPage accounts = new AccountsPage(driver);

	    Assert.assertTrue(accounts.isAtAccountsOverview(), "❌ Accounts Overview page not loaded!");
	    Assert.assertTrue(accounts.hasAccountsListed(), "❌ No accounts listed in Accounts Overview!");

	    accounts.logout();
	}

}
