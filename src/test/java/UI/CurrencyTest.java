package UI;

import Framework.IphonePage;
import Framework.MainPage;
import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void correctPriceInDifferentCurrencyTest() {
        String currentCurrency = mainPage.getCurrentCurrency();
        if (!currentCurrency.equals("$")) {
            mainPage.switchToDollarCurrency();
        }
        IphonePage iphonePage = mainPage.clickOnTheIphoneCard();
        String iphonePrice = iphonePage
                .getIphonePrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("123.20");

        mainPage.switchToEuroCurrency();
        iphonePrice = iphonePage.getIphonePrice();

        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("106.04");
        mainPage.switchToPoundCurrency();
        iphonePrice = iphonePage.getIphonePrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("95.32");
        softAssertions.assertAll();
    }

}
