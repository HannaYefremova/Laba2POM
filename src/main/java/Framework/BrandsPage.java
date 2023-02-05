package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandsPage extends BasePage {
    private final By brandLocator = By.xpath("//div[@id='product-manufacturer']//div[@class='col-sm-3']/a");

    public List<WebElement> getBrands() {
        return findAll(brandLocator);
    }
}
