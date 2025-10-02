package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        Log.info("===== Starting validLoginTest =====");
        LoginPage loginPage = new LoginPage(driver);

        Log.info("Attempting login with username: " + ConfigReader.get("username"));
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        Assert.assertTrue(loginPage.isLogoutDisplayed(), "❌ Login failed with valid credentials!");
        Log.info("✅ Login successful. Logout button is visible.");
    }

    @Test
    public void invalidLoginTest() {
        Log.info("===== Starting invalidLoginTest =====");
        LoginPage loginPage = new LoginPage(driver);

        Log.info("Attempting login with invalid credentials...");
        loginPage.login("wronguser", "wrongpass");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "❌ Error message not shown for invalid login!");
        Log.info("✅ Error message displayed as expected for invalid login.");
    }

    @Test
    public void emptyFieldsTest() {
        Log.info("===== Starting emptyFieldsTest =====");
        LoginPage loginPage = new LoginPage(driver);

        Log.info("Attempting login with empty username & password...");
        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "❌ Error message not shown for empty fields!");
        Log.info("✅ Error message displayed as expected for empty login.");
    }
}
