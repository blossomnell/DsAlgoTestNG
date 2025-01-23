package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import Utilities.LoggerLoad;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)

public class LoginTest extends BaseTest {

	@Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class,  description = "Navigates to sign in page")
	public void testsignin() {
		LoggerLoad.info("Test Case: Verify navigation to sign in page");
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigatetohomepage();
        loginPage.signin();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login Page is not displayed!");
        LoggerLoad.info("Test Passed: Login Page is displayed.");
		
	}
	
	
    @Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Test login with multiple data sets", dataProvider = "LoginData", dataProviderClass = TestDataProvider.class)
    public void testLogin(String username, String password, String expectedMessage) {
    	LoggerLoad.info("Test Case: Test login with multiple data sets");
        LoggerLoad.info("Test Data - Username: " + username + ", Password: " + password + ", Expected Message: " + expectedMessage);
        
        LoginPage loginPage = new LoginPage(getDriver()); 
        loginPage.navigatetohomepage();
        LoggerLoad.info("Navigated to home page");
        
        loginPage.signin();
        LoggerLoad.info("Navigated to sign-in page");
        
        loginPage.navigatetologinpage();
        LoggerLoad.info("Navigated to login page");
        
        loginPage.enterUsername(username);
        LoggerLoad.info("Entered username: " + username);
        
        loginPage.enterPassword(password);
        LoggerLoad.info("Entered password: " + password);
        
        loginPage.clickloginBtn();
        LoggerLoad.info("Clicked login button");
        
        if (expectedMessage.equalsIgnoreCase("You are logged in")) {
            String currentUrl = getDriver().getCurrentUrl();
            LoggerLoad.info("Current URL after login: " + currentUrl);
            Assert.assertTrue(currentUrl.contains("home"), "Login failed for valid credentials");
            LoggerLoad.info("Test Passed: Login was successful for valid credentials");
        } else {
            String alertMsg = loginPage.getAlertMessage();
            LoggerLoad.info("Alert message received: " + alertMsg);
            Assert.assertEquals(alertMsg, expectedMessage, "Error message mismatch for invalid login");
            LoggerLoad.info("Test Passed: Correct error message displayed for invalid login");
        }
    }
}
       
