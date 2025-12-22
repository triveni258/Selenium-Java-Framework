package rahulshettyacademy.PageObjectFiles;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbtractComponent.AbstractComponentJava;

public class ConfirmationPage extends AbstractComponentJava {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css=".hero-primary")
    WebElement confirmMessage;

    public String getConfirmationMessage()
    {
        return  confirmMessage.getText();

    }
}
