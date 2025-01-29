package com.testing.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader() {
        // Constructor implementation
    }
    public static String readKey(String key) {
        String value = null;
        Properties properties = new Properties();

        // Use try-with-resources for auto-closure
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties"
        )) {
            properties.load(fileInputStream);
            value= properties.getProperty(key);
        } catch (FileNotFoundException e) {
            System.err.println("Properties file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
        }
        return value;
    }
}
