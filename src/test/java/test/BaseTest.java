package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.SignInPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    private String siteUrl = "https://ok.ru/";
    protected SignInPage page;

    @BeforeAll
    public static void setupConfig() {
        /*В соотвествие с вашими замечаниями добавил принудительный выбор русского языка.
        Пытался вынести всё в отдельный класс и созадвать экземпляр браузера используя
        класс FirefoxWebDriveFactory, но пока не получилось реализовать.
         */

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("intl.accept_languages", "ru-RU").merge(new MutableCapabilities());
        FirefoxDriver driver = new FirefoxDriver(options);
        WebDriverRunner.setWebDriver(driver);

        Configuration.timeout = 8000;
        Configuration.headless = false;
    }

    @BeforeEach
    public void SetUp() {
        page = new SignInPage();
        open(siteUrl);
    }

    @AfterEach
    public void close() {
        closeWindow();
    }
}
