package UI;

import Framework.Components.ProductComponent;
import Framework.Helpers.CurrencyHelper;
import Framework.Helpers.ProductsHelpers;
import Framework.ProductPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

public class CurrencyTest extends BaseTest {
    @Test
    public void correctPriceInDifferentCurrencyTest() {
        String currentCurrency = CurrencyHelper.getCurrentCurrency();
        if (!currentCurrency.equals("$")) {
            CurrencyHelper.switchToCurrencyByName("$ US Dollar");
        }

        List<ProductComponent> productComponentList = ProductsHelpers.getAllProducts();
        ProductPage productPage = ProductsHelpers.getProductByProductName(productComponentList, "iPhone")
                .clickOnProduct();

        SoftAssertions softAssertions = new SoftAssertions();
        String iphonePrice = productPage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .isEqualTo("123.20");

        CurrencyHelper.switchToCurrencyByName("€ Euro");
        iphonePrice = productPage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .isEqualTo("106.04");

        CurrencyHelper.switchToCurrencyByName("£ Pound Sterling");
        iphonePrice = productPage.getPrice();
        softAssertions.assertThat(iphonePrice)
                .as("Price is not equals expected")
                .isEqualTo("95.32");
        softAssertions.assertAll();
    }
}
