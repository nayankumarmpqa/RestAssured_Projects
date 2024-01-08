package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class SwipeDemo8 extends SwipeDemoBase8 {

    @Test
    public void AppiumTest1() throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have following type of locators
        // xpath , id,className, accessibilityId, androidUIAutomator
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();

        WebElement firstImage = androidDriver.findElement(By.xpath("//android.widget.ImageView[1]"));

        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");

//        //Swipe code
//        ((JavascriptExecutor) androidDriver).executeScript
//        (
//                "mobile: swipeGesture",
//                ImmutableMap.of
//                (
    //                "elementId", ((RemoteWebElement)firstImage ).getId(),
    //                "direction", "left",
    //                "percent", 0.75
//                )
//        );

        // Above swipe gesture code is moved to base class as a method
        swipeLeftFrom(firstImage, "left"); // swipe code moved to Base class

        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");

        Thread.sleep(5000);

    }
}
