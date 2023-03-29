package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtil;

public class LoginPage extends BasePage {

    // Xpath Locators
    private final By usernameinput = By.xpath("//input[@name='username']");
    private final By passwordinput = By.xpath("//input[@name='password']");
    private final By loginbutton = By.xpath("//button[@type='submit']");

    private final By pageTitle =
            By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String userName) {
        WebElement userNameField = driver.findElement(usernameinput);
        WaitUtil.waitForElementToBeVisible(driver, userNameField, 10);
        userNameField.sendKeys(userName); // Type username
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordinput);
        WaitUtil.waitForElementToBeVisible(driver, passwordField, 10);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginbutton);
        WaitUtil.waitForElementToBeClickable(driver, loginButton, 10);
        loginButton.click();
    }

    public void login(String userName, String password) {
        enterPassword(userName);
        enterPassword(password);
        clickLoginButton();
        waitForPageToLoad(10);
        waitForPageTitle("Dashboard", 10); // Page title in Home screen
    }

    public String getPageTitle() {
        WebElement titleWebElement = driver.findElement(pageTitle);
        return titleWebElement.getText();
    }
}
