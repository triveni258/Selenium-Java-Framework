package rahulshettyacademy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.PageObjectFiles.CartPage;
import rahulshettyacademy.PageObjectFiles.OrderPage;

import java.time.Duration;


public class AbstractComponent {

    public WebDriver driver;

    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void moveToElement(WebElement element)//SaflyAdded
    {
        Actions act = new Actions(driver);
        act.moveToElement(element);
        act.build().perform();

    }

    public void waitForElementToBeClickable(WebElement element)//SaflyAdded
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public CartPage goToCartPage() {
//        WebElement header = driver.findElement(By.tagName("header"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", header);

        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return new CartPage(driver);
    }

    public OrderPage goToOrdersPage() {

        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
    public void scrollTillEndByJS()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void scrollTillUpByJS() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: 0, behavior: 'instant' });");
    }

    public void scrollToElementByJS(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}

