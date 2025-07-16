package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // You are telling junit to run the TestRunner class as a cucumber Test
@CucumberOptions(features = "src/test/resources/features/login_saucedemo.feature",
            glue = {"stepdefinitions"} ,
            plugin = {"pretty" , "html:target/primetech-report-2025.html",
            "json:target/primetech-report-2025.json" }


)


public class TestRunner {
}


/**
 * This class will allow us to execute and run our feature files/step definitions
 *
 */