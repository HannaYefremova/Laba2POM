package UI;

import Framework.BasePage;
import Framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkShowLimitSelectedValue(){
        String showLimitSelectedValue = mainPage.clickShowAllDesktops()
                .getShowLimitSelectedValue();
        Assertions.assertThat(showLimitSelectedValue)
                .as("Show limit selected value is not equals expected")
                .isEqualTo("10");
    }
    @Test
    public void checkSortBySelectedValue(){
        String selectedSortByValue = mainPage.clickShowAllDesktops()
                .getSelectedSortByValue();
        Assertions.assertThat(selectedSortByValue)
                .as("Selected sort By value is not equals expected")
                .isEqualTo("Default");
    }
    @Test
    public void checkProductItemsCount(){
        int productsCountValue = mainPage.clickShowAllDesktops()
                .getProductsCountValue();
        Assertions.assertThat(productsCountValue)
                .as("Products count value is not equals expected")
                .isEqualTo(10);
    }
    @Test
    public void checkShowItemsCountsAfter25ElementsClick(){
        int productsCountValue=mainPage.clickShowAllDesktops()
                .clickShowItem25()
                .getProductsCountValue();
        Assertions.assertThat(productsCountValue)
                .as("Products count value is not equals expected")
                .isEqualTo(12);
    }
    @Test
    public void checkShowEndTextAfter25ElementsClick(){
        String endText=mainPage.clickShowAllDesktops()
                .clickShowItem25()
                .getEndText();
        Assertions.assertThat(endText)
                .as("End text value is not equals expected")
                .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");
    }
    @Test
    public void checkProductsSortAZ(){
        List<String> productItemsName = mainPage.clickShowAllDesktops()
                .clickSortByNameAZ()
                .getProductItemsName();
        Boolean result = BasePage.isStringListSorted(productItemsName);
        Assertions.assertThat(result)
                .as("Product list is not sorted correctly")
                .isEqualTo(true);
    }
    @Test
    public void checkProductsSortPriceLowToHeight(){
        List<Double> productItemsPrice = mainPage.clickShowAllDesktops()
                .clickSortByPriceLowHight()
                .getProductItemsPrice();
        Boolean result = BasePage.isDoubleListSorted(productItemsPrice);
        Assertions.assertThat(result)
                .as("Product list is not sorted correctly by price")
                .isEqualTo(true);
    }
}
