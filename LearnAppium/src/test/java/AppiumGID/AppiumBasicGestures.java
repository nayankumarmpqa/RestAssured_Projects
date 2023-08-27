package AppiumGID;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AppiumBasicGestures extends BeforeEachTest5 {

    @Test
    public void AppiumTest1() throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have following type of locators
        // xpath , id,className, accessibilityId, androidUIAutomator
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNames = androidDriver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        //Longtap gesture
        ((JavascriptExecutor)androidDriver)
                .executeScript("mobile: longClickGesture",
                        ImmutableMap.of( "elementId", ((RemoteWebElement) peopleNames).getId(),
                        "duration", 2000));

        Thread.sleep(5000);

    }
}
