package hooks;

import base.DriverFactory;
import constants.FrameworkConstants;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;

public class Hooks {
    @BeforeTest
    public void setUp(){
        DriverFactory.getDriver().get(ConfigReader.getProperty(FrameworkConstants.URL));

    }
    @AfterTest
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
