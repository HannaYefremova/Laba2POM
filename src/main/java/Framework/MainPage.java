package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private final By desktopsButtonLocator = By.xpath("//div[@id='narbar-menu']/ul/li[1]/a");
    private final By showAllDesktopsLocator = By.xpath("//ul[@class='nav navbar-nav']/li[1]//a[@class='see-all']");
    private final By cameraButtonLocator = By.xpath("//div[@id='narbar-menu']/ul/li[7]/a");
    private final By brandsLinkLocator = By.xpath("//div[@class ='col-sm-3'][3]/ul/li[1]/a");
    private final By myAccountLocator = By.xpath("//nav[@id='top']//div[@class='nav float-end']//li[2]//span[@class='d-none d-md-inline']");
    private final By registerDropdownLocator = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right show']/li[1]/a");


    public BrandsPage clickBrandsLink() {

        WebElement element = find(brandsLinkLocator);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);

        return new BrandsPage();
    }

    public RegistrationPage clickRegister() {
        getDriver().findElement(myAccountLocator).click();
        getDriver().findElement(registerDropdownLocator).click();
        return new RegistrationPage();
    }

    public ProductsPage clickShowAllDesktops() {
        hoverOverElement(desktopsButtonLocator);
        clickOnLocator(showAllDesktopsLocator);
        return new ProductsPage();
    }

    public ProductsPage clickOnTheCameraButton() {
        getDriver().findElement(cameraButtonLocator).click();
        return new ProductsPage();
    }
}