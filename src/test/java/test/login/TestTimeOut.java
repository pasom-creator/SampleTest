package test.login;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.BaseTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TestTimeOut extends BaseTest {

    private final String userLogin = "technopol37";
    private final String userPassword = "technopolisPassword";

    @Test
    @Tag("Login")
    public void assertTimeoutWithMessage() {
        assertTimeout(Duration.ofSeconds(15),() -> {
            page.authorize(userLogin, userPassword).getCurrentUser();
        }, "Performance issue.");
    }
}
