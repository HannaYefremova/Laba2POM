package Framework;

import org.openqa.selenium.By;

public class IphonePage extends BasePage{

    private final By iPhonePriceLocator = By.xpath("//h2//span[@class='price-new']");

    public String getIphonePrice(){
        return getDriver().findElement(iPhonePriceLocator).getText();
    }
}
