package rahulshettyacademy.TestComponent;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver IntializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream
                (System.getProperty("user.dir") +
                        "/src/main/java/rahulshettyacademy/resources/GlobalData.properties");

        prop.load(fis);
        String browserName;
        if (System.getProperty("browser") != null) {
            browserName = System.getProperty("browser");

        } else {
            browserName = prop.getProperty("browser");
        }


        if (browserName.contains("chrome")) {  //jar chrome asel tar intialise chrome
            ChromeOptions options = new ChromeOptions();

            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));
            // intialise chrome
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            //firefox code
        } else if (browserName.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
            //edge code
        }
        System.out.println("Browser name is :" + browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

        // Read JSON to String
        String jsonContent = FileUtils.readFileToString
                (new File(filePath));


        // String to HashMap - Jackson Databind
        ObjectMapper mapper = new ObjectMapper();

        List<HashMap<String, String>> data =
                mapper.readValue(
                        jsonContent,
                        new TypeReference<List<HashMap<String, String>>>() {
                        }
                );

        return data;
    }

    @Test
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
    }


    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = IntializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();   // use quit(), not close()
            } catch (Exception e) {
                System.out.println("Driver already closed");
            }
        }
    }


}
