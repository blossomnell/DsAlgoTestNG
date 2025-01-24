package pageObjects;

import java.time.Duration;

import java.util.Properties;


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
	    
	        getStartedButton.click();
	    }

	    public boolean isStackPageDisplayed() {

	        return stackTitle.isDisplayed();
	    }

	    public void clickOperationsInStackLink() {

	        operationsInStackLink.click();
	    }

	    public boolean isOperationsInStackPageDisplayed() {
	 
	        return operationsInStackPageTitle.isDisplayed();
	    }

	    public void scrollDownAndClickTryHere() {
	
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", tryHereButton);
	        tryHereButton.click();
	    }

	    public boolean isTryEditorPageDisplayed() {
	   
	        return tryEditorPage.isDisplayed();
	    }

	    public void enterCode(String code) {

	        codeEditor_click.click();
	        codeEditor.sendKeys(code);
	    }

	    public void clickRunButton() {
	    
	        try {
	            runButton.click();
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	            wait.until(ExpectedConditions.alertIsPresent());
	        } catch (Exception e) {
	          
	        }
	    }

	    public String getOutputText() {
	        
	        return outputConsole.getText();
	    }

	    public String handlePopupError() {
	     
	        try {
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	         
	            alert.accept();
	            return alertText;
	        } catch (NoAlertPresentException e) {
	         
	            return "";
	        }
	    }

	    public void clickImplementationLink() {
	     
	        ImplementationLink.click();
	    }

	    public boolean isImplementationPageDisplayed() {
	      
	        return implementationPage.isDisplayed();
	    }

	    public void clickApplicationLink() {
	       
	        ApplicationLink.click();
	    }

	    public boolean isApplicationPageDisplayed() {
	       
	        return ApplicationPage.isDisplayed();
	    }

	    public void clickPracticeQuestionsLink() {
	    
	        practiceQuestionLink.click();
	    }

	    public boolean isPracticePageDisplayed() {
	   
	        return practicePage.isDisplayed();
	    }
	}

