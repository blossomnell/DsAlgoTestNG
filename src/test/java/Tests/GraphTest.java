package Tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.TestDataProvider;
import pageObjects.GraphPage;

public class GraphTest extends BaseTest{
          
	@BeforeMethod
	 public void setUp() {
	     loginToApplication();
	 }
	
	 @Test(priority = 1, description = "Navigation to Graph page")
	    public void testNavigationToGraphPage() {
	        GraphPage graphPage = new GraphPage(getDriver());
	        
	        graphPage.clickgetstartedBtn();
	        Assert.assertTrue(graphPage.isGraphPageDisplayed(), "Graph Page is not displayed!");
	    }
	 
	 @Test(priority = 2, description = "Navigation to MainGraph page")
	    public void testMainGraphPage() {
	        GraphPage graphPage = new GraphPage(getDriver());
	        
	        graphPage.clickgetstartedBtn();
	        graphPage.MainGraph();
	        Assert.assertTrue(graphPage.isMainGraphPageDisplayed(), "MainGraph Page is not displayed!");
	    }
	 
	 @Test(priority = 3, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage() {
		 GraphPage graphPage = new GraphPage(getDriver());
	        
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.Tryhere();
	        //graphPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(graphPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 @Test(priority = 4, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
		 GraphPage graphPage = new GraphPage(getDriver());
		 
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.Tryhere();

		 graphPage.enterCode(code);
		 graphPage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	            String popupMessage = graphPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = graphPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 5, description = "Navigation to Graph Representations page")
	    public void testGraphRepresentationsPage() {
		 GraphPage graphPage = new GraphPage(getDriver());
	        graphPage.clickgetstartedBtn();
	        graphPage.MainGraph();
	        graphPage.GraphRepresentations();
	        Assert.assertTrue(graphPage.isGraphRepresentationPageDisplayed(), "GraphRepresentation Page is not displayed!");
	    }
	 @Test(priority = 6, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage1() {
		 GraphPage graphPage = new GraphPage(getDriver());
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.GraphRepresentations();
		 graphPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(graphPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 @Test(priority = 7, description = "Verify python code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 GraphPage graphPage = new GraphPage(getDriver());
		 
		 graphPage.clickgetstartedBtn();
		 graphPage.MainGraph();
		 graphPage.GraphRepresentations();
		 graphPage.Tryhere();

		 graphPage.enterCode(code);
		 graphPage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	            String popupMessage = graphPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = graphPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	 }
	        
	        @Test(priority = 8, description = "Navigation to Practice Questions page")
		    public void testPracticeQuestionsPage() {
	        	GraphPage graphPage = new GraphPage(getDriver());
	        	graphPage.clickgetstartedBtn();
	        	graphPage.MainGraph();
	        	graphPage.PracticeQuestions();
		       // graphPage.isPracticeQuestionsPageDisplayed();
		        Assert.assertTrue(graphPage.isPracticeQuestionsPageDisplayed(), "PracticeQuestions Page is not displayed!");
		     
	        
	    }
	 
	 
}
