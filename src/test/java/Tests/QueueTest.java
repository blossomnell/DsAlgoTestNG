package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.QueuePage;
import Utilities.LoggerLoad;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)

public class QueueTest extends BaseTest {


	  @BeforeMethod
	    public void setUp() {
	        LoggerLoad.info("Setting up before test execution: Logging into the application...");
	        loginToApplication();
	    }

	    @Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Queue page")
	    public void testNavigationToQueuePage() {
	        LoggerLoad.info("Test Case: Verify navigation to Queue Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        Assert.assertTrue(queuePage.isQueuePageDisplayed(), "Introduction Page is not displayed!");
	    }

	    @Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Implementation of Queue page")
	    public void testNavigationToImplementationofQueuePage() {
	        LoggerLoad.info("Test Case: Verify navigation to Implementation of Queue Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationOfQueueInPythonLink();
	        Assert.assertTrue(queuePage.isImplementationOfQueueInPythonPageDisplayed(), "Implementation of queue Page is not displayed!");
	    }

	    @Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page")
	    public void testNavigationToTryEditorPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationOfQueueInPythonLink();
	        queuePage.clickTryhereButton();
	        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 4, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationOfQueueInPythonLink();
	        queuePage.clickTryhereButton();

	        LoggerLoad.info("Entering code and executing: " + code);
	        queuePage.enterCode(code);
	        queuePage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	            LoggerLoad.info("Handling popup error...");
	            String popupMessage = queuePage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = queuePage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Implementation using collections deque page is displayed")
	    public void testNavigationToImplementationUsingCollectionsDequePage() {
	        LoggerLoad.info("Test Case: Verify navigation to Implementation Using Collections Deque Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationUsingCollectionsDequeLink();
	        Assert.assertTrue(queuePage.isImplementationUsingCollectionDequePageDispayed(), "Is Implementation Using Collection Deque Page not displayed!");
	    }

	    @Test(priority = 6, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page")
	    public void testNavigationToTryEditorPage1() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page 1");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationUsingCollectionsDequeLink();
	        queuePage.clickTryhereButton();
	        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 7, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data 1");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationUsingCollectionsDequeLink();
	        queuePage.clickTryhereButton();

	        LoggerLoad.info("Entering code and executing: " + code);
	        queuePage.enterCode(code);
	        queuePage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	            LoggerLoad.info("Handling popup error...");
	            String popupMessage = queuePage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = queuePage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 8, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Implementation using array page is displayed")
	    public void testNavigationToImplementationUsingArrayPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Implementation Using Array Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationUsingarrayLink();
	        Assert.assertTrue(queuePage.isImplementationUsingArrayPageDispayed(), "Is Implementation Using Array Page not displayed!");
	    }

	    @Test(priority = 9, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page")
	    public void testNavigationToTryEditorPage2() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page 2");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationUsingarrayLink();
	        queuePage.clickTryhereButton();
	        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 10, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data 2");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationUsingarrayLink();
	        queuePage.clickTryhereButton();

	        LoggerLoad.info("Entering code and executing: " + code);
	        queuePage.enterCode(code);
	        queuePage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	            LoggerLoad.info("Handling popup error...");
	            String popupMessage = queuePage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = queuePage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 11, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "User navigates to the Queue Operations page")
	    public void TestUserNavigatesToTheQueueOperationsPage() {
	        LoggerLoad.info("Test Case: User navigates to the Queue Operations Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickQueueOperationsLink();
	        Assert.assertTrue(queuePage.isQueueOperationsPageDispayed(), "Is Queue operations Page not displayed!");
	    }

	    @Test(priority = 12, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page")
	    public void testNavigationToTryEditorPage3() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page 3");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickQueueOperationsLink();
	        queuePage.clickTryhereButton();
	        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 13, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData3(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data 3");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickQueueOperationsLink();
	        queuePage.clickTryhereButton();

	        LoggerLoad.info("Entering code and executing: " + code);
	        queuePage.enterCode(code);
	        queuePage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	            LoggerLoad.info("Handling popup error...");
	            String popupMessage = queuePage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = queuePage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 14, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Practice Questions page")
	    public void testNavigationToPracticeQuestionsPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Practice Questions Page");
	        QueuePage queuePage = new QueuePage(getDriver());
	        queuePage.clickGetStarted();
	        queuePage.isQueuePageDisplayed();
	        queuePage.clickImplementationOfQueueInPythonLink();
	        queuePage.clickPracticeQuestionsLink();
	        Assert.assertTrue(queuePage.ispracticeQuestionPageDisplayed(),
	                "Practice Questions Page is not displayed!");
	    }
	}