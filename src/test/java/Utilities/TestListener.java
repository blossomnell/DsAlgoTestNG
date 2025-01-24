package Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import baseTest.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

	@Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot on failure
        WebDriver driver = BaseTest.getDriver();
        if (driver != null) {
            String testName = result.getName(); // Get test method name
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "screenshots/" + testName + ".png";
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot taken for test: " + testName);
            } catch (IOException e) {
                System.out.println("Error while taking screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("WebDriver instance is null. Screenshot not taken.");
        }

        // Check if the test is being retried
        if (result.getMethod().getRetryAnalyzer(result) != null) {
            boolean willRetry = result.getMethod().getRetryAnalyzer(result).retry(result);
            if (willRetry) {
                System.out.println("Retrying test: " + result.getName());
            } else {
                System.out.println("Test failed after retries: " + result.getName());
            }
        }
    }

    @Override
    public void onStart(ITestContext context) {
        // No specific action required here
    }

    @Override
    public void onFinish(ITestContext context) {
        // No specific action required here
    }

    @Override
    public void onTestStart(ITestResult result) {
        // No specific action required here
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // No specific action required here
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	System.out.println("Test skipped: " + result.getName());
    }
}