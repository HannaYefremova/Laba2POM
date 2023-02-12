package UI;

import Framework.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BrandsTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkBrandsName() {

        List<String> brandsList = mainPage
                .clickBrandsLink()
                .getBrands();

        List<String> actualBrandsList = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");

        Assertions.assertThat(brandsList)
                .as("error name")
                .containsExactlyElementsOf(actualBrandsList);
    }
}
