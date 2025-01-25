package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.LoggerLoad;
import Utilities.TestDataProvider;
import baseTest.BaseTest;
import pageObjects.TreePage;

@Listeners(Utilities.TestListener.class)
public class TreeTest extends  BaseTest {
	
	@BeforeMethod
    public void setUp() {
        LoggerLoad.info("Setting up before test execution: Logging into the application...");
        loginToApplication();
    }
	    
    
	@Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Tree page")
    public void tstNavigationToTreePage() throws InterruptedException {
		LoggerLoad.info("Verify navigation to Tree page");
        TreePage treePage = new TreePage(getDriver());
        treePage.getstarted();
        Assert.assertTrue(treePage.istreePageDisplayed(), "Tree Page is not displayed!");
    }

	 @Test(priority = 2,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Overview of Tree Page")
	    public void tstNavigationToOverviewOfTreePage() {
		 LoggerLoad.info("Verify navigation to Overview of Tree Page");
		 TreePage treePage = new TreePage(getDriver());
		 treePage.getstarted();
	     treePage.clickOnoverviewOfTreesPage();
	        
	        Assert.assertTrue(treePage.isOverviewoftreePageDisplayed(),"Overview of Tree Page is not displayed!");
	    }

	 @Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTreeTryEditorPage() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
	    	 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnoverviewOfTreesPage();
             treePage.tryhere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 4,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnoverviewOfTreesPage();
         treePage.tryhere();
//         treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }

	 
	 @Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Terminologies")
	    public void tstNavigationToTerminologies() {
		 LoggerLoad.info("Test Case: Verify code for Terminologies");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTerminaLink();
	        Assert.assertTrue(treePage.isterminologiesPageDisplayed(), "Is Terminologies Page not displayed!");
	    }
	 
	 @Test(priority = 6,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage1() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickOnTerminaLink();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 7,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData1(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnTerminaLink();
         treePage.tryhere();
//      treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }

	  
	 @Test(priority = 8,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Types of Trees")
	    public void tstNavigationToTypesOfTrees()  {
		 LoggerLoad.info("Verify Types of Trees");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTypesOfTreesPage();
	        Assert.assertTrue(treePage.istypesofTreesPageDisplayed(), "Is Types Of Trees Page not displayed!");
	    }
	 
	 @Test(priority = 9,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage2() {
	    	 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickOnTypesOfTreesPage();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 10, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData2(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnTypesOfTreesPage();
         treePage.tryhere();
//      treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }

	
	 
	 @Test(priority = 11, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Tree Traversals")
	    public void tstNavigationToTreeTraversals() throws InterruptedException {
		 LoggerLoad.info("Verify Tree Traversals");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTreeTraversalsLink();
	        Assert.assertTrue(treePage.istreetraversalsPageDisplayed(), "Is Tree Traversals Page not displayed!");
	    }
	 
	 @Test(priority = 12,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage3() {
	    LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickOnTreeTraversalsLink();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 13,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData3(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnTreeTraversalsLink();
         treePage.tryhere();
//      treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }

	 
	 @Test(priority = 14,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Traversals-Illustration")
	    public void tstNavigationToTraversalsIllustration()  {
		 LoggerLoad.info("Test Case: Verify Traversals-Illustration");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTrav_illus_Link();
	        Assert.assertTrue(treePage.istravillustrationsPageDisplayed(), "Is Traversals-Illustration Page not displayed!");
	    }
	 
	 @Test(priority = 15, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage4() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickOnTrav_illus_Link();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 16,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData4(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnTrav_illus_Link();
         treePage.tryhere();
//   treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }	
	 
	 
	 @Test(priority = 17,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Binary Trees")
	    public void tstNavigationToBinaryTrees()  {
		 LoggerLoad.info(" Verify Binary Trees");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnBinaryTreesLink();
	        Assert.assertTrue(treePage.isbinaryTreesPageDisplayed(), "Is Binary Trees Page not displayed!");
	    }
	 
	 @Test(priority = 18,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage5() {
	    	 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickOnBinaryTreesLink();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 19, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData5(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnBinaryTreesLink();
         treePage.tryhere();
//   treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }
	 

	 @Test(priority = 20, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Types of Binary Trees")
	    public void tstNavigationToTypesofBinaryTrees()  {
		 LoggerLoad.info(" Verify Types of Binary Trees");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickOnTypesOfBTLink();
	        Assert.assertTrue(treePage.istypesofbinarytreesDisplayed(), "Is Types of Binary Trees Page not displayed!");
	    }
	 
	 @Test(priority = 21,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage6() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickOnTypesOfBTLink();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 22,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData6(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickOnTypesOfBTLink();
         treePage.tryhere();
//treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }
	 
	 @Test(priority = 23,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Implementation in Python")
	    public void tstNavigationToImplementationinPython()  {
		 LoggerLoad.info(" Verify Implementation in Python");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_implementationinPython();
	        Assert.assertTrue(treePage.isimplementationinpythonDisplayed(), "Is Implementation in Python not displayed!");
	    }
	 
	 @Test(priority = 24,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage7() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.click_implementationinPython() ;
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 25, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData7(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.click_implementationinPython();
         treePage.tryhere();
//treePage.scrollDownAndClickTryHere();
	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }
	 
	 @Test(priority = 26,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Binary Tree Traversals")
	    public void tstNavigationToBinaryTreeTraversals()  {
		 LoggerLoad.info(" Verify Binary Tree Traversals");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_binaryTreeTraversals();
	        Assert.assertTrue(treePage.isbinarytreetransversalsDisplayed(), "Is Binary Tree Traversals not displayed!");
	    }
	 
	 @Test(priority = 27,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage8() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.click_binaryTreeTraversals();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 28,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData8(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
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
	
	 @Test(priority = 29,retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Implementation of Binary Trees")
	    public void tstNavigationToImplementationofBinaryTrees()  {
		 LoggerLoad.info(" Verify Implementation of Binary Trees");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_implementationOfBinaryTrees();
	        Assert.assertTrue(treePage.isimplementationofbinarytreesDisplayed(), "Is Implementation of Binary Trees not displayed!");
	    }
	 
	 @Test(priority = 30,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage9() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.click_implementationOfBinaryTrees();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 31, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData9(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.click_implementationOfBinaryTrees();
       treePage.tryhere();

	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }

	 @Test(priority = 32, description = "Applications of Binary trees")
	    public void tstNavigationToApplicationsoffBinaryTrees()  {
		 LoggerLoad.info("Verify Applications of Binary trees");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_applicationsOfBinaryTrees();
	        Assert.assertTrue(treePage.isapplicationofbinarytreesDisplayed(), "Is Applications of Binary Trees not displayed!");
	    }
	 
	 @Test(priority = 33,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage10() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.click_applicationsOfBinaryTrees();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 34,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData10(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.click_applicationsOfBinaryTrees();
         treePage.tryhere();

	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }
	 
	 @Test(priority = 35,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Binary Search Trees")
	    public void tstNavigationTBinarySearchTrees()  {
		 LoggerLoad.info(" Verify Binary Search Trees");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.clickonbinarysearchtreeslink();
	        Assert.assertTrue(treePage.isbinarySearchTreesDisplayed(), "Is Binary Search Trees not displayed!");
	    }
	 
	 @Test(priority = 36,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage11() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.clickonbinarysearchtreeslink();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 37, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData11(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.clickonbinarysearchtreeslink();
          treePage.tryhere();

	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }	
	 
	 
	 @Test(priority = 38,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Implementation Of BST")
	    public void tstNavigationImplementationOfBST()  {
		 LoggerLoad.info("Verify Implementation Of BST");
			 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	 treePage.click_implementationOfBST();
	        Assert.assertTrue(treePage.isimplementationOfBSTDisplayed(), "Is Implementation Of BST not displayed!");
	    }
	 
	 @Test(priority = 39,  retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify navigation to Try Editor page")
	    public void tstNavigationToTryEditorPage12() {
		 LoggerLoad.info("Verify navigation to Try Editor page");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
	     treePage.click_implementationOfBST();
	     treePage.scrollDownAndClickTryHere();
	        Assert.assertTrue(treePage.tryeditorpageisDisplayed(), "Try Editor Page is not displayed!");
	    }
	 
	 @Test(priority = 40, retryAnalyzer = Utilities.RetryAnalyzer.class,description = "Verify code execution with Excel data", dataProvider = "PythonData", dataProviderClass = TestDataProvider.class)
	    public void tstCodeExecutionWithExcelData12(String code, String expectedOutput) {
		 LoggerLoad.info("Test Case: Verify code execution with Excel data");
		 TreePage treePage = new TreePage(getDriver());
    	 treePage.getstarted();
    	 treePage.click_implementationOfBST();
          treePage.tryhere();

	        // Enter code from Excel and execute
	    	treePage.enterCode(code);
	    	treePage.clicksrunBtn();

	        if (expectedOutput.contains("popup error message")) {
	        	LoggerLoad.info("Handling popup error...");
	            String popupMessage = treePage.popupError();
	            Assert.assertTrue(popupMessage.contains("SyntaxError"),
	                "Popup message did not match expected. Actual: " + popupMessage);
	        } else {
	            String actualOutput = treePage.getOutputTextFromTryEditorPage();
	            Assert.assertTrue(actualOutput.contains("hello"),
	            		"Actual message did not match expected. Actual: " + actualOutput);
	        }
	 }
	 @Test(priority = 41,retryAnalyzer = Utilities.RetryAnalyzer.class, description = "Verify navigation to Practice Questions page")
	    public void tstNavigationToPracticeQuestionsPage() {
		 LoggerLoad.info(" Verify navigation to Practice Questions page");
		 TreePage treePage = new TreePage(getDriver());
	    	 treePage.getstarted();
	    	  treePage.click_implementationOfBST();
	    	 treePage.click_practiceQuestion();
	        Assert.assertTrue(treePage.isPQPageDisplayed(),"Practice Questions Page is not displayed!");
	    }
}

