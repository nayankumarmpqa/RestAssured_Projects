package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JournalListPage extends AndroidActions {
    AndroidDriver androidDriver;

    public JournalListPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Journal\"]")
    private WebElement journalListPageHealing;

    @AndroidFindBy(className = "UIAKeyboard")
    private WebElement keyboard;

    public boolean isCheckInHistoryListVisible() {
        return journalListPageHealing.isDisplayed();
    }

    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            androidDriver.hideKeyboard();
        }
    }
}
