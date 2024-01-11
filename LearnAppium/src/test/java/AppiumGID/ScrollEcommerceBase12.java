package AppiumGID;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ScrollEcommerceBase12 {
    public AppiumDriverLocalService appiumDriverLocalService;
    public UiAutomator2Options uiAutomator2Options;
    public AndroidDriver androidDriver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        //start the server programmatically
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();

        uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel7API33");
        uiAutomator2Options
                .setApp("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\LearnAppium\\src\\test\\java\\resources\\General-Store.apk");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);

        //below code is to apply global implicit wait
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //code above is common for all tests
    }

    //@AfterClass
    public void tearDown() {
        androidDriver.quit();

        appiumDriverLocalService.stop(); //To stop server
    }

   /* public void longPressJsexecutor(WebElement peopleNamesElemet){
        //Long tap gesture
        ((JavascriptExecutor)androidDriver)
                .executeScript("mobile: longClickGesture",
                        ImmutableMap.of( "elementId", ((RemoteWebElement) peopleNamesElemet).getId(),
                                "duration", 2000));
    }


    public void scrollToEndAction(){

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver)
                    .executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "down",
                            "percent", 3.0
                    ));
        }while(canScrollMore);
    }

    public void swipeLeftFrom(WebElement firstImage, String direction ){
        //Swipe code
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)firstImage ).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public void dragAndDropAction(WebElement sourceElement, int endX, int endY ){
        //Drag and Drop gesture code
        ((JavascriptExecutor) androidDriver).executeScript
                (
                        "mobile: dragGesture", ImmutableMap.of
                                (
                                        "elementId", ((RemoteWebElement) sourceElement).getId(),
                                        "endX", endX,
                                        "endY", endY
                                ));
    }*/
}
