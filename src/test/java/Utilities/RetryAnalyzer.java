package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Number of retries

    @Override

    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + " | Retry attempt: " + retryCount);
            return true; // Retry the test
        }

        System.out.println("Test failed after " + retryCount + " retries: " + result.getName());
        return false; // No more retries

    }

}