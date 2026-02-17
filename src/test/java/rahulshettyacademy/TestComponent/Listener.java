package rahulshettyacademy.TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import rahulshettyacademy.AbtractComponent.ExtentReport;

import java.io.IOException;

public class Listener extends BaseClass implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReport.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

    public void Listeners() {
    }

    public void onTestStart(ITestResult result) {
        this.test = this.extent.createTest(result.getMethod().getMethodName());
        this.extentTest.set(this.test);
    }

    public void onTestSuccess(ITestResult result) {
        ((ExtentTest) this.extentTest.get()).log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String filePath= null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


    }
}

