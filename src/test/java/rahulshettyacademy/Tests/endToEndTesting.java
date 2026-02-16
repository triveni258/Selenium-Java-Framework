package rahulshettyacademy.Tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageObjectFiles.ProductCatalogue;
import rahulshettyacademy.TestComponent.BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class endToEndTesting extends BaseTest {
    ProductCatalogue productCatalogue;
    String productName = "ZARA COAT 3";

    @Test (dataProvider = "getData")
    public void EndToEndTest(HashMap<String,String> input) throws InterruptedException {

        productCatalogue = LandingPage1().LoginSubmit(input.get("email"),input.get("password"));
        System.out.println("Login Successful");
        productCatalogue.getProductList();
        productCatalogue.getProductByName(input.get("productName"));
        productCatalogue.addProductToCart(input.get("productName"));
    }
//    @DataProvider
//            public Object[][] getData() throws IOException
//    {
//        String jsonContent = FileUtils.readFileToString(
//                new File(
//                        System.getProperty("user.dir")
//                                + "/src/test/java/Data/PurchaseOrder.json"
//                ),
//                StandardCharsets.UTF_8
//        );
//        ObjectMapper mapper = new ObjectMapper();
//        //   <HashMap<String ,String>> data = mapper.readValue(Ty)
//    }
}



//
//        @DataProvider
//        public Object[][] getData()
//
//        {
//            HashMap<String,String> map = new HashMap<String, String>();
//            map.put("email","samaya333@gmail.com");
//            map.put("password","Kitaboo@123");
//            map.put("productName","ZARA COAT 3");
//
//            HashMap<String,String> map1 = new HashMap<String, String>();
//            map1.put("email","triveni.bhaskar999@gmail.com");
//            map1.put("password","Kitaboo@123");
//            map1.put("productName","ADIDAS ORIGINAL");
//
//           return new Object[][] {{map},{map1}};
//        }







