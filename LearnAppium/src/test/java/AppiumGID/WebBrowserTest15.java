package AppiumGID;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WebBrowserTest15 extends WebBrowserTestBase15 {

    private AppiumDriverLocalService appiumDriverLocalService ;

    @Test
    public void fillForm() throws InterruptedException {


       // we can directly start with the get method to open website in mobile chorme browser
        //because the chrome is initiated in beforeTest method -> uiAutomator2Options.setCapability("browserName", "Chrome")
        androidDriver.get("https://rahulshettyacademy.com/angularAppdemo/");
//       androidDriver.get("https://www.google.com/");
//        androidDriver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//        androidDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));

        System.out.println("performed web browser test on mobile successfully!!!....");


    }



}



