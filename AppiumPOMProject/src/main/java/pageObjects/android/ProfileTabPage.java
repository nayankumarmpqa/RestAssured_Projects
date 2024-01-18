package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfileTabPage {
AndroidDriver androidDriver;
    public ProfileTabPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your information']")
    private WebElement yourInformationOption;

    public YourInformationPage clickYourInformationOption(){
        yourInformationOption.click();
        return new YourInformationPage(androidDriver);
    }


}
