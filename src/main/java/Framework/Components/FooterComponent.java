package Framework.Components;

import Framework.BasePage;
import Framework.BrandsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FooterComponent extends BasePage {
    private final By brandsLinkLocator = By.xpath("//div[@class ='col-sm-3'][3]/ul/li[1]/a");

    public BrandsPage clickBrandsLink() {

        WebElement element = find(brandsLinkLocator);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);

        return new BrandsPage();
    }
}
