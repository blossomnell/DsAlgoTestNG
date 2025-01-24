package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0; // Current retry attempt
    private static final int maxRetryCount = 2; // Maximum retry attempts

    @Override
    public boolean retry(ITestResult result) {
        // Check if the test can be retried
        if (retryCount < maxRetryCount) {
            retryCount++; // Increment retry counter
            System.out.println("Retrying test: " + result.getName() + " | Retry attempt: " + retryCount);
            return true; // Retry the test
        }
        // Log failure after all retries
        System.out.println("Test failed after " + retryCount + " retries: " + result.getName());
        return false; // No more retries
    }
}
