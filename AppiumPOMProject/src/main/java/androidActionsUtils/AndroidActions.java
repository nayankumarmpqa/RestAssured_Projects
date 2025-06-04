package androidActionsUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class AndroidActions extends AppiumCommonActions {

    AndroidDriver androidDriver;

    public AndroidActions(AndroidDriver androidDriver) {
        //super(androidDriver);
        this.androidDriver = androidDriver;
    }


    public void longClickGesture(WebElement element) {
        //Long tap gesture
        ((JavascriptExecutor) androidDriver)
                .executeScript("mobile: longClickGesture",
                        ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                                "duration", 2000));
    }

    public void scrollToEndAction() throws InterruptedException {
        Dimension dimension = androidDriver.manage().window().getSize();
        int screenHeight = dimension.getHeight();
        int screenWidth = dimension.getWidth();

        boolean canScrollMore;

        do {
            // Using try-catch to handle unexpected JavaScript errors gracefully
            try {
                canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", 10,
                        "top", screenHeight / 5,
                        "width", screenWidth - 20,
                        "height", screenHeight / 2,
                        "direction", "down",
                        "percent", 1
                ));
            } catch (Exception e) {
                System.out.println("⚠️ Scroll gesture failed: " + e.getMessage());
                break; // Exit loop if scroll fails
            }

            Thread.sleep(500);
        } while (canScrollMore);
    }


    public void swipeUpGesture(){
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100,
                "top", 500,
                "width", 300,
                "height", 600,
                "direction", "up",
                "percent", 0.75
        ));

    }


    public void swipeLeftFrom(WebElement firstImage, String direction) {
        //Swipe code
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstImage).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public void dragAndDropAction(WebElement sourceElement, int endX, int endY) {
        //Drag and Drop gesture code
        ((JavascriptExecutor) androidDriver).executeScript
                (
                        "mobile: dragGesture", ImmutableMap.of
                                (
                                        "elementId", ((RemoteWebElement) sourceElement).getId(),
                                        "endX", endX,
                                        "endY", endY
                                ));
    }


    public void scrollToTextGesture(String text) {

        androidDriver.findElement(
                //androidUIAutomator by google method to scroll
                (AppiumBy.androidUIAutomator
                        (
                                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"
                        )));
    }

    public void waitForElementToBeVisible(int sec, WebElement element){
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void pressByCoordinates () {
        new TouchAction(androidDriver)
                .press(point(950,2300))
                .waitAction(waitOptions(ofSeconds(1)))
                .release()
                .perform();
    }

    public void tapTopMiddleByCoordinates() {
        TouchAction<?> action = new TouchAction<>(androidDriver);

        for (int i = 0; i < 2; i++) {
            action
                    .press(PointOption.point(500, 100))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))) // Short wait between taps
                    .release()
                    .perform();
        }
    }

    public void activateApp() {
        //screen to home page
        Activity activity = new Activity(" com.whistle.whistle.beta", "com.whistle.whistle.MainActivity");

        // Command i used is ---- adb shell dumpsys window | find "mCurrentFocus"
        //  output  ----   mCurrentFocus=Window{1dbe151 u0 com.whistle.whistle.beta/com.whistle.whistle.MainActivity}

        //driver.startActivity(activity);
        ((JavascriptExecutor)androidDriver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.whistle.whistle.beta/com.whistle.whistle.MainActivity"));

    }

    public void navigateBackFromScreen() {
        androidDriver.navigate().back();
    }
    public void hideKeyboardIfVisible() {
            androidDriver.hideKeyboard();
    }


}
