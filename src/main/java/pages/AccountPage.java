package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(){
        this.driver = DriverFactory.getDriver();
    }
    private By usernameField = By.cssSelector("#reg_username");
    private By emailAddressField = By.cssSelector("#reg_email");
    private By passwordField = By.cssSelector("#reg_password");
    private By registerBtn = By.cssSelector("button[value='Register']");

   public void enterUsername (String username){
       driver.findElement(usernameField).sendKeys(username);
   }
   public void enterEmailAddress (String email){
       driver.findElement(emailAddressField).sendKeys(email);
   }
   public void enterPassword(String password){
       driver.findElement(passwordField).sendKeys(password);
   }
   public void clickRegisterbtn(){
       driver.findElement(registerBtn).click();
   }
   public String getUsername(){
       return driver.findElement(By.cssSelector("strong:nth-child(1)")).getText();
   }

   public void register(String username, String emailAddress, String password){
       enterUsername(username);
       enterEmailAddress(emailAddress);
       enterPassword(password);
       clickRegisterbtn();
   }

}
