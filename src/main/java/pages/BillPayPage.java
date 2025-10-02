package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPayPage {
    private WebDriver driver;

    // Locators
    private By billPayLink = By.linkText("Bill Pay");
    private By payeeName = By.name("payee.name");
    private By address = By.name("payee.address.street");
    private By city = By.name("payee.address.city");
    private By state = By.name("payee.address.state");
    private By zipCode = By.name("payee.address.zipCode");
    private By phone = By.name("payee.phoneNumber");
    private By account = By.name("payee.accountNumber");
    private By verifyAccount = By.name("verifyAccount");
    private By amount = By.name("amount");
    private By fromAccountDropdown = By.name("fromAccountId");
    private By sendPaymentButton = By.cssSelector("input[value='Send Payment']");
    private By successMessage = By.xpath("//h1[text()='Bill Payment Complete']");
    private By errorMessage = By.cssSelector(".error");

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate
    public void goToBillPay() {
        driver.findElement(billPayLink).click();
    }

    // Fill Payee Details
    public void fillPayeeDetails(String name, String street, String cityVal,
                                 String stateVal, String zip, String phoneNum,
                                 String acc, String verifyAcc, String amt, String fromAcc) {
        driver.findElement(payeeName).sendKeys(name);
        driver.findElement(address).sendKeys(street);
        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phone).sendKeys(phoneNum);
        driver.findElement(account).sendKeys(acc);
        driver.findElement(verifyAccount).sendKeys(verifyAcc);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(fromAccountDropdown).sendKeys(fromAcc);
    }

    // Submit
    public void submitPayment() {
        driver.findElement(sendPaymentButton).click();
    }

    public boolean isPaymentSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isErrorShown() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
