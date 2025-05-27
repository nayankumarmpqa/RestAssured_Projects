package androidActionsUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumCommonActions {

    AppiumDriverLocalService appiumDriverLocalService;

//Appium server start method placed here from TestBase Class
public AppiumDriverLocalService startAppiumServer(String iPAddress, String port) {
    appiumDriverLocalService = new AppiumServiceBuilder()
            .withAppiumJS(new File("C:\\Users\\Hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
            .withIPAddress(iPAddress)
            .usingPort(Integer.parseInt(port))
            .build();
    appiumDriverLocalService.start();
    return appiumDriverLocalService;
}
    //code for common waiting for screen title to appear
    public void waitForElementToAppear(WebElement element, String screenTitle, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((element), "text", screenTitle));
    }

    // code for string management etc
    public String takeScreenshotAndGetPath(String testCaseName, AppiumDriver driver) throws IOException
    {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"//Screenshots_For_Reports//"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
        //1. capture and place in folder //2. extent report pick file and attach to report
    }

    public Double getaDouble(int noOfItems, Double sumContainer, WebElement elementID, AppiumDriver driver) {
        for (int i = 0; i < noOfItems; i++) {
            String priceString = driver.findElements(By.id("elementID")).get(i).getText();
            Double priceAsDouble = Double.parseDouble(priceString.substring(1));
            sumContainer = sumContainer + priceAsDouble;
        }
        return sumContainer;
    }

    // convert json file content to json string
    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        //System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"
        // convert json file content to json string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

}
