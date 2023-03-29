package config;

public class Configuration {

    private static final String CONFIG_FILE_PATH = "resources/config.properties";
    private final PropertiesLoader propertiesLoader;

    public Configuration() {
        propertiesLoader = new PropertiesLoader(CONFIG_FILE_PATH);
    }

    // Application settings
    public String getBaseUrl() {
        return propertiesLoader.getProperty("base.url");
    }

    // Browser settings
    public String getBrowser() {
        return propertiesLoader.getProperty("browser");
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(propertiesLoader.getProperty("browser.headless"));
    }

    // Timeout settings
    public int getImplicitWait() {
        return Integer.parseInt(propertiesLoader.getProperty("implicitly.wait"));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(propertiesLoader.getProperty("page.load.timeout"));
    }

    // Credentials
    public String getUsername() {
        return propertiesLoader.getProperty("username");
    }

    public String getPassword() {
        return propertiesLoader.getProperty("password");
    }

    // Add more methods to access other properties as needed
}
