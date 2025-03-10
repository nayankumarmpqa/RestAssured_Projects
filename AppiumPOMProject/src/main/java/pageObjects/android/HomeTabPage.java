package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class HomeTabPage extends AndroidActions {
AndroidDriver androidDriver;
    public HomeTabPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    // androidDriver.findElement(By.xpath("//android.view.View[@index=3]")).click();

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Profile\"]")
    private WebElement profileTabNavButton;

    public ProfileTabPage clickProfileTabNavButton(){
        profileTabNavButton.click();
         return new ProfileTabPage(androidDriver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement doThisLaterButton;

    public void clickDoThisLaterButton(){
        waitForElementToBeVisible(20,doThisLaterButton);
        doThisLaterButton.click();
    }


    public void pressByCoordinates () {
        new TouchAction(androidDriver)
                .press(point(950,2300))
                .waitAction(waitOptions(ofSeconds(1)))
                .release()
                .perform();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Location\"]")
    private WebElement locationTabButton;

    public boolean isLocationTabPresent() {
        List<WebElement> elements = androidDriver.findElements(By.xpath("//android.widget.TextView[@text='Location']"));
        return !elements.isEmpty(); // Returns false if not found
    }



}
