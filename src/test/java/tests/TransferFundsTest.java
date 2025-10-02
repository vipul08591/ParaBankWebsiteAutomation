package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransferFundsPage;
import utils.Log;

public class TransferFundsTest extends BaseTest {

    @Test
    public void validFundsTransferTest() {
        Log.info("===== Starting validFundsTransferTest =====");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        Log.info("Logging in with valid credentials...");
        login.login("john", "demo");

        // Step 2: Navigate to Transfer Funds
        TransferFundsPage transfer = new TransferFundsPage(driver);
        Log.info("Navigating to Transfer Funds page...");
        transfer.goToTransferFunds();

        // Step 3: Fill Transfer Details
        Log.info("Entering amount: 200");
        transfer.enterAmount("200");

        Log.info("Selecting From Account: 12345");
        transfer.selectFromAccount("12345"); // Replace with real account numbers

        Log.info("Selecting To Account: 54321");
        transfer.selectToAccount("54321");

        Log.info("Submitting transfer...");
        transfer.submitTransfer();

        // Step 4: Verify
        Assert.assertTrue(transfer.isTransferSuccessful(), "❌ Transfer not successful!");
        Log.info("✅ Transfer completed successfully.");

        Log.info("===== Finished validFundsTransferTest =====");
    }

    @Test
    public void invalidFundsTransferTest() {
        Log.info("===== Starting invalidFundsTransferTest =====");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        Log.info("Logging in with valid credentials...");
        login.login("john", "demo");

        // Step 2: Navigate to Transfer Funds
        TransferFundsPage transfer = new TransferFundsPage(driver);
        Log.info("Navigating to Transfer Funds page...");
        transfer.goToTransferFunds();

        // Step 3: Enter invalid data (empty amount)
        Log.info("Leaving amount empty to simulate invalid transfer...");
        transfer.enterAmount("");

        Log.info("Selecting From Account: 12345");
        transfer.selectFromAccount("12345");

        Log.info("Selecting To Account: 54321");
        transfer.selectToAccount("54321");

        Log.info("Submitting invalid transfer...");
        transfer.submitTransfer();

        // Step 4: Verify Error
        Assert.assertTrue(transfer.isErrorShown(), "❌ Error message not displayed for invalid transfer!");
        Log.info("⚠️ Proper error message displayed for invalid transfer.");

        Log.info("===== Finished invalidFundsTransferTest =====");
    }
}
