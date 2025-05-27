package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityTabPage extends AndroidActions {
AndroidDriver androidDriver;
//Constructor
public ActivityTabPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Rotating Icon\"]")
    private WebElement syncActivityRotatingIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Profile\"]")
    private WebElement profileTabNavButton;


    // Actions---------------------------------------------

    public boolean isSyncActivityRotatingIconDisplayed() {
        return syncActivityRotatingIcon.isDisplayed();
    }

}
