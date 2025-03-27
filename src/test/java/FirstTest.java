import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    public void Test2(){
        String expected = "https://ok.ru/dk?st.cmd=anonym2FAPhoneConfirm";
        String actual = page.authorize("ma-x-us@bk.ru","Ui83nhdjfyu74").getPageUrl();
        Assertions.assertEquals(expected,actual);
    }
}

