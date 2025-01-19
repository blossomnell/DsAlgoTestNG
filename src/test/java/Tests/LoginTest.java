package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import Utilities.TestDataProvider;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Test login with multiple data sets", dataProvider = "LoginData", dataProviderClass = TestDataProvider.class)
    public void testLogin(String username, String password, String expectedMessage) {
        LoginPage loginPage = new LoginPage(getDriver()); 
        loginPage.navigatetohomepage();
        loginPage.signin();
        loginPage.navigatetologinpage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickloginBtn();
       
        if (expectedMessage.equalsIgnoreCase("You are logged in")) {
            String currentUrl = getDriver().getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("home"), "Login failed for valid credentials");
        } else {
            String alertMsg = loginPage.getAlertMessage();
            Assert.assertEquals(alertMsg, expectedMessage, "Error message mismatch for invalid login");
        }
    }
}