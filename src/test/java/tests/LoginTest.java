package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        // Verify the page title after login
        String expectedPageTitle = "Dashboard";
        String actualPageTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Test");

    }
}
