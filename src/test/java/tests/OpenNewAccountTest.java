package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import utils.Log;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void openCheckingAccountTest() {
        Log.info("===== Starting openCheckingAccountTest =====");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        Log.info("Logging in with valid credentials...");
        login.login("john", "demo");

        // Step 2: Go to Open New Account page
        OpenNewAccountPage newAcc = new OpenNewAccountPage(driver);
        Log.info("Navigating to Open New Account page...");
        newAcc.goToOpenNewAccount();

        // Step 3: Select type and account
        Log.info("Selecting account type: CHECKING");
        newAcc.selectAccountType("CHECKING");

        Log.info("Selecting 'From Account' number: 12345");
        newAcc.selectFromAccount("12345"); // Replace with valid account number

        Log.info("Submitting request to open new account...");
        newAcc.submitNewAccount();

        // Step 4: Verify success
        Assert.assertTrue(newAcc.isAccountOpened(), "❌ New account was not opened successfully!");
        String accountId = newAcc.getNewAccountId();
        Log.info("✅ New Checking Account opened successfully. Account ID: " + accountId);

        Log.info("===== Finished openCheckingAccountTest =====");
    }

    @Test
    public void openSavingsAccountTest() {
        Log.info("===== Starting openSavingsAccountTest =====");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        Log.info("Logging in with valid credentials...");
        login.login("john", "demo");

        // Step 2: Go to Open New Account page
        OpenNewAccountPage newAcc = new OpenNewAccountPage(driver);
        Log.info("Navigating to Open New Account page...");
        newAcc.goToOpenNewAccount();

        // Step 3: Select type and account
        Log.info("Selecting account type: SAVINGS");
        newAcc.selectAccountType("SAVINGS");

        Log.info("Selecting 'From Account' number: 12345");
        newAcc.selectFromAccount("12345"); // Replace with valid account number

        Log.info("Submitting request to open new savings account...");
        newAcc.submitNewAccount();

        // Step 4: Verify success
        Assert.assertTrue(newAcc.isAccountOpened(), "❌ New savings account was not opened successfully!");
        String accountId = newAcc.getNewAccountId();
        Log.info("✅ New Savings Account opened successfully. Account ID: " + accountId);

        Log.info("===== Finished openSavingsAccountTest =====");
    }
}
