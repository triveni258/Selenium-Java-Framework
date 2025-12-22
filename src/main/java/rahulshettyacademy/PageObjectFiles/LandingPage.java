package rahulshettyacademy.PageObjectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbtractComponent.AbstractComponentJava;

public class LandingPage extends AbstractComponentJava {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        @FindBy (id="userEmail")
    WebElement userEmain;
            @FindBy(id= "userPassword")
    WebElement userPassword;
            @FindBy(id="login")
    WebElement submit;
    @FindBy(css="[class*='toast-message']")
    WebElement errorMessage;//ng-tns-c4-5 toast-message ng-star-inserted

            public String getErrorMessage()
            {
                waitWebElementToAppear(errorMessage);
                return errorMessage.getText();
            }
            //div[aria-label='Incorrect email or password.']
            //


            public ProductCatPage loginApplication(String email, String password)
            {
                userEmain.sendKeys(email);
                userPassword.sendKeys(password);
                submit.click();
                ProductCatPage productCatPage = new ProductCatPage(driver);
                return productCatPage;
            }
            public void goTo()
            {
                driver.get("https://rahulshettyacademy.com/client");
            }



}
