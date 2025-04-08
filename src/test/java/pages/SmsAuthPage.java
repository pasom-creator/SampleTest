package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SmsAuthPage extends BasePage{

    private final By smsButton = By.xpath("//*[@value='Отправить код']");

    public void findSmsButton(){
        $(smsButton).shouldBe(visible)
                .shouldHave(attribute("name","st.r.goToSms"));
    }
}
