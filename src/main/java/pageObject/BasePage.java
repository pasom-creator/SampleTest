package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public abstract class BasePage {

    String URL;

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void open() {
        Selenide.open(URL);
    }

    public void click(By elementBy) {
        $(elementBy).shouldBe(visible).click();
    }

    public void writeText(By elementBy, String text) {
        $(elementBy).shouldBe(visible).setValue(text);
    }

    public String readText(By elementBy) {
        return $(elementBy).shouldBe(visible).getText();
    }

    public String getCurrentPageUrl() {
        return webdriver().driver().url();
    }

    public SelenideElement getElement(By elementBy) {
        return $(elementBy).shouldBe(visible);
    }
}