import pageObject.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By buttonUsername = By.cssSelector("div.ellip:nth-child(1)");
    private final By headerUsername = By.cssSelector(".__user-profile-name-decorator");

    public String checkHeader() {
        click(buttonUsername);
        return readText(headerUsername);
    }
}
