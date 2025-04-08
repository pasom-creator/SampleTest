package pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private final By header = By.xpath("//*[@class='ext-registration_h']");

    public void getPageHeader() {
        haveText(header,"Введите номер телефона");
    }
}