package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AppiumBasics5 extends BeforeEachTest5 {

    @Test
    public void AppiumTest1() throws MalformedURLException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();

        //tearDown(); will be automatically invoked as @Afterclass method in parent class
    }
}
