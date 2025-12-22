package rahulshettyacademy.PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbtractComponent.AbstractComponentJava;

import javax.xml.xpath.XPath;

public class CheckOutPage extends AbstractComponentJava {

    WebDriver driver;
    public CheckOutPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);


    }
    @FindBy(css="[placeholder='Select Country']")
    WebElement country;
    @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;
    @FindBy(css=".action__submit")
    WebElement submit;
    By result=By.cssSelector(".ta-results");

    public void SelectCountry(String countryName ){
        Actions a = new Actions(driver);
        a.sendKeys(country, "countryName").build().perform();

        waitWebElementToAppear(result);

        selectCountry.click();

    }
    public ConfirmationPage SumbitOrder()
    {
        submit.click();
       return new ConfirmationPage(driver);
    }


}
