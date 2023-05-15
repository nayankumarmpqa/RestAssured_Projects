package GIDSeleniumProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Documents\\IntelliJ Projects\\AIDSeleniumProj\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String[] urls = {
                "https://whistle-staging.myshopify.com/",
                "https://whistle-staging.myshopify.com/pages/app",
                "https://whistle-staging.myshopify.com/pages/learn",
                "https://whistle-staging.myshopify.com/pages/for-business-v3",
                "https://whistle-staging.myshopify.com/pages/pet-insight-new",
                "https://whistle-staging.myshopify.com/pages/about-contact",
                "https://whistle-staging.myshopify.com/products/whistle-health-limited-edition",
                "https://whistle-staging.myshopify.com/products/whistle-health-gps-dog-tracker-activity-monitor",
                "https://whistle-staging.myshopify.com/products/whistle-health-gps-plus-dog-tracker-activity-monitor",
                "https://whistle-staging.myshopify.com/products/dog-leash?variant=40615277658173",
                "https://whistle-staging.myshopify.com/products/dog-leash?variant=40615277690941",
                "https://whistle-staging.myshopify.com/products/whistle-health-limited-edition-attachment?variant=40380284272701",
                "https://whistle-staging.myshopify.com/products/summer-sunset-leash?variant=39393005535293",
                "https://whistle-staging.myshopify.com/collections/whistle-360-pet-monitoring",
                "https://whistle-staging.myshopify.com/pages/allergies-v3",
                "https://whistle-staging.myshopify.com/pages/overweight-v3",
                "https://whistle-staging.myshopify.com/pages/old-age-v3",
                "https://whistle-staging.myshopify.com/pages/in-the-press",
                "https://whistle-staging.myshopify.com/pages/reviews-v3",
                "https://whistle-staging.myshopify.com/pages/faq-v3"
        };

        for (String url : urls) {
            System.out.println(url);
            FileWriter fw = new FileWriter("./file1.txt", true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write("Page url is : " + url + "\n");

            driver.get(url);
            bf.write("Page Title is : " + driver.getTitle() + "\n");
            bf.write("--------------------------------------------------------------------------"+"\n");

            driver.manage().window().maximize();
            if (driver.getCurrentUrl().equalsIgnoreCase("https://whistle-staging.myshopify.com/password")) {
                driver.findElement(By.xpath("(//input[@id='Password'])[1]")).sendKeys("whistle");
                driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
            }
            //Get list of web-elements with tagName  - a
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));

            //Traversing through the list and printing its text along with link address
            for (WebElement link : allLinks) {
                if (!link.getText().equals("")) {
                    bf.write(link.getText() + " - " + link.getAttribute("href"));
                    bf.write("\n");
                }
            }
            bf.close();
//
//            for (WebElement link : allLinks) {
//                if (!link.getText().equals("")) {
//                    System.out.println(link.getText() + " - " + link.getAttribute("href"));
//                }
//            }

            //Commenting driver.quit() for user to easily verify the links
            // driver.quit();
        }
    }
}
