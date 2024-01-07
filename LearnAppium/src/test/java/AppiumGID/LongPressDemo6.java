package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LongPressDemo6 extends LLongPressDemoBase6 {

    @Test
    public void AppiumTest1() throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have following type of locators
        // xpath , id,className, accessibilityId, androidUIAutomator
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNames = androidDriver.findElement(
                                            By.xpath("//android.widget.TextView[@text='People Names']")
                                                        );
        longPressJsexecutor(peopleNames);
       //Long tap gesture moved to base class method
//        ((JavascriptExecutor)androidDriver)
//                .executeScript(
//                                  "mobile: longClickGesture",
//                                  ImmutableMap.of( "elementId", ((RemoteWebElement) peopleNames).getId(),
//                                  "duration", 2000)
//                              );
        String menuText = androidDriver.findElement(By.id("android:id/title")).getText();

        //Assert the Sample menu is equals to actual menu text
        Assert.assertEquals(menuText, "Sample menu");

        //Assert the Sample menu is displayed or not
        Assert.assertTrue(androidDriver.findElement(By.id("android:id/title")).isDisplayed());

        Thread.sleep(5000);

    }
}
