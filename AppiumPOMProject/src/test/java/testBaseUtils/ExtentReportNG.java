package testBaseUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    static ExtentReports extentReports; // created static ti access with class name in the listener class > on Test start

    public static ExtentReports getExtentReportsObject() {

        // Two important classes for reporting ExtentSparkReporter, ExtentReport

        String path = System.getProperty("user.dir")+"src\\test\\java\\resources\\index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("whistle Automation Results");
        extentSparkReporter.config().setDocumentTitle("Whistle Test results page title");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Tester", "Nayan Kumar");

        return extentReports;

    }
}
