package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WhatsYourEmailPage extends AndroidActions {
    AndroidDriver androidDriver;

    public WhatsYourEmailPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Whats your email address?']")
    private WebElement whatsYourEmailScreenTitle;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement usernameField;
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement usernameFieldInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
    private WebElement nextButtonToEnterPassword;

    @AndroidFindBy(className = "UIAKeyboard")
    private WebElement keyboard;

    public boolean isUserNameFieldDisplayed() {
        return usernameFieldInput.isDisplayed();
    }

    public void clickAndSetUsernameField(String userEmail) throws InterruptedException {
        usernameField.click();
        usernameFieldInput.sendKeys(userEmail);
        Thread.sleep(3000);
    }

    public SignInPage clickNextButton() throws InterruptedException {
        nextButtonToEnterPassword.click();
        Thread.sleep(3000);
        return new SignInPage(androidDriver);
    }

    public boolean isWhatsYourEmailLabelDisplayed() {
        return whatsYourEmailScreenTitle.isDisplayed();
    }

    public void checkAndClickCreatePasswordButton() {
        if (nextButtonToEnterPassword.isDisplayed()) {
            nextButtonToEnterPassword.click();
        }
    }

    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
            androidDriver.hideKeyboard();
        }
    }
}
