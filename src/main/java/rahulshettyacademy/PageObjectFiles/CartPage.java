package rahulshettyacademy.PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponent;
import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(xpath = "(//ul//button[@class='btn btn-primary'])[2]")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Boolean VerifyProductDisplay(String productName) {
        Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;

    }

    public CheckoutPage goToCheckout()
    {
        Actions a = new Actions(driver);
        a.moveToElement(checkoutEle).build().perform();
        waitForElementToBeClickable(checkoutEle);
        checkoutEle.click();
        return new CheckoutPage(driver);

    }
}

