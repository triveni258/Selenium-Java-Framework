package rahulshettyacademy.AbtractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.PageObjectFiles.CartPage;

import java.time.Duration;

public class AbstractComponentJava

{
    WebDriver driver;
    public AbstractComponentJava(WebDriver driver)
    {
        this.driver=driver;

    }

    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
    public void waitWebElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));


    }
    public void waitWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(findBy));
    }


        public CartPage goToCart ()
        {
            cartHeader.click();
            CartPage cartPage = new CartPage(driver);
            return cartPage;
        }

        public void WebElementToDisappear (WebElement ele) throws InterruptedException {
            Thread.sleep(2000);
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    wait.until(ExpectedConditions.invisibilityOf(ele));


        }
    }


