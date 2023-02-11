package UI;

import Framework.BasePage;
import Framework.MainPage;
import Framework.ProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkShowLimitSelectedValue() {

        ProductsPage productsPage = mainPage.clickShowAllDesktops();

        String showLimitSelectedValue = productsPage.GetProductFilter().getValueFromCountDropDown();
        Assertions.assertThat(showLimitSelectedValue)
                .as("Show limit selected value is not equals expected")
                .isEqualTo("10");

        String selectedSortByValue = productsPage.GetProductFilter().getValueFromSortByDropdown();
        Assertions.assertThat(selectedSortByValue)
                .as("Selected sort By value is not equals expected")
                .isEqualTo("Default");

        int productsCountValue = productsPage.GetProductList().getProductsCountValue();
        Assertions.assertThat(productsCountValue)
                .as("Products count value is not equals expected")
                .isEqualTo(10);

        productsPage.GetProductFilter().selectFromCountDropDown("25");
        productsCountValue = productsPage.GetProductList().getProductsCountValue();
        Assertions.assertThat(productsCountValue)
                .as("Products count value is not equals expected")
                .isEqualTo(12);

        String endText = productsPage.GetProductFilter().getEndText();
        Assertions.assertThat(endText)
                .as("End text value is not equals expected")
                .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");

        productsPage.GetProductFilter().selectFromSortByDropdown("Name (A - Z)");
        List<String> productItemsName = productsPage.GetProductList().getProductNames();
        Boolean sortedByNameResult = BasePage.isStringListSorted(productItemsName);
        Assertions.assertThat(sortedByNameResult)
                .as("Product list is not sorted correctly")
                .isEqualTo(true);

        productsPage.GetProductFilter().selectFromSortByDropdown("Price (Low > High)");

        List<Double> productItemsPrice = productsPage.GetProductList().getProductPrices();
        Boolean sortedByPriceResult = BasePage.isDoubleListSorted(productItemsPrice);
        Assertions.assertThat(sortedByPriceResult)
                .as("Product list is not sorted correctly by price")
                .isEqualTo(true);
    }
}
