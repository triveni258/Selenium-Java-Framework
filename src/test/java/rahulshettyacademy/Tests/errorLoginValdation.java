package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.CartPage;
import rahulshettyacademy.PageObjectFiles.ProductCatalogue;
import rahulshettyacademy.TestComponent.BaseClass;
import rahulshettyacademy.TestComponent.Retry;

import java.io.IOException;
import java.util.List;
public class errorLoginValdation extends BaseClass {
@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
public void LoginErrorValidation() throws IOException, InterruptedException {


    landingPage.loginApplication("anshika@gmail.com", "Iamki000");
    Assert.assertEquals("Incorrect email or password1.", landingPage.getErrorMessage());

}


@Test
public void ProductErrorValidation() throws IOException, InterruptedException
{

    String productName = "ADIDAS ORIGINAL";
    ProductCatalogue productCatalogue = landingPage.loginApplication("samaya333@gmail.com", "Kitaboo@123");
    List<WebElement> products = productCatalogue.getProductList();
    productCatalogue.addProductToCart(productName);
//    CartPage cartPage = productCatalogue.goToCartPage();
//    Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");
//    Assert.assertFalse(match);
}




}







