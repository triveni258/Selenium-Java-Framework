package rahulshettyacademy.PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbtractComponent.AbstractComponentJava;

import java.util.List;

public class ProductCatPage extends AbstractComponentJava {

    WebDriver driver;

    public ProductCatPage(WebDriver driver)
        {
            super(driver);
            //
            this.driver = driver;
            PageFactory.initElements(driver, this);
            //initElemnts initialise the page factory

        }
        //            List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        @FindBy(css = ".mb3")
        List<WebElement> products;
        @FindBy(css=".ng-animating")
         WebElement Spinner;




        By productsBy = By.cssSelector(".mb-3");
        By addToCart=By.cssSelector(".card-body button:last-of-type");
        By toastMessage=By.cssSelector("#toast-container");

        public List<WebElement> getProductList()
        {
            waitWebElementToAppear(productsBy);
            return products;
        }
        public WebElement getProductName(String productName)
        {
            WebElement prod =	getProductList().stream().filter(product->
                    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
         return prod;
         //prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        }
        public void addToCart(String productName) throws InterruptedException {
            WebElement prod= getProductName(productName);
           prod.findElement(addToCart).click();
            WebElementToDisappear(Spinner);
            waitWebElementToAppear(toastMessage);

        }


    }


