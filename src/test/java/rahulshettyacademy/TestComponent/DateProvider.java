package rahulshettyacademy.TestComponent;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.CartPage;
import rahulshettyacademy.PageObjectFiles.CheckOutPage;
import rahulshettyacademy.PageObjectFiles.ConfirmationPage;
import rahulshettyacademy.PageObjectFiles.ProductCatPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DateProvider extends BaseClass {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData",
            groups = {"Purchase"})
    public void SubmitOrderTesr(HashMap<String, String> input) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        ProductCatPage productCatPage = landingPage.loginApplication(input.get("email"),input.get("password"));
        List<WebElement> products = productCatPage.getProductList();
        productCatPage.addToCart(input.get("productName"));
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

//        @DataProvider
//        public Object[][] getData () {
//            HashMap<String, String> map = new HashMap();
//            map.put("email", "samaya333@gmail.com");
//            map.put("password", "Kitaboo@123");
//            map.put("productName", "ZARA COAT 3");
//            HashMap<String, String> map1 = new HashMap();
//            map1.put("email", "triveni.bhaskar999@gmail.com");
//            map1.put("password", "Kitaboo@123");
//            map1.put("productName", "ADIDAS ORIGINAL");
//            return new Object[][]{{map}, {map1}};
//        }

    }

