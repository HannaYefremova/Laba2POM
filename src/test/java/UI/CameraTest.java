package UI;

import Framework.CameraPage;
import Framework.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CameraTest extends BaseTest{

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkProductItemsCount(){
        CameraPage cameraPage = mainPage.clickOnTheCameraButton();

        List<WebElement> productsCountValue = cameraPage
                .getProductItems();
        softAssertions.assertThat(productsCountValue.size())
                .as("Products count value is not equals expected")
                .isEqualTo(2);

        List<String> productItemNames = cameraPage
                .getProductItemsName();
        softAssertions.assertThat(productItemNames.get(0))
                .as("Product name is not equals expected")
                .isEqualTo("Canon EOS 5D");

        List<String> productItemOldPrices = cameraPage
                .getProductItemsOldPrice();
        softAssertions.assertThat(productItemOldPrices.get(0))
                .as("Product old price is not equals expected")
                .contains("122.00");

        List<String> productItemNewPrices = cameraPage
                .getProductItemsNewPrice();
        softAssertions.assertThat(productItemNewPrices.get(0))
                .as("Product new price is not equals expected")
                .contains("98.00");

        softAssertions.assertThat(productItemNames.get(1))
                .as("Product name is not equals expected")
                .isEqualTo("Nikon D300");

        List<String> productItemTaxPrices = cameraPage
                .getProductItemsTaxPrice();
        softAssertions.assertThat(productItemTaxPrices.get(1))
                .as("Product tax price is not equals expected")
                .contains("80.00");
        softAssertions.assertAll();
    }
}
