package pageObjects;

import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
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
		getStartedButton.click();
	}

	public boolean isQueuePageDisplayed() {

		return QueuePageTitle.isDisplayed();
	}

	public void clickImplementationOfQueueInPythonLink() {
		ImplementationOfQueueInPythonLink.click();
	}

	public boolean isImplementationOfQueueInPythonPageDisplayed() {
		return ImplementationOfQueueInPythonPageTitle.isDisplayed();
	}

	public boolean isImplementationUsingCollectionDequePageDispayed() {

		return ImplementationUsingCollectionsDequePageTitle.isDisplayed();
	}

	public void clickImplementationUsingCollectionsDequeLink() {
		ImplementationUsingCollectionsDequeLink.click();
	}

	public void clickImplementationUsingarrayLink() {
		ImplementationUsingArrayLink.click();

	}

	public boolean isImplementationUsingArrayPageDispayed() {

		return ImplementationUsingArrayPageTitle.isDisplayed();
	}

	public void clickQueueOperationsLink() {
		QueueOperationsLink.click();

	}

	public boolean isQueueOperationsPageDispayed() {

		return QueueOperationsTitle.isDisplayed();
	}

	public void clickTryhereButton() {
		tryHereButton.click();
	}
		
		
	public boolean isTryEditorPageDisplayed() {

			return tryEditorPage.isDisplayed();
		}

		public void enterCode(String code) {

			codeEditor_click.click();

			// codeEditorTextarea.clear();
			codeEditor.sendKeys(code);
		}

		public void clickRunButton() {
			try {
				runButton.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
				wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
			} catch (Exception e) {
				System.out.println("No alert present.");
			}
		}

		public String getOutputText() {

			return outputConsole.getText();
		}

		public String handlePopupError() {
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

		public void clickPracticeQuestionsLink() {
			practiceQuestionsLink.click();

		}

		public boolean ispracticeQuestionPageDisplayed() {

			return practiceQuestionsPageTitle.isDisplayed();
		}



	}





