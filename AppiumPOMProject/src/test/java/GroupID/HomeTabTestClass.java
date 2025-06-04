package GroupID;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.android.*;
import testBaseUtils.WFlashBeforeEachTestAndroid;

import java.net.MalformedURLException;
import java.time.Duration;

public class HomeTabTestClass extends WFlashBeforeEachTestAndroid {

    private HomeTabPage homeTabPage;

    @DataProvider(name = "userProfiles")
    public Object[][] userProfiles() {
        return new Object[][]{
                {"GPSUser", "nayan.kumar+29apr@whistle.com", "T3stf1rst"},
                {"NonGPSUser", "nayan.kumar+17apr@whistle.com", "T3stf1rst"}
        };
    }

    @BeforeMethod
    public void setupApp() throws MalformedURLException {
        System.out.println("Restarting Appium driver before each test...");

        try {
            if (androidDriver != null) {
                androidDriver.quit();
            }
        } catch (Exception e) {
            System.out.println("⚠️ Error while quitting driver: " + e.getMessage());
        }

        androidDriver = new AndroidDriver(appiumDriverLocalService.getUrl(), uiAutomator2Options);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Reinitialize page objects
        letsGoPage = new LetsGoPage(androidDriver);
    }


    @AfterMethod
    public void logout() throws InterruptedException {
        System.out.println("Logging out and closing session...");
        if (homeTabPage != null) {
            homeTabPage.tapTopMiddleByCoordinates();
            ProfileTabPage profileTabPage = homeTabPage.clickProfileTabNavButton();
            homeTabPage.tapTopMiddleByCoordinates();
            YourInformationPage yourInformationPage = profileTabPage.clickYourInformationOption();
            yourInformationPage.scrollToTextGesture("Log out");
            yourInformationPage.clickLogOutOption();
            yourInformationPage.clickLogOutConfirmation();
        }
    }

    @Test(dataProvider = "userProfiles", priority = 0)
    public void testPetProfileTabs(String userType, String email, String password) throws InterruptedException {
        // Ensure fresh login before starting tests
        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick();
        whatsYourEmailPage.clickAndSetUsernameField(email);
        SignInPage signInPage = whatsYourEmailPage.clickNextButton();
        signInPage.clickPasswordField();
        signInPage.setInputPassword(password);
        homeTabPage = signInPage.clickSignInButton();

        homeTabPage.clickDoThisLaterButton();
        homeTabPage.tapTopMiddleByCoordinates();

        if (userType.equals("GPSUser")) {
            Assert.assertTrue(homeTabPage.isLocationTabPresent(), "Tracking tab missing!");
            System.out.println("✅ Location tab found!");
        } else {
            Assert.assertFalse(homeTabPage.isLocationTabPresent(), "Tracking tab should NOT be present!");
            System.out.println("✅ Location tab NOT found for NonGPS user.");
        }
    }

    @Test(dataProvider = "userProfiles", priority = 1)
    public void verifyHomeScreenElements(String userType, String email, String password) throws InterruptedException {
        loginToApp(email, password); // Ensure login before testing UI elements
        homeTabPage = new HomeTabPage(androidDriver);
        homeTabPage.tapTopMiddleByCoordinates();
        Assert.assertTrue(homeTabPage.isPetProfileVisible(), "Pet profile is not visible.");
        Assert.assertTrue(homeTabPage.isActivityGoalSectionVisible(), "Activity goal section is missing.");
        Assert.assertTrue(homeTabPage.isHealthSectionVisible(), "Health section is not visible.");
        Assert.assertTrue(homeTabPage.isCheckInButtonVisible(), "Check-in button is not visible.");


        if (userType.equals("GPSUser")) {
            Assert.assertTrue(homeTabPage.isLocationTabPresent(), "Location tab is missing for GPS user.");
        } else {
            System.out.println("⏩ Skipping Location Tab verification for Non-GPS user.");
        }
    }

    @Test(dataProvider = "userProfiles", priority = 2)
    public void testCheckInButtonFunctionality(String userType, String email, String password) throws InterruptedException {
        loginToApp(email, password);
        homeTabPage = new HomeTabPage(androidDriver);
        homeTabPage.tapTopMiddleByCoordinates();

        homeTabPage.clickCheckInButton();
        homeTabPage.navigateBackFromScreen();
        // Add verification for successful check-in if necessary
    }

    @Test(dataProvider = "userProfiles", priority = 3)
    public void testNavigationToLocationTab(String userType, String email, String password) throws InterruptedException {
        loginToApp(email, password);
        homeTabPage = new HomeTabPage(androidDriver);
        homeTabPage.tapTopMiddleByCoordinates();

        if (userType.equals("GPSUser")) {
            homeTabPage.navigateToLocationTab();
            // Add assertions for successful navigation
        } else {
            System.out.println("⏩ Skipping Location Tab navigation test for Non-GPS user.");
        }
    }

    private void loginToApp(String email, String password) throws InterruptedException {
        System.out.println("🔐 Logging in...");
        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick();
        whatsYourEmailPage.clickAndSetUsernameField(email);
        SignInPage signInPage = whatsYourEmailPage.clickNextButton();
        signInPage.clickPasswordField();
        signInPage.setInputPassword(password);
        homeTabPage = signInPage.clickSignInButton();
        homeTabPage.clickDoThisLaterButton();
        homeTabPage.tapTopMiddleByCoordinates();
    }
}
