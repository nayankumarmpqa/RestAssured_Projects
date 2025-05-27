package pageObjects.android;

import androidActionsUtils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class HomeTabPage extends AndroidActions {
AndroidDriver androidDriver;
//Constructor
public HomeTabPage(AndroidDriver androidDriver){
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Home\"]")
    private WebElement homeTabNavButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Profile\"]")
    private WebElement profileTabNavButton;

    public ProfileTabPage clickProfileTabNavButton(){
        profileTabNavButton.click();
         return new ProfileTabPage(androidDriver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement doThisLaterButton;

    public void clickDoThisLaterButton(){
        waitForElementToBeVisible(20,doThisLaterButton);
        doThisLaterButton.click();
    }

    // Location Navigation Button (Visible for GPS Users)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Location\"]")
    private WebElement locationTabButton;

    public boolean isLocationTabPresent() {
        List<WebElement> elements = androidDriver.findElements(By.xpath("//android.widget.TextView[@text='Location']"));
        return !elements.isEmpty(); // Returns false if not found
    }

    // Pet Profile Name
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private WebElement petProfileName;


    // Map widget
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View")
    private WebElement mapWidget;

    // Activity Goal Section
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Activity goal')]")
    private WebElement activityGoalTitle;

    // Activity Widget
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"min\"]")
    private WebElement activityWidget;

    public ActivityTabPage clickActivityWidget(){
        activityWidget.click();
        return new ActivityTabPage(androidDriver);
    }

    // Health Section
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Health')]")
    private WebElement healthSection;

    // Journal Section
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Journal')]")
    private WebElement journalSection;

    // Journal Section
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'This week']")
    private WebElement thisWeekHeading;

    //bottom nav bar
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]")
    private WebElement bottomNavBar;

    // Check-in button
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Check-in\"]")
    private WebElement checkInButton;


    // Actions---------------------------------------------
    public boolean isPetProfileVisible() {
        return petProfileName.isDisplayed();
    }

    public boolean isActivityGoalSectionVisible() {
        return activityGoalTitle.isDisplayed();
    }

    public boolean isHealthSectionVisible() {
        return healthSection.isDisplayed();
    }

    public boolean isCheckInButtonVisible() {
        return checkInButton.isDisplayed();
    }

    public void  backFromCheckInScreen() {
        androidDriver.navigate().back();
    }

    public void clickCheckInButton() {
        checkInButton.click();
    }

    public void navigateToLocationTab() {
        locationTabButton.click();
    }

    public boolean isHomeTabVisible() {

        return homeTabNavButton.isEnabled();
    }

    public boolean isMapWidgetVisible() {

        return mapWidget.isDisplayed();
    }

    public boolean isJournalSectionVisible() {
        return journalSection.isDisplayed();
    }

    public boolean isThisWeekHeadingVisible() {
        return thisWeekHeading.isDisplayed();
    }

    public boolean isBottomNavigationBarVisible() {
        return bottomNavBar.isEnabled();
    }

}
