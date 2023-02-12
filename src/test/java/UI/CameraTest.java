package UI;

import Framework.Components.ProductComponent;
import Framework.Helpers.ProductsHelpers;
import Framework.MainPage;
import Framework.ProductsPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

public class CameraTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkProductItemsCount() {

        ProductsPage cameraPage = mainPage
                .clickOnTheCameraButton();

        List<ProductComponent> productComponentList = ProductsHelpers
                .getAllProducts();

        SoftAssertions softAssertions = new SoftAssertions();

        int productsCountValue = productComponentList.size();
        softAssertions.assertThat(productsCountValue)
                .as("Products count value is not equals expected")
                .isEqualTo(2);

        ProductComponent canon = ProductsHelpers
                .getProductByProductName(productComponentList, "Canon EOS 5D");
        softAssertions.assertThat(canon.getProductOldPrice())
                .as("Product old price is not equals expected")
                .isEqualTo("122.00");
        softAssertions.assertThat(canon.getProductNewPrice())
                .as("Product new price is not equals expected")
                .isEqualTo("98.00");

        ProductComponent nikon = ProductsHelpers
                .getProductByProductName(productComponentList, "Nikon D300");

        softAssertions.assertThat(nikon.getProductTaxPrice())
                .as("Product tax price is not equals expected")
                .isEqualTo("80.00");

        softAssertions.assertAll();
    }
}
