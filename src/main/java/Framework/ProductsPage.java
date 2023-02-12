package Framework;

import org.openqa.selenium.By;


public class ProductsPage extends BasePage {

    private final By showItemLocator = By.xpath("//select[@id='input-limit']");
    private final By endTextLocator = By.xpath("//div[@class='col-sm-6 text-end']");
    private final By sortByLocator = By.id("input-sort");

    public String getEndText() {
        return getDriver().findElement(endTextLocator).getText();
    }

    public void selectFromSortByDropdown(String value) {
        selectByText(sortByLocator, value);
    }

    public String getValueFromSortByDropdown() {
        return getSelectedValue(sortByLocator);
    }

    public void selectFromCountDropDown(String value) {
        selectByText(showItemLocator, value);
    }

    public String getValueFromCountDropDown() {
        return getSelectedValue(showItemLocator);
    }


}

