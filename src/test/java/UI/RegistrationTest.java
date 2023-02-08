package UI;

import Framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void registrationAccount() {

        String pageName = mainPage.clickRegister()
                .enterFirstName("Hanna")
                .enterLastName("Yefremova")
                .enterEmail("annakurdel@gmail.com")
                .enterPassword("An142kurd")
                .checkCheckboxPrivacyPolicy()
                .clickContinueButton()
                .pageName();

        Assertions
                .assertThat(pageName)
                .as("Page name is not equals expected.")
                .isEqualTo("Welcome");
    }
}