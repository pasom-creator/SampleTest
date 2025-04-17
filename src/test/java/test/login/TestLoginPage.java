package test.login;

import appconfigs.ConfProperties;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.*;

public class TestLoginPage extends BaseTest {

    private final String userLogin = "technopol37";
    private final String userPassword = "technopolisPassword";
    private final String wrongLogin = "";
    private final String wrongPassword = "";
    private final String expectedUrl = "https://ok.ru/dk?st.cmd=anonym2FAPhoneConfirm";

    @Test
    @Tag("Login")
    public void LoginTest() {
        assertTrue(page.loginAndRedirect(userLogin, userPassword).isHaveElement());
    }

    @Test
    @Tag("Login")
    public void twoFauthTest() {
        assertAll("2FA page tests",
                () -> assertTrue(page.loginAndRedirect(ConfProperties.getDetails("login"),
                        ConfProperties.getDetails("password")).isHaveElement()),
                () -> assertEquals(expectedUrl, url()));
    }


    @Test
    @Tag("Login")
    @Tag("negative")
    public void NegativeTestWrongPassword() {
        page.loginAndRedirect(userLogin, wrongPassword);
        assertTrue(page.isHaveElement());
    }

    @Test
    @Tag("Login")
    @Tag("negative")
    public void NegativeTestWrongUsername() {
        page.loginAndRedirect(wrongLogin, userPassword);
        assertTrue(page.isHaveElement());
    }

}
