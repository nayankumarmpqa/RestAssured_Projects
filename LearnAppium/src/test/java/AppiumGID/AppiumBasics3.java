package AppiumGID;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics3 {

    @Test
    public void AppiumTest1() throws MalformedURLException {


        //start the server programmatically
        AppiumDriverLocalService appiumDriverLocalService =new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        appiumDriverLocalService.start();

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel7API33");
        uiAutomator2Options
                .setApp("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\LearnAppium\\src\\test\\java\\resources\\ApiDemos-debug.apk");


        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);

        //code above is common for all tests


        // finding and clicking locator
        androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();

        //androidDriver.quit();

        //stop server
        appiumDriverLocalService.stop();
    }
}
