import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class FirstTest {
    private SignInPage page;

    @BeforeAll
    public static void setupConfig() {
        Configuration.browser = "firefox";
        Configuration.timeout = 8000;
        Configuration.headless = false;
    }

    @BeforeEach
    public void setUp() {
        page = new SignInPage();
        page.open();
    }

    @AfterEach
    public void close() {
        System.out.println("Test finished.");
    }

    @Test
    public void test1() {
        String expected = "Введите номер телефона";
        String actual = page.goToRegistrationPage().getHeader();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() throws IOException {
        String expected = "https://ok.ru/dk?st.cmd=anonym2FAPhoneConfirm";
        String actual = page.authorize(ConfProperties.getDetails("login"),
                ConfProperties.getDetails("password")).getCurrentPageUrl();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expected = "technopol37 technopol37";
        String actual = page.authorize("technopol37", "technopolisPassword").checkHeader();
        Assertions.assertEquals(expected, actual);
    }
}

