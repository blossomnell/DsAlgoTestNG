package pageObjects;

import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import Utilities.LoggerLoad;
import Utilities.configReader;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StackPage {

    WebDriver driver;
    Properties prop;

    // Constructor to initialize WebDriver and properties
    public StackPage(WebDriver driver) {
        this.driver = driver;
        configReader reader = new configReader();
        prop = reader.init_prop();
        PageFactory.initElements(driver, this);
        LoggerLoad.info("StackPage initialized.");
    }
    
    @FindBy(xpath = "//a[@href='stack' and text()='Get Started']")
	WebElement getStartedButton;

	@FindBy(xpath = "//html/body/div[2]/h4")
	// @FindBy(xpath = "//h4[@class='bg-secondary text-white' and text()='Stack']")
	WebElement stackTitle;

	@FindBy(xpath = "//a[@href='operations-in-stack']")
	WebElement operationsInStackLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Operations in Stack']")
	WebElement operationsInStackPageTitle;

//	 @FindBy(xpath = "//a[@href='/tryEditor' and contains(text(),'Try here')]")
	@FindBy(xpath = "//a[contains(@href, '/tryEditor')]")
	WebElement tryHereButton;

	@FindBy(xpath = "/html/body/div/div")
	WebElement tryEditorPage;

	@FindBy(xpath = "//a[@href='implementation' and text()='Implementation']")
	WebElement ImplementationLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Implementation']")
	WebElement implementationPage;

	@FindBy(xpath = "//a[@href='stack-applications' and text()='Applications']")
	WebElement ApplicationLink;

	@FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Applications']")
	WebElement ApplicationPage;
	
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
	// @FindBy(xpath="//a[@href='/stack/practice' and text()='Practice Questions']")
	WebElement practiceQuestionLink;

	@FindBy(xpath = "//a[@class='navbar-brand' and text()='NumpyNinja']")
	WebElement practicePage;
	
	  public void clickGetStarted() {
	        LoggerLoad.info("Clicking on 'Get Started' button for Stack Page...");
	        getStartedButton.click();
	    }

	    public boolean isStackPageDisplayed() {
	        LoggerLoad.info("Verifying if Stack Page is displayed...");
	        return stackTitle.isDisplayed();
	    }

	    public void clickOperationsInStackLink() {
	        LoggerLoad.info("Clicking on 'Operations in Stack' link...");
	        operationsInStackLink.click();
	    }

	    public boolean isOperationsInStackPageDisplayed() {
	        LoggerLoad.info("Verifying if Operations in Stack Page is displayed...");
	        return operationsInStackPageTitle.isDisplayed();
	    }

	    public void scrollDownAndClickTryHere() {
	        LoggerLoad.info("Scrolling down and clicking 'Try Here' button...");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", tryHereButton);
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

	    public void clickImplementationLink() {
	        LoggerLoad.info("Clicking on 'Implementation' link...");
	        ImplementationLink.click();
	    }

	    public boolean isImplementationPageDisplayed() {
	        LoggerLoad.info("Verifying if Implementation Page is displayed...");
	        return implementationPage.isDisplayed();
	    }

	    public void clickApplicationLink() {
	        LoggerLoad.info("Clicking on 'Applications' link...");
	        ApplicationLink.click();
	    }

	    public boolean isApplicationPageDisplayed() {
	        LoggerLoad.info("Verifying if Applications Page is displayed...");
	        return ApplicationPage.isDisplayed();
	    }

	    public void clickPracticeQuestionsLink() {
	        LoggerLoad.info("Clicking on 'Practice Questions' link...");
	        practiceQuestionLink.click();
	    }

	    public boolean isPracticePageDisplayed() {
	        LoggerLoad.info("Verifying if Practice Questions Page is displayed...");
	        return practicePage.isDisplayed();
	    }
	}

