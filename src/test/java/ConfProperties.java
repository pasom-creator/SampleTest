import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfProperties {

    public String getDetails(String details) throws IOException {
        Properties props = new Properties();
        InputStream file = new FileInputStream(new File("src/test/resources/config.properties"));
        props.load(file);
        return props.getProperty(details);
    }
}
