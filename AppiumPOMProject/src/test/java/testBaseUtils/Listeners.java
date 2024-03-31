package testBaseUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentReports extentReports = ExtentReportNG.getExtentReportsObject(); // calling static method to get the object
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestStart(result);
        test = extentReports.createTest(result.getMethod().getMethodName() + " Creating a Test for Extent Report");
        // createTest method is used to show method in report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       // ITestListener.super.onTestSuccess(result);
        test.log(Status.PASS,"My test Passed");
        // OR we can use
        // test.pass(result.getThrowable());
    }

    @Override
    public void onTestFailure(ITestResult result) {
       // ITestListener.super.onTestFailure(result);

        test.log(Status.FAIL,"My test Failed");
        test.fail(result.getThrowable()); //  give the error message
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {

        //ITestListener.super.onFinish(context);
        extentReports.flush(); // get the report ready
    }
}
