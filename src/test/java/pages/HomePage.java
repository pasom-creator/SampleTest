package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By userField = By.xpath(".//*[@class = 'tico ellip']");
    private final String userName = "technopol37 technopol37";

    public boolean checkCurrentUser() {
        return isHaveText(userField, userName);
    }
}
