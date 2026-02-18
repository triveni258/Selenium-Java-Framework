package rahulshettyacademy.TestComponent;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
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

    public BaseClass() {
    }

    public WebDriver IntializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Data/GlobalData");
        prop.load(fis);
        String browserName;
        if (System.getProperty("browser") != null) {
            browserName = System.getProperty("browser");
        } else {
            browserName = prop.getProperty("browser");
        }

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments(new String[]{"headless"});
            }

            this.driver = new ChromeDriver(options);
            this.driver.manage().window().setSize(new Dimension(1440, 900));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            this.driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            this.driver = new EdgeDriver((EdgeOptions)(new EdgeOptions()).addArguments(new String[]{"--remote-allow-origins=*"}));
        }

        System.out.println("Browser name is :" + browserName);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        this.driver.manage().window().maximize();
        return this.driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
    {
        String jsonContent = FileUtils.readFileToString(new File(filePath));
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = (List)mapper.readValue
                (jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    @Test
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = (File)ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
    }

    @BeforeMethod(
            alwaysRun = true
    )
    public LandingPage launchApplication() throws IOException {
        this.driver = this.IntializeDriver();
        this.landingPage = new LandingPage(this.driver);
        this.landingPage.goTo();
        return this.landingPage;
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void tearDown() {
        if (this.driver != null) {
            try {
                this.driver.quit();
            } catch (Exception var2) {
                System.out.println("Driver already closed");
            }
        }

    }

}
