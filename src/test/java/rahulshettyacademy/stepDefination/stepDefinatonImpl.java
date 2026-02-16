package rahulshettyacademy.stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import rahulshettyacademy.PageObjectFiles.*;
import rahulshettyacademy.TestComponent.BaseClass;

import java.io.IOException;
import java.util.List;

public class stepDefinatonImpl extends BaseClass {

    public LandingPage landingPage;
    public  ProductCatalogue productCatPage;
    public    ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public  void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage =launchApplication();

    }
    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_usernameme_and_password (String username, String password)
    {
        productCatPage = landingPage.loginApplication(username,password);
    }
    @When("^Add the product (.+) to the cart$")
    public void Add_the_product_to_the_cart(String productName) throws InterruptedException
    {
        List<WebElement> products = productCatPage.getProductList();
        productCatPage.addProductToCart(productName);
    }
    @When("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName)
    {
        CartPage cartPage = productCatPage.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        checkoutPage.selectCountry("india");
        confirmationPage= checkoutPage.submitOrder();
    }
    @When("{string} message is displayed on the confirmation page")
    public void message_is_displayed_on_the_confirmation_page(String string)
    {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    }




}
