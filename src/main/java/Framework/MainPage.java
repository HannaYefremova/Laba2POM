package Framework;

import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private final By desktopsButtonLocator = By.xpath("//div[@id='narbar-menu']/ul/li[1]/a");
    private final By showAllDesktopsLocator = By.xpath("//ul[@class='nav navbar-nav']/li[1]//a[@class='see-all']");
    private final By cameraButtonLocator = By.xpath("//div[@id='narbar-menu']/ul/li[7]/a");

    public ProductsPage clickShowAllDesktops(){
        hoverOverElement(desktopsButtonLocator);
        clickOnLocator(showAllDesktopsLocator);
        return new ProductsPage();
    }

    public ProductsPage clickOnTheCameraButton(){
        getDriver().findElement(cameraButtonLocator).click();
        return new ProductsPage();
    }
}