package UI;

import Framework.Helpers.StringHelper;
import Framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void registrationAccount() {

        String pageName = mainPage
                .clickRegister()
                .enterFirstName(StringHelper.generateInvalidFirstName())
                .enterLastName(StringHelper.generateInvalidLastName())
                .enterEmail(StringHelper.generateInvalidEmail())
                .enterPassword(StringHelper.generateInvalidPassword())
                .checkCheckboxPrivacyPolicy()
                .clickContinueButton()
                .getPageTitle();

        Assertions
                .assertThat(pageName)
                .as("Page name is not equals expected.")
                .isEqualTo("Welcome");
    }
}