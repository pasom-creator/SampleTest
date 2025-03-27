import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.BasePage;

public class IndexPage extends BasePage {

    private By buttonLogin = By.cssSelector("input.button-pro");
    private By buttonRegistration = By.cssSelector(".mb-3x");
    private By messageRegistration = By.cssSelector(".ext-registration_h");
    private By fieldEmail = By.cssSelector("#field_email");
    private By fieldPassword = By.cssSelector("#field_password");

    public IndexPage(WebDriver driver) {
        super(driver);
        setURL("https://ok.ru/");
    }

    public IndexPage authorize(String login, String password) {
        getDriver().findElement(fieldEmail).sendKeys(login);
        getDriver().findElement(fieldPassword).sendKeys(password);
        getDriver().findElement(buttonLogin).click();
        return new IndexPage(getDriver());
    }

    public RegistrationPage clickButton() {
        getDriver().findElement(buttonRegistration).click();
        return new RegistrationPage(getDriver());
    }

    public String getPageUrl(){
        return getDriver().getCurrentUrl();
    }

}
