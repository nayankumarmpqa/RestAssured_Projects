package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AndroidActions {
    AndroidDriver androidDriver;
    public SignInPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    @AndroidFindBy(className = "UIAKeyboard")
    private WebElement keyboard;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    private WebElement signInScreenTitle;

    @AndroidFindBy(xpath = "//*[@text='Help me find my password.']")
    private WebElement  helpMeLink;

   /* @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.EditText/android.view.View")
    private WebElement passwordField;*/

    /*@AndroidFindBy(xpath = "//android.view.View[@Index='2']")*/
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement inputPasswordField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in']")
    private WebElement signInButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot password?']")
    private WebElement forGotPasswordLink;


    public boolean isSignInScreenTitleDisplayed() {
        return signInScreenTitle.isDisplayed();
    }
    public boolean isHelpMeLinkEnabled() {
        return helpMeLink.isEnabled();
    }

    public void clickResetPasswordLink() {
        if (forGotPasswordLink.isDisplayed()) {
            forGotPasswordLink.click();
        }
    }

    public void clickPasswordField() throws InterruptedException {
        waitForElementToBeVisible(10,inputPasswordField);
        inputPasswordField.click();
        System.out.println("Clicked inside password");
        Thread.sleep(2000);
    }

    public void setInputPassword(String password) throws InterruptedException {
        waitForElementToBeVisible(10,inputPasswordField);
        inputPasswordField.sendKeys(password);
        Thread.sleep(2000);

        if (keyboard != null) {
            androidDriver.hideKeyboard();
        }

    }

    public HomeTabPage clickSignInButton() throws InterruptedException {
        waitForElementToBeVisible(10,signInButton);
        signInButton.click();
        Thread.sleep(10000);
        return new HomeTabPage(androidDriver);
    }

    public ForgotPasswordPage clickForgotPasswordLink() throws InterruptedException {
        forGotPasswordLink.click();
        Thread.sleep(5000);
        return new ForgotPasswordPage(androidDriver);
    }



}
