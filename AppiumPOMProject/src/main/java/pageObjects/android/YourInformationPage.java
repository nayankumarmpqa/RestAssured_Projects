package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage extends AndroidActions {
AndroidDriver androidDriver;
    public YourInformationPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log out']")
    private WebElement logOutOption;

    public void clickLogOutOption() throws InterruptedException {
        logOutOption.click();
        Thread.sleep(2000);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log out']")
    private WebElement logOutConfirmation;

    public void clickLogOutConfirmation() throws InterruptedException {
        logOutConfirmation.click();
        Thread.sleep(7000);
    }


}
