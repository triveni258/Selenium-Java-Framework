package rahulshettyacademy.Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v131.filesystem.model.File;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.*;
import rahulshettyacademy.TestComponent.BaseClass;
import rahulshettyacademy.TestComponent.Retry;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseClass {

    String productName = "ADIDAS ORIGINAL";

    @Test(dataProvider = "getData", groups = {"Purchase"})//,retryAnalyzer = Retry.class

    public void SubmitOrderTest(HashMap<String, String> input) throws InterruptedException {


        // LandingPage landingPage=launchApplicSACation(); Used before method in baseClass
        ProductCatalogue productCatPage = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatPage.getProductList();
        productCatPage.addProductToCart(input.get("productName"));
CartPage cartPage = productCatPage.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

//    @Test(dependsOnMethods = {"SubmitOrderTest"})
//
//    public void OrderHystoryTest() throws IOException, InterruptedException {
//        ProductCatalogue productCatPage = landingPage.loginApplication("triveni.bhaskar999@gmail.com", "Kitaboo@123");
//        OrderPage orderPage = productCatPage.goToOrdersPage();
//        Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
//    }

    @DataProvider

            public  Object[] [] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

//    public class tTakeScreenShots(String testCaseName) {
//        public void ScreenShotsTest() {
//            TakesScreenshot ts= (TakesScreenshot) driver;
//            File source=ts.getScreenshotAs(OutputType.FILE);
//            File file = new File(System.getProperty("user.dir")+"/reports/index.html");
//            FileUtils.copyFile(source,file);
//            return System.getProperty("user.dir")+"/reports/index.html");




//    @DataProvider
//    public Object[][] getData()
//    {
//        return new Object[][]{{"samaya333@gmail.com", "Kitaboo@123", "ZARA COAT 3"},
//                {"samaya333@gmail.com", "Kitaboo@123", "ADIDAS ORIGINAL"}};
//    }

//@DataProvider
//    public Object[][] getData()
//
//{
//    HashMap<String,String> map = new HashMap<String, String>();
//        map.put("email","samaya333@gmail.com");
//        map.put("password","Kitaboo@123");
//        map.put("productName","ZARA COAT 3");
//
//        HashMap<String,String> map1 = new HashMap<String, String>();
//        map1.put("email","triveni.bhaskar999@gmail.com");
//        map1.put("password","Kitaboo@123");
//        map1.put("productName","ADIDAS ORIGINAL");
//
//        return new Object[][] {{map},{map1}};
//    }

//       //What are the Extent Reports
//
//

    }



