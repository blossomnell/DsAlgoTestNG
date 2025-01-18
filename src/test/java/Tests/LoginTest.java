package Tests;

import baseTest.BaseTest;
import pageObjects.LoginPage;
//import static org.testng.Assert.assertEquals;
import org.testng.Assert;

import org.testng.annotations.Test;
import Utilities.RetryAnalyzer; 

public class LoginTest extends BaseTest {

    //@Test(priority = 1, description = "Test valid login")
    @Test(priority = 1, description = "Test valid login", retryAnalyzer = RetryAnalyzer.class)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickloginBtn();

        // Add assertions to validate successful login
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("home"), "Login failed for valid credentials");
    }

    @Test(priority = 2, description = "Test invalid login", retryAnalyzer = RetryAnalyzer.class)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickloginBtn();

        
        String alertMsg = loginPage.getAlertMessage();
        Assert.assertEquals(alertMsg, "Invalid username or password", "Error message mismatch for invalid login");
    }

    @Test(priority = 3, description = "Test empty login fields", retryAnalyzer = RetryAnalyzer.class)
    public void testEmptyLoginFields() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickloginBtn();

        String alertMsg = loginPage.getAlertMessage();
        Assert.assertEquals(alertMsg, "Please fill out this field.", "Error message mismatch for empty fields");
    }
}
