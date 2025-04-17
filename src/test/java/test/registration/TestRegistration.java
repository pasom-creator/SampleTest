package test.registration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegistration extends BaseTest {

    @DisplayName("Test registration")
    @Test
    public void newUserRegistrationTest() {
        assertTrue(page.goToRegistrationPage().checkPageHeader());
    }
}
