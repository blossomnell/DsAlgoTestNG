package baseTest;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import Utilities.ExcelReader;
import Utilities.configReader;
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
	    	DriverManager.quitDriver();
//	        if (driver.get() != null) {
//	            System.out.println("Quitting WebDriver for thread: " + Thread.currentThread().getName());
//	            driver.get().quit();
//	            driver.remove();
//	        }
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
	    
	    public void loginToApplication() {
	    	  try {
	    		  
	    		  configReader configReader = new configReader();
	    		  Properties Prop = configReader.init_prop();
	    	        String excelFilePath = Prop.getProperty("excelFilePath");
	    		 
	    		  
//	    	  String excelFilePath = "src/test/resources/loginData.xlsx";
	    	    ExcelReader excelReader = new ExcelReader(excelFilePath);

	    	    // Read credentials from the Excel sheet
	    	    String username = excelReader.getCellData("LoginValidData", 0, 1); // Row 0, Column 1
	    	    String password = excelReader.getCellData("LoginValidData", 1, 1); // Row 1, Column 1

	    	    // Perform login
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
	     // Close the workbook
	        excelReader.closeWorkbook();

	    } catch (IOException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to read login data from Excel file: " + e.getMessage());
	    }
	    }
	}
	 

