//package Utilities;
//
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//
//public class RetryAnalyzer implements IRetryAnalyzer {
//    private int count = 0;
//    private static final int MAX_RETRY_COUNT = 2; // Retry up to 2 times
//
//    @Override
//    public boolean retry(ITestResult result) {
//        if (count < MAX_RETRY_COUNT) {
//            count++;
//            System.out.println("Retrying test: " + result.getName() + " | Attempt: " + (count + 1));
//            return true;
//        }
//        return false;
//    }
//}