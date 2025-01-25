package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.LoggerLoad;
import Utilities.TestDataProvider;
import baseTest.BaseTest;
import pageObjects.ArrayPage;
import pageObjects.GraphPage;

@Listeners(Utilities.TestListener.class)
public class ArrayTest extends BaseTest{
          
	@BeforeMethod
	 public void setUp() {
		LoggerLoad.info("Setting up: Logging into the application...");
	     loginToApplication();
	 }
	
	 @Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Array page")
	    public void testNavigationToArrayPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
	        Assert.assertTrue(arrayPage.ArraypageDisplayed(), "Array Page is not displayed!");
	        LoggerLoad.info("Test Passed: Array Page is displayed.");
	    }

	 @Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to ArraysInPython page")
	    public void testArraysInPythonPage() {
		 LoggerLoad.info("Test Case: Verify navigation to ArraysInPython page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
	        Assert.assertTrue(arrayPage.isArraysInPythonButtonisDisplayed(), "ArraysInPython Page is not displayed!");
	        LoggerLoad.info("Test Passed: ArraysInPython Page is displayed.");
	    }

	 @Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Tryeditor page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("Test Passed: Tryeditor Page is displayed.");
	    }

	 @Test(priority = 4, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to ArraysInPython page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.Tryhere();

		 arrayPage.enterCode(code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            LoggerLoad.info("Popup message: " + popupMessage);
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Test Passed: Code executed successfully.");
	        }
	    }


	 @Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Arrays Using List page")
	    public void testArraysUsingListPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Arrays Using List page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ArrayUsingList();
	        Assert.assertTrue(arrayPage.isArraysUsingListButtonisDisplayed(), "ArrayUsingList Page is not displayed!");
	        LoggerLoad.info("Test Passed: Arrays Using List Page is displayed.");
	    }

	 @Test(priority = 6, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage1() {
		 LoggerLoad.info("Test Case: Verify navigation to Tryeditor page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ArrayUsingList();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("Test Passed: Tryeditor Page is displayed.");
	    }


	 @Test(priority = 7, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Arrays Using List page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysUsingListButton();
		 arrayPage.Tryhere();

		 arrayPage.enterCode(code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 @Test(priority = 8, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Basic Operations In List page")
	    public void testBasicOperationsInListPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Basic Operations In List page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.BasicOperationsInList();
	        Assert.assertTrue(arrayPage.isBasicOperationsInListsButtonisDisplayed(), "BasicOperationsInList Page is not displayed!");
	        LoggerLoad.info("Test Passed: Basic Operations In List Page is displayed.");
	    }

	 @Test(priority = 9, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage2() {
		 LoggerLoad.info("Test Case: Verify navigation to Tryeditor page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.BasicOperationsInList();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("Test Passed: Tryeditor Page is displayed.");
	    }

	 @Test(priority = 10, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Basic Operations In List page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.BasicOperationsInList();
		 arrayPage.Tryhere();

		 arrayPage.enterCode(code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 //new
	 @Test(priority = 11, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Application Of Array page")
	    public void testApplicationOfArrayPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Application Of Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ApplicationOfArray();
	        Assert.assertTrue(arrayPage.isApplicationOfArrayButtonisDisplayed(), "ApplicationOfArray Page is not displayed!");
	        LoggerLoad.info("Test Passed: Application Of Array Page is displayed.");
	    }

	 @Test(priority = 12, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage3() {
		 LoggerLoad.info("Test Case: Verify navigation to Tryeditor page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ApplicationOfArray();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	        LoggerLoad.info("Test Passed: Tryeditor Page is displayed.");
	    }

	 @Test(priority = 13, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData3(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Application Of Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ApplicationOfArray();
		 arrayPage.Tryhere();

		 arrayPage.enterCode(code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 @Test(priority = 14, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Practice Questions page")
	    public void testPracticeQuestionsPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Practice Questions page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
	       // arrayPage.isPracticeQuestionsPageDisplayed();
	        Assert.assertTrue(arrayPage.isPracticeQuestionsPageisDisplayed(), "PracticeQuestions Page is not displayed!");
	        LoggerLoad.info("Test Passed: Practice Questions Page is displayed.");


       }

	 
	 @Test(priority = 15, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Search The Array page")
	    public void testSearchTheArrayPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Search The Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SearchTheArray();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   LoggerLoad.info("Test Passed: Try Editor Page is displayed.");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   LoggerLoad.info("Test Passed: Run button is displayed.");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
	   LoggerLoad.info("Test Passed: Submit button is displayed.");
  
    }
    
	 //practice questions


	 @Test(priority = 16, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData-SearchArray", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData4(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Search The Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SearchTheArray();
		 //arrayPage.Tryhere();


		 //arrayPage.enterPythonCode(code, expectedOutput);
		 arrayPage.enterCode(code);

		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 @Test(priority = 17, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to MaxConsecutive Ones page")
	    public void testMaxConsecutiveOnesPage() {
		 LoggerLoad.info("Test Case: Verify navigation to MaxConsecutive Ones page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.MaxConsecutiveOnesButton();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   LoggerLoad.info("Test Passed: Try Editor is displayed.");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   LoggerLoad.info("Test Passed: Run button is displayed.");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
	   LoggerLoad.info("Test Passed: Submit button is displayed.");

 }

	 //Practice questions

	 @Test(priority = 18, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData-MaxConsecutive", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData5(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to MaxConsecutive Ones page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.MaxConsecutiveOnesButton();
		 //arrayPage.Tryhere();


		 //arrayPage.enterPythonCode(code, expectedOutput);
		 arrayPage.enterCode(code);

		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 @Test(priority = 19, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Find Number With EvenNumber Of Digits page")
	    public void testFindNumberWithEvenNumberOfDigitsPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Find Number With EvenNumber Of Digits page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.FindNumberWithEvenNumberOfDigits();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   LoggerLoad.info("Test Passed: Try Editor is displayed.");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   LoggerLoad.info("Test Passed: Run button is displayed.");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
	   LoggerLoad.info("Test Passed: Submit button is displayed.");

}

	 //Practice questions

	 @Test(priority = 20, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData-FindEventNum", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData6(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Find Number With EvenNumber Of Digits page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.FindNumberWithEvenNumberOfDigits();
		 //arrayPage.Tryhere();


		 //arrayPage.enterPythonCode(code, expectedOutput);
		 arrayPage.enterCode(code);

		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 @Test(priority = 21, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Navigation to Squares Of A Sorted Array page")
	    public void testSquaresOfASortedArrayPage() {
		 LoggerLoad.info("Test Case: Verify navigation to Squares Of A Sorted Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SquaresOfASortedArray();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   LoggerLoad.info("Test Passed: Try Editor is displayed.");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   LoggerLoad.info("Test Passed: Run button is displayed.");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
	   LoggerLoad.info("Test Passed: Submit button is displayed.");

}

	 @Test(priority = 22, retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData-SquareSorted", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData7(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify navigation to Squares Of A Sorted Array page");
		 ArrayPage arrayPage = new ArrayPage(getDriver());

		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SquaresOfASortedArray();
		 //arrayPage.Tryhere();


		 //arrayPage.enterPythonCode(code, expectedOutput);
		 arrayPage.enterCode(code);

		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	            LoggerLoad.info("SyntaxError popup message verified.");
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	            LoggerLoad.info("Code output verified: " + actualOutput);
	        }
	    }

	 
	 
}
