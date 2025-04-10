package test.registration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseTest;

public class TestRegistration extends BaseTest {

    @DisplayName("Test registration")
    @Test
    public void newUserRegistration() {
        page.goToRegistrationPage().getPageHeader();
    }
}
