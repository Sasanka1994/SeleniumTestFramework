package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    public static void waitFor(WebDriver driver, Duration timeout, ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBePresent(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToDisappear(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static void waitForPageTitle(WebDriver driver, String title, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.titleIs(title));
    }

}
