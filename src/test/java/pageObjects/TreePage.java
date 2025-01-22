package pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.configReader;


public class TreePage {
	WebDriver driver;
	Properties prop;
	
	
	public TreePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configReader reader = new configReader();
		prop = reader.init_prop();
		
		
	}

// Home page
	@FindBy(xpath = "//button[text()='Get Started']") WebElement getStarted;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle' and text() = 'Data Structures']")
	WebElement dropdwnbtn;
	@FindBy(id = "id_username")
	WebElement txt_username;
	@FindBy(id = "id_password")
	WebElement txt_password;
    @FindBy(xpath = "//a[@href='tree' and text()='Get Started']")
    WebElement getstartedbtn;
	@FindBy(xpath = "//a[@class='dropdown-item' and text() = 'Tree']")
	WebElement treegetstarted;
	@FindBy(xpath="//*[@href='overview-of-trees']")
	WebElement overviewOfTrees;
	@FindBy(xpath="//a[@href ='/tree/overview-of-trees/']")
	WebElement overviewOfTreesLink;
	//a[@href='overview-of-trees' and text()='Overview of Trees']"
	// (or) a[normalize-space()='Tree'] 
	
	// Tree Page
	@FindBy(xpath="//h4[@class='bg-secondary text-white' and text()='Tree']") WebElement treetitle;
	@FindBy(xpath="//div[@class='CodeMirror-code']") WebElement treetryherebtn;
	@FindBy(linkText = "Terminologies")
	WebElement terminologiesLink;
	@FindBy(xpath="//a[@href='binary-search-trees']") WebElement binarysearchtreeslink;
	
	@FindBy(xpath="//a[@href='/tree/terminologies/']") WebElement terminologytitle;
	@FindBy(xpath = "//a[@href='/tree/overview-of-trees/' and text()='Overview of Trees']")
	WebElement overviewOfTreesTitle;
	@FindBy(xpath = "//*[@href='types-of-trees']")
	WebElement typesoftreesLink;
	@FindBy(xpath="//a[@href='/tree/types-of-trees/']") WebElement typesoftreestitle;
//	@FindBy(xpath="//div[@class='CodeMirror-gutter-wrapper']") WebElement terminologytitle;
	@FindBy(xpath = "//*[@href='tree-traversals']")
	WebElement treetraversalsLink;
	@FindBy(xpath="//a[@href='/tree/tree-traversals/']") WebElement treetraversalstitle;
	@FindBy(xpath = "//*[@href='traversals-illustration']")
	WebElement trav_illustrationsLink;
	@FindBy(xpath="//a[@href='/tree/traversals-illustration/']") WebElement traversalsillustrationtitle;
	@FindBy(xpath = "//*[@href='binary-trees']")
	WebElement binarytreesLink;
	@FindBy(xpath="//a[@href='/tree/binary-trees/']") WebElement binarytreestitle;
	@FindBy(xpath = "//*[@href='types-of-binary-trees']")
	WebElement typesofBinaryTreesLink;
	@FindBy(xpath="//a[@href='/tree/types-of-binary-trees/']") WebElement typesofbinarytreestitle;
	@FindBy(xpath = "//a[@href='implementation-in-python']")
	WebElement implementationInPythonLink;
	@FindBy(xpath="//a[@href='/tree/implementation-in-python/']") WebElement implementationinpythontitle;
	@FindBy(xpath = "//a[@href='binary-tree-traversals']")
	WebElement binaryTreeTraversalsLink;
	@FindBy(xpath="//a[@href='/tree/binary-tree-traversals/']") WebElement binarytreetraversalstitle;
	@FindBy(xpath = "//a[@href='implementation-of-binary-trees']")
	WebElement implementationOfBinaryTreesLink;
	@FindBy(xpath="//a[@href='/tree/implementation-of-binary-trees/']") WebElement implementationofbinarytreestitle;
	@FindBy(xpath = "//a[@href='applications-of-binary-trees']")
	WebElement applicationsOfBinaryTreesLink;
	@FindBy(xpath="//a[@href='/tree/applications-of-binary-trees/']") WebElement applicationsOfbinarytreestitle;
	@FindBy(xpath = "//a[@href='binary-search-trees']")
	WebElement binarySearchTreesLink;
	@FindBy(xpath="//a[@href='/tree/binary-search-trees/']") WebElement binarySearchTreestitle;
	@FindBy(xpath = "//a[@href='implementation-of-bst']")
	WebElement implementationOfBSTLink;
	@FindBy(xpath="//a[@href='/tree/implementation-of-bst/']") WebElement implementationOfBSTtitle;
	@FindBy(xpath = "//a[@href='/tree/practice']")
	WebElement practiceQuestionLink;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryhere_btn;	
	@FindBy(xpath = "//button[text()='Run']")
    WebElement run_btn;		
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	 WebElement text_code;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement output_text;
	@FindBy(xpath = "//a[@href='/logout' and text()='Sign out']")
	WebElement signoutBtn;
	 @FindBy(xpath="//div[@class='bs-example']")
	 WebElement practiceQuestionsPageTitle;	
	
