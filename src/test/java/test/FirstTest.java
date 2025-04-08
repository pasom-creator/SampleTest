package test;

import org.junit.jupiter.api.Test;
import appconfigs.ConfProperties;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest extends BaseTest {

    private String userLogin = "technopol37";
    private String userPassword = "technopolisPassword";
    private String expectedUrl = "https://ok.ru/dk?st.cmd=anonym2FAPhoneConfirm";


    @Test
    public void newUserRegistration() {
        page.goToRegistrationPage().getPageHeader();
    }

    @Test
    public void checkSmsAuth() throws IOException {
        assertAll("2FA page tests",
                ()-> page.smsAuthorization(ConfProperties.getDetails("login"),
                        ConfProperties.getDetails("password")).findSmsButton(),
                ()->assertEquals(expectedUrl,page.getCurrentPageUrl()));
    }

    @Test
    public void checkUsername() {
        page.authorize(userLogin, userPassword).getCurrentUser();
    }
}

