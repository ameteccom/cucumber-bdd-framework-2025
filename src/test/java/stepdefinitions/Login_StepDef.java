package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_StepDef {
    WebDriver driver;

    @Given("User is navigate to saucedemo website")
    public void user_is_navigate_to_saucedemo_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        }
    @When("User enters {string} in the username field")
    public void user_enters_in_the_username_field(String username) {
        System.out.println("Value is : " + username);
        WebElement userNameElement = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNameElement.sendKeys(username);

    }
    @And("User enters {string} in the password field")
    public void user_enters_in_the_password_field(String password) {
        System.out.println("Value is : " + password);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
        passwordElement.sendKeys(password);

    }
    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

    }
    @Then("user is able to verify the {string} label is displayed")
    public void user_is_able_to_verify_the_label_is_displayed(String expectedProductLabel) {
        WebElement productLabelElement = driver.findElement(By.xpath("//span[text()='Products']"));
        String actualProductLabel = productLabelElement.getText();


//        if(productLabelElement.isDisplayed()){
//            System.out.println("Product is displayed on the screen");
//        } else {
//            System.out.println("Product is not displayed on the screen");
//        }

        if(actualProductLabel.equals(expectedProductLabel)){
            System.out.println("The product label is matching with the expected label");
        }else {
            System.out.println("The labels are not matching because actual label is ["
            + actualProductLabel + " ] vs the expected is  ---> " + expectedProductLabel);
        }

        // Assertion --> a way for you to verify if expected value is equal to actual value

        Assert.assertEquals(expectedProductLabel , actualProductLabel);

        Assert.assertTrue(productLabelElement.isDisplayed());

        driver.close();


    }

}
