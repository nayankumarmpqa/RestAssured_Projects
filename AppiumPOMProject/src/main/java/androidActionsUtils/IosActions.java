package androidActionsUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class IosActions {

    IOSDriver iOSDriver;

    public IosActions(IOSDriver iOSDriver) {

        this.iOSDriver = iOSDriver;
    }

// below are the example iOS actions, I will replace them with actual iOS actions later

    public void longClickGesture(WebElement element) {
        //Long tap gesture
        ((JavascriptExecutor) iOSDriver)
                .executeScript("mobile: longClickGesture",
                        ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                                "duration", 2000));
    }

  }
