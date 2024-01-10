package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class DragDropDemo9 extends DragDropDemoBase9 {

    @Test
    public void AppiumTest1() throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have following type of locators
        // xpath , id,className, accessibilityId, androidUIAutomator
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement sourceElement = androidDriver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));


//        //Drag and Drop gesture code
//        ((JavascriptExecutor) androidDriver).executeScript("mobile: dragGesture",
//        ImmutableMap.of(
//                "elementId", ((RemoteWebElement)sourceElement ).getId(),
//                "endX", 619,
//                "endY", 560
//        ));

        dragAndDropAction(sourceElement, 619, 560); // Drag and Drop gesture code is moved to base class

        Thread.sleep(3000);

        String resultStatusMessage = androidDriver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(resultStatusMessage, "Dropped!");
    }
}
