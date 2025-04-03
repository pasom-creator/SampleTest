import pageObject.BasePage;
import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private final By header = By.cssSelector(".ext-registration_h");

    public String getHeader() {
        return readText(header);
    }
}