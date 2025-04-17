package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final String userName = "technopol37 technopol37";

    @Override
    public boolean isHaveElement() {
        return isHaveText(userField,userName);
    }
}
