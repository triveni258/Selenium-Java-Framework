package rahulshettyacademy.TestComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import rahulshettyacademy.PageObjectFiles.LoginPage1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;

    public WebDriver IntializerDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/rahulshettyacademy/resources/GlobalData.properties");

        prop.load(fis);
        String browserName=System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");
        //ternary operator




        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();


        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //global wait
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod

    public LoginPage1 LandingPage1() {
        try {
            driver = IntializerDriver(); //if problem occurred, then catch block execute
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoginPage1 loginpage1 = new LoginPage1(driver);
        loginpage1.LoginUrl();
        return loginpage1;


    }


}
