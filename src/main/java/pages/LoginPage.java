package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginBtn = By.cssSelector("input[value='Log In']");
    private By logoutLink = By.linkText("Log Out");
    private By errorMessage = By.cssSelector(".error"); // ParaBank shows error in red

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLogoutDisplayed() {
        return driver.findElements(logoutLink).size() > 0;
    }

    public boolean isErrorDisplayed() {
        // Case 1: actual error message visible
        if (driver.findElements(errorMessage).size() > 0) {
            return true;
        }
        // Case 2: still stuck on login page (means invalid/empty login)
        return driver.findElements(usernameField).size() > 0;
    }

    public void logout() {
        if (isLogoutDisplayed()) {
            driver.findElement(logoutLink).click();
        }
    }
}
