package GroupID;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.android.*;

import java.net.MalformedURLException;


public class Wflash1 extends WFlashBeforeEachTestAndroid {

    @Test(dataProvider = "data-provider")
    public void AppiumTest1(String un, String pw) throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class
        // finding and clicking locator
        // in Appium we have the following types of locators
        // xpath , id,className, accessibilityId, androidUIAutomator

        LetsGoPage letsGoPage = new LetsGoPage(androidDriver);
        letsGoPage.letsGoButtonClick();

        WhatsYourEmailPage whatsYourEmailPage = new WhatsYourEmailPage(androidDriver);
        whatsYourEmailPage.clickAndSetUsernameField(un);
        whatsYourEmailPage.clickEnterPasswordButton();

        SignInPasswordPage signInPasswordPage = new SignInPasswordPage(androidDriver);

        signInPasswordPage.clickPasswordField();
        signInPasswordPage.setInputPassword(pw);
        signInPasswordPage.clickSignInButton();

        HomeTabPage homeTabPage = new HomeTabPage(androidDriver);
        homeTabPage.clickProfileTabNavButton();

        ProfileTabPage profileTabPage = new ProfileTabPage(androidDriver);
        profileTabPage.clickYourInformationOption();

        YourInformationPage yourInformationPage = new YourInformationPage(androidDriver);
        yourInformationPage.scrollToTextGesture("Log out");
        yourInformationPage.clickLogOutOption();
        yourInformationPage.clickLogOutConfirmation();

        //tearDown(); will be automatically invoked as @Afterclass method in parent class
    }


    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"nayan.kumar.ext+187am2@whistle.com", "T3stf1rst"},
                {"nayan.kumar.ext+am6-2@whistle.com", "T3stf1rst1"},
                {"nayan.kumar.ext+w04w@whistle.com", "T3stf1rst2"},
                {"nayan.kumar.ext+15aug@whistle.com", "T3stf1rst2"},
                {"nayan.kumar.ext+fm@whistle.com", "T3stf1rst"},
                {"nkorth@outlook.com", "Whistle1"}
        };
    }
}


