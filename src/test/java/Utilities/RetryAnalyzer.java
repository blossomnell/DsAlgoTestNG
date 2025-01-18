package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int count = 0;
    private static final int MAX_RETRY_COUNT = 3; // Set the number of retries you want

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY_COUNT) {
            count++;
            System.out.println("Retrying test: " + result.getName() + " (Attempt " + count + ")");
            return true; // Retry the test
        }
        return false; // No more retries
    }
}

