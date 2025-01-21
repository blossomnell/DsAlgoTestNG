package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.QueuePage;
import pageObjects.StackPage;
import Utilities.TestDataProvider;

public class StackTest extends BaseTest {


    @BeforeMethod
    public void setUp() {
        loginToApplication();
    }
    
    @Test(priority = 4, description = "Verify navigation to Stack page")
    public void testNavigationToStackPage() {
        StackPage stackPage = new StackPage(getDriver());
        stackPage.clickGetStarted();
        stackPage.isStackPageDisplayed();
        Assert.assertTrue(stackPage.isStackPageDisplayed(), "Stack Page is not displayed!");
    }
    
    @Test(priority = 4, description = "Verify navigation to Implementation of Queue page")
    public void testNavigationToImplementationofQueuePage() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickOperationsInStackLink();
        
        Assert.assertTrue(stackPage.isOperationsInStackPageDisplayed(), "Implementation of queue Page is not displayed!");
    }
    
    @Test(priority = 4, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickOperationsInStackLink();
    	 stackPage.scrollDownAndClickTryHere();
        Assert.assertTrue(stackPage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }

    @Test(priority = 4, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickOperationsInStackLink();
    	 stackPage.scrollDownAndClickTryHere();
        // Enter code from Excel and execute
    	 stackPage.enterCode(code);
    	 stackPage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = stackPage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = stackPage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    @Test(priority = 4, description = "Implementation")
    public void testNavigationToImplementation() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickImplementationLink();
        Assert.assertTrue(stackPage.isImplementationPageDisplayed(), "Is Implementation Page not displayed!");
    }

    @Test(priority = 4, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage1() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickImplementationLink();
    	 stackPage.scrollDownAndClickTryHere();
        Assert.assertTrue(stackPage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }
    @Test(priority = 4, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickImplementationLink();
        stackPage.scrollDownAndClickTryHere();

        // Enter code from Excel and execute
        stackPage.enterCode(code);
        stackPage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = stackPage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = stackPage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    @Test(priority = 4, description = "Applications")
    public void testNavigationToApplications() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickApplicationLink();
        Assert.assertTrue(stackPage.isApplicationPageDisplayed(), "Is Application Page not displayed!");
    }

    @Test(priority = 4, description = "Verify navigation to Try Editor page")
    public void testNavigationToTryEditorPage2() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickApplicationLink();
    	 stackPage.scrollDownAndClickTryHere();
        Assert.assertTrue(stackPage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
    }
    @Test(priority = 4, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickApplicationLink();
        stackPage.scrollDownAndClickTryHere();

        // Enter code from Excel and execute
        stackPage.enterCode(code);
        stackPage.clickRunButton();

        if (expectedOutput.contains("popup error message")) {
            String popupMessage = stackPage.handlePopupError();
            Assert.assertTrue(popupMessage.contains("SyntaxError"),
                "Popup message did not match expected. Actual: " + popupMessage);
        } else {
            String actualOutput = stackPage.getOutputText();
            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
        }
    }
    @Test(priority = 4, description = "Verify navigation to Practice Questions page")
    public void testNavigationToPracticeQuestionsPage() {
    	 StackPage stackPage = new StackPage(getDriver());
    	 stackPage.clickGetStarted();
    	 stackPage.isStackPageDisplayed();
    	 stackPage.clickOperationsInStackLink();
    	 stackPage.clickPracticeQuestionsLink();
        Assert.assertTrue(stackPage.isPracticePageDisplayed(),
                "Practice Questions Page is not displayed!");
    }
    
}
