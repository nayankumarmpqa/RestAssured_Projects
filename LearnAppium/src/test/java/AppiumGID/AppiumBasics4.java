package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class AppiumBasics4 extends BeforeEachTest {

    @Test
    public void AppiumTest1() throws MalformedURLException {
        configureAppium();
        // finding and clicking locator
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        tearDown();
    }
}
