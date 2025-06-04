package testBaseUtils;

import androidActionsUtils.AppiumCommonActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObjects.android.LetsGoPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WFlashBeforeEachTestAndroid extends AppiumCommonActions {
    public AppiumDriverLocalService appiumDriverLocalService;
    public UiAutomator2Options uiAutomator2Options;
    public AndroidDriver androidDriver;
    public LetsGoPage letsGoPage;


    @BeforeClass(alwaysRun=true)
    public void configureAppium() throws IOException {
        System.out.println("// Configuring app in before class method");
        // Reading properties from file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configResources\\data.properties");
        prop.load(fis);
        String ipAddress = System.getProperty("ipAddress")!=null? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
        //String iPAddress = prop.getProperty("ipAddress");
        String port =prop.getProperty("port");
        String androidDeviceName = prop.getProperty("androidDeviceName");

        //start the server programmatically
        appiumDriverLocalService = startAppiumServer(ipAddress, port );

        uiAutomator2Options = new UiAutomator2Options();

        // uiAutomator2Options.setDeviceName("Pixel7API33");
        uiAutomator2Options.setDeviceName(androidDeviceName);

        //uiAutomator2Options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\app-beta-release 50.apk");
        uiAutomator2Options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\Flash v6.0.2.0 (89).apk");

        uiAutomator2Options.autoGrantPermissions();

        //androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
        //androidDriver = new AndroidDriver(appiumDriverLocalService.getUrl(), uiAutomator2Options);

        //below code is to apply global implicit wait
       // androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //code above is common for all tests
       // letsGoPage = new LetsGoPage(androidDriver); // created the first screen object inside before class method
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        // Quit driver and stop Appium server after all tests
        if (androidDriver != null) {
            androidDriver.quit();
        }
        if (appiumDriverLocalService != null) {
            appiumDriverLocalService.stop();
        }
    }

    // Below method moveed to AppiumCommonActions class
   /* private void startAppiumServer() {
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();
    }*/
}
