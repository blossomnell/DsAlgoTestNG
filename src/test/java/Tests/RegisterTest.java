package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;
import Utilities.TestDataProvider;

public class RegisterTest extends BaseTest {

	@Test(priority = 1, description = "navigates to register page")
	public void testNavigationToRegisterPage() {
		RegisterPage registerPage = new RegisterPage(getDriver());
	
		registerPage.navigatetohomepage();
  	    registerPage.register();
  	    Assert.assertTrue(registerPage.isRegisterPageDisplayed(), "Register Page is not displayed!");
	}
	
    @Test(priority = 2, description = "Test register with multiple data sets", dataProvider = "RegisterData", dataProviderClass = TestDataProvider.class)
    public void testRegister(String username, String password1, String password2, String expectedMessage) {
    	
    	RegisterPage registerPage = new RegisterPage(getDriver());
    	
    	  registerPage.navigatetohomepage();
    	  registerPage.register();
    	  registerPage.enterUsername(username);
    	  registerPage.enterPassword1(password1);
    	  registerPage.enterPassword2(password2);
    	  registerPage.clickregisterBtn();
    	  
 
        if (expectedMessage.equalsIgnoreCase("New Account Created. You are logged in as Ninjasquad")) {
            String currentUrl = getDriver().getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("register"), "Register failed for valid credentials");
        } else {
            String alertMsg = registerPage.getAlertMessage();
            Assert.assertEquals(alertMsg, expectedMessage, "password_mismatch:The two password fields didn’t match.");
        }
    }
}

