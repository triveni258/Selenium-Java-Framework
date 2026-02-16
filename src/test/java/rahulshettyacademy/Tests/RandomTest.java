package rahulshettyacademy.Tests;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.LoginPage1;
import rahulshettyacademy.TestComponent.BaseClass;
import rahulshettyacademy.TestComponent.BaseTest;

//WebDriver driver;


public class RandomTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RandomTest.class);

    @Test

    public void loginPage()
    {

        LoginPage1 loginPage = LandingPage1();

    }
}
