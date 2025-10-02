package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.DriverManager;
import utils.ExtentManager;
import utils.ScreenshotUtils;
import utils.Log;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupSuite() {
        extent = ExtentManager.getInstance();
        Log.info("===== Test Suite Started =====");
    }

    @BeforeMethod
    public void setupDriver(Method method) {
        driver = DriverManager.getDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Attach ExtentTest for current test
        test = extent.createTest(method.getName());
        Log.setExtentTest(test);

        Log.info("Launching browser and opening ParaBank URL");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Log.fail("❌ Test Failed: " + result.getThrowable());

            // Take screenshot and attach
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getMethod().getMethodName());
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                Log.warn("⚠️ Failed to attach screenshot to Extent Report");
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Log.pass("✅ Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            Log.warn("⚠️ Test Skipped: " + result.getThrowable());
        }

        DriverManager.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
        Log.info("===== Test Suite Finished =====");
    }
}
