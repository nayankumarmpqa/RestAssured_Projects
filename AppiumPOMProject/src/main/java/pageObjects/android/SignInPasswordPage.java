package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPasswordPage {
    AndroidDriver androidDriver;
    public SignInPasswordPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.widget.Button")
    private WebElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    private WebElement signInLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Reset Password']")
    private WebElement resetPasswordLink;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.EditText/android.view.View")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    private WebElement inputPassword;


    public boolean isSignInLabelDisplayed() {
        return signInLabel.isDisplayed();
    }

    public void clickResetPasswordLink() {
        if (resetPasswordLink.isDisplayed()) {
            resetPasswordLink.click();
        }
    }

    public void clickPasswordField() throws InterruptedException {
        passwordField.click();
        Thread.sleep(2000);
    }

    public void setInputPassword(String password) throws InterruptedException {
        inputPassword.click();
        Thread.sleep(3000);
        inputPassword.sendKeys(password);
        Thread.sleep(2000);
    }

    public HomeTabPage clickSignInButton() throws InterruptedException {
        signInButton.click();
        Thread.sleep(5000);
        return new HomeTabPage(androidDriver);
    }


}
