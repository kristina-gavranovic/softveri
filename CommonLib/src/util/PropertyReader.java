
package util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropertyReader {

    private Properties properties;
    private static PropertyReader instance;

    private PropertyReader() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src\\resources\\database.properties"));
        } catch (Exception ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
