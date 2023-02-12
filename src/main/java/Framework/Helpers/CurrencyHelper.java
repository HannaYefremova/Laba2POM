package Framework.Helpers;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CurrencyHelper {
    private static final By currencyElementsLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li/a");
    private static final By currencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a");
    private static final By currentCurrencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a/strong");
    public static String getCurrentCurrency() {

        return BasePage.find(currentCurrencyLocator).getText();
    }

    public static List<WebElement> getAllCurrencies() {

        return BasePage.findAll(currencyElementsLocator);
    }

    public static void switchToCurrencyByName(String name) {
        BasePage.find(currencyLocator).click();
        for (WebElement element : getAllCurrencies()) {
            if (element.getText().equals(name)) {
                element.click();
                return;
            }
        }
    }
}
