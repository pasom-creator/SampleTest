package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By userField = By.xpath("//*[contains(@class, 'tico') and contains(@class, 'ellip')]");

    public void getCurrentUser() {
        haveText(userField,"technopol37 technopol37");
    }
}
