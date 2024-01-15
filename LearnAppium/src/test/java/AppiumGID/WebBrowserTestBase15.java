package AppiumGID;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebBrowserTestBase15 {
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
        uiAutomator2Options.setChromedriverExecutable("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\LearnAppium\\src\\test\\java\\resources\\chromedriver120.exe");

        //setting chrome option to use android web browser with selenium methods to automate
        uiAutomator2Options.setCapability("browserName", "Chrome");
        //uiAutomator2Options.setApp("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\LearnAppium\\src\\test\\java\\resources\\General-Store.apk");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
        //below code is to apply global implicit wait
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //code above is common for all tests
    }

    public Double getaDouble(int itemsInCart, Double cartPriceSum) {
        for (int i = 0; i < itemsInCart; i++) {
            String priceString = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            Double priceAsDouble = Double.parseDouble(priceString.substring(1));
            cartPriceSum = cartPriceSum + priceAsDouble;
        }
        return cartPriceSum;
    }

    //@AfterClass
    public void tearDown() {
        androidDriver.quit();

        appiumDriverLocalService.stop(); //To stop server
    }


}
