package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage {

    private final By buttonLogin = By.xpath("//*[@value='Войти в Одноклассники']");
    private final By buttonRegistration = By.xpath("//*[@tsid='login-block21_link_ffa6bf']");
    private final By fieldEmail = By.xpath("//*[@id='field_email']");
    private final By fieldPassword = By.xpath("//*[@id='field_password']");
    private final By errorField = By.xpath("//*[@class='input-e login_error']");

    public void login(String login, String password) {
        writeText(fieldEmail, login);
        writeText(fieldPassword, password);
        click(buttonLogin);
    }

    public boolean isError() {
        return $(errorField).exists();
    }

    public HomePage authorize(String login, String password) {
        login(login, password);
        return new HomePage();
    }

    public SignInPage wrongInput(String login, String password) {
        login(login, password);
        return this;
    }

    public SmsAuthPage smsAuthorization(String login, String password) {
        login(login, password);
        return new SmsAuthPage();
    }

    public RegistrationPage goToRegistrationPage() {
        click(buttonRegistration);
        return new RegistrationPage();
    }
}
