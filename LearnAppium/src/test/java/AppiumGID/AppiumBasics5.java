package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AppiumBasics5 extends BeforeEachTest5 {

    @Test
    public void AppiumTest1() throws MalformedURLException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have following type of locators
        // xpath , id,className, accessibilityId, androidUIAutomator
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        androidDriver.findElement(By.id("android:id/checkbox")).click();
        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle = androidDriver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        androidDriver.findElement(By.id("android:id/edit")).sendKeys("Nayan wifi");
        androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        //tearDown(); will be automatically invoked as @Afterclass method in parent class
    }
}
