package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.get("browser").toLowerCase();

            switch (browser) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;

                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;

                case "edge":
                    driver.set(new EdgeDriver());
                    break;

                default:
                    throw new IllegalArgumentException("❌ Browser not supported: " + browser);
            }

            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
