package testBaseUtils;

import androidActionsUtils.AppiumCommonActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;
import pageObjects.android.LetsGoPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class WFlashBeforeEachTestAndroid extends AppiumCommonActions {
    public AppiumDriverLocalService appiumDriverLocalService;
    public UiAutomator2Options uiAutomator2Options;
    public AndroidDriver androidDriver;
    public LetsGoPage letsGoPage;



    @BeforeClass
    public void configureAppium() throws IOException {

        // Reading properties from file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configResources\\data.properties");
        prop.load(fis);
        String iPAddress = prop.getProperty("ipAddress");
        String port =prop.getProperty("port");
        String androidDeviceName = prop.getProperty("androidDeviceName");

        //start the server programmatically
        appiumDriverLocalService = startAppiumServer(iPAddress, port );

        uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName(androidDeviceName); // uiAutomator2Options.setDeviceName("Pixel7API33");

        //uiAutomator2Options.setApp("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\AppiumPOMProject\\src\\test\\java\\resources\\app-debug 2301.apk");
        uiAutomator2Options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\app-debug 2301.apk");

        uiAutomator2Options.autoGrantPermissions();

        //androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
        androidDriver = new AndroidDriver(appiumDriverLocalService.getUrl(), uiAutomator2Options);

        //below code is to apply global implicit wait
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //code above is common for all tests
        letsGoPage = new LetsGoPage(androidDriver); // created the first screen object inside before class method
    }



    private void startAppiumServer() {
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();
    }

    // @AfterClass
    public void tearDown() {
        androidDriver.quit();

        appiumDriverLocalService.stop(); //To stop server
    }
}
