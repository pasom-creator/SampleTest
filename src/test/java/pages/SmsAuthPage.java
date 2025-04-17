package pages;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SmsAuthPage extends BasePage{

    @Override
    public boolean isHaveElement() {
        return $(smsButton)
                .should(exist.because("Элемент на странице не найден."))
                .getValue().equals("Отправить код");
    }

}
