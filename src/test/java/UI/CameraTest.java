package UI;

import Framework.Components.ProductComponent;
import Framework.MainPage;
import Framework.ProductsPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CameraTest extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void checkProductItemsCount() {

        ProductsPage cameraPage = mainPage.clickOnTheCameraButton();

        int productsCountValue = cameraPage.GetProductList().getProductsCountValue();
        softAssertions.assertThat(productsCountValue)
                .as("Products count value is not equals expected")
                .isEqualTo(2);

        ProductComponent canon = cameraPage.GetProductList().getProductByProductName("Canon EOS 5D");
        softAssertions.assertThat(canon.getProductOldPrice())
                .as("Product old price is not equals expected")
                .contains("122.00");
        softAssertions.assertThat(canon.getProductNewPrice())
                .as("Product new price is not equals expected")
                .contains("98.00");

        ProductComponent nikon = cameraPage.GetProductList().getProductByProductName("Nikon D300");
        softAssertions.assertThat(nikon.getProductTaxPrice())
                .as("Product tax price is not equals expected")
                .contains("80.00");
        softAssertions.assertAll();
    }
}
