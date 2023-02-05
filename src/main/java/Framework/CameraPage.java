package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CameraPage extends BasePage{
    private final By productItemsLocator = By.xpath("//div[@id='product-list']/div[@class='col']");
    private final By productItemsNameLocator = By.xpath("//div[@id='product-list']/div[@class='col']//h4/a");
    private final By productItemsNewPriceLocator = By.xpath("//div[@id='product-list']//span[@class='price-new']");
    private final By productItemsOldPriceLocator = By.xpath("//div[@id='product-list']//span[@class='price-old']");
    private final By productItemsTaxPriceLocator = By.xpath("//div[@id='product-list']//span[@class='price-tax']");

    public List<WebElement> getProductItems(){
       return getDriver().findElements(productItemsLocator);
    }
    public List<String> getProductItemsName(){
        List<String> productItemsName = new ArrayList<>();
        List<WebElement> webElements = getDriver().findElements(productItemsNameLocator);
        for (WebElement element : webElements) {
            productItemsName.add(element.getText());
        }
        return productItemsName;
    }
    public List<String> getProductItemsOldPrice(){
        List<String> productItemsOldPrice = new ArrayList<>();
        List<WebElement> webElements = getDriver().findElements(productItemsOldPriceLocator);
        for (WebElement element : webElements) {
            productItemsOldPrice.add(element.getText());
        }
        return productItemsOldPrice;
    }
    public List<String> getProductItemsNewPrice(){
        List<String> productItemsNewPrice = new ArrayList<>();
        List<WebElement> webElements = getDriver().findElements(productItemsNewPriceLocator);
        for (WebElement element : webElements) {
            productItemsNewPrice.add(element.getText());
        }
        return productItemsNewPrice;
    }
    public List<String> getProductItemsTaxPrice(){
        List<String> productItemsTaxPrice = new ArrayList<>();
        List<WebElement> webElements = getDriver().findElements(productItemsTaxPriceLocator);
        for (WebElement element : webElements) {
            productItemsTaxPrice.add(element.getText());
        }
        return productItemsTaxPrice;
    }
}
