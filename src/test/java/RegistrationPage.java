import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.BasePage;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getElement(){
        WebElement element = getDriver().findElement(By.cssSelector(".ext-registration_h"));
        return element.getText();
    }
}