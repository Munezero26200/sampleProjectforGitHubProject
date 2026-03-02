package stepDefinitions;

import base.DriverFactory;
import constants.FrameworkConstants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccountPage;
import pages.HomePage;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class RegisterSteps {
    AccountPage accountPage = new AccountPage();
    HomePage homePage = new HomePage();


    @Given("customer is on the account page")
    public void beOnAccountPage() {
        DriverFactory.getDriver().get(ConfigReader.getProperty(FrameworkConstants.URL));
        homePage.clickOnAccount();

    }

    @When("the customer registers with the credentials")
    public void registerWithValidCredentials(DataTable dataTable) {
    //convert Datatable to list of maps
        List<Map<String,String>> userlist = dataTable.asMaps(String.class, String.class);
        //loop through each row
        for(Map<String,String> user : userlist){
            String username = user.get("username");
            String email = user.get("email");
            String password = user.get("password");
            accountPage.register(username,email,password);
        }
    }

    @Then("account details Page shows username {string}")
    public void usernameDisplayed(String expectedUsername) {
       String actualUsername = accountPage.getUsername();
        Assert.assertTrue(expectedUsername.contains(actualUsername));
    }
}
