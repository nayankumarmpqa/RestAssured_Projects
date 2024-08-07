package GroupID;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.android.*;
import testBaseUtils.WFlashBeforeEachTestAndroid;

public class FlashTestClass extends WFlashBeforeEachTestAndroid {

    @Test(dataProvider = "data-provider")
    public void AppiumTest1(String un, String pw) throws InterruptedException {
        // configureAppium(); will be automatically invoked as @Beforeclass method in parent class

        //LetsGoPage letsGoPage = new LetsGoPage(androidDriver);
        //letsGoPage.letsGoButtonClick();
        // commented above line because object is created with before class method
        WhatsYourEmailPage whatsYourEmailPage = letsGoPage.letsGoButtonClick(); // catching the next class object for further use

        //WhatsYourEmailPage whatsYourEmailPage = new WhatsYourEmailPage(androidDriver);
        whatsYourEmailPage.clickAndSetUsernameField(un);
        SignInPage signInPage = whatsYourEmailPage.clickNextButton(); // catching the next class object for further use

        //SignInPasswordPage signInPasswordPage = new SignInPasswordPage(androidDriver);
        signInPage.clickPasswordField();
        signInPage.setInputPassword(pw);
        HomeTabPage homeTabPage = signInPage.clickSignInButton(); // catching the next class object for further use

        homeTabPage.clickDoThisLaterButton();
        homeTabPage.pressByCoordinates();
        homeTabPage.pressByCoordinates();
        homeTabPage.pressByCoordinates();

        //HomeTabPage homeTabPage = new HomeTabPage(androidDriver);
        ProfileTabPage profileTabPage = homeTabPage.clickProfileTabNavButton(); // catching the next class object for further use

        //ProfileTabPage profileTabPage = new ProfileTabPage(androidDriver);
        YourInformationPage yourInformationPage = profileTabPage.clickYourInformationOption();// catching the next class object for further use

       //YourInformationPage yourInformationPage = new YourInformationPage(androidDriver);
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
                {"nayan.kumar+15aug@whistle.com", "T3stf1rst"},
                {"nkorth@outlook.com", "Whistle1"}
        };
    }
}


