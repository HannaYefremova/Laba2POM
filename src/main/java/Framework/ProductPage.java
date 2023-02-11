package Framework;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private final By priceLocator = By.xpath("//h2//span[@class='price-new']");

    public String getPrice() {
        return getDriver().findElement(priceLocator).getText();
    }
}
