package Framework.Components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
public class ProductComponent {
    private String productName;
    private String productNewPrice;
    private String productOldPrice;
    private String productTaxPrice;

    public ProductComponent(WebElement conteiner){
        this.productName = conteiner.findElement(By.xpath(".//h4/a")).getText();
        this.productNewPrice = conteiner.findElement(By.xpath(".//span[@class='price-new']")).getText();
        try {
            this.productOldPrice = conteiner.findElement(By.xpath(".//span[@class='price-old']")).getText();
        }
        catch (NoSuchElementException exception){
            this.productOldPrice = null;
        }

        try {
            this.productTaxPrice = conteiner.findElement(By.xpath(".//span[@class='price-tax']")).getText();
        }
        catch (NoSuchElementException exception){
            this.productTaxPrice = null;
        }

    }


}
