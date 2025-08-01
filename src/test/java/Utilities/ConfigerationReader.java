package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigerationReader {

    // Declaring an object of the Properties class --> This class will allow us to read from .properties file
    private static Properties configFile;


    // we need to make sure that the properties are available before main method gets executed

    static {
        String path = "src/test/resources/configuration.properties"; // the path to the properties file

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            configFile = new Properties(); // we are instantiating the configFile object
            // load the file into the configFile object
            configFile.load(fileInputStream);
            fileInputStream.close(); //close the stream

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method will return the value of the key that was passed as a parameter from the property file
     * @param key the key from the property file
     * @return the value of the key
     */
    public static String getPropertyValue(String key){
        return configFile.getProperty(key);
    }

}
