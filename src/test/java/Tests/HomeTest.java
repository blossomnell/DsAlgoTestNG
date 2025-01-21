package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.TestDataProvider;
import baseTest.BaseTest;
import pageObjects.HomePage;



public class HomeTest extends BaseTest{
	
@Test(priority = 2, dataProvider = "dropdownOptions", dataProviderClass = TestDataProvider.class)
public void testHome(String option,String expectedMessage)  {
	HomePage home = new HomePage(getDriver());
	home.homePg();
	home.getstarted_DS();
	Assert.assertEquals(home.alertmsg(), "You are not logged in");
	home.dropdown(expectedMessage);
	home.getStartedForModule(option);
	home.click_login();
	home.click_register();

}

}