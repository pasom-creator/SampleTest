import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class FirstTest {
    private WebDriver driver;
    private SignInPage page;

    @BeforeAll
    public static void SetupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        page = new SignInPage(driver);
        page.open();
    }

    @AfterEach
    public void close() {
        driver.close();
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
        String actual = page.authorize(new ConfProperties().getDetails("login"),
                new ConfProperties().getDetails("password")).getCurrentPageUrl();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expected = "technopol37 technopol37";
        String actual = page.authorize("technopol37", "technopolisPassword").checkHeader();
        Assertions.assertEquals(expected, actual);
    }
}

