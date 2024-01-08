package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class Wflash1 extends WFlashBeforeEachTest {

    @Test(dataProvider = "data-provider")
    public void AppiumTest1(String un, String pw) throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class
        // finding and clicking locator
        // in Appium we have the following types of locators
        // xpath , id,className, accessibilityId, androidUIAutomator

        androidDriver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View")).click();
        //WebElement webElementUserId = androidDriver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
       androidDriver.findElement(By.className("android.widget.EditText")).click();
//androidDriver.findElement(By.xpath("//android.widget.TextView[@text='username']")).click();
        Thread.sleep(5000);
        //webElementUserId.click();
       // webElementUserId.sendKeys(un);
        androidDriver.findElement(By.className("android.widget.EditText")).sendKeys(un);
        androidDriver.findElement(AppiumBy.className("android.widget.Button")).click();

        WebElement webElementPassword = androidDriver.findElements(AppiumBy.className("android.widget.EditText")).get(1);
        webElementPassword.click();
        webElementPassword.sendKeys(pw);

        Thread.sleep(2000);
        WebElement webElementSignInButton =androidDriver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View/android.widget.Button"));
        webElementSignInButton.click();

        Thread.sleep(5000);


        androidDriver.findElement(AppiumBy.accessibilityId("Profile")).click();
        //androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[4]/android.widget.TextView")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Your information']")).click();

        //androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.TextView")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Log out']")).click();
        Thread.sleep(2000);
        //androidDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Log out']")).click();

        Thread.sleep(2000);

        androidDriver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View")).click();
        Thread.sleep(2000);

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
                {"nayan.kumar.ext+am6-2@whistle.com", "T3stf1rst1"},
                {"nayan.kumar.ext+w04w@whistle.com", "T3stf1rst2"},
                {"nayan.kumar.ext+15aug@whistle.com", "T3stf1rst2"},
                {"nayan.kumar.ext+fm@whistle.com", "T3stf1rst"},
                {"nkorth@outlook.com", "Whistle1"}
        };
    }
}


