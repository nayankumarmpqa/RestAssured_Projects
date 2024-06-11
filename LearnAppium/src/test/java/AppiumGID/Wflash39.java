package AppiumGID;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class Wflash39 extends WFlash39BaseClassFile {

    @Test(dataProvider = "data-provider")
    public void AppiumTest1(String un, String pw) throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class
        // finding and clicking locator
        // in Appium we have the following types of locators
        // xpath , id,className, accessibilityId, androidUIAutomator

        //androidDriver.findElement(By.className("android.widget.Button")).click(); // Let's Go button
        androidDriver.findElement(By.xpath("//android.view.View[@index=1]")).click();

        //WebElement webElementUserId = androidDriver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
        androidDriver.findElement(By.className("android.widget.EditText")).click(); // Username Input field

        androidDriver.findElement(By.className("android.widget.EditText")).sendKeys(un); // Sending username

        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();

        androidDriver.findElement(By.xpath("//android.widget.EditText[@index='4']")).sendKeys(pw); // sending password

        androidDriver.hideKeyboard();

        Thread.sleep(2000);
        androidDriver.findElement(By.xpath("//android.view.View[@index='6']")).click();
        Thread.sleep(5000);

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.tap(PointOption.point(900, 2220)).perform();
        Thread.sleep(2000);
        touchAction.tap(PointOption.point(900, 2220)).perform();

        androidDriver.findElement(AppiumBy.accessibilityId("Profile")).click();
        touchAction.tap(PointOption.point(900, 2220)).perform();
        Thread.sleep(2000);

        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Your information']")).click();

        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Log out']")).click();

        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Log out']")).click();



//        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
//        androidDriver.findElement(By.id("android:id/checkbox")).click();
//        androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//
//        String alertTitle = androidDriver.findElement(By.id("android:id/alertTitle")).getText();
//        Assert.assertEquals(alertTitle, "WiFi settings");
//
//        androidDriver.findElement(By.id("android:id/edit")).sendKeys("Nayan wifi");
//        androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        //tearDown(); will be automatically invoked as @Afterclass method in parent class
    }


    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"nayan.kumar.ext+187am2@whistle.com", "T3stf1rst"},
                {"nkorth@outlook.com", "Whistle1"}
//                {"nayan.kumar.ext+am6-2@whistle.com", "T3stf1rst1"},
//                {"nayan.kumar.ext+w04w@whistle.com", "T3stf1rst2"},
//                {"nayan.kumar.ext+15aug@whistle.com", "T3stf1rst2"},
//                {"nayan.kumar.ext+fm@whistle.com", "T3stf1rst"},
//
        };
    }
}


