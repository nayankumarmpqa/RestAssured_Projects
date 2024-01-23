package androidActionsUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumCommonActions{

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

    public void scrollToEndAction() {

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver)
                    .executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "down",
                            "percent", 3.0
                    ));
        } while (canScrollMore);
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


    public void scrollToTextGesture(String text){

        androidDriver.findElement(
                //androidUIAutomator by google method to scroll
                (AppiumBy.androidUIAutomator
                        (
                                "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"
                        )));
    }


}
