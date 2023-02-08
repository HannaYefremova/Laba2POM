package Framework.Pages;

import Framework.BasePage;
import Framework.Components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private final By productsAllContainersLocator = By.xpath("//div[@id='product-list']/div[@class='col']");
    private final By selectedShowItemLocator = By.xpath("//select[@id='input-limit']/option[@selected]");
    private final By selectedSortByLocator = By.xpath("//select[@id='input-sort']/option[@selected]");
    private final By productItemsLocator = By.xpath("//div[@id='product-list']/div[@class='col']");
    private final By showItemLocator = By.xpath("//select[@id='input-limit']");
    private final By showItem25Locator = By.xpath("//select[@id='input-limit']/option[2]");
    private final By endTextLocator = By.xpath("//div[@class='col-sm-6 text-end']");
    private final By sortByLocator = By.id("input-sort");
    private final By sortByNameAZLocator = By.xpath("//select[@id='input-sort']/option[2]");
    private final By sortByPriceLowHightLocator = By.xpath("//select[@id='input-sort']/option[4]");
    private final By getProductItemsPriceLocator = By.xpath("//div[@id='product-list']//span[@class='price-new']");


    public List<ProductComponent> getAllProducts() {
        List<ProductComponent> products = new ArrayList<>();
        List<WebElement> containers = findAll(productsAllContainersLocator);
        for (WebElement element : containers) {
            ProductComponent productComponent = new ProductComponent(element);
            products.add(productComponent);
        }
        return products;
    }

    public String getShowLimitSelectedValue() {

        return getDriver().findElement(selectedShowItemLocator).getText();
    }

    public List<String> getProductItemsName(){
        List<String> productItemsName = new ArrayList<>();
        List<ProductComponent> productComponentList = getAllProducts();
        for (ProductComponent element : productComponentList) {
            productItemsName.add(element.getProductName());
        }
        return productItemsName;
    }
    public List<String> getProductItemsOldPrice(){
        List<String> productItemsOldPrice = new ArrayList<>();
        List<ProductComponent> productComponents = getAllProducts();
        for (ProductComponent element : productComponents) {
            productItemsOldPrice.add(element.getProductOldPrice());
        }
        return productItemsOldPrice;
    }
    public List<String> getProductItemsNewPrice(){
        List<String> productItemsNewPrice = new ArrayList<>();
        List<ProductComponent> productComponents = getAllProducts();
        for (ProductComponent element : productComponents) {
            productItemsNewPrice.add(element.getProductNewPrice());
        }
        return productItemsNewPrice;
    }
    public List<String> getProductItemsTaxPrice(){
        List<String> productItemsTaxPrice = new ArrayList<>();
        List<ProductComponent> productComponents = getAllProducts();
        for (ProductComponent element : productComponents) {
            productItemsTaxPrice.add(element.getProductTaxPrice());
        }
        return productItemsTaxPrice;
    }
    public String getSelectedSortByValue() {

        return getDriver().findElement(selectedSortByLocator).getText();
    }
    public int getProductsCountValue() {

        return getDriver().findElements(productItemsLocator).size();
    }
    public ProductsPage clickShowItem25(){
        getDriver().findElement(showItemLocator).click();
        getDriver().findElement(showItem25Locator).click();
        return this;
    }
    public String getEndText(){
        return getDriver().findElement(endTextLocator).getText();
    }
    public ProductsPage clickSortByNameAZ(){
        getDriver().findElement(sortByLocator).click();
        getDriver().findElement(sortByNameAZLocator).click();
        return this;
    }
    public ProductsPage clickSortByPriceLowHight() {
        getDriver().findElement(sortByLocator).click();
        getDriver().findElement(sortByPriceLowHightLocator).click();
        return this;
    }
    public List<Double> getProductItemsPrice(){
        List<Double> result = new ArrayList<>();
        List<ProductComponent> productComponents = getAllProducts();
        for (ProductComponent element : productComponents) {
            result.add(Double.parseDouble(element.getProductNewPrice().substring(1)));
        }
        return result;
    }
}
