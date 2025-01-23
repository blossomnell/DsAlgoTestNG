package pageObjects;

import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import Utilities.LoggerLoad;
import Utilities.configReader;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QueuePage {

    WebDriver driver;
    Properties prop;

    // Constructor to initialize WebDriver and properties
    public QueuePage(WebDriver driver) {
        this.driver = driver;
        configReader reader = new configReader();
        prop = reader.init_prop();
        PageFactory.initElements(driver, this);
        LoggerLoad.info("QueuePage initialized.");
    }
    @FindBy(xpath = "//a[@href='queue' and text()='Get Started']")
	WebElement getStartedButton;

	@FindBy(xpath = "/html/body/div[2]/h4")
	WebElement QueuePageTitle;

	@FindBy(xpath = "//a[@href='/tryEditor' and contains(text(),'Try here')]")
	WebElement tryHereButton;

	@FindBy(xpath = "//a[@href='implementation-lists']")
	WebElement ImplementationOfQueueInPythonLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Implementation of Queue in Python']")
	WebElement ImplementationOfQueueInPythonPageTitle;

	@FindBy(xpath = "//a[contains(text(),'Implementation using collections.deque')]")
	WebElement ImplementationUsingCollectionsDequeLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Implementation using collections.deque']")
	WebElement ImplementationUsingCollectionsDequePageTitle;

	@FindBy(xpath = "//a[@href='Implementation-array' and @class='list-group-item' and text()='Implementation using array']")
	WebElement ImplementationUsingArrayLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Implementation using array']")
	WebElement ImplementationUsingArrayPageTitle;

	@FindBy(xpath = "//a[@href='QueueOp' and @class='list-group-item' and text()='Queue Operations']")
	WebElement QueueOperationsLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Queue Operations']")
	WebElement QueueOperationsTitle;
	
	@FindBy(xpath = "/html/body/div/div")
	WebElement tryEditorPage;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]")
//	 @FindBy(xpath="//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre")
	WebElement codeEditor_click;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
    WebElement codeEditor;

	@FindBy(xpath = "//button[@type='button']")
	WebElement runButton;

	@FindBy(xpath = "//*[@id=\"output\"]")
	WebElement outputConsole;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/a")
	WebElement practiceQuestionsLink;

	@FindBy(xpath = "/html")
	WebElement practiceQuestionsPageTitle;
	
	 public void clickGetStarted() {
	        LoggerLoad.info("Clicking on 'Get Started' button for Queue Page...");
	        getStartedButton.click();
	    }

	    public boolean isQueuePageDisplayed() {
	        LoggerLoad.info("Verifying if Queue Page is displayed...");
	        return QueuePageTitle.isDisplayed();
	    }

	    public void clickImplementationOfQueueInPythonLink() {
	        LoggerLoad.info("Clicking on 'Implementation of Queue in Python' link...");
	        ImplementationOfQueueInPythonLink.click();
	    }

	    public boolean isImplementationOfQueueInPythonPageDisplayed() {
	        LoggerLoad.info("Verifying if Implementation of Queue in Python Page is displayed...");
	        return ImplementationOfQueueInPythonPageTitle.isDisplayed();
	    }

	    public boolean isImplementationUsingCollectionDequePageDispayed() {
	        LoggerLoad.info("Verifying if Implementation Using Collections Deque Page is displayed...");
	        return ImplementationUsingCollectionsDequePageTitle.isDisplayed();
	    }

	    public void clickImplementationUsingCollectionsDequeLink() {
	        LoggerLoad.info("Clicking on 'Implementation Using Collections Deque' link...");
	        ImplementationUsingCollectionsDequeLink.click();
	    }

	    public void clickImplementationUsingarrayLink() {
	        LoggerLoad.info("Clicking on 'Implementation Using Array' link...");
	        ImplementationUsingArrayLink.click();
	    }

	    public boolean isImplementationUsingArrayPageDispayed() {
	        LoggerLoad.info("Verifying if Implementation Using Array Page is displayed...");
	        return ImplementationUsingArrayPageTitle.isDisplayed();
	    }

	    public void clickQueueOperationsLink() {
	        LoggerLoad.info("Clicking on 'Queue Operations' link...");
	        QueueOperationsLink.click();
	    }

	    public boolean isQueueOperationsPageDispayed() {
	        LoggerLoad.info("Verifying if Queue Operations Page is displayed...");
	        return QueueOperationsTitle.isDisplayed();
	    }

	    public void clickTryhereButton() {
	        LoggerLoad.info("Clicking on 'Try Here' button...");
	        tryHereButton.click();
	    }

	    public boolean isTryEditorPageDisplayed() {
	        LoggerLoad.info("Verifying if Try Editor Page is displayed...");
	        return tryEditorPage.isDisplayed();
	    }

	    public void enterCode(String code) {
	        LoggerLoad.info("Entering code into the editor...");
	        codeEditor_click.click();
	        codeEditor.sendKeys(code);
	    }

	    public void clickRunButton() {
	        LoggerLoad.info("Clicking the 'Run' button...");
	        try {
	            runButton.click();
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	            wait.until(ExpectedConditions.alertIsPresent());
	        } catch (Exception e) {
	            LoggerLoad.warn("No alert present after clicking 'Run' button.");
	        }
	    }

	    public String getOutputText() {
	        LoggerLoad.info("Fetching output text from the console...");
	        return outputConsole.getText();
	    }

	    public String handlePopupError() {
	        LoggerLoad.info("Handling popup error...");
	        try {
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            LoggerLoad.info("Popup alert text: " + alertText);
	            alert.accept();
	            return alertText;
	        } catch (NoAlertPresentException e) {
	            LoggerLoad.warn("No popup alert present.");
	            return "";
	        }
	    }

	    public void clickPracticeQuestionsLink() {
	        LoggerLoad.info("Clicking on 'Practice Questions' link...");
	        practiceQuestionsLink.click();
	    }

	    public boolean ispracticeQuestionPageDisplayed() {
	        LoggerLoad.info("Verifying if Practice Questions Page is displayed...");
	        return practiceQuestionsPageTitle.isDisplayed();
	    }
	}



