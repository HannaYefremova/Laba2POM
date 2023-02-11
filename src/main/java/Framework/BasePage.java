package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Iterables.isEmpty;

public class BasePage {

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

    public String getSelectedValue(By selectLocator) {
        Select select = new Select(getDriver().findElement(selectLocator));
        return select.getFirstSelectedOption().getText();
    }

    public void selectByText(By selectLocator, String text) {
        Select select = new Select(getDriver().findElement(selectLocator));
        select.selectByVisibleText(text);
    }

    public void clickOnLocator(By locator) {
        WebElement element = find(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public void clickOnWebElement(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", webElement);
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
}