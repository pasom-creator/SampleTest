package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    public void click(By elementBy) {
        $(elementBy).shouldBe(enabled.because("Элемент для клика не найден на странице")).click();
    }

    public void writeText(By elementBy, String text) {
        $(elementBy).shouldBe(visible.because("Текстовое поле на странице не найдено.")).setValue(text);
    }

    public boolean isHaveText(By elementBy, String text) {
        return $(elementBy).should(exist.because("Элемент на странице не найден."))
                .shouldHave(text(text)).getText().equals(text);
    }

}