package UI;

import Framework.Components.HeaderComponent;
import Framework.Helpers.StringHelper;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    private final HeaderComponent header = new HeaderComponent();

    @Test
    public void registrationAccount() {

        String pageName = header.clickRegister()
                .enterFirstName(StringHelper.generateInvalidFirstName())
                .enterLastName(StringHelper.generateInvalidLastName())
                .enterEmail(StringHelper.generateInvalidEmail())
                .enterPassword(StringHelper.generateInvalidPassword())
                .checkCheckboxPrivacyPolicy()
                .clickContinueButton()
                .pageName();

        Assertions
                .assertThat(pageName)
                .as("Page name is not equals expected.")
                .isEqualTo("Welcome");
    }
}