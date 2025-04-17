package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
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

    public BasePage loginAndRedirect(String login, String password) {
        login(login, password);

        if (isHaveElement()) {
            return this;
        } else if ($(smsButton).is(visible)) {
            return new SmsAuthPage();
        } else if ($(userField).is(visible)) {
            return new HomePage();
        }

        return this;
    }

    public RegistrationPage goToRegistrationPage() {
        click(buttonRegistration);
        return new RegistrationPage();
    }

    @Override
    public boolean isHaveElement() {
        return $(errorField).exists();
    }
}
