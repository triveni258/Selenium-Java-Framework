package rahulshettyacademy.PageObjectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbtractComponent.AbstractComponentJava;

import java.util.List;
import java.util.zip.CheckedOutputStream;

public class CartPage extends AbstractComponentJava
{
    WebDriver driver;
    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (css=".cartSection h3")
    List<WebElement> cartProducts;
    @FindBy (css=".btn-primary")
    WebElement checkoutele;


    public Boolean VerifyProductDisplay(String productName)
    {

        Boolean match =cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().
                equalsIgnoreCase(productName));
        return match;

    }
    public CheckOutPage goToCheckout()
    {
        checkoutele.click();
       return new CheckOutPage(driver);

        // driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
