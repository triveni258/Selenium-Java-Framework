package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.CartPage;
import rahulshettyacademy.PageObjectFiles.CheckoutPage;
import rahulshettyacademy.PageObjectFiles.ConfirmationPage;
import rahulshettyacademy.PageObjectFiles.ProductCatalogue;
import rahulshettyacademy.TestComponent.BaseClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class dataProviderTest extends BaseClass {


        String productName = "ZARA COAT 3";

        @Test(dataProvider = "getData", groups = {"Purchase"})

        public void SubmitOrderTest(String email, String password, String productName) throws IOException, InterruptedException
        {


            // LandingPage landingPage=launchApplication(); Used before method in baseClass
            ProductCatalogue productCatPage = landingPage.loginApplication(email, password);
            List<WebElement> products = productCatPage.getProductList();
            productCatPage.addProductToCart(productName);
            CartPage cartPage = productCatPage.goToCartPage();
            Boolean match = cartPage.VerifyProductDisplay(productName);
            Assert.assertTrue(match);
            CheckoutPage checkoutPage = cartPage.goToCheckout();

            checkoutPage.selectCountry("india");
            ConfirmationPage confirmationPage = checkoutPage.submitOrder();

            String confirmMessage = confirmationPage.getConfirmationMessage();
            Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

        }
    @DataProvider
    public Object[][] getData()

    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("email","samaya333@gmail.com");
        map.put("password","Kitaboo@123");
        map.put("productName","ZARA COAT 3");

        HashMap<String,String> map1 = new HashMap<String, String>();
        map1.put("email","triveni.bhaskar999@gmail.com");
        map1.put("password","Kitaboo@123");
        map1.put("productName","ADIDAS ORIGINAL");

        return new Object[][] {{map},{map1}};
    }

    }
