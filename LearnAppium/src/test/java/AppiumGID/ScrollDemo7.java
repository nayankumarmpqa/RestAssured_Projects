package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class ScrollDemo7 extends ScrollDemoBase7 {

    @Test
    public void AppiumTest1() throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have the following types of locators
        // xpath , id,className, accessibilityId, androidUIAutomator
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(
                //androidUIAutomator by google method to scroll
                (AppiumBy.androidUIAutomator
                        (
                                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"
                        )));

        Thread.sleep(3000);

        androidDriver.findElement(
                //androidUIAutomator by google method to scroll
                (AppiumBy.androidUIAutomator
                        (
                                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Animation\"));"
                        )));

        // OR we can use android-mobile-gestures javascript method we created in base class
        //scrollToEndAction();

        Thread.sleep(5000);

    }
}
