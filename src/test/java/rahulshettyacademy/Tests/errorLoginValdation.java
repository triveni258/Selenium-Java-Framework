package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.CartPage;
import rahulshettyacademy.PageObjectFiles.ProductCatPage;
import rahulshettyacademy.TestComponent.BaseClass;

import java.util.List;

public class errorLoginValdation extends BaseClass
{



    @Test
    public void errorLoginValidation()
    {
        landingPage.loginApplication("triveni.bhaskar999@gmail.com1","Kitaboo@123");
       // String errorMessage = landingPage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage(),"Somethign went wrong");

       // div[aria-label='Incorrect email or password.'
       // ng-tns-c4-5 toast-message ng-star-inserted
    }
    @Test
    public void ErrorProductName() throws InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatPage productCatPage = this.landingPage.loginApplication("triveni.bhaskar999@gmail.com", "Kitaboo@123");
        List<WebElement> products = productCatPage.getProductList();
        productCatPage.addToCart(productName);
        CartPage cartPage = productCatPage.goToCart();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertTrue(match);
    }


}
