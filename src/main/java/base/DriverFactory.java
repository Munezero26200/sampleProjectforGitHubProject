package base;

import constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
   private static WebDriver driver;

   private DriverFactory(){
     //prevent instantiation
   }
   public static WebDriver getDriver(){
       if(driver == null){
           String browser = ConfigReader.getProperty(FrameworkConstants.BROWSER);
           String headless = ConfigReader.getProperty(FrameworkConstants.HEADLESS);
           String timeout = ConfigReader.getProperty(FrameworkConstants.TIMEOUT);

           if(browser.equalsIgnoreCase("chrome")){
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--disable-dev");
               boolean isCI = System.getenv("CI") != null;
               if (isCI){
                   options.addArguments("--headless=new");
                   options.addArguments("--no-sandbox");
                   options.addArguments("--disable-dev");
                   options.addArguments("--disable-gpu");
                   options.addArguments("--window-size=1920,1080");
               }
           }
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeout)));
       }
       return driver;
   }
   public static void quitDriver(){
       if(driver != null){
           driver.quit();
           driver = null;
       }
   }

}
