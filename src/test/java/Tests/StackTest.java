package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.QueuePage;
import pageObjects.StackPage;
import Utilities.LoggerLoad;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)

public class StackTest extends BaseTest {


	  @BeforeMethod
	    public void setUp() {
	        LoggerLoad.info("Setting up before test execution: Logging into the application...");
	        loginToApplication();
	    }

	    @Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Stack page")
	    public void testNavigationToStackPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Stack Page");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        Assert.assertTrue(stackPage.isStackPageDisplayed(), "Stack Page is not displayed!");
	    }

	    @Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Operations in Stack page")
	    public void testNavigationToOperationsInStackPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Operations in Stack Page");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickOperationsInStackLink();
	        Assert.assertTrue(stackPage.isOperationsInStackPageDisplayed(), "Operations in Stack Page is not displayed!");
	    }

	    @Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page")
	    public void testNavigationToTryEditorPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickOperationsInStackLink();
	        stackPage.scrollDownAndClickTryHere();
	        Assert.assertTrue(stackPage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 4, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickOperationsInStackLink();
	        stackPage.scrollDownAndClickTryHere();

	        stackPage.enterCode(code);
	        stackPage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = stackPage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"), "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = stackPage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Implementation page")
	    public void testNavigationToImplementationPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Implementation Page");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickImplementationLink();
	        Assert.assertTrue(stackPage.isImplementationPageDisplayed(), "Implementation Page is not displayed!");
	    }

	    @Test(priority = 6, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page for Implementation")
	    public void testNavigationToTryEditorPageForImplementation() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page for Implementation");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickImplementationLink();
	        stackPage.scrollDownAndClickTryHere();
	        Assert.assertTrue(stackPage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 7, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data for Implementation", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelDataForImplementation(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data for Implementation");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickImplementationLink();
	        stackPage.scrollDownAndClickTryHere();

	        stackPage.enterCode(code);
	        stackPage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = stackPage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"), "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = stackPage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 8, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Applications page")
	    public void testNavigationToApplicationsPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Applications Page");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickApplicationLink();
	        Assert.assertTrue(stackPage.isApplicationPageDisplayed(), "Applications Page is not displayed!");
	    }

	    @Test(priority = 9, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Try Editor page for Applications")
	    public void testNavigationToTryEditorPageForApplications() {
	        LoggerLoad.info("Test Case: Verify navigation to Try Editor Page for Applications");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickApplicationLink();
	        stackPage.scrollDownAndClickTryHere();
	        Assert.assertTrue(stackPage.isTryEditorPageDisplayed(), "Try Editor Page is not displayed!");
	    }

	    @Test(priority = 10, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data for Applications", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelDataForApplications(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify code execution with Excel data for Applications");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickApplicationLink();
	        stackPage.scrollDownAndClickTryHere();

	        stackPage.enterCode(code);
	        stackPage.clickRunButton();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = stackPage.handlePopupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"), "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = stackPage.getOutputText();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	    @Test(priority = 11, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Practice Questions page")
	    public void testNavigationToPracticeQuestionsPage() {
	        LoggerLoad.info("Test Case: Verify navigation to Practice Questions Page");
	        StackPage stackPage = new StackPage(getDriver());
	        stackPage.clickGetStarted();
	        stackPage.isStackPageDisplayed(); // Ensured this line remains as is
	        stackPage.clickOperationsInStackLink();
	        stackPage.clickPracticeQuestionsLink();
	        Assert.assertTrue(stackPage.isPracticePageDisplayed(), "Practice Questions Page is not displayed!");
	    }
	}