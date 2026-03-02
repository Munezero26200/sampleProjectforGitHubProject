package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    public HomePage(){
        this.driver = DriverFactory.getDriver();
    }
    private By account = By.linkText("Account");

    public void clickOnAccount(){
        driver.findElement(account).click();
    }
}
