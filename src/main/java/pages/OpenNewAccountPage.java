package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenNewAccountPage {
    private WebDriver driver;

    // Locators
    private By openNewAccountLink = By.linkText("Open New Account");
    private By accountTypeDropdown = By.id("type");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By openNewAccountButton = By.cssSelector("input[value='Open New Account']");
    private By confirmationMessage = By.xpath("//h1[text()='Account Opened!']");
    private By newAccountId = By.id("newAccountId");

    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate
    public void goToOpenNewAccount() {
        driver.findElement(openNewAccountLink).click();
    }

    // Fill details
    public void selectAccountType(String type) {
        driver.findElement(accountTypeDropdown).sendKeys(type); // e.g. CHECKING or SAVINGS
    }

    public void selectFromAccount(String fromAccount) {
        driver.findElement(fromAccountDropdown).sendKeys(fromAccount);
    }

    // Submit
    public void submitNewAccount() {
        driver.findElement(openNewAccountButton).click();
    }

    // Verifications
    public boolean isAccountOpened() {
        return driver.findElements(confirmationMessage).size() > 0;
    }

    public String getNewAccountId() {
        return driver.findElement(newAccountId).getText();
    }
}
