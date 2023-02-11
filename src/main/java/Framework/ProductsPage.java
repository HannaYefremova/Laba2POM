package Framework;

import Framework.Components.ProductFilterComponent;
import Framework.Components.ProductListComponent;


public class ProductsPage extends BasePage {

    public ProductsPage() {
        productFilter = new ProductFilterComponent();
        productList = new ProductListComponent();
    }

    ProductListComponent productList;
    ProductFilterComponent productFilter;

    public ProductListComponent GetProductList() {
        return productList;
    }

    public ProductFilterComponent GetProductFilter() {
        return productFilter;
    }
}
