package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LetsGoPage {
    AndroidDriver androidDriver;

    public LetsGoPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    // androidDriver.findElement(By.xpath("//android.view.View[@index=3]")).click();
    @AndroidFindBy(xpath = "//android.view.View[@index=3]")
    private WebElement letsGoButton;

    public WhatsYourEmailPage letsGoButtonClick() {
        letsGoButton.click();
        //also
        return new WhatsYourEmailPage(androidDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to']")
    private WebElement welcomeLabel;

    public boolean isWelcomeLabelDisplayed(){
        return welcomeLabel.isDisplayed();
    }
    @AndroidFindBy(id = "Whistle Logo Name")
    private WebElement logo;

    public boolean isWhistleLogoDisplayed() {
        return logo.isDisplayed();
    }

    @AndroidFindBy(id = "Image of a dog")
    private WebElement imageOfDog;

    public boolean isDogImageDisplayed() {
        return imageOfDog.isDisplayed();
    }

}
