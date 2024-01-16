package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WhatsYourEmailPage {
AndroidDriver androidDriver;
    public WhatsYourEmailPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement usernameFieldInput;


    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement usernameField;

    public void clickAndSetUsernameField(String useremail) throws InterruptedException {
        usernameField.click();
        Thread.sleep(7000);
        usernameFieldInput.sendKeys(useremail);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Password']")
    private WebElement enterPasswordButton;

    public void clickEnterPasswordButton() throws InterruptedException {
        enterPasswordButton.click();
        Thread.sleep(2000);
    }
}
