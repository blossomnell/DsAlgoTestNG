package Tests;

import baseTest.BaseTest;
import pageObjects.LinkedListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.LoggerLoad;
import Utilities.TestDataProvider;

@Listeners(Utilities.TestListener.class)
public class LinkedListTest extends BaseTest{
	 
	 @BeforeMethod
	 public void setUp() {
		 LoggerLoad.info("Setting up: Logging into the application...");
	     loginToApplication();
	     LoggerLoad.info("Successfully logged into the application.");
	 }


	 @Test(priority = 1, description = "Navigation to LinkedList page")
	    public void testNavigationToLinkedListPage() {
		    LoggerLoad.info("Test Case: Navigation to LinkedList page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button for LinkedList.");
	        
	        Assert.assertTrue(linkedlistPage.isLinkedListPageDisplayed(), "LinkedList Page is not displayed!");
	        LoggerLoad.info("LinkedList Page is displayed.");
	    }
	
	 @Test(priority = 2, description = "Navigation to Introduction page")
	    public void testIntroductionPage() {
		    LoggerLoad.info("Test Case: Navigation to Introduction page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button for LinkedList.");
	        
	        linkedlistPage.Introduction();
	        LoggerLoad.info("Navigated to Introduction page.");
	        
	        Assert.assertTrue(linkedlistPage.isIntroductionPageDisplayed(), "Introdcution Page is not displayed!");
	        LoggerLoad.info("Introduction Page is displayed.");
	    }
	 
