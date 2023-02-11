package Framework.Components;

import Framework.BasePage;
import Framework.ProductPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductComponent extends BasePage {
    private final String productName;
    private final String productNewPrice;
    private String productOldPrice;
    private String productTaxPrice;

    private WebElement productImage;

    public ProductComponent(WebElement container) {
        this.productName = container.findElement(By.xpath(".//h4/a")).getText();
        this.productNewPrice = container.findElement(By.xpath(".//span[@class='price-new']")).getText();
        try {
            this.productOldPrice = container.findElement(By.xpath(".//span[@class='price-old']")).getText();
        } catch (NoSuchElementException exception) {
            this.productOldPrice = null;
        }

        try {
            this.productTaxPrice = container.findElement(By.xpath(".//span[@class='price-tax']")).getText();
        } catch (NoSuchElementException exception) {
            this.productTaxPrice = null;
        }

        try {
            this.productImage = container.findElement(By.xpath(".//div[@class='image']/a"));
        } catch (NoSuchElementException exception) {
            this.productImage = null;
        }
    }

    public ProductPage clickOnProduct() {
        clickOnWebElement(this.getProductImage());
        return new ProductPage();
    }
}
