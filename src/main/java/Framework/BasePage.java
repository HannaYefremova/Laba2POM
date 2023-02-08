package Framework;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Iterables.isEmpty;

public class BasePage {
    private final By currencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a");
    private final By currencyEuroLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li[1]/a");
    private final By currencyPoundLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li[2]/a");
    private final By currencyDollarLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li[3]/a");
    private final By currentCurrencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a/strong");

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public void clickOnLocator(By locator) {
        WebElement element = find(locator);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public void hoverOverElement(By locator) {
        WebElement element = find(locator);

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();
    }

    public static boolean isStringListSorted(List<String> listOfStrings) {
        if (isEmpty(listOfStrings) || listOfStrings.size() == 1) return true;

        Iterator<String> iter = listOfStrings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next().toLowerCase();
            if (previous.toLowerCase().compareTo(current) >= 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public static boolean isDoubleListSorted(List<Double> doubleList) {
        if (isEmpty(doubleList) || doubleList.size() == 1) return true;

        Iterator<Double> iter = doubleList.iterator();
        Double current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous > current) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public String getCurrentCurrency() {
        return getDriver().findElement(currentCurrencyLocator).getText();
    }

    public void switchToDollarCurrency() {
        getDriver().findElement(currencyLocator).click();
        getDriver().findElement(currencyDollarLocator).click();
    }

    public void switchToEuroCurrency() {
        getDriver().findElement(currencyLocator).click();
        getDriver().findElement(currencyEuroLocator).click();
    }

    public void switchToPoundCurrency() {
        getDriver().findElement(currencyLocator).click();
        getDriver().findElement(currencyPoundLocator).click();
    }
}