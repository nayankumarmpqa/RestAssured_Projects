package pageObjects.android;

import androidActionsUtils.AndroidActions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.http.conn.util.PublicSuffixList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LetsGoPage extends AndroidActions {
    AndroidDriver androidDriver;

    public LetsGoPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Whistle Logo Name\"]")
    private WebElement logo;
    @AndroidFindBy(xpath = "//android.view.View[@index=1]")
    private WebElement letsGoButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family or friend?']")
    private WebElement familyOrFriendLink;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check your messages for an invite link']")
    private WebElement checkYourMessageDialog;

    @AndroidFindBy(xpath = ("//android.widget.TextView)[2]"))
    private WebElement dialogMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Got it']")
    private WebElement gotItButton;

    public boolean isWhistleLogoDisplayed() {
        return logo.isDisplayed();
    }

    //--------------------------
    // Methods
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public boolean isLetsGoButtonDisplayed() {
        return letsGoButton.isDisplayed();
    }

    public boolean isLetsGoButtonEnabled() {
        return letsGoButton.isEnabled();
    }

    public boolean isFamilyOrFriendTextDisplayed() {
        return familyOrFriendLink.isDisplayed();
    }
    public WhatsYourEmailPage letsGoButtonClick() {
        letsGoButton.click();
        //also return next screen/page object
        return new WhatsYourEmailPage(androidDriver);
    }

    //-------------------------------
    public boolean isFamilyOrFriendDisplayed() {
        return familyOrFriendLink.isDisplayed();
    }

    public void clickFamilyOrFriendLink() {
        familyOrFriendLink.click();
    }

    public void getDialogTitle() {
        System.out.println(checkYourMessageDialog.getText());
    }

    public void clickGotIt() {
        gotItButton.click();
    }

    public void setActivityToLaunchScreen() {
        Activity activity = new Activity("com.whistle.bolt.flash", "com.whistle.flash.MainActivity");
        ((JavascriptExecutor) androidDriver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.whistle.bolt.flash/com.whistle.flash.MainActivity"));


    }
}
