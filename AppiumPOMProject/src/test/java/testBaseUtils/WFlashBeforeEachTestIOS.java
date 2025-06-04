package testBaseUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;
import pageObjects.android.LetsGoPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WFlashBeforeEachTestIOS {
    public AppiumDriverLocalService appiumDriverLocalService;
    public UiAutomator2Options uiAutomator2Options;
    public AndroidDriver androidDriver;
    public IOSDriver iOSDriver;
    public LetsGoPage letsGoPage;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        //start the server programmatically
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();

        XCUITestOptions optioniOS = new XCUITestOptions();
        optioniOS.setDeviceName("iPhone 14 Pro");
        optioniOS.setApp("iOS app path");
        optioniOS.setPlatformName("18.5");
        //Appium > Web driver Agent > iOS Apps automation. in the backend
        optioniOS.setWdaLaunchTimeout(Duration.ofSeconds(20));

        iOSDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), optioniOS);
        //below code is to apply global implicit wait
        iOSDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //code above is common for all tests
        letsGoPage = new LetsGoPage(androidDriver); // created the first screen object inside before class method
    }

/*      uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel7API33");
        uiAutomator2Options
                .setApp("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\LearnAppium\\src\\test\\java\\resources\\app-debug 9 Jan-2.apk");
        uiAutomator2Options.autoGrantPermissions();  // To accepting the permission dialogs
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);

        //below code is to apply global implicit wait
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //code above is common for all tests
        letsGoPage = new LetsGoPage(androidDriver); // created the first screen object inside before class method
*/

   // @AfterClass
    public void tearDown() {
        androidDriver.quit();

        appiumDriverLocalService.stop(); //To stop server
    }
}
