package UI;

import Framework.Components.FooterComponent;
import Framework.MainPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BrandsTest extends BaseTest {

    private final FooterComponent footerComponent = new FooterComponent();

    @Test
    public void checkBrandsName() {

        List<String> brandsList = footerComponent.clickBrandsLink()
                .getBrands();

        List<String> actualBrandsList = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");

        Assertions.assertThat(brandsList)
                .as("error name")
                .containsExactlyElementsOf(actualBrandsList);
    }
}
