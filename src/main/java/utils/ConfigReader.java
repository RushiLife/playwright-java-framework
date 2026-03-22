package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties initProp() 
    {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/resources/config/config.properties"
            );

            prop.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
    
}
