import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.BasePage;

public class HomePage extends BasePage {

    private By buttonUsername = By.cssSelector("div.ellip:nth-child(1)");
    private By headerUsername= By.cssSelector(".__user-profile-name-decorator");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String checkHeader(){
        click(buttonUsername);
        return readText(headerUsername);
    }
}
