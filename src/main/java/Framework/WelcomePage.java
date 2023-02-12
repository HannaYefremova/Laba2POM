package Framework;

public class WelcomePage extends BasePage {
    public String getPageTitle() {

        return getDriver().getTitle();
    }
}
