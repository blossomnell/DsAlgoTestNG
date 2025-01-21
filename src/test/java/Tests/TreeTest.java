package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.TestDataProvider;
import baseTest.BaseTest;
import pageObjects.TreePage;

public class TreeTest extends  BaseTest {
	
	 @BeforeMethod
	    public void setUp() {
		 loginToApplication("Ninjasquad", "abss@123");
	    }
	    

		@Test(priority = 6, description = "Verify navigation to Tree page")
	    public void tstNavigationToTreePage() throws InterruptedException {
	        TreePage treePage = new TreePage(getDriver());
	        treePage.getstarted();
	        Assert.assertTrue(treePage.istreePageDisplayed(), "Tree Page is not displayed!");
	    }

		 @Test(priority = 6, description = "Verify navigation to Overview of Tree Page")
		    public void tstNavigationToOverviewOfTreePage() {
			 TreePage treePage = new TreePage(getDriver());
			 treePage.getstarted();
		     treePage.clickOnoverviewOfTreesPage();
		        
		        Assert.assertTrue(treePage.isOverviewoftreePageDisplayed(),"Overview of Tree Page is not displayed!");
		    }
		
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTreeTryEditorPage() {
		    	 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnoverviewOfTreesPage();
                 treePage.tryhere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnoverviewOfTreesPage();
             treePage.tryhere();
//             treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }

		 
		 @Test(priority = 6, description = "Terminologies")
		    public void tstNavigationToTerminologies() {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnTerminaLink();
		        Assert.assertTrue(treePage.isterminologiesPageDisplayed(), "Is Terminologies Page not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage1() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickOnTerminaLink();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData1(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTerminaLink();
             treePage.tryhere();
//          treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }

		 

		
		 
		 @Test(priority = 6, description = "Types of Trees")
		    public void tstNavigationToTypesOfTrees()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnTypesOfTreesPage();
		        Assert.assertTrue(treePage.istypesofTreesPageDisplayed(), "Is Types Of Trees Page not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage2() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickOnTypesOfTreesPage();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData2(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTypesOfTreesPage();
             treePage.tryhere();
//          treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }

		
		 
		 @Test(priority = 6, description = "Tree Traversals")
		    public void tstNavigationToTreeTraversals() throws InterruptedException {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnTreeTraversalsLink();
		        Assert.assertTrue(treePage.istreetraversalsPageDisplayed(), "Is Tree Traversals Page not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage3() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickOnTreeTraversalsLink();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData3(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTreeTraversalsLink();
             treePage.tryhere();
//          treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }

		 
		 @Test(priority = 6, description = "Traversals-Illustration")
		    public void tstNavigationToTraversalsIllustration()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnTrav_illus_Link();
		        Assert.assertTrue(treePage.istravillustrationsPageDisplayed(), "Is Traversals-Illustration Page not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage4() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickOnTrav_illus_Link();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData4(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTrav_illus_Link();
             treePage.tryhere();
//       treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }	
		 
		 
		 @Test(priority = 6, description = "Binary Trees")
		    public void tstNavigationToBinaryTrees()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnBinaryTreesLink();
		        Assert.assertTrue(treePage.isbinaryTreesPageDisplayed(), "Is Binary Trees Page not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage5() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickOnBinaryTreesLink();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData5(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnBinaryTreesLink();
             treePage.tryhere();
//       treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }
		 
	
		 @Test(priority = 6, description = "Types of Binary Trees")
		    public void tstNavigationToTypesofBinaryTrees()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickOnTypesOfBTLink();
		        Assert.assertTrue(treePage.istypesofbinarytreesDisplayed(), "Is Types of Binary Trees Page not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage6() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickOnTypesOfBTLink();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData6(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTypesOfBTLink();
             treePage.tryhere();
//    treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }
		 
		 @Test(priority = 6, description = "Implementation in Python")
		    public void tstNavigationToImplementationinPython()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.click_implementationinPython();
		        Assert.assertTrue(treePage.isimplementationinpythonDisplayed(), "Is Implementation in Python not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage7() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.click_implementationinPython() ;
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData7(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_implementationinPython();
             treePage.tryhere();
// treePage.scrollDownAndClickTryHere();
		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }
		 
		 @Test(priority = 6, description = "Binary Tree Traversals")
		    public void tstNavigationToBinaryTreeTraversals()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.click_binaryTreeTraversals();
		        Assert.assertTrue(treePage.isbinarytreetransversalsDisplayed(), "Is Binary Tree Traversals not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage8() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.click_binaryTreeTraversals();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData8(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_binaryTreeTraversals();
              treePage.tryhere();

		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }	 
		
		 @Test(priority = 6, description = "Implementation of Binary Trees")
		    public void tstNavigationToImplementationofBinaryTrees()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.click_implementationOfBinaryTrees();
		        Assert.assertTrue(treePage.isimplementationofbinarytreesDisplayed(), "Is Implementation of Binary Trees not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage9() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.click_implementationOfBinaryTrees();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData9(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_implementationOfBinaryTrees();
           treePage.tryhere();

		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }
	
		 @Test(priority = 6, description = "Applications of Binary trees")
		    public void tstNavigationToApplicationsoffBinaryTrees()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.click_applicationsOfBinaryTrees();
		        Assert.assertTrue(treePage.isapplicationofbinarytreesDisplayed(), "Is Applications of Binary Trees not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage10() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.click_applicationsOfBinaryTrees();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData10(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_applicationsOfBinaryTrees();
             treePage.tryhere();

		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }
		 
		 @Test(priority = 6, description = "Binary Search Trees")
		    public void tstNavigationTBinarySearchTrees()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.clickonbinarysearchtreeslink();
		        Assert.assertTrue(treePage.isbinarySearchTreesDisplayed(), "Is Binary Search Trees not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage11() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.clickonbinarysearchtreeslink();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData11(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickonbinarysearchtreeslink();
              treePage.tryhere();

		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }	
		 
		 
		 @Test(priority = 6, description = "Implementation Of BST")
		    public void tstNavigationImplementationOfBST()  {
				 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	 treePage.click_implementationOfBST();
		        Assert.assertTrue(treePage.isimplementationOfBSTDisplayed(), "Is Implementation Of BST not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify navigation to Try Editor page")
		    public void tstNavigationToTryEditorPage12() {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
		     treePage.click_implementationOfBST();
		     treePage.scrollDownAndClickTryHere();
		        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
		    }
		 
		 @Test(priority = 6, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
		    public void tstCodeExecutionWithExcelData12(String code, String expectedOutput) {
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_implementationOfBST();
              treePage.tryhere();

		        // Enter code from Excel and execute
		    	treePage.enterCode(code);
		    	treePage.clicksrunBtn();

		        if (expectedOutput.contains("popup error message")) {
		            String popupMessage = treePage.popupError();
		            Assert.assertTrue(popupMessage.contains("SyntaxError"),
		                "Popup message did not match expected. Actual: " + popupMessage);
		        } else {
		            String actualOutput = treePage.getOutputTextFromTryEditorPage();
		            Assert.assertTrue(actualOutput.contains("hello"),
		            		"Actual message did not match expected. Actual: " + actualOutput);
		        }
		 }
		 @Test(priority = 4, description = "Verify navigation to Practice Questions page")
		    public void tstNavigationToPracticeQuestionsPage() {
			 TreePage treePage = new TreePage(getDriver());
		    	 treePage.getstarted();
		    	  treePage.click_implementationOfBST();
		    	 treePage.click_practiceQuestion();
		        Assert.assertTrue(treePage.isPQPageDisplayed(),"Practice Questions Page is not displayed!");
		    }
}
