package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DataStructurePage;
import Utilities.LoggerLoad;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)
public class DataStructureTest extends BaseTest {

	@BeforeMethod
    public void setUp() {
        LoggerLoad.info("Setting up: Logging into the application...");
        loginToApplication();
    }

    @Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Data Structures-Introduction page")
    public void testNavigationToIntroductionPage() {
        LoggerLoad.info("Test Case: Verify navigation to Data Structures-Introduction page");
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        Assert.assertTrue(dataStructurePage.isIntroductionPageDisplayed(), "Introduction Page is not displayed!");
        LoggerLoad.info("Test Passed: Introduction Page is displayed.");
    }

    @Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Time Complexity page Failure")
    public void testNavigationToTimeComplexityPage() {
        LoggerLoad.info("Test Case: Verify navigation to Time Complexity page");
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        Assert.assertTrue(dataStructurePage.isTimeComplexityPageDisplayed(), "Time Complexity Page is not displayed!");
        LoggerLoad.info("Test Passed: Time Complexity Page is displayed.");
    }

    @Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage() {
        LoggerLoad.info("Test Case: Verify navigation to Try Editor page");
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        dataStructurePage.clickTryHereButton();
        Assert.assertTrue(dataStructurePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
        LoggerLoad.info("Test Passed: Try Editor Page is displayed.");
    }

    @Test(priority = 4,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
        LoggerLoad.info("Test Case: Verify code execution with Excel data");
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        dataStructurePage.clickTryHereButton();

        LoggerLoad.info("Entering code and executing: " + code);
        dataStructurePage.enterCode(code);
        dataStructurePage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            LoggerLoad.info("Handling popup error...");
            String popupMessage = dataStructurePage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = dataStructurePage.getOutputText();
            LoggerLoad.info("Verifying output: Expected = " + expectedOutput + ", Actual = " + actualOutput);
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }

    @Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Practice Questions page")
    public void testNavigationToPracticeQuestionsPage() {
        LoggerLoad.info("Test Case: Verify navigation to Practice Questions page");
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        dataStructurePage.clickPracticeQuestionsLink();
        Assert.assertTrue(dataStructurePage.isPracticeQuestionsPageDisplayed(),
                "Practice Questions Page is not displayed!");
        LoggerLoad.info("Test Passed: Practice Questions Page is displayed.");
    }
}