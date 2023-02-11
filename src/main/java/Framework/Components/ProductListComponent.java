package Framework.Components;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductListComponent extends BasePage {
    private final By productsAllContainersLocator = By.xpath("//div[@id='content']//div[@class='col']");

    public List<ProductComponent> getAllProducts() {
        List<ProductComponent> products = new ArrayList<>();
        List<WebElement> containers = findAll(productsAllContainersLocator);
        for (WebElement element : containers) {
            ProductComponent productComponent = new ProductComponent(element);
            products.add(productComponent);
        }
        return products;
    }

    public ProductComponent getProductByProductName(String name) {
        for (ProductComponent element : getAllProducts()) {
            if (element.getProductName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public int getProductsCountValue() {
        return getAllProducts().size();
    }

    public List<Double> getProductPrices() {
        List<Double> result = new ArrayList<>();
        for (ProductComponent element : getAllProducts()) {
            result.add(Double.parseDouble(element.getProductNewPrice().substring(1).replace(",", "")));
        }
        return result;
    }

    public List<String> getProductNames() {
        List<String> result = new ArrayList<>();
        for (ProductComponent element : getAllProducts()) {
            result.add(element.getProductName());
        }
        return result;
    }

}
