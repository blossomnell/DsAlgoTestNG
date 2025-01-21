package baseTest;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.LoginPage;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "headless"})
    public void setUp(String browser, String headless) {
        boolean isHeadless = Boolean.parseBoolean(headless);
        System.out.println("Setting up WebDriver for browser: " + browser + ", headless: " + isHeadless);
        driver.set(DriverManager.getDriver(browser, isHeadless));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver.get() != null) {
            System.out.println("Quitting WebDriver for thread: " + Thread.currentThread().getName());
            DriverManager.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        if (driver.get() != null) {
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

