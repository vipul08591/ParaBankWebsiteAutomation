package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    // Locators
    private By registerLink = By.linkText("Register");
    private By firstNameField = By.id("customer.firstName");
    private By lastNameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipField = By.id("customer.address.zipCode");
    private By phoneField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");
    private By successMessage = By.cssSelector("#rightPanel p");
    private By errorMessage = By.cssSelector("span[class='error']");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void goToRegisterPage() {
        driver.findElement(registerLink).click();
    }

    public void enterDetails(String firstName, String lastName, String address, String city,
                             String state, String zip, String phone, String ssn,
                             String username, String password, String confirmPassword) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(ssnField).sendKeys(ssn);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void submitRegistration() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccess() {
        return driver.findElement(successMessage).getText().contains("Your account was created successfully");
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
