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

public class DataStructurePage {

    WebDriver driver;
    Properties prop;

    // Constructor to initialize WebDriver and properties
    public DataStructurePage(WebDriver driver) {
        this.driver = driver;
        configReader reader = new configReader();
        prop = reader.init_prop();
        PageFactory.initElements(driver, this);
        LoggerLoad.info("DataStructurePage initialized.");
    }

    // Locators for elements on the Data Structure page
    @FindBy(xpath = "//a[@href='data-structures-introduction' and text()='Get Started']")
    WebElement getStartedButton;

    @FindBy(xpath = "//h4[text()='Data Structures-Introduction']")
    WebElement pageTitle;

    @FindBy(xpath = "//a[@href='time-complexity' and text()='Time Complexity']")
    WebElement timeComplexityLink;

    @FindBy(xpath = "//p[@class='bg-secondary text-white' and text()='Time Complexity']")
    WebElement timeComplexityHeading;

    @FindBy(xpath = "//a[@href='/tryEditor' and contains(text(),'Try here')]")
    WebElement tryHereButton;
    
    @FindBy(xpath = "/html/body/div/div")
	WebElement tryEditorPage;

	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]")
	WebElement codeEditor_click;
	
    @FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
    WebElement codeEditor;

    @FindBy(xpath = "//button[@type='button']")
    WebElement runButton;

    @FindBy(xpath = "//*[@id='output']")
    WebElement outputConsole;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/a")
    WebElement practiceQuestionsLink;

    // Methods for actions on the Data Structure page

    // Navigate to the Data Structures page
    public void navigateToDataStructuresPage() {
        LoggerLoad.info("Navigating to Data Structures-Introduction page...");
        driver.get(prop.getProperty("testurl") + "/data-structures-introduction");
    }
    public void clickGetStarted() {
        LoggerLoad.info("Clicking the Get Started button...");
        getStartedButton.click();
    }

    public boolean isIntroductionPageDisplayed() {
        LoggerLoad.info("Verifying if the Introduction Page is displayed...");
        return pageTitle.isDisplayed() && pageTitle.getText().contains("Data Structures");
    }

    public void clickTimeComplexityLink() {
        LoggerLoad.info("Clicking the Time Complexity link...");
        timeComplexityLink.click();
    }

    public boolean isTimeComplexityPageDisplayed() {
        LoggerLoad.info("Verifying if the Time Complexity Page is displayed...");
        return timeComplexityHeading.isDisplayed();
    }

    public void clickTryHereButton() {
        LoggerLoad.info("Clicking the Try Here button...");
        tryHereButton.click();
    }

    public boolean isTryEditorPageDisplayed() {
        LoggerLoad.info("Verifying if the Try Editor Page is displayed...");
        return tryEditorPage.isDisplayed();
    }

    public void enterCode(String code) {
        LoggerLoad.info("Entering code into the editor: " + code);
        codeEditor_click.click();
        codeEditor.sendKeys(code);
    }

    public void clickRunButton() {
        LoggerLoad.info("Clicking the Run button...");
        try {
            runButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            LoggerLoad.info("Run button clicked and alert handled.");
        } catch (Exception e) {
            LoggerLoad.warn("No alert present after clicking Run button.");
        }
    }

    public String getOutputText() {
        LoggerLoad.info("Fetching output text from the console...");
        return outputConsole.getText();
    }

    public void clickPracticeQuestionsLink() {
        LoggerLoad.info("Clicking the Practice Questions link...");
        practiceQuestionsLink.click();
    }

    public String handlePopupError() {
        LoggerLoad.info("Handling popup error...");
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            LoggerLoad.info("Alert text: " + alertText);
            alert.accept();
            return alertText;
        } catch (NoAlertPresentException e) {
            LoggerLoad.warn("No alert present.");
            return "";
        }
    }

    public boolean isPracticeQuestionsPageDisplayed() {
        LoggerLoad.info("Verifying if the Practice Questions Page is displayed...");
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("practice")
                || practiceQuestionsLink.isDisplayed();
    }
}