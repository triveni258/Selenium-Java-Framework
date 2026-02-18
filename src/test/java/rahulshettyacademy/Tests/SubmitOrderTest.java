package rahulshettyacademy.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.*;
import rahulshettyacademy.TestComponent.BaseClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseClass {
    @Test(dataProvider = "getData")

    public void SubmitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            ProductCatPage productCatPage = landingPage.loginApplication(input.get("email"),input.get("password"));
            List<WebElement> products = productCatPage.getProductList();
            productCatPage.addToCart(input.get("productName")) ;
            CartPage cartPage = productCatPage.goToCart();
            Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));

            Assert.assertTrue(match);
            CheckOutPage checkOutPage = cartPage.goToCheckout();
            checkOutPage.SelectCountry("india");
            ConfirmationPage confirmationPage = checkOutPage.SumbitOrder();

            String confirmMessage = confirmationPage.getConfirmationMessage();
            Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
            // driver.close();
        }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = this.getJsonDataToMap(System.getProperty
                ("user.dir") + "/src/main/java/Data/jSonFile.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};


    }
}


