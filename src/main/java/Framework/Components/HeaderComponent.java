package Framework.Components;

import Framework.BasePage;
import Framework.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderComponent extends BasePage {
    private final By myAccountLocator = By.xpath("//nav[@id='top']//div[@class='nav float-end']//li[2]//span[@class='d-none d-md-inline']");
    private final By registerDropdownLocator = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']/li[1]/a");
    private final By currencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a");
    private final By currencyElementsLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li/a");
    private final By currentCurrencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a/strong");

    public RegistrationPage clickRegister() {
        getDriver().findElement(myAccountLocator).click();
        getDriver().findElement(registerDropdownLocator).click();
        return new RegistrationPage();
    }

    public String getCurrentCurrency() {
        return getDriver().findElement(currentCurrencyLocator).getText();
    }

    public List<WebElement> getAllCurrencies() {
        return getDriver().findElements(currencyElementsLocator);
    }

    public void switchToCurrencyByName(String name) {
        getDriver().findElement(currencyLocator).click();
        for (WebElement element : getAllCurrencies()) {
            if (element.getText().equals(name)) {
                element.click();
                return;
            }
        }
    }

}
