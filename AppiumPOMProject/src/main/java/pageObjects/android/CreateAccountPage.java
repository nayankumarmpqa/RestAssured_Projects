package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends AndroidActions {
    AndroidDriver androidDriver;

    public CreateAccountPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create a Whistle account']")
    private WebElement createAccountScreenTitle;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View")
    private WebElement createPasswordInputField;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement signUpProductUpdatesCheckbox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of Use & Privacy Policy']")
    private WebElement termsOfUseLink;

    @AndroidFindBy(xpath = "//*[@text='Create account']")
    private WebElement createAccountButton;

    public boolean isCreateAccountScreenTitleDisplayed() {
        return createAccountScreenTitle.isDisplayed();
    }

    public void selectSignUpProductUpdatesCheckbox() {
        if (!signUpProductUpdatesCheckbox.isSelected()) {
            signUpProductUpdatesCheckbox.click();
        } else {
            System.out.println("already checked");
        }
    }

    public boolean isTermsOfUseClickable() {
        return termsOfUseLink.isEnabled();

    }

    public WhistleSetupPage clickSignInButton() throws InterruptedException {
        try {
            if (createAccountButton.isEnabled()) {
                createAccountButton.click();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new WhistleSetupPage(androidDriver);
    }


}
