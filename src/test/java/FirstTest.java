import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class FirstTest {
    private WebDriver driver;
    IndexPage page;

    @BeforeAll
    public static void SetupDriver(){
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp(){
        driver = new FirefoxDriver();
        page = new IndexPage(driver);
        page.open();
    }

    @AfterEach
    public void close(){
        driver.close();
    }

    @Test
    public void Test1() {
        String expected = "Введите номер телефона";
        String actual = page.clickButton().getElement();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test2() throws IOException {
        String expected = "https://ok.ru/dk?st.cmd=anonym2FAPhoneConfirm";
        String actual = page.authorize(new ConfProperties().getDetails("login"),
                new ConfProperties().getDetails("password")).getPageUrl();
        Assertions.assertEquals(expected,actual);
    }
}

