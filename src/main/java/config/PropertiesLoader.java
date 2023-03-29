package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertiesLoader {

    private final Properties properties;

    public PropertiesLoader(String filePath) {
        properties = new Properties();
        loadPropertiesFromFile(filePath);
    }

    private void loadPropertiesFromFile(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