	 @Test(priority = 3, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage() {
		    LoggerLoad.info("Test Case: Navigation to TryEditor page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button for LinkedList.");
	        
	        linkedlistPage.Introduction();
	        LoggerLoad.info("Navigated to Introduction page.");
	        
	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Clicked 'Try Here' button.");
	        
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }
	 
	 @Test(priority = 4, description = "Verify pthon code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
		    LoggerLoad.info("Test Case: Verify Python code execution with Excel data.");
	        LoggerLoad.info("Test Data - Code: " + code + ", Expected Output: " + expectedOutput);
	        
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		 
		    linkedlistPage.clickgetstartedBtn();
		    LoggerLoad.info("Clicked 'Get Started' button for LinkedList.");
		    
	        linkedlistPage.Introduction();
	        LoggerLoad.info("Navigated to Introduction page.");
	        
	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Clicked 'Try Here' button.");

	        linkedlistPage.enterCode(code);
	        LoggerLoad.info("Entered code: " + code);
	        
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Clicked 'Run' button.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            LoggerLoad.info("Popup message: " + popupMessage);
	            Assert.assertTrue(popupMessage.contains("SyntaxError"), "Popup message did not match expected.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            LoggerLoad.info("Actual Output: " + actualOutput);
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	        LoggerLoad.info("Test Passed: Code executed successfully.");
	    }


	 @Test(priority = 5, description = "Navigation to Creating LinkedList page")
	    public void testCreatingLinkedListPage() {
		 LoggerLoad.info("Test Case: Navigation to Creating LinkedList page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button for LinkedList.");
	        
	        linkedlistPage.CreatingLinkedList();
	        LoggerLoad.info("Navigated to Creating LinkedList page.");
	        
	        Assert.assertTrue(linkedlistPage.isCreatingLinkedListPageDisplayed(), "CreatingLinkedList Page is not displayed!");
	        LoggerLoad.info("Creating LinkedList Page is displayed.");
	    }
	 
	 @Test(priority = 6, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage1() {
		    LoggerLoad.info("Test Case: Navigation to TryEditor page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
	        
	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");
	        
	        linkedlistPage.CreatingLinkedList();
	        LoggerLoad.info("Navigated to 'Creating LinkedList' page.");
	        
	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");
	        
	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }
	 
	 @Test(priority = 7, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify python code execution with Excel data.");
		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
		 
		 
		    linkedlistPage.clickgetstartedBtn();
		    LoggerLoad.info("Clicked 'Get Started' button.");
		    
	        linkedlistPage.CreatingLinkedList();
	        LoggerLoad.info("Navigated to 'Creating LinkedList' page.");
	        
	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        linkedlistPage.enterCode(code);
	        LoggerLoad.info("Entering code: " + code);
	        
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Executed code.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                    "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	 }

	 @Test(priority = 8, description = "Navigation to Types of LinkedList page")
	    public void testTypesofLinkedListPage() {
	        LoggerLoad.info("Test Case: Navigation to Types of LinkedList page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.TypesofLinkedList();
	        LoggerLoad.info("Navigated to 'Types of LinkedList' page.");

	        Assert.assertTrue(linkedlistPage.isTypesofLinkedListPageDisplayed(), "TypesofLinkedList Page is not displayed!");
	        LoggerLoad.info("TypesofLinkedList Page is displayed.");
	    }

	    @Test(priority = 9, description = "Navigation to TryEditor page")
	    public void testTryEditorPage2() {
	        LoggerLoad.info("Test Case: Navigation to TryEditor page from Types of LinkedList.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.TypesofLinkedList();
	        LoggerLoad.info("Navigated to 'Types of LinkedList' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }

	    @Test(priority = 10, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify python code execution with Excel data in Types of LinkedList.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.TypesofLinkedList();
	        LoggerLoad.info("Navigated to 'Types of LinkedList' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        LoggerLoad.info("Entering code: " + code);
	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Executed code.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                    "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }
	    @Test(priority = 11, description = "Navigation to Implement Linked List in Python page")
	    public void testImplementLinkedListinPythonPage() {
	        LoggerLoad.info("Test Case: Navigation to Implement Linked List in Python page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.ImplementLinkedListinPython();
	        LoggerLoad.info("Navigated to 'Implement Linked List in Python' page.");

	        Assert.assertTrue(linkedlistPage.isImplementLinkedListinPythonPageDisplayed(), "ImplementLinkedListinPython page is not displayed");
	        LoggerLoad.info("Implement Linked List in Python page is displayed.");
	    }

	    @Test(priority = 12, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage3() {
	        LoggerLoad.info("Test Case: Navigation to Tryeditor page from Implement Linked List in Python.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.ImplementLinkedListinPython();
	        LoggerLoad.info("Navigated to 'Implement Linked List in Python' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }

	    @Test(priority = 13, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData3(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify python code execution with Excel data on 'Implement Linked List in Python'.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.ImplementLinkedListinPython();
	        LoggerLoad.info("Navigated to 'Implement Linked List in Python' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        linkedlistPage.enterCode(code);
	        LoggerLoad.info("Entering code: " + code);
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Executed code.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                    "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	    @Test(priority = 14, description = "Navigation to Traversal Page")
	    public void testTraversalPage() {
	        LoggerLoad.info("Test Case: Navigation to Traversal Page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Traversal();
	        LoggerLoad.info("Navigated to 'Traversal' page.");

	        Assert.assertTrue(linkedlistPage.isTraversalPageDisplayed(), "Traversal page is not displayed");
	        LoggerLoad.info("Traversal page is displayed.");
	    }

	    @Test(priority = 15, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage4() {
	        LoggerLoad.info("Test Case: Navigation to Tryeditor page from Traversal page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Traversal();
	        LoggerLoad.info("Navigated to 'Traversal' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }

	    @Test(priority = 16, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData4(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify python code execution with Excel data on 'Traversal' page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Traversal();
	        LoggerLoad.info("Navigated to 'Traversal' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        linkedlistPage.enterCode(code);
	        LoggerLoad.info("Entering code: " + code);
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Executed code.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                    "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }
	    
	    @Test(priority = 17, description = "Navigation to Insertion Page")
	    public void testInsertionPage() {
	        LoggerLoad.info("Test Case: Navigation to Insertion Page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Insertion();
	        LoggerLoad.info("Navigated to 'Insertion' page.");

	        Assert.assertTrue(linkedlistPage.isInsertionPageDisplayed(), "Insertion page is not displayed");
	        LoggerLoad.info("Insertion page is displayed.");
	    }

	    @Test(priority = 18, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage5() {
	        LoggerLoad.info("Test Case: Navigation to Tryeditor page from Insertion Page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Insertion();
	        LoggerLoad.info("Navigated to 'Insertion' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }

	    @Test(priority = 19, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData5(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify python code execution with Excel data on 'Insertion' page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Insertion();
	        LoggerLoad.info("Navigated to 'Insertion' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        LoggerLoad.info("Entering code: " + code);
	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Executed code.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                    "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	    @Test(priority = 20, description = "Navigation to Deletion Page")
	    public void testDeletionPage() {
	        LoggerLoad.info("Test Case: Navigation to Deletion Page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Deletion();
	        LoggerLoad.info("Navigated to 'Deletion' page.");

	        Assert.assertTrue(linkedlistPage.isDeletionPageDisplayed(), "Deletion page is not displayed");
	        LoggerLoad.info("Deletion page is displayed.");
	    }

	    @Test(priority = 21, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage6() {
	        LoggerLoad.info("Test Case: Navigation to Tryeditor page from Deletion Page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Deletion();
	        LoggerLoad.info("Navigated to 'Deletion' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("TryEditor Page is displayed.");
	    }

	    @Test(priority = 22, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData6(String code, String expectedOutput) {
	        LoggerLoad.info("Test Case: Verify python code execution with Excel data on 'Deletion' page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Deletion();
	        LoggerLoad.info("Navigated to 'Deletion' page.");

	        linkedlistPage.Tryhere();
	        LoggerLoad.info("Navigated to 'Try here' page.");

	        LoggerLoad.info("Entering code: " + code);
	        linkedlistPage.enterCode(code);
	        linkedlistPage.clicksrunBtn();
	        LoggerLoad.info("Executed code.");

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = linkedlistPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                    "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	    @Test(priority = 23, description = "Navigation to Practice Questions page")
	    public void testPracticeQuestionsPage() {
	        LoggerLoad.info("Test Case: Navigation to Practice Questions page.");
	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());

	        linkedlistPage.clickgetstartedBtn();
	        LoggerLoad.info("Clicked 'Get Started' button.");

	        linkedlistPage.Introduction();
	        LoggerLoad.info("Navigated to 'Introduction' page.");

	        linkedlistPage.PracticeQuestions();
	        LoggerLoad.info("Navigated to 'Practice Questions' page.");

	        Assert.assertTrue(linkedlistPage.isPracticeQuestionsPageDisplayed(), "PracticeQuestions Page is not displayed!");
	        LoggerLoad.info("PracticeQuestions Page is displayed.");
	    }
}

	 

	
//	 @Test(priority = 17, description = "Navigation to Insertion Page")
//	    public void testInsertionPage() {
//	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//	        linkedlistPage.clickgetstartedBtn();
//	        linkedlistPage.Insertion();
//	        //linkedlistPage.isInsertionPageDisplayed();
//	        Assert.assertTrue(linkedlistPage.isInsertionPageDisplayed(), "Insertion page is not displayed");
//	    }
//	 
//	 @Test(priority = 18, description = "Navigation to Tryeditor page")
//	    public void testTryEditorPage5() {
//	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//	        linkedlistPage.clickgetstartedBtn();
//	        linkedlistPage.Insertion();
//	        linkedlistPage.Tryhere();
//	        //linkedlistPage.isTryEditorPageDisplayed();
//	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
//	    }
//	 @Test(priority = 19, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
//	    public void testCodeExecutionWithExcelData5(String code, String expectedOutput) {
//		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//		    linkedlistPage.clickgetstartedBtn();
//		    linkedlistPage.Insertion();
//	        linkedlistPage.Tryhere();
//
//	        linkedlistPage.enterCode(code);
//	        linkedlistPage.clicksrunBtn();
//
//	        if (expectedOutput.contains("SyntaxError")) {
//	            String popupMessage = linkedlistPage.getPopupAlertText();
//	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
//	                "Popup message did not match expected. Actual: " + popupMessage);
//	        } else {
//	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
//	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
//	        }
//	    }
//	 
//	 @Test(priority = 20, description = "Navigation to Deletion Page")
//	    public void testDeletionPage() {
//	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//	        linkedlistPage.clickgetstartedBtn();
//	        linkedlistPage.Deletion();
//	        //linkedlistPage.isDeletionPageDisplayed();
//	        Assert.assertTrue(linkedlistPage.isDeletionPageDisplayed(), "Deletion page is not displayed");
//	    }
//	 
//	 @Test(priority = 21, description = "Navigation to Tryeditor page")
//	    public void testTryEditorPage6() {
//	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//	        linkedlistPage.clickgetstartedBtn();
//	        linkedlistPage.Deletion();
//	        linkedlistPage.Tryhere();
//	        //linkedlistPage.isTryEditorPageDisplayed();
//	        Assert.assertTrue(linkedlistPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
//	    }
//	 @Test(priority = 22, description = "Verify python code execution with Excel data", dataProvider = "LinkedListData", dataProviderClass = TestDataProvider.class)
//	    public void testCodeExecutionWithExcelData6(String code, String expectedOutput) {
//		 LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//		    linkedlistPage.clickgetstartedBtn();
//		    linkedlistPage.Deletion();
//	        linkedlistPage.Tryhere();
//
//	        linkedlistPage.enterCode(code);
//	        linkedlistPage.clicksrunBtn();
//
//	        if (expectedOutput.contains("SyntaxError")) {
//	            String popupMessage = linkedlistPage.getPopupAlertText();
//	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
//	                "Popup message did not match expected. Actual: " + popupMessage);
//	        } else {
//	            String actualOutput = linkedlistPage.getOutputTextFromTryEditorPage();
//	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
//	        }
//	    }
//	 
//	 @Test(priority = 23, description = "Navigation to Practice Questions page")
//	    public void testPracticeQuestionsPage() {
//	        LinkedListPage linkedlistPage = new LinkedListPage(getDriver());
//	        linkedlistPage.clickgetstartedBtn();
//	        linkedlistPage.Introduction();
//	        linkedlistPage.PracticeQuestions();
//	       // linkedlistPage.isPracticeQuestionsPageDisplayed();
//	        Assert.assertTrue(linkedlistPage.isPracticeQuestionsPageDisplayed(), "PracticeQuestions Page is not displayed!");
//	    }
//	 
//	 
//}

 
  

