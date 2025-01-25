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

public class DataStructurePage {

	WebDriver driver;
	Properties prop;

	// Constructor to initialize WebDriver and properties
	public DataStructurePage(WebDriver driver) {
		this.driver = driver;
		configReader reader = new configReader();
		prop = reader.init_prop();
		PageFactory.initElements(driver, this);

	}

	// Locators for elements on the Data Structure page
	@FindBy(xpath = "//a[@href='data-structures-introduction' and text()='Get Started']")
	WebElement getStartedButton;

	@FindBy(xpath = "//h4[text()='Data Structures-Introduction']")
	WebElement pageTitle;

	@FindBy(xpath = "//a[@href='time-complexity' and text()='Time Complexit']")
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

		driver.get(prop.getProperty("testurl") + "/data-structures-introduction");
	}

	public void clickGetStarted() {

		getStartedButton.click();
	}

	public boolean isIntroductionPageDisplayed() {

		return pageTitle.isDisplayed() && pageTitle.getText().contains("Data Structures");
	}

	public void clickTimeComplexityLink() {

		timeComplexityLink.click();
	}

	public boolean isTimeComplexityPageDisplayed() {

		return timeComplexityHeading.isDisplayed();
	}

	public void clickTryHereButton() {

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

	public void clickPracticeQuestionsLink() {

		practiceQuestionsLink.click();
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

	public boolean isPracticeQuestionsPageDisplayed() {

		return Objects.requireNonNull(driver.getCurrentUrl()).contains("practice")
				|| practiceQuestionsLink.isDisplayed();
	}
}