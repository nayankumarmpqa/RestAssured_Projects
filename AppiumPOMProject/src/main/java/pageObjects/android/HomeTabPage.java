package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeTabPage {
AndroidDriver androidDriver;
    public HomeTabPage(AndroidDriver androidDriver){
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
