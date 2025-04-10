package test.login;

import appconfigs.ConfProperties;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import java.io.IOException;

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
    public void TestLogin() {
        page.authorize(userLogin, userPassword).getCurrentUser();
    }

    @Test
    @Tag("Login")
    public void Test2Fauth()throws IOException {
        assertAll("2FA page tests",
                ()-> page.smsAuthorization(ConfProperties.getDetails("login"),
                        ConfProperties.getDetails("password")).findSmsButton(),
                ()->assertEquals(expectedUrl,url()));
    }


    @Test
    @Tag("Login")
    @Tag("negative")
    public void TestNegativeWrongPassword(){
        page.wrongInput(userLogin,wrongPassword);
        assertTrue(page.isError());
    }

    @Test
    @Tag("Login")
    @Tag("negative")
    public void TestNegativeWrongUsername(){
        page.wrongInput(wrongLogin,userPassword);
        assertTrue(page.isError());
    }

}
