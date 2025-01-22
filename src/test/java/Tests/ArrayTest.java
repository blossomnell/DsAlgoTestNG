package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.TestDataProvider;
import baseTest.BaseTest;
import pageObjects.ArrayPage;
import pageObjects.GraphPage;

public class ArrayTest extends BaseTest{
          
	 @BeforeMethod
	    public void setUp() {
	        loginToApplication("Ninjasquad", "abss@123");
	
	 }

	 @Test(priority = 1, description = "Navigation to Array page")
	    public void testNavigationToArrayPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
	        
		 arrayPage.clickgetstartedBtn();
	        Assert.assertTrue(arrayPage.ArraypageDisplayed(), "Array Page is not displayed!");
	    }
	 
	 @Test(priority = 2, description = "Navigation to ArraysInPython page")
	    public void testArraysInPythonPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
	        
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
	        Assert.assertTrue(arrayPage.isArraysInPythonButtonisDisplayed(), "ArraysInPython Page is not displayed!");
	    }
	 
	 @Test(priority = 3, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
	        
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 @Test(priority = 4, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData(String code, String expectedOutput) {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.Tryhere();

		 arrayPage.enterCode(code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 
	 @Test(priority = 5, description = "Navigation to Arrays Using List page")
	    public void testArraysUsingListPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ArrayUsingList();
	        Assert.assertTrue(arrayPage.isArraysUsingListButtonisDisplayed(), "ArrayUsingList Page is not displayed!");
	    }
	 
	 @Test(priority = 6, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage1() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
	        
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ArrayUsingList();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 
	 @Test(priority = 7, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.Tryhere();

		 arrayPage.enterCode(code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 8, description = "Navigation to Basic Operations In List page")
	    public void testBasicOperationsInListPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.BasicOperationsInList();
	        Assert.assertTrue(arrayPage.isBasicOperationsInListsButtonisDisplayed(), "BasicOperationsInList Page is not displayed!");
	    }
	 
	 @Test(priority = 9, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage2() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
	        
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.BasicOperationsInList();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 @Test(priority = 10, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData2(String code, String expectedOutput) {
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
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	 //new
	 @Test(priority = 11, description = "Navigation to Application Of Array page")
	    public void testApplicationOfArrayPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ApplicationOfArray();
	        Assert.assertTrue(arrayPage.isApplicationOfArrayButtonisDisplayed(), "ApplicationOfArray Page is not displayed!");
	    }
	 
	 @Test(priority = 12, description = "Navigation to Tryeditor page")
	    public void testTryEditorPage3() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
	        
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.ApplicationOfArray();
		 arrayPage.Tryhere();
	        //arrayPage.isTryEditorPageDisplayed();
	        Assert.assertTrue(arrayPage.isTryEditorPageDisplayed(), "TryEditor Page is not displayed!");
	    }
	 
	 @Test(priority = 13, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData3(String code, String expectedOutput) {
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
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	 @Test(priority = 14, description = "Navigation to Practice Questions page")
	    public void testPracticeQuestionsPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
	       // arrayPage.isPracticeQuestionsPageDisplayed();
	        Assert.assertTrue(arrayPage.isPracticeQuestionsPageisDisplayed(), "PracticeQuestions Page is not displayed!");
	     
     
       }

	 
	 @Test(priority = 15, description = "Navigation to Search The Array page")
	    public void testSearchTheArrayPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SearchTheArray();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");
  
    }
    
	 //practice questions
	 
	 
	 @Test(priority = 16, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData4(String code, String expectedOutput) {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SearchTheArray();
		 arrayPage.Tryhere();
		 

		 arrayPage.enterPythonCodeForPractice(code, arrayPage.txt_code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 17, description = "Navigation to MaxConsecutive Ones page")
	    public void testMaxConsecutiveOnesPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.MaxConsecutiveOnesButton();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");

 }
	 
	 //Practice questions
	 
	 @Test(priority = 18, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData5(String code, String expectedOutput) {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.MaxConsecutiveOnesButton();
		 arrayPage.Tryhere();
		 

		 arrayPage.enterPythonCodeForPractice(code, arrayPage.txt_code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 @Test(priority = 19, description = "Navigation to Find Number With EvenNumber Of Digits page")
	    public void testFindNumberWithEvenNumberOfDigitsPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.FindNumberWithEvenNumberOfDigits();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");

}
	 
	 //Practice questions
	 
	 @Test(priority = 20, description = "Verify pthon code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData6(String code, String expectedOutput) {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.MaxConsecutiveOnesButton();
		 arrayPage.Tryhere();
		 

		 arrayPage.enterPythonCodeForPractice(code, arrayPage.txt_code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }

	 @Test(priority = 21, description = "Navigation to Squares Of A Sorted Array page")
	    public void testSquaresOfASortedArrayPage() {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.SquaresOfASortedArray();
	       // arrayPage.isSearchTheArrayPageDisplayed();
	   Assert.assertTrue(arrayPage.isnavigatetopracticeqaeditorPageDisplayed(), "Try Editor page is not displayed");
	   Assert.assertTrue(arrayPage.isRunButtonDisplayed(), "Run button is not displayed");
	   Assert.assertTrue(arrayPage.isSubmitButtonDisplayed(), "Submit button is not displayed");

}
	 
	 @Test(priority = 22, description = "Verify pthon code execution with Excel data", dataProvider = "ArrayData", dataProviderClass = TestDataProvider.class)
	    public void testCodeExecutionWithExcelData7(String code, String expectedOutput) {
		 ArrayPage arrayPage = new ArrayPage(getDriver());
		 
		 arrayPage.clickgetstartedBtn();
		 arrayPage.ArraysInPythonButton();
		 arrayPage.PracticeQuestions();
		 arrayPage.MaxConsecutiveOnesButton();
		 arrayPage.Tryhere();
		 

		 arrayPage.enterPythonCodeForPractice(code, arrayPage.txt_code);
		 arrayPage.clicksrunBtn();

	        if (expectedOutput.contains("SyntaxError")) {
	            String popupMessage = arrayPage.getPopupAlertText();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = arrayPage.getOutputTextFromTryEditorPage();
	            Assert.assertEquals(actualOutput.trim(), expectedOutput.trim(), "Output mismatch!");
	        }
	    }
	 
	 
	 
}
