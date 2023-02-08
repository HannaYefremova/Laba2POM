package UI;

import Framework.MainPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BrandsTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkBrandsName() {

        List<WebElement> brandsList = mainPage.clickBrandsLink()
                .getBrands();

        List<String> actualBrandsList = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm", "Sony");



        for (WebElement element : brandsList) {
            Assertions.assertThat(actualBrandsList)
                    .as("error name")
                    .contains(element.getText());
        }
    }
}
