package pages;

import data.Links;
import data.Time;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePageClass{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final String MAIN_PAGE_URL = Links.BASE_URL;


    public MainPage open() {
        openPage(MAIN_PAGE_URL);
        return this;
    }

    public MainPage verifyLoginPage() {
        waitForUrlChange(MAIN_PAGE_URL, Time.TIME_SHORT);
        return this;
    }
}
