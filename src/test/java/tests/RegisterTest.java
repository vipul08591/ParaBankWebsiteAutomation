package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

	@Test
	public void successfulRegistrationTest() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.goToRegisterPage();

		String uniqueUsername = "user" + System.currentTimeMillis();

		registerPage.enterDetails("John", "Doe", "123 Elm Street", "New York", "NY", "10001", "1234567890", "111223333",
				uniqueUsername, "password123", "password123");
		registerPage.submitRegistration();

		Assert.assertTrue(registerPage.isRegistrationSuccess(), "❌ Registration failed, success message not shown!");
	}

	@Test
	public void registrationWithMismatchedPasswords() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.goToRegisterPage();

		registerPage.enterDetails("Jane", "Doe", "456 Oak Street", "Los Angeles", "CA", "90001", "9876543210",
				"999887777", "janedoe" + System.currentTimeMillis(), "password123", "wrongpass");
		registerPage.submitRegistration();

		Assert.assertTrue(registerPage.isErrorDisplayed(), "❌ Error message not shown for mismatched passwords!");
	}
}
