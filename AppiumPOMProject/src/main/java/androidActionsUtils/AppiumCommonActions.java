package androidActionsUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumCommonActions {

    AppiumDriver driver; // AppiumDriver is parent class of android or IOS driver classes

    public AppiumCommonActions(AppiumDriver driver) { // no matter android or IOS driver, it will handle
        this.driver = driver;
    }


    // code for string management etc
    public Double getaDouble(int noOfItems, Double sumContainer, WebElement elementID) {
        for (int i = 0; i < noOfItems; i++) {
            String priceString = driver.findElements(By.id("elementID")).get(i).getText();
            Double priceAsDouble = Double.parseDouble(priceString.substring(1));
            sumContainer = sumContainer + priceAsDouble;
        }
        return sumContainer;
    }


    //code for common waiting for screen title to appear
    public void waitForElementToAppear(WebElement element, String screenTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((element), "text", screenTitle));
    }

}
