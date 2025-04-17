package pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private final By header = By.xpath("//*[@class='ext-registration_h']");
    private final String text = "Введите номер телефона";

    public boolean checkPageHeader() {
        return isHaveText(header, text);
    }
}