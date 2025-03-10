package GroupID;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.android.*;
import testBaseUtils.WFlashBeforeEachTestAndroid;

import java.io.IOException;

public class HomeScreenTestClass extends WFlashBeforeEachTestAndroid {

    @DataProvider(name = "userProfiles")
    public Object[][] userProfiles() {
        return new Object[][]{
                {"GPSUser", "nkorth@outlook.com", "Whistle1"},
                {"NonGPSUser", "nayan.kumar+27feb@whistle.com", "T3stf1rst"}
        };
    }

    @Test(dataProvider = "userProfiles")
    public void testPetProfileTabs(String userType, String email, String password) throws InterruptedException {
        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick(); // catching the next class object for further use

        whatsYourEmailPage.clickAndSetUsernameField(email);
        SignInPage signInPage = whatsYourEmailPage.clickNextButton(); // catching the next class object for further use

        signInPage.clickPasswordField();
        signInPage.setInputPassword(password);
        HomeTabPage homeTabPage = signInPage.clickSignInButton(); // catching the next class object for further use

        homeTabPage.clickDoThisLaterButton();

        if (userType.equals("GPSUser")) {
            Assert.assertTrue(homeTabPage.isLocationTabPresent(), "Tracking tab missing!");
            System.out.println("Location tab found!");
        } else {
            // Ensure the script does not try to find a non-existing element
            boolean isTabPresent = homeTabPage.isLocationTabPresent(); // Use a safe method
            Assert.assertFalse(isTabPresent, "Tracking tab should not be present!");
            System.out.println("Location tab NOT found! It is a NonGPS pet.");
        }


        ProfileTabPage profileTabPage = homeTabPage.clickProfileTabNavButton(); // catching the next class object for further use

        YourInformationPage yourInformationPage = profileTabPage.clickYourInformationOption();// catching the next class object for further use

        yourInformationPage.scrollToTextGesture("Log out");
        yourInformationPage.clickLogOutOption();
        yourInformationPage.clickLogOutConfirmation();

        //tearDown(); will be automatically invoked as @After class method in parent class
        System.out.println("Resetting the app before the test...");

    }
}


