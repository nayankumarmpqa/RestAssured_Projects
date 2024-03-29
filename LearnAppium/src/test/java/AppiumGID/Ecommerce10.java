package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Ecommerce10 extends EcommerceBase10{

    @Test
    public void fillForm(){

        //click and expand the dropdown
        androidDriver.findElement(By.id("android:id/text1")).click();

        // scroll to Argentina
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        // Click Argentina
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nayan");
        androidDriver.hideKeyboard();
        // select female
        androidDriver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

        //click lets shop
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }


}
