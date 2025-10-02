package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements ITestListener {
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("✅ Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getMethod().getMethodName());

        extentTest.get().fail("❌ Test Failed: " + result.getThrowable());

        try {
            // Attach screenshot in Extent Report
            extentTest.get().addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("⚠️ Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
