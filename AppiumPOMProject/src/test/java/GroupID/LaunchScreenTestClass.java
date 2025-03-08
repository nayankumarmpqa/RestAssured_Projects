package GroupID;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.android.*;
import testBaseUtils.WFlashBeforeEachTestAndroid;

public class LaunchScreenTestClass extends WFlashBeforeEachTestAndroid {

    @Test(dataProvider = "data-provider")
    public void AppiumTest1(String un, String pw) throws InterruptedException {

        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick(); // catching the next class object for further use

        whatsYourEmailPage.clickAndSetUsernameField(un);
        SignInPage signInPage = whatsYourEmailPage.clickNextButton(); // catching the next class object for further use

        Thread.sleep(3000);
        signInPage.clickPasswordField();
        signInPage.setInputPassword(pw);
        HomeTabPage homeTabPage = signInPage.clickSignInButton(); // catching the next class object for further use

        homeTabPage.clickDoThisLaterButton();
        homeTabPage.pressByCoordinates();
        homeTabPage.pressByCoordinates();
        homeTabPage.pressByCoordinates();

        ProfileTabPage profileTabPage = homeTabPage.clickProfileTabNavButton(); // catching the next class object for further use

        YourInformationPage yourInformationPage = profileTabPage.clickYourInformationOption();// catching the next class object for further use

        yourInformationPage.scrollToTextGesture("Log out");
        yourInformationPage.clickLogOutOption();
        yourInformationPage.clickLogOutConfirmation();

        //tearDown(); will be automatically invoked as @After class method in parent class
    }
/*
@BeforeMethod
public void resetToLaunchScreen(){
letsGoPage.setActivityToLaunchScreen();
}*/

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                //{"nayan.kumar.ext+187am2@whistle.com", "T3stf1rst"}
               // {"nayan.kumar+15aug@whistle.com", "T3stf1rst"},
                {"nkorth@outlook.com", "Whistle1"}
        };
    }


    //---------------------------------------------------------------------------
    @Test(priority = 1)
    public void testAppLaunchAndUIElements() {

        // Verify app launched successfully
        Assert.assertTrue(letsGoPage.isLogoDisplayed(), "App logo is not displayed.");

        // Verify "Let's go" button visibility & properties
        Assert.assertTrue(letsGoPage.isLetsGoButtonDisplayed(), "Let's go button is missing.");
        Assert.assertTrue(letsGoPage.isLetsGoButtonEnabled(), "Let's go button is disabled.");

        // Verify "Family or friend?" text
        Assert.assertTrue(letsGoPage.isFamilyOrFriendTextDisplayed(), "Family or friend text is not visible.");
    }

    @Test(priority = 2)
    public void testNavigationFromLaunchScreen() {

        // Click "Let's go" button
        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick();

        // Verify navigation (assuming next screen has an element with ID "nextScreenElementId")
        Assert.assertTrue(whatsYourEmailPage.isWhatsYourEmailLabelDisplayed(), "Navigation failed.");

        // Press the back button twice to minimize key board and nav back to launch screen
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Test(priority = 3)
    public void testBackButtonBehavior() {
        // Press the back button
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));

        // Verify that the app is minimized
        boolean isAppInBackground = androidDriver.queryAppState("com.whistle.whistle.beta") == ApplicationState.RUNNING_IN_BACKGROUND;

        Assert.assertTrue(isAppInBackground, "App did not minimize after pressing the Back button.");
    }



}


