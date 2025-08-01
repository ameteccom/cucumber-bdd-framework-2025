package stepdefinitions;

import Utilities.ConfigerationReader;
import Utilities.Driver;
import Utilities.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.time.Duration;

public class UserAccess_StepDef {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Given("User is navigated to Crater Login page")
    public void user_is_navigated_to_crater_login_page() {
        //navigate to crater login page
        driver.get(ConfigerationReader.getPropertyValue("crater-url"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().maximize();


    }
    @When("User enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        //loginPage.emailInput.sendKeys("entityadmin@primetechschool.com");
        //loginPage.passwordInput.sendKeys("primetech@school");
        SeleniumUtils.sendKeysActionClass(loginPage.emailInput, ConfigerationReader.getPropertyValue("username"));
        SeleniumUtils.sendKeysActionClass(loginPage.passwordInput, ConfigerationReader.getPropertyValue("password"));
    }
    @And("User clicks on crater application Login button")
    public void user_clicks_on_crater_application_login_button() {
        // Scroll the button into view before clicking
        SeleniumUtils.scrollToElement(loginPage.loginButton);
        loginPage.loginButton.click();

    }
    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws InterruptedException {
        String loginUrl = "http://crater.primetech-apps.com/login";
        String currentNewUrl = driver.getCurrentUrl(); // http://crater.primetech-apps.com/admin/settings/account-settings

        // Verify that login url is not same as current url --> you are logged in successfully
        Assert.assertNotEquals(loginUrl , currentNewUrl);

        // I commented below, because it is now in hooks class
        //Thread.sleep(5000);
        //Driver.closeDriver();  // adding this line to the hooks inside afterScenario
        //driver.quit();

    }


    @When("User enters invalid username and invalid password")
    public void user_enters_invalid_username_and_invalid_password() {
        SeleniumUtils.sendKeysActionClass(loginPage.emailInput, "test@test.com");
        SeleniumUtils.sendKeysActionClass(loginPage.passwordInput, "123@school");
    }
    @Then("User should see an error message {string} displayed")
    public void user_should_see_an_error_message_displayed(String expectedErrorMessage) throws InterruptedException {
        Thread.sleep(2000);
        String actualErrorMessage = loginPage.loginErrorMessageLabel.getText();
        System.out.println("The actual error from UI is --> " + actualErrorMessage);
        //Verify that the error message displayed is equal to the expected error message

        // Wait a bit to allow page load
        SeleniumUtils.waitForSeconds(4);


        Assert.assertTrue(expectedErrorMessage.equals(actualErrorMessage));
    }
    @And("User should not be logged in")
    public void user_should_not_be_logged_in() {
        // Verify that login url did not change from before clicking on the login button and
        // after clicking on the login button.
        String loginUrlBefore = "http://crater.primetech-apps.com/login";
        String urlAfterLogin = driver.getCurrentUrl();
        System.out.println("After Login--> " + urlAfterLogin);
        Assert.assertTrue(loginUrlBefore.equals(urlAfterLogin));
        //Driver.closeDriver();  // adding this line to the hooks inside afterScenario
    }


}
