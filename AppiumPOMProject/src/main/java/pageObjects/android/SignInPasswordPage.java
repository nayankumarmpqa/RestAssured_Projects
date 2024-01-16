package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPasswordPage {
AndroidDriver androidDriver;
    public SignInPasswordPage(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.EditText/android.view.View")
    private WebElement passwordField;

    public void clickPasswordField() throws InterruptedException {
        passwordField.click();
        Thread.sleep(2000);
    }

    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    private WebElement inputPassword;

    public void setInputPassword(String password) throws InterruptedException {
        inputPassword.click();
        Thread.sleep(3000);
        inputPassword.sendKeys(password);
        Thread.sleep(2000);
    }

    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.widget.Button")
    private WebElement signInButton;

    public void clickSignInButton() throws InterruptedException {
        signInButton.click();
        Thread.sleep(5000);

    }


}
