package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.*;
import rahulshettyacademy.TestComponent.BaseClass;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTest extends BaseClass
{
    @Test

        public void SubmitOrderTesr() throws IOException, InterruptedException {
            // TODO Auto-generated method stub

            String productName = "ZARA COAT 3";
           // LandingPage landingPage=launchApplication(); Used before method in baseClass
          ProductCatPage productCatPage = landingPage.loginApplication("triveni.bhaskar999@gmail.com","Kitaboo@123");
            List<WebElement> products=productCatPage.getProductList();
            productCatPage.addToCart(productName);
            CartPage cartPage =productCatPage.goToCart();
            Boolean match = cartPage.VerifyProductDisplay(productName);

            Assert.assertTrue(match);
            CheckOutPage checkOutPage=cartPage.goToCheckout();
            checkOutPage.SelectCountry("india");
            ConfirmationPage confirmationPage=checkOutPage.SumbitOrder();

            String confirmMessage = confirmationPage.getConfirmationMessage();
            Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
           // driver.close();


        }

    }


