package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.PrimitiveIterator;

public class LetsGoPage {
    AndroidDriver androidDriver;

    public LetsGoPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "Whistle Logo Name")
    private WebElement logo;
    @AndroidFindBy(xpath = "//android.view.View[@index=1]")
    private WebElement letsGoButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Family or friend?']")
    private WebElement familyOrFriend;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Check your messages for an invite link']")
    private WebElement checkYourMessageDialog;

    @AndroidFindBy(xpath = ("//android.widget.TextView)[2]"))
    private WebElement dialogMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Got it']")
    private WebElement gotItButton;

    public boolean isWhistleLogoDisplayed() {
        return logo.isDisplayed();
    }

    public WhatsYourEmailPage letsGoButtonClick() {
        letsGoButton.click();
        //also
        return new WhatsYourEmailPage(androidDriver);
    }

    public boolean isFamilyOrFriendDisplayed() {
        return familyOrFriend.isDisplayed();
    }

    public void clickFamilyOrFriendLink() {
        familyOrFriend.click();
    }

    public void getDialogTitle() {
        System.out.println(checkYourMessageDialog.getText());
    }

    public void clickGotIt() {
        gotItButton.click();
    }

    /*@AndroidFindBy(id = "Image of a dog")
    private WebElement imageOfDog;

    public boolean isDogImageDisplayed() {
        return imageOfDog.isDisplayed();
    }*/

}
