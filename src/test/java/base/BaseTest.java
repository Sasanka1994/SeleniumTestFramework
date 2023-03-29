package base;

import config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.BrowserFactory;


import java.util.concurrent.TimeUnit;
public class BaseTest {

    protected WebDriver driver;
    protected Configuration config;

    @BeforeClass
    public void beforeClass() {
        config = new Configuration();

        // Set up Chrome WebDriver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(config.getPageLoadTimeout(), TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        // Code that runs before each test method
        driver.get(config.getBaseUrl()); // Navigate to the base URL before each test method
    }

    @AfterMethod
    public void afterMethod() {
        // Code that runs after each test method
        driver.manage().deleteAllCookies(); // Delete all cookies after each test method
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    // TODO: 26/03/2023 This will be added later on the project
    @BeforeSuite
    public void beforeSuite() {
        // Code that runs before the entire test suite
    }

    @AfterSuite
    public void afterSuite() {
        // Code that runs after the entire test suite
    }

    @BeforeTest
    public void beforeTest() {
        // Code that runs before each test (<test> in testng.xml)
    }

    @AfterTest
    public void afterTest() {
        // Code that runs after each test (<test> in testng.xml)
    }
}
