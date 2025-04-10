package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    public void click(By elementBy) {
        $(elementBy).shouldBe(enabled).click();
    }

    public void writeText(By elementBy, String text) {
        $(elementBy).shouldBe(visible).setValue(text);
    }

    public void haveText(By elementBy,String text) {
        $(elementBy).should(exist).shouldHave(text(text));
    }

}