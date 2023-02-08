package UI;

import Framework.ProductPage;
import Framework.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void correctPriceInDifferentCurrencyTest() {
        String currentCurrency = mainPage.getCurrentCurrency();
        if (!currentCurrency.equals("$")) {
            mainPage.switchToDollarCurrency();
        }
        ProductPage iphonePage = mainPage.clickOnTheIphoneCard();
        String iphonePrice = iphonePage
                .getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("123.20");

        mainPage.switchToEuroCurrency();
        iphonePrice = iphonePage.getPrice();

        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("106.04");
        mainPage.switchToPoundCurrency();
        iphonePrice = iphonePage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("95.32");
        softAssertions.assertAll();
    }

}
