package Framework.Helpers;

import Framework.BasePage;
import Framework.Components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsHelpers {
    private static final By productsAllContainersLocator = By.xpath("//div[@id='content']//div[@class='col']");

    public static List<ProductComponent> getAllProducts() {
        List<ProductComponent> products = new ArrayList<>();
        List<WebElement> containers = BasePage.findAll(productsAllContainersLocator);
        for (WebElement element : containers) {
            ProductComponent productComponent = new ProductComponent(element);
            products.add(productComponent);
        }
        return products;
    }

    public static ProductComponent getProductByProductName(List<ProductComponent> products, String name) {
        for (ProductComponent element : products) {
            if (element.getProductName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public static List<String> getProductNames(List<ProductComponent> products) {
        List<String> result = new ArrayList<>();
        for (ProductComponent element : products) {
            result.add(element.getProductName());
        }
        return result;
    }

    public static List<Double> getProductNewPrices(List<ProductComponent> products) {
        List<Double> result = new ArrayList<>();
        for (ProductComponent element : products) {
            result.add(Double.parseDouble(element.getProductNewPrice().substring(1).replace(",", "")));
        }
        return result;
    }
}
