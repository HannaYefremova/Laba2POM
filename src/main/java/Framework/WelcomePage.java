package Framework;

public class WelcomePage extends BasePage {
    public String pageName(){
        return getDriver().getTitle();
    }
}
