package UI;

import Framework.Components.ProductComponent;
import Framework.Helpers.ProductsHelpers;
import Framework.MainPage;
import Framework.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class DesktopsTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkShowLimitSelectedValue() {

        ProductsPage productsPage = mainPage.clickShowAllDesktops();

        String showLimitSelectedValue = productsPage.getValueFromCountDropDown();
        Assertions.assertThat(showLimitSelectedValue)
                .as("Show limit selected value is not equals expected")
                .isEqualTo("10");

        String selectedSortByValue = productsPage.getValueFromSortByDropdown();
        Assertions.assertThat(selectedSortByValue)
                .as("Selected sort By value is not equals expected")
                .isEqualTo("Default");

        List<ProductComponent> products = ProductsHelpers.getAllProducts();

        Assertions.assertThat(products.size())
                .as("Products count value is not equals expected")
                .isEqualTo(10);

        productsPage.selectFromCountDropDown("25");
        products = ProductsHelpers.getAllProducts();
        Assertions.assertThat(products.size())
                .as("Products count value is not equals expected")
                .isEqualTo(12);

        String endText = productsPage.getEndText();
        Assertions.assertThat(endText)
                .as("End text value is not equals expected")
                .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");

        List<String> sortedByNameExpected = ProductsHelpers.getProductNames(products);
        sortedByNameExpected.sort(Comparator.comparing(String::toLowerCase));
        productsPage.selectFromSortByDropdown("Name (A - Z)");
        List<String> actualSortedByName = ProductsHelpers.getProductNames(ProductsHelpers.getAllProducts());
        Assertions.assertThat(sortedByNameExpected)
                .as("Product list is not sorted correctly")
                .containsExactlyElementsOf(actualSortedByName);

        List<Double> sortedByPriceExpected = ProductsHelpers.getProductNewPrices(products);
        sortedByPriceExpected.sort(Comparator.comparingDouble(Double::doubleValue));
        productsPage.selectFromSortByDropdown("Price (Low > High)");
        List<Double> actualSortedByPrice = ProductsHelpers.getProductNewPrices(ProductsHelpers.getAllProducts());
        Assertions.assertThat(sortedByPriceExpected)
                .as("Product list is not sorted correctly by price")
                .containsExactlyElementsOf(actualSortedByPrice);
    }
}
