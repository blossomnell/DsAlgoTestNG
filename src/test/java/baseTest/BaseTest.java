package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import webdriver.DriverFactory;

public class BaseTest extends AbstractTestNGCucumberTests {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
		
	  @BeforeClass
	    @Parameters({"browser", "headless"})
	    public void setUp(String browser, String headless) {
	        boolean isHeadless = Boolean.parseBoolean(headless); 
	        System.out.println("Initializing WebDriver for browser: " + browser + ", headless: " + isHeadless);
	        driver.set(DriverFactory.getDriver(browser, isHeadless));
	    
	    }
	    
	    @AfterClass
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
	    
	    //@Override
	    @DataProvider(parallel = false) 
	    public Object[][] scenarios() {
	        return super.scenarios();
	}
	}

	 

