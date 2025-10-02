package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By accountsOverviewHeader = By.xpath("//h1[contains(text(),'Accounts Overview')]");
    private By accountsTable = By.id("accountTable");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAtAccountsOverview() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsOverviewHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasAccountsListed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountsTable));
            return driver.findElements(By.cssSelector("#accountTable tr")).size() > 1; // header + rows
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        driver.findElement(By.linkText("Log Out")).click();
    }
}
