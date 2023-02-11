package Framework;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {
    private final By firstNameInputLocator = By.id("input-firstname");
    private final By lastNameInputLocator = By.id("input-lastname");
    private final By emailInputLocator = By.id("input-email");
    private final By passwordInputLocator = By.id("input-password");
    private final By privacyPolicyCheckboxLocator = By.xpath("//input[@type='checkbox']");
    private final By buttonContinueLocator = By.xpath("//button[@class='btn btn-primary']");

    public RegistrationPage enterFirstName(String firstName) {
        find(firstNameInputLocator).sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        find(lastNameInputLocator).sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        find(emailInputLocator).sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        find(passwordInputLocator).sendKeys(password);
        return this;
    }

    public RegistrationPage checkCheckboxPrivacyPolicy() {
        clickOnLocator(privacyPolicyCheckboxLocator);
        return this;
    }

    public WelcomePage clickContinueButton() {
        clickOnLocator(buttonContinueLocator);
        return new WelcomePage();

    }
}
