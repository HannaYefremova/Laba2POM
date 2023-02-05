package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends BasePage {

    private final By selectedShowItemLocator = By.xpath("//select[@id='input-limit']/option[@selected]");
    private final By selectedSortByLocator = By.xpath("//select[@id='input-sort']/option[@selected]");
    private final By productItemsLocator = By.xpath("//div[@id='product-list']/div[@class='col']");
    private final By showItemLocator = By.xpath("//select[@id='input-limit']");
    private final By showItem25Locator = By.xpath("//select[@id='input-limit']/option[2]");
    private final By endTextLocator = By.xpath("//div[@class='col-sm-6 text-end']");
    private final By sortByLocator = By.id("input-sort");
    private final By sortByNameAZLocator = By.xpath("//select[@id='input-sort']/option[2]");
    private final By sortByPriceLowHightLocator = By.xpath("//select[@id='input-sort']/option[4]");
    private final By getProductItemsNameLocator = By.xpath("//div[@id='product-list']/div[@class='col']//h4/a");
    private final By getProductItemsPriceLocator = By.xpath("//div[@id='product-list']//span[@class='price-new']");

    public String getShowLimitSelectedValue() {

        return getDriver().findElement(selectedShowItemLocator).getText();
    }

    public String getSelectedSortByValue() {

        return getDriver().findElement(selectedSortByLocator).getText();
    }
    public int getProductsCountValue() {

        return getDriver().findElements(productItemsLocator).size();
    }
    public DesktopsPage clickShowItem25(){
        getDriver().findElement(showItemLocator).click();
        getDriver().findElement(showItem25Locator).click();
        return this;
    }
    public String getEndText(){
       return getDriver().findElement(endTextLocator).getText();
    }
    public DesktopsPage clickSortByNameAZ(){
        getDriver().findElement(sortByLocator).click();
        getDriver().findElement(sortByNameAZLocator).click();
        return this;
    }
    public List<String> getProductItemsName(){
        List<String> result = new ArrayList<>();
       List<WebElement> webElements = getDriver().findElements(getProductItemsNameLocator);
        for (WebElement element : webElements) {
            result.add(element.getText());
        }
        return result;
    }
    public DesktopsPage clickSortByPriceLowHight() {
        getDriver().findElement(sortByLocator).click();
        getDriver().findElement(sortByPriceLowHightLocator).click();
        return this;
    }
    public List<Double> getProductItemsPrice(){
        List<Double> result = new ArrayList<>();
        List<WebElement> webElements = getDriver().findElements(getProductItemsPriceLocator);
        for (WebElement element : webElements) {
            result.add(Double.parseDouble(element.getText().substring(1)));
        }
        return result;
    }
}

