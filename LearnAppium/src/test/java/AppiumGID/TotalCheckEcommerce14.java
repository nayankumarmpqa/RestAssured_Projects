package AppiumGID;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TotalCheckEcommerce14 extends TotalCheckEcommerceBase14 {

    @Test
    public void fillForm() throws InterruptedException {

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
                // break;
            }
        }
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.attributeContains(androidDriver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));


        int itemsInCart = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        Double cartPriceSum = 0.0;
        cartPriceSum = getaDouble(itemsInCart, cartPriceSum);

        String checkoutPriceString = androidDriver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double checkoutPriceStringAsDouble = Double.parseDouble(checkoutPriceString.substring(1));

        System.out.println("cartPriceSum, checkoutPriceStringAsDouble is = " + cartPriceSum +" " + checkoutPriceStringAsDouble);

        Assert.assertEquals(cartPriceSum, checkoutPriceStringAsDouble);

    }



}



