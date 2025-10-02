package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.BillPayPage;
import utils.Log;

public class BillPayTest extends BaseTest {

    @Test
    public void validBillPaymentTest() {
        Log.info("===== Starting validBillPaymentTest =====");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        Log.info("Logging in with valid credentials...");
        login.login("john", "demo");

        // Step 2: Navigate to Bill Pay
        BillPayPage billPay = new BillPayPage(driver);
        Log.info("Navigating to Bill Pay page...");
        billPay.goToBillPay();

        // Step 3: Fill details
        Log.info("Filling Bill Pay details for payee: Electric Company, amount: 500");
        billPay.fillPayeeDetails(
                "Electric Company",  // Payee name
                "123 Street",        // Address
                "New York",          // City
                "NY",                // State
                "10001",             // Zip
                "1234567890",        // Phone
                "12345",             // Account
                "12345",             // Verify Account
                "500",               // Amount
                "12345"              // From account
        );

        Log.info("Submitting bill payment...");
        billPay.submitPayment();

        // Step 4: Verify
        Assert.assertTrue(billPay.isPaymentSuccessful(), "❌ Bill payment failed!");
        Log.info("✅ Bill payment completed successfully.");

        Log.info("===== Finished validBillPaymentTest =====");
    }

    @Test
    public void invalidBillPaymentTest() {
        Log.info("===== Starting invalidBillPaymentTest =====");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        Log.info("Logging in with valid credentials...");
        login.login("john", "demo");

        // Step 2: Navigate to Bill Pay
        BillPayPage billPay = new BillPayPage(driver);
        Log.info("Navigating to Bill Pay page...");
        billPay.goToBillPay();

        // Step 3: Submit empty form
        Log.info("Submitting empty Bill Pay form (invalid case)...");
        billPay.submitPayment();

        // Step 4: Verify error
        Assert.assertTrue(billPay.isErrorShown(), "❌ No error displayed for invalid Bill Pay submission!");
        Log.info("⚠️ Proper error message displayed for invalid Bill Pay submission.");

        Log.info("===== Finished invalidBillPaymentTest =====");
    }
}
