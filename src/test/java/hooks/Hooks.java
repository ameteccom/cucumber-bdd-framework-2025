package hooks;

import io.cucumber.java.*;


import Utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {


    //@Before ("@smoke")
    @Before
    public void beforeScenario(){
        System.out.println("We are running before each scenario");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

//    @Before(order=1)
//    public void beforeScenario2(){
//        System.out.println("We are running before each scenario");
//        System.out.println("We are running before each scenario order 1");
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        System.out.println("We are running after each Scenario");
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot , "image/phg" , scenario.getName());
        }




        //Thread.sleep(5000);


    }

//    @BeforeStep
//    public void beforeStep(){
//        System.out.println("We are running before each step");
//
//    }

    @AfterStep
    public void afterStep() throws InterruptedException {
        //System.out.println("We are running after each step");
        Thread.sleep(3000);

    }


}
