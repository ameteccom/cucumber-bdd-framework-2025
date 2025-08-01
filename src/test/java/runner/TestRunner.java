package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // You are telling junit to run the TestRunner class as a cucumber Test
@CucumberOptions(features = "src/test/resources/features/",
            glue = {"stepdefinitions", "hooks"} ,
            plugin = {"pretty" , "html:target/primetech-report-2025.html",
            "json:target/primetech-report-2025.json",
           "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        //tags = "@crater"
        tags = "@add-item"
        //tags = "@saucedemo"
        //tags = "@demo-datatable"
        //tags = "@calculator"
        // tags = "@smoke and not @ignore"
        //tags = "@smoke"
        //tags = "@regression"
        // Examples:
        // or and
        // @A and not @B -> Run all with @A but exclude those with @B.
        // @A or @B and not @C

)


public class TestRunner {
}


/**
 * This class will allow us to execute and run our feature files/step definitions
 *
 */