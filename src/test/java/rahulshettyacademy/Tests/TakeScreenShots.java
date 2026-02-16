package rahulshettyacademy.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v131.filesystem.model.File;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponent.BaseClass;

public class TakeScreenShots extends BaseClass {
    ExtentReports extent;




       @BeforeMethod
               public void Config()
       {
           String path=(System.getProperty("user.dir")+"/reports/index.html");
           ExtentSparkReporter reporter= new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
         extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Triveni Bhaskar");



       }
       @Test
       public void InitialDemo()
       {
           extent.createTest("Initial Demo");
           WebDriver driver = new ChromeDriver();
           driver.get("https://rahulshettyacademy.com");
           extent.flush();
       }
}
