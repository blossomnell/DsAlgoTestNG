package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.QueuePage;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)

public class QueueTest extends BaseTest {


    @BeforeMethod
    public void setUp() {
        loginToApplication();
    }
    
    @Test(priority = 1, description = "Verify navigation to Queue page")
    public void testNavigationToQueuePage() {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        Assert.assertTrue(queuePage.isQueuePageDisplayed(), "Introduction Page is not displayed!");
    }
    
    @Test(priority = 2, description = "Verify navigation to Implementation of Queue page")
    public void testNavigationToImplementationofQueuePage() {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        queuePage.clickImplementationOfQueueInPythonLink();
        
        Assert.assertTrue(queuePage.isImplementationOfQueueInPythonPageDisplayed(), "Implementation of queue Page is not displayed!");
    }
    
    @Test(priority = 3, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage() {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        queuePage.clickImplementationOfQueueInPythonLink();
        queuePage.clickTryhereButton();
        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }

    @Test(priority = 4, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        queuePage.clickImplementationOfQueueInPythonLink();
        queuePage.clickTryhereButton();

        // Enter code from Excel and execute
        queuePage.enterCode(code);
        queuePage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = queuePage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = queuePage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    
    @Test(priority = 5, description = "Implementation using collections deque page is displayed")
    public void testNavigationToImplementationUsingCollectionsDequePage() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
    	 queuePage.isQueuePageDisplayed();
    	 queuePage.clickImplementationUsingCollectionsDequeLink();
        Assert.assertTrue(queuePage.isImplementationUsingCollectionDequePageDispayed(), "Is Implementation Using Collection Deque Page not displayed!");
    }

    @Test(priority = 6, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage1() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
    	 queuePage.isQueuePageDisplayed();
    	 queuePage.clickImplementationUsingCollectionsDequeLink();
    	 queuePage.clickTryhereButton();
        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }
    @Test(priority = 7, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        queuePage.clickImplementationUsingCollectionsDequeLink();
        queuePage.clickTryhereButton();

        // Enter code from Excel and execute
        queuePage.enterCode(code);
        queuePage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = queuePage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = queuePage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    @Test(priority = 8, description = "Implementation using array page is displayed")
    public void testNavigationToImplementationUsingArrarPage() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
    	 queuePage.isQueuePageDisplayed();
    	 queuePage.clickImplementationUsingarrayLink();
        Assert.assertTrue(queuePage.isImplementationUsingArrayPageDispayed(), "Is Implementation Using Array Page not displayed!");
    }

    @Test(priority = 9, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage2() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
    	 queuePage.isQueuePageDisplayed();
    	 queuePage.clickImplementationUsingarrayLink();
    	 queuePage.clickTryhereButton();
        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }
    @Test(priority = 10, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        queuePage.clickImplementationUsingarrayLink();
        queuePage.clickTryhereButton();

        // Enter code from Excel and execute
        queuePage.enterCode(code);
        queuePage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = queuePage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = queuePage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    @Test(priority = 11, description = "User navigates to the Queue Operations page")
    public void TestUserNavigatesToTheQueueOperationsPage() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
    	 queuePage.isQueuePageDisplayed();
    	 queuePage. clickQueueOperationsLink();
        Assert.assertTrue(queuePage.isQueueOperationsPageDispayed(), "Is Queue operations Page not displayed!");
    }

    @Test(priority = 12, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage3() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
    	 queuePage.isQueuePageDisplayed();
    	 queuePage. clickQueueOperationsLink();
    	 queuePage.clickTryhereButton();
        Assert.assertTrue(queuePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }
    @Test(priority = 13, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData3(String code, String expectedOutput) {
        QueuePage queuePage = new QueuePage(getDriver());
        queuePage.clickGetStarted();
        queuePage.isQueuePageDisplayed();
        queuePage. clickQueueOperationsLink();
        queuePage.clickTryhereButton();

        // Enter code from Excel and execute
        queuePage.enterCode(code);
        queuePage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = queuePage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = queuePage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    @Test(priority = 14, description = "Verify navigation to Practice Questions page")
    public void testNavigationToPracticeQuestionsPage() {
    	 QueuePage queuePage = new QueuePage(getDriver());
    	 queuePage.clickGetStarted();
         queuePage.isQueuePageDisplayed();
         queuePage.clickImplementationOfQueueInPythonLink();
    	 queuePage.clickPracticeQuestionsLink();
        Assert.assertTrue(queuePage.ispracticeQuestionPageDisplayed(),
                "Practice Questions Page is not displayed!");
    }
     
    
    
}