package Utilities;

import baseTest.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Execution Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Tester", "Your Name");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success in the report
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.getDriver();
        String testName = result.getName();

        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "test-output/screenshots/" + testName + ".png";
            try {
                // Ensure the directory exists
                new File("test-output/screenshots/").mkdirs();
                FileUtils.copyFile(screenshot, new File(screenshotPath));

                // Attach screenshot to ExtentReports
                extentTest.get().fail(result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                System.out.println("Error while taking screenshot: " + e.getMessage());
            }
        } else {
            extentTest.get().fail("WebDriver instance is null. Screenshot not taken.");
        }

        extentTest.get().fail("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped test in the report
        extentTest.get().skip("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the ExtentReports object to write the report
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}