package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.TestDataProvider;
import baseTest.BaseTest;
import pageObjects.HomePage;



public class HomeTest extends BaseTest{
	
@Test(priority = 1, dataProvider = "dropdownOptions", dataProviderClass = TestDataProvider.class)
public void testHome(String expectedMessage,String option)  {
	HomePage home = new HomePage(getDriver());
	home.homePg();
	home.getstarted_DS();
	Assert.assertEquals(home.alertmsg(), "You are not logged in");
	home.dropdown(expectedMessage);
	home.getStartedForModule(option);
	Assert.assertEquals(home.alertmsg(), "You are not logged in");
	home.click_login();
	home.click_register();

}


}