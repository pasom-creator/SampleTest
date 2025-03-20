import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Test
    public void testTrueIsTrue() {
        assertTrue(isEven(4));
        assertTrue(isEven(6));
    }
}
