package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    public Driver() {

    }

    /**
     * Static method to get the single instance of webdriver     *
     *
     * @return
     */
    public static WebDriver getDriver() {
        //Read the browser type you want to lunch from properties (configuration.properties) file
        String browserType = ConfigerationReader.getPropertyValue("browserType");


        // Check if there is a driver (Browser) is open or not (same thing as checking is driver is null)
        System.out.println("Getting an instance of the driver");
        if (driver == null) {
            // Create if driver based on the browser Type
            switch (browserType.toLowerCase()) {
                case "chrome": // if browser type is chrome
                    driver = new ChromeDriver();  // Instantiate only once
                    break;
                case "firefox": // if browser type is firefox
                    driver = new FirefoxDriver();
                    break;
                case "edge": // if browser type is Edge
                    driver = new EdgeDriver();
                    break;
                case "safari": // if browser type is Safari
                    driver = new SafariDriver();
                    break;
                case "chrome-headless":
                    System.out.println("Running in headless mode in chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox-headless": // if browser type is Safari
                    System.out.println("Running in headless mode in Firefox");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }

//                  System.out.println("Creating new Chrome driver");
//                  driver = new ChromeDriver(); // Instantiation the driver only once

                // *********THE BELOW ACTION DID NOT MAKE ANY DIFFERENCE************
                // Move the window to a secondary monitor (example: monitor on the right side)
                // X=1920 assumes your laptop screen width is 1920 pixels; adjust if yours is different
//            org.openqa.selenium.Point position = new org.openqa.selenium.Point(-1920, 0);
//            driver.manage().window().setPosition(position);

                // Optional: Set specific size (e.g., 1280x800) if needed
                // driver.manage().window().setSize(new Dimension(1280, 800));
            }
            return driver; // return the driver (browser) if it's not null or the one that is just created


        }


        /**
         *This method will quit the driver and set it to null
         */

        public static void closeDriver() {
            System.out.println("Closing the driver");
            if (driver != null) { // check if browser is open
                driver.quit();
                driver = null; // making sure driver is clean from memory
            }

        }
    }
