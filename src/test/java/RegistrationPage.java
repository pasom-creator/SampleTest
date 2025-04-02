import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.BasePage;

public class RegistrationPage extends BasePage {

    private By header = By.cssSelector(".ext-registration_h");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getHeader(){
        return readText(header);
    }

}