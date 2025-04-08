package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private final By buttonLogin = By.xpath("//*[@value='Войти в Одноклассники']");
    private final By buttonRegistration = By.xpath("//*[@class='button-pro __sec mb-3x __wide']");
    private final By fieldEmail = By.xpath("//*[@id='field_email']");
    private final By fieldPassword = By.xpath("//*[@id='field_password']");

    public void login(String login, String password){
        writeText(fieldEmail, login);
        writeText(fieldPassword, password);
        click(buttonLogin);
    }

    public HomePage authorize(String login, String password) {
        login(login,password);
        return new HomePage();
    }

    public SmsAuthPage smsAuthorization(String login,String password){
        login(login,password);
        return new SmsAuthPage();
    }

    public RegistrationPage goToRegistrationPage() {
        click(buttonRegistration);
        return new RegistrationPage();
    }
}
