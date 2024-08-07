package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WhistleSetupPage extends AndroidActions {
AndroidDriver androidDriver;
    public WhistleSetupPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    // androidDriver.findElement(By.xpath("//android.view.View[@index=3]")).click();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
    private WebElement profileTabNavButton;

    public ProfileTabPage clickProfileTabNavButton(){
        profileTabNavButton.click();
         return new ProfileTabPage(androidDriver);
    }

}
