package pageObject;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private WebDriver driver;
    private String URL;

    public BasePage (WebDriver driver){
        this.driver=driver;
    }

    public void open(){
        driver.get(URL);
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public WebDriver getDriver() {
        return driver;
    }
}