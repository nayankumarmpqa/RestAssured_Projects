package androidActionsUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class AppiumCommonActions {

    AppiumDriver driver; // AppiumDriver is parent class of android or IOS driver classes
    AppiumDriverLocalService appiumDriverLocalService;
//    public AppiumCommonActions(AppiumDriver driver) { // no matter android or IOS driver, it will handle
//        this.driver = driver;
//    }

//Appium server start method
public AppiumDriverLocalService startAppiumServer(String iPAddress, String port) {
    appiumDriverLocalService = new AppiumServiceBuilder()
            .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
            .withIPAddress(iPAddress)
            .usingPort(Integer.parseInt(port))
            .build();
    appiumDriverLocalService.start();
    return appiumDriverLocalService;
}
    // code for string management etc
    public Double getaDouble(int noOfItems, Double sumContainer, WebElement elementID, AppiumDriver driver) {
        for (int i = 0; i < noOfItems; i++) {
            String priceString = driver.findElements(By.id("elementID")).get(i).getText();
            Double priceAsDouble = Double.parseDouble(priceString.substring(1));
            sumContainer = sumContainer + priceAsDouble;
        }
        return sumContainer;
    }


    //code for common waiting for screen title to appear
    public void waitForElementToAppear(WebElement element, String screenTitle, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((element), "text", screenTitle));
    }

}
