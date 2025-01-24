package Tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.LoggerLoad;
import Utilities.TestDataProvider;
import baseTest.BaseTest;

import pageObjects.HomePage;

@Listeners(Utilities.TestListener.class)
public class HomeTest extends BaseTest{
	
	
	 @Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class,dataProvider = "dropdownOptions", dataProviderClass = TestDataProvider.class)
	    public void testHome(String expectedMessage,String option)  {
		    LoggerLoad.info("Test Case: Test HomePage with multiple data sets");
	        LoggerLoad.info("Test Data - DropDownOptions: " + option + ", Expected Message: " + expectedMessage);
	        HomePage home = new HomePage(getDriver());
			home.homePg();
			home.getstarted_DS();
			LoggerLoad.info("Navigated to home page");
			LoggerLoad.info("Test Passed:You are not logged in");
			home.dropdown(expectedMessage);
			LoggerLoad.info("Click on dropdown button");
			home.getStartedForModule(option);
			LoggerLoad.info("Navigate to Homepage");
			home.click_login();
			LoggerLoad.info("Clicked on Login button");
			home.click_register();
			LoggerLoad.info("Click on register button");

	       
	    }

}


