package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage {
    private WebDriver driver;

    // Locators
    private By transferFundsLink = By.linkText("Transfer Funds");
    private By amountField = By.id("amount");
    private By fromAccountDropdown = By.id("fromAccountId");
    private By toAccountDropdown = By.id("toAccountId");
    private By transferButton = By.cssSelector("input[value='Transfer']");
    private By successMessage = By.xpath("//h1[text()='Transfer Complete!']");
    private By errorMessage = By.cssSelector(".error");

    // Constructor
    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void goToTransferFunds() {
        driver.findElement(transferFundsLink).click();
    }

    public void enterAmount(String amount) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
    }

    public void selectFromAccount(String account) {
        driver.findElement(fromAccountDropdown).sendKeys(account);
    }

    public void selectToAccount(String account) {
        driver.findElement(toAccountDropdown).sendKeys(account);
    }

    public void submitTransfer() {
        driver.findElement(transferButton).click();
    }

    public boolean isTransferSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isErrorShown() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
