package GroupID;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.android.*;

import java.net.MalformedURLException;


public class FlashObectOptimised extends WFlashBeforeEachTestAndroid {

    @Test(dataProvider = "data-provider")
    public void AppiumTest1(String un, String pw) throws MalformedURLException, InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class


        //LetsGoPage letsGoPage = new LetsGoPage(androidDriver);
        //letsGoPage.letsGoButtonClick();
        // commented above line because object is created with before class method

        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick(); // catching the next class object for further use

        //WhatsYourEmailPage whatsYourEmailPage = new WhatsYourEmailPage(androidDriver);

        whatsYourEmailPage.clickAndSetUsernameField(un);
        SignInPasswordPage signInPasswordPage = whatsYourEmailPage.clickEnterPasswordButton(); // catching the next class object for further use

        //SignInPasswordPage signInPasswordPage = new SignInPasswordPage(androidDriver);
        signInPasswordPage.clickPasswordField();
        signInPasswordPage.setInputPassword(pw);
        HomeTabPage homeTabPage = signInPasswordPage.clickSignInButton(); // catching the next class object for further use

        //HomeTabPage homeTabPage = new HomeTabPage(androidDriver);
        ProfileTabPage profileTabPage = homeTabPage.clickProfileTabNavButton(); // catching the next class object for further use

        //ProfileTabPage profileTabPage = new ProfileTabPage(androidDriver);
        YourInformationPage yourInformationPage = profileTabPage.clickYourInformationOption();// catching the next class object for further use

       // YourInformationPage yourInformationPage = new YourInformationPage(androidDriver);
        yourInformationPage.scrollToTextGesture("Log out");
        yourInformationPage.clickLogOutOption();
        yourInformationPage.clickLogOutConfirmation();

        //tearDown(); will be automatically invoked as @After class method in parent class
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


