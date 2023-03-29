package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtil;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void waitForPageTitle(String title, long timeoutInSeconds) {
        WaitUtil.waitForPageTitle(driver, title, timeoutInSeconds);
    }

    public void waitForPageToLoad(long timeoutInSeconds) {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(pageLoadCondition);
    }
}
