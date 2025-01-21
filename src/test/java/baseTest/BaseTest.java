package baseTest;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import driverManager.DriverManager;
import pageObjects.LoginPage;
	
	public class BaseTest {    
		protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	        
	  @BeforeClass(alwaysRun = true)
	    @Parameters({"browser", "headless"})
	    public void setUp(String browser, String headless) {
	        boolean isHeadless = Boolean.parseBoolean(headless); 
	        System.out.println("Initializing WebDriver for browser: " + browser + ", headless: " + isHeadless);
	        driver.set(DriverManager.getDriver(browser, isHeadless));    
	    }
    
	    @AfterClass(alwaysRun = true)
	    public void tearDown() {
	        if (driver.get() != null) {
	            System.out.println("Quitting WebDriver for thread: " + Thread.currentThread().getName());
	            driver.get().quit();
	            driver.remove();
	        }
	    }
	   
	        @AfterMethod(alwaysRun = true) 
	        public void clearCookies() {
	            if (driver != null) {
	                driver.get().manage().deleteAllCookies();
	            }
	        }
	    
	    public static WebDriver getDriver() {
	        return driver.get();
	    }
	        
	    public void loginToApplication(String username, String password) {
	        LoginPage loginPage = new LoginPage(getDriver());
	        loginPage.navigatetohomepage();
	        loginPage.signin();
	        loginPage.navigatetologinpage();
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickloginBtn();
	        if (!loginPage.isSignOutButtonDisplayed()) {
	            throw new RuntimeException("Login failed! Cannot proceed with the tests.");
	        }
	    }
	    
	}

	 

