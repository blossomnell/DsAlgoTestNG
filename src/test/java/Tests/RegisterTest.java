package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import Utilities.LoggerLoad;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)
public class RegisterTest extends BaseTest {

	@Test(priority = 1, description = "navigates to register page")
	public void testNavigationToRegisterPage() {
		LoggerLoad.info("Test Case: Verify navigation to Register Page");
		RegisterPage registerPage = new RegisterPage(getDriver());
	
		registerPage.navigatetohomepage();
		LoggerLoad.info("Navigated to Home Page");
		
  	    registerPage.register();
  	    LoggerLoad.info("Clicked on Register link");
  	    
  	    Assert.assertTrue(registerPage.isRegisterPageDisplayed(), "Register Page is not displayed!");
  	    LoggerLoad.info("Test Passed: Register Page is displayed.");
	}
	
    @Test(priority = 2, description = "Test register with multiple data sets", dataProvider = "RegisterData", dataProviderClass = TestDataProvider.class)
    public void testRegister(String username, String password1, String password2, String expectedMessage) {
    	
    	LoggerLoad.info("Test Case: Test registration with multiple data sets");
        LoggerLoad.info("Test Data - Username: " + username + ", Password1: " + password1 + ", Password2: " + password2 + ", Expected Message: " + expectedMessage);
    	
    	RegisterPage registerPage = new RegisterPage(getDriver());
    	
    	  registerPage.navigatetohomepage();
    	  LoggerLoad.info("Navigated to Home Page");
    	  
    	  registerPage.register();
    	  LoggerLoad.info("Clicked on Register link");
    	  
    	  registerPage.enterUsername(username);
    	  LoggerLoad.info("Entered username: " + username);
    	  
    	  registerPage.enterPassword1(password1);
    	  registerPage.enterPassword1(password1);
          LoggerLoad.info("Entered password: " + password1);
          
    	  registerPage.enterPassword2(password2);
    	  LoggerLoad.info("Entered confirm password: " + password2);
    	  
    	  registerPage.clickregisterBtn();
    	  LoggerLoad.info("Clicked on Register button");
 
    	  if (expectedMessage.equalsIgnoreCase("New Account Created. You are logged in as Ninjasquad")) {
              String currentUrl = getDriver().getCurrentUrl();
              LoggerLoad.info("Current URL after registration: " + currentUrl);
              Assert.assertTrue(currentUrl.contains("register"), "Register failed for valid credentials");
              LoggerLoad.info("Test Passed: Registration successful with valid credentials.");
          } else {
              String alertMsg = registerPage.getAlertMessage();
              LoggerLoad.info("Alert message received: " + alertMsg);
              Assert.assertEquals(alertMsg, expectedMessage, "password_mismatch: The two password fields didn’t match.");
              LoggerLoad.info("Test Passed: Correct error message displayed for invalid registration.");
          }
      }
  }


