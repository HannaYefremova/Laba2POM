package UI;

import Framework.Components.HeaderComponent;
import Framework.Components.ProductListComponent;
import Framework.ProductPage;
import Framework.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

    private final HeaderComponent header = new HeaderComponent();
    private final ProductListComponent productList = new ProductListComponent();
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void correctPriceInDifferentCurrencyTest() {
        String currentCurrency = header.getCurrentCurrency();
        if (!currentCurrency.equals("$")) {
            header.switchToCurrencyByName("$ US Dollar");
        }

        ProductPage productPage = productList.getProductByProductName("iPhone").clickOnProduct();

        String iphonePrice = productPage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("123.20");

        header.switchToCurrencyByName("€ Euro");
        iphonePrice = productPage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("106.04");

        header.switchToCurrencyByName("£ Pound Sterling");
        iphonePrice = productPage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .contains("95.32");
        softAssertions.assertAll();
    }
}
