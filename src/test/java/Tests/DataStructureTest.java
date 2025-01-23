package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DataStructurePage;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)
public class DataStructureTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        loginToApplication();
    }
	
    @Test(priority = 1, description = "Verify navigation to Data Structures-Introduction page")
    public void testNavigationToIntroductionPage() {
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        Assert.assertTrue(dataStructurePage.isIntroductionPageDisplayed(), "Introduction Page is not displayed!");
    }

    @Test(priority = 2, description = "Verify navigation to Time Complexity page")
    public void testNavigationToTimeComplexityPage() {
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        Assert.assertTrue(dataStructurePage.isTimeComplexityPageDisplayed(), "Time Complexity Page is not displayed!");
    }

    @Test(priority = 3, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage() {
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        dataStructurePage.clickTryHereButton();
        Assert.assertTrue(dataStructurePage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }

    @Test(priority = 4, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        dataStructurePage.clickTryHereButton();

        // Enter code from Excel and execute
        dataStructurePage.enterCode(code);
        dataStructurePage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = dataStructurePage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = dataStructurePage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }

    @Test(priority = 5, description = "Verify navigation to Practice Questions page")
    public void testNavigationToPracticeQuestionsPage() {
        DataStructurePage dataStructurePage = new DataStructurePage(getDriver());
        dataStructurePage.navigateToDataStructuresPage();
        dataStructurePage.clickTimeComplexityLink();
        dataStructurePage.clickPracticeQuestionsLink();
        Assert.assertTrue(dataStructurePage.isPracticeQuestionsPageDisplayed(),
                "Practice Questions Page is not displayed!");
    }
}

