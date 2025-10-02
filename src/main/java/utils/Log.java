package utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);
    private static ExtentTest extentTest;

    // Attach current ExtentTest from BaseTest
    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }

    public static void info(String message) {
        logger.info(message); // Log4j
        if (extentTest != null) {
            extentTest.info(message); // Extent Report
        }
    }

    public static void pass(String message) {
        logger.info(message);
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }

    public static void fail(String message) {
        logger.error(message);
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }

    public static void warn(String message) {
        logger.warn(message);
        if (extentTest != null) {
            extentTest.warning(message);
        }
    }
}
