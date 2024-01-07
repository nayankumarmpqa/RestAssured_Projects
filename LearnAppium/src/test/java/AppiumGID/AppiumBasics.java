package AppiumGID;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {

    @Test
    public void AppiumTest1() throws MalformedURLException {


        //start the server manually on cmd
        // then this code below works
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options
                .setDeviceName("Pixel7API33");
        uiAutomator2Options
                .setApp("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\LearnAppium\\src\\test\\java\\resources\\" +
                        "app-debug 03 Jan.apk");


        // Appium code > Appium server > mobile
        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
        //androidDriver.quit();

        //stop server
    }
}
