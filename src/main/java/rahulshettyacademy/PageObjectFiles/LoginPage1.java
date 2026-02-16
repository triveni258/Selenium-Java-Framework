package rahulshettyacademy.PageObjectFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponent;

public class LoginPage1 extends AbstractComponent {

    WebDriver driver;
    public LoginPage1(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(id=("userEmail"))
    WebElement UserName;
    @FindBy(id=("userPassword"))
    WebElement Password;
    @FindBy(id=("login"))
    WebElement submit;


    public void LoginUrl()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }
    public ProductCatalogue LoginSubmit(String username, String password)
    {
        UserName.sendKeys(username);
        Password.sendKeys((password));
        submit.click();
        ProductCatalogue productCatalogue=new ProductCatalogue(driver);
        return productCatalogue;
    }



}
