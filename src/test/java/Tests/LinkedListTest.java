package Tests;

import baseTest.BaseTest;
import pageObjects.LinkedListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.TestDataProvider;

public class LinkedListTest extends BaseTest{
	 
	 @BeforeMethod
	 public void setUp() {
	     loginToApplication("Ninjasquad", "abss@123"); // Replace with valid credentials
	 }


	 @Test(priority = 1, description = "Navigation to LinkedList page")
	    public void testNavigationToLinkedListPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        //linkedlistPage.isLinkedListPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isLinkedListPageDisplayed(), "LinkedList Page is not displayed!");
	    }
	
	 @Test(priority = 2, description = "Navigation to Introduction page")
	    public void testIntroductionPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Introduction();
	        //linkedlistPage.isIntroductionPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isIntroductionPageDisplayed(), "Introdcution Page is not displayed!");
	    }
	 
	 @Test(priority = 3, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Introduction();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 @Test(priority = 4, description = "Verify pthon code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		 
		    linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Introduction();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	 @Test(priority = 5, description = "Navigation to Creating LinkedList page")
	    public void testCreatingLinkedListPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.CreatingLinkedList();
	        //linkedlistPage.isCreatingLinkedListPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isCreatingLinkedListPageDisplayed(), "CreatingLinkedList Page is not displayed!");
	    }
	 
	 @Test(priority = 6, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage1() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.CreatingLinkedList();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 @Test(priority = 7, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		 
		    linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.CreatingLinkedList();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	 
	 @Test(priority = 8, description = "Navigation to Types of LinkedList page")
	    public void testTypesofLinkedListPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.TypesofLinkedList();
	        //linkedlistPage.isTypesofLinkedListPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTypesofLinkedListPageDisplayed(), "TypesofLinkedList Page is not displayed!");
	    }
	 
	 @Test(priority = 9, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage2() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.TypesofLinkedList();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 @Test(priority = 10, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		    linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.TypesofLinkedList();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 
	 @Test(priority = 11, description = "Navigation to Implement Linked List in Python page")
	    public void testImplementLinkedListinPythonPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.ImplementLinkedListinPython();
	        //linkedlistPage.isImplementLinkedListinPythonPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isImplementLinkedListinPythonPageDisplayed(), "ImplementLinkedListinPython page is not displayed");
	    }
	 
	 @Test(priority = 12, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage3() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.ImplementLinkedListinPython();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 @Test(priority = 13, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData3(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		    linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.ImplementLinkedListinPython();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 

	 @Test(priority = 14, description = "Navigation to Traversal Page")
	    public void testTraversalPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Traversal();
	        //linkedlistPage.isTraversalPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTraversalPageDisplayed(), "Traversal page is not displayed");
	    }
	 
	 @Test(priority = 15, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage4() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Traversal();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 @Test(priority = 16, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData4(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		    linkedlistPage.clickgetstartedBtn();
		    linkedlistPage.Traversal();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 @Test(priority = 17, description = "Navigation to Insertion Page")
	    public void testInsertionPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Insertion();
	        //linkedlistPage.isInsertionPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isInsertionPageDisplayed(), "Insertion page is not displayed");
	    }
	 
	 @Test(priority = 18, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage5() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Insertion();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 @Test(priority = 19, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData5(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		    linkedlistPage.clickgetstartedBtn();
		    linkedlistPage.Insertion();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 20, description = "Navigation to Deletion Page")
	    public void testDeletionPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Deletion();
	        //linkedlistPage.isDeletionPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isDeletionPageDisplayed(), "Deletion page is not displayed");
	    }
	 
	 @Test(priority = 21, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage6() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Deletion();
	        linkedlistPage.Tryhere();
	        //linkedlistPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 @Test(priority = 22, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData6(String code, String expectedOutput) {
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		    linkedlistPage.clickgetstartedBtn();
		    linkedlistPage.Deletion();
	        linkedlistPage.Tryhere();

	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 23, description = "Navigation to Practice Questions page")
	    public void testPracticeQuestionsPage() {
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        linkedlistPage.clickgetstartedBtn();
	        linkedlistPage.Introduction();
	        linkedlistPage.PracticeQuestions();
	       // linkedlistPage.isPracticeQuestionsPageDisplayed();
	        Assert.assertTrue(linkedlistPage.isPracticeQuestionsPageDisplayed(), "PracticeQuestions Page is not displayed!");
	    }
	 
	 
}

 
  

