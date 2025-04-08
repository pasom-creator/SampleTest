package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.SignInPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    private String siteUrl = "https://ok.ru/";
    protected SignInPage page;

    @BeforeAll
    public static void setupConfig() {
        Configuration.browser = "firefox";
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
