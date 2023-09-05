package AppiumGID;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AppPackageAndActivityBasics extends BeforeEachTest5 {

    @Test
    public void AppiumTest1() throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        // finding and clicking locator
        // in Appium we have following types of locators
        // xpath , id,className, accessibilityId, androidUIAutomator


        //Activity class object is to directly navigate to the desired screen
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        androidDriver.startActivity(activity);

        //Below code is not required
        // androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
        // androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();

        androidDriver.findElement(By.className("android.widget.CheckBox")).click();

        //code to Device rotation
        DeviceRotation deviceRotationObject =  new DeviceRotation(0,0,90);
        androidDriver.rotate(deviceRotationObject);

        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String actualAlertTitle = androidDriver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals(actualAlertTitle, "WiFi settings");

       // again rotating the device to view it properly
        DeviceRotation deviceRotationObject2 =  new DeviceRotation(90,0,0);
        androidDriver.rotate(deviceRotationObject2);
        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        //setting and getting ClipBoard text
        androidDriver.setClipboardText("My name is Nayan");
        androidDriver.findElement(By.className("android.widget.EditText")).sendKeys(androidDriver.getClipboardText());

        // Press Kye actions
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        androidDriver.findElement(By.id("android:id/button1")).click();


        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));

        Thread.sleep(5000);

    }
}
