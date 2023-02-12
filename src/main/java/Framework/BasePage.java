package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public static List<WebElement> findAll(By locator) {
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
}