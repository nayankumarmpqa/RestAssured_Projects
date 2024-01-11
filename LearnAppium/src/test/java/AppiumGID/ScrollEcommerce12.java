package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollEcommerce12 extends ScrollEcommerceBase12 {

    @Test
    public void fillForm() {

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
        // Toast msg checking
        // String toastMessage =  androidDriver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        // Assert.assertEquals(toastMessage, "Please enter your name");

        androidDriver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"
                )
        );

        int productCount = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int i = 0; i < productCount; i++) {
            String productName = androidDriver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                androidDriver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

    }


}
