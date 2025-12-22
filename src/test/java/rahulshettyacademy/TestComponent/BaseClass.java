package rahulshettyacademy.TestComponent;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulshettyacademy.PageObjectFiles.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
   public WebDriver driver;
   public LandingPage landingPage;

    public WebDriver IntializeDriver() throws IOException {
        Properties prop = new Properties();
//
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/GlobalData.properties"
        );

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase( "chrome")) {
            driver = new ChromeDriver();

        } else if (browserName == "firefox") {
            driver = new FirefoxDriver();
            //firefox code
        } else if (browserName == "edge") {
            driver = new EdgeDriver();
            //edge code
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver= IntializeDriver();
         landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;

    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }







}
