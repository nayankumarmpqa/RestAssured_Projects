package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.KeyEvent;

public class WhatsYourEmailPage {
AndroidDriver androidDriver;
    public WhatsYourEmailPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement usernameFieldInput;

    public boolean isUserNameFieldDisplayed(){
        return usernameFieldInput.isDisplayed();
    }


    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement usernameField;

    public void clickAndSetUsernameField(String useremail) throws InterruptedException {
        usernameField.click();
        Thread.sleep(7000);
        usernameFieldInput.sendKeys(useremail);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Password']")
    private WebElement enterPasswordButton;

    public SignInPasswordPage clickEnterPasswordButton() throws InterruptedException {
        enterPasswordButton.click();
        Thread.sleep(2000);
        return new SignInPasswordPage(androidDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Whats your email address?']")
    private WebElement whatsYourEmailLabel;

    public boolean isWhatsYourEmailLabelDisplayed() {
        return whatsYourEmailLabel.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Password']")
    private WebElement createPasswordButton;
    public void checkAndClickCreatePasswordButton(){
        if(createPasswordButton.isDisplayed()){
            createPasswordButton.click();
        }
    }

    @AndroidFindBy(className = "UIAKeyboard")
    private WebElement keyboard;
    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            androidDriver.hideKeyboard();
        }
    }
}
