package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.LoggerLoad;
import Utilities.TestDataProvider;
import pageObjects.GraphPage;


@Listeners(Utilities.TestListener.class)
public class GraphTest extends BaseTest{
          
	@BeforeMethod
	 public void setUp() {
		LoggerLoad.info("Setting up: Logging into the application...");
	     loginToApplication();
	 }
	
	 @Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Graph page")
	    public void testNavigationToGraphPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Graph page");
	        GraphPage graphPage = new GraphPage(getDriver());
	        graphPage.clickgetstartedBtn();
	        Assert.assertTrue(graphPage.isGraphPageDisplayed(), "Graph Page is not displayed!");
	        LoggerLoad.info("Test Passed: Graph Page is displayed.");
	    }
	 
	 @Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to MainGraph page")
	    public void testMainGraphPage() {
		 LoggerLoad.info("Test Case: Verify navigation to MainGraph page");
	        GraphPage graphPage = new GraphPage(getDriver());
	        
	        graphPage.clickgetstartedBtn();
	        graphPage.MainGraph();
	        Assert.assertTrue(graphPage.isMainGraphPageDisplayed(), "MainGraph Page is not displayed!");
	        LoggerLoad.info("Test Passed: MainGraph Page is displayed.");
	    }
	 
	 @Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Tryeditor page");
		 GraphPage graphPage = new GraphPage(getDriver());
	        
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.Tryhere();
	        //graphPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(graphPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("Test Passed: Tryeditor Page is displayed.");
	    }
	 
	 @Test(priority = 4, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to MainGraph page");
		 GraphPage graphPage = new GraphPage(getDriver());
		 
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.Tryhere();
		 LoggerLoad.info("Entering code and executing: " + code);
		 graphPage.enterCode(code);
		 graphPage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = graphPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = graphPage.getOutputTextFromTryEditorPage();
	            LoggerLoad.info("Verifying output: Expected = " + expectedOutput + ", Actual = " + actualOutput);
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Graph Representations page")
	    public void testGraphRepresentationsPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Graph Representations page");
		 GraphPage graphPage = new GraphPage(getDriver());
	        graphPage.clickgetstartedBtn();
	        graphPage.MainGraph();
	        graphPage.GraphRepresentations();
	        Assert.assertTrue(graphPage.isGraphRepresentationPageDisplayed(), "GraphRepresentation Page is not displayed!");
	        LoggerLoad.info("Test Passed: Graph Representations Page is displayed.");
	    }
	 
	 
	 @Test(priority = 6, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage1() {
		 LoggerLoad.info("Test Case: Verify navigation to Tryeditor page");
		 GraphPage graphPage = new GraphPage(getDriver());
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.GraphRepresentations();
		 graphPage.Tryhere();
	        
	     Assert.assertTrue(graphPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	     LoggerLoad.info("Test Passed: Tryeditor Page is displayed.");
	    }
	 
	 @Test(priority = 7, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify python code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Graph Representations page");
		 GraphPage graphPage = new GraphPage(getDriver());
		 
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.GraphRepresentations();
		 graphPage.Tryhere();
		 LoggerLoad.info("Entering code and executing: " + code);
		 graphPage.enterCode(code);
		 graphPage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = graphPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = graphPage.getOutputTextFromTryEditorPage();
	            LoggerLoad.info("Verifying output: Expected = " + expectedOutput + ", Actual = " + actualOutput);
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	 }
	        
	        @Test(priority = 8, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Practice Questions page")
		    public void testPracticeQuestionsPage() {
	        	LoggerLoad.info("Test Case: Verify navigation to Practice Questions page");
	        	GraphPage graphPage = new GraphPage(getDriver());
	        	graphPage.clickgetstartedBtn();
	        	graphPage.MainGraph();
	        	graphPage.PracticeQuestions();
		       // graphPage.isPracticeQuestionsPageDisplayed();
		        Assert.assertTrue(graphPage.isPracticeQuestionsPageDisplayed(), "PracticeQuestions Page is not displayed!");
		        LoggerLoad.info("Test Passed: Practice Questions Page is displayed.");
		     
	        
	    }
	 
	 
}
