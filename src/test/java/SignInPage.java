import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.BasePage;

public class SignInPage extends BasePage {

    private By buttonLogin = By.cssSelector("input.button-pro");
    private By buttonRegistration = By.cssSelector(".mb-3x");
    private By fieldEmail = By.cssSelector("#field_email");
    private By fieldPassword = By.cssSelector("#field_password");

    public SignInPage(WebDriver driver) {
        super(driver);
        setURL("https://ok.ru/");
    }

    public HomePage authorize(String login, String password) {
        writeText(fieldEmail,login);
        writeText(fieldPassword,password);
        click(buttonLogin);
        return new HomePage(getDriver());
    }

    public RegistrationPage goToRegistrationPage() {
        click(buttonRegistration);
        return new RegistrationPage(getDriver());
    }

}
