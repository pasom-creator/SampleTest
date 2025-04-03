import org.openqa.selenium.By;
import pageObject.BasePage;

public class SignInPage extends BasePage {

    private final By buttonLogin = By.cssSelector("input.button-pro");
    private final By buttonRegistration = By.cssSelector(".mb-3x");
    private final By fieldEmail = By.cssSelector("#field_email");
    private final By fieldPassword = By.cssSelector("#field_password");

    public SignInPage() {
        setURL("https://ok.ru/");
    }

    public HomePage authorize(String login, String password) {
        writeText(fieldEmail, login);
        writeText(fieldPassword, password);
        click(buttonLogin);
        return new HomePage();
    }

    public RegistrationPage goToRegistrationPage() {
        click(buttonRegistration);
        return new RegistrationPage();
    }
}
