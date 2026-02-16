package rahulshettyacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.AbstractComponent;

import javax.swing.*;

public class StandAloneTest {

    @Test
    public void standAloneTestE2E() throws InterruptedException {
        // TODO Auto-generated method stub

        String productName = "iphone 13 pro";
        WebDriver driver = new ChromeDriver(); //webdriver initialization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //global wait
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id(("userEmail"))).sendKeys("triveni.bhaskar999@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Kitaboo@123");
        driver.findElement(By.id("login")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));



        WebElement prod = products.stream()
                .filter(p -> p.findElement(By.cssSelector("b"))
                        .getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));






//        WebElement prod = null;
//
//        for (WebElement product : products) {
////dcscroo, wait
//            String name = product.findElement(By.cssSelector("b")).getText().trim();
//            System.out.println("Found product: " + name); // DEBUG LINE
//
//            if (name.equalsIgnoreCase(productName.trim())) {
//                prod = product;
//                break;
//            }
//        }
//
//// HARD STOP if not found
//        if (prod == null) {
//            throw new RuntimeException("❌ Product NOT found: " + productName);
//        }


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        WebElement addToCartBtn = prod.findElement(
                By.cssSelector(".card-body button:last-of-type"));
       // wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));


        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //ng-animating
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//        js.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(1000);
        js.executeScript("document.documentElement.scrollTop = 0;");
      //  js.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();



    //    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();




       // driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        Thread.sleep(1000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);

        WebElement checkout = driver.findElement(By.xpath("(//ul//button[@class='btn btn-primary'])[2]"));
        checkout.click();
        System.out.println("Clicked on checkout Button")
//        Actions act1 = new Actions(driver);
//        act1.moveToElement(checkout);
//        act1.build().perform();
//        wait.until(ExpectedConditions.elementToBeClickable(checkout));


       ;
        //.btn-primary//.totalRow button

//
//            Actions a = new Actions(driver);
//            a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

//
        WebElement placeOrderButton = driver.findElement(By.xpath("(//a[@class='btnn action__submit ng-star-inserted' and text()='Place Order '])"));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));


        ////div[contains(text(),'CVV Code ')]/following-sibling::input
        //Select ccc code
        driver.findElement(By.xpath("//div[contains(text(),'CVV Code ')]/following-sibling::input")).sendKeys("555");
        //
        //Select country
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
        List<WebElement> options = driver.findElements((By.xpath("//section[@class=\"ta-results list-group ng-star-inserted\"]/button")));

        for (WebElement countryName : options) {
            if (countryName.getText().equalsIgnoreCase("India")) {
               // Thread.sleep(1000);
              wait.until(ExpectedConditions.elementToBeClickable(countryName));
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
               Thread.sleep(1000);
                countryName.click();



                break;
            }
        }
        Thread.sleep(1000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);


        placeOrderButton.click();

        System.out.println("Clicked on Place Order Button");

        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();


    }


}