public void navigatetohomepage() {
	
	//driver.get(configReader.gettestUrl());
	//System.out.println("testurl" + configReader.gettestUrl());
	//driver.navigate().to("https://dsportalapp.herokuapp.com");
//	driver.get("https://dsportalapp.herokuapp.com");
	driver.get(prop.getProperty("testurl"));
	getStarted.click();
}

public void getstarted() {
	 getstartedbtn.click();
}		

public void navigatetoOVoftreepage()  {
	overviewOfTreesLink.click();
}

public void navigatetotreepage() throws InterruptedException  {
	 getstartedbtn.click();
	Thread.sleep(5000);
}

public void clickdropdownmenu() {
	dropdwnbtn.click();	
}

public void clickOnoverviewOfTreesPage()    {
	overviewOfTrees.click();
}

public void tryhere() {
	tryhere_btn.click();
	
}
public void clickOnTerminaLink() {
	terminologiesLink.click();	
}

public void clickOnTypesOfTreesPage() {
	typesoftreesLink.click();
}
public void clickOnTreeTraversalsLink() {
	treetraversalsLink.click();
	
}
public void clickonbinarysearchtreeslink() {
	binarysearchtreeslink.click();
}

public void clickOnTrav_illus_Link() {
	trav_illustrationsLink.click();
	
}

public void clickOnBinaryTreesLink() {
	binarytreesLink.click();
	
}
public void clickOnTypesOfBTLink() {
	typesofBinaryTreesLink.click();	
}

public void click_implementationinPython() {
	implementationInPythonLink.click();
	
}

public void click_binaryTreeTraversals() {
	binaryTreeTraversalsLink.click();
	
}

public void click_implementationOfBinaryTrees() {
	implementationOfBinaryTreesLink.click();
	
}

public void click_applicationsOfBinaryTrees() {
	applicationsOfBinaryTreesLink.click();
	
}

public void click_implementationOfBST() {
	implementationOfBSTLink.click();
}
public void click_practiceQuestion() {
	practiceQuestionLink.click();
}

public boolean istreePageDisplayed() {

return treetitle.isDisplayed();
}


public boolean isOverviewoftreePageDisplayed() {

return overviewOfTreesTitle.isDisplayed();

}
public boolean tryeditorpageisDisplayed() {
	
	return treetryherebtn.isDisplayed();
}

public boolean isterminologiesPageDisplayed() {
	return terminologytitle.isDisplayed();
	
}
public boolean istypesofTreesPageDisplayed() {
	return typesoftreestitle.isDisplayed();
}

public boolean istreetraversalsPageDisplayed() {
	return treetraversalstitle.isDisplayed();
}

public boolean istravillustrationsPageDisplayed() {
	return traversalsillustrationtitle.isDisplayed();
}
public boolean isbinaryTreesPageDisplayed() {
	return binarytreestitle.isDisplayed();
}

public boolean istypesofbinarytreesDisplayed() {
	return typesofbinarytreestitle.isDisplayed();
}
public boolean isimplementationinpythonDisplayed() {
	return implementationinpythontitle.isDisplayed();
}

public boolean isbinarytreetransversalsDisplayed() {
	return binarytreetraversalstitle.isDisplayed();
}

public boolean isimplementationofbinarytreesDisplayed() {
	return implementationofbinarytreestitle.isDisplayed();
}
public boolean isapplicationofbinarytreesDisplayed() {
	return applicationsOfbinarytreestitle.isDisplayed();
}
public boolean isbinarySearchTreesDisplayed() {
	return binarySearchTreestitle.isDisplayed();
}

public boolean isimplementationOfBSTDisplayed() {
	return implementationOfBSTtitle.isDisplayed();
}

public void enterCode(String code) {
	text_code.sendKeys(code);
	
}


public void clicksrunBtn() {
	run_btn.click();
	
}

public void scrollDownAndClickTryHere() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", tryhere_btn);
	tryhere_btn.click();

}
public String popupError() {
    try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText(); // Get the alert text
        System.out.println("Alert text: " + alertText);
        alert.accept(); // Accept the alert
        return alertText;
    } catch (NoAlertPresentException e) {
        return "";
    }
}
public String getOutputText() {
	
	  return output_text.getText();
	}
	
	
public String getOutputTextFromTryEditorPage() {
	
	return output_text.getText();
}

public boolean isPQPageDisplayed() {
	
	return practiceQuestionsPageTitle.isDisplayed();
}

}
