package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelReader;
import Utilities.configReader;


public class ArrayPage {
    
	
	 WebDriver driver;
	 Properties prop;
	
	 ExcelReader excelReader;
	    	    
	
	
	 public ArrayPage(WebDriver driver) {
    	 this.driver = driver;
 		configReader reader = new configReader();
         prop = reader.init_prop();
         PageFactory.initElements(driver, this);
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
     }
	
	@FindBy(id = "id_username")
	WebElement txt_username;
	@FindBy(id = "id_password")
	WebElement txt_password;
	@FindBy(xpath = "//input[@type='submit'and @value='Login']")
	WebElement login_btn;
	@FindBy(xpath = "//a[@href='/login' and text()='Sign in']")
   WebElement signin_btn;
	@FindBy(xpath = "//a[@href='array']")
	WebElement getstarted_btn;
	@FindBy(xpath = "//a[@href='arrays-in-python']")       
	WebElement arraysinpythonlink;
	@FindBy(xpath = "//a[@href='arrays-using-list']")
	WebElement arraysUsingListLink;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement tryhere_btn;
	@FindBy(xpath = "//a[@href='/tryEditor']")                                           
	WebElement tryhere1_btn;
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement txt_code;	
	@FindBy(xpath = "//button[text()='Run']")
   WebElement run_btn;
	@FindBy(xpath = "//*[@class='button']")                     
   WebElement submit_btn;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement output_text;
	@FindBy(xpath = "//*[@id=\"content\"]/li[2]/a")                                
	WebElement arrayusinglistlink;
	@FindBy(xpath = "//*[@id=\"content\"]/li[3]/a")                        
	WebElement basicoperationinlistlink;
	@FindBy(xpath = "//a[@href='/tryEditor']")                                          
	WebElement tryhere2_btn;
	@FindBy(xpath = "//*[@id=\"content\"]/li[4]/a")                           
	WebElement applicationofarraylink;
	@FindBy(xpath = "//a[@href='/tryEditor']")                                         
	WebElement tryhere3_btn;
	@FindBy(xpath = "//a[@href='/array/practice']")                                  
	WebElement practicequestionslink;
	@FindBy(xpath = "//a[@href='/question/1']")
	WebElement searchthearraylink;
	@FindBy(xpath="//a[@href='/question/2']")
	WebElement maxconsecutiveones_btn;
	@FindBy (xpath="//a[@href='/question/3']")
	WebElement findnumberwithevennumberofdigitslink;
	@FindBy (xpath="//a[@href='/question/4']")
	WebElement squaresofsortedarraylink;
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]")
	WebElement codeEditor_click;
	

	public void clickgetstartedBtn() {
		getstarted_btn.click();
	}


		public boolean ArraypageDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/array/");              //added
	}
	
	
	public void ArraysInPythonButton() {
		 arraysinpythonlink.click();
		
   }

	public void ArraysUsingListButton() {
		arraysUsingListLink.click();

	}


	public boolean isArraysInPythonButtonisDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/array/arrays-in-python/");
		
	}

	
	public void Tryhere() {
		tryhere_btn.click();                 
		
	}

	     
	public void handleAlert() {
	    try {
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert text: " + alert.getText());
	        alert.accept(); // Accept the alert
	    } catch (NoAlertPresentException e) {
	        System.out.println("No alert present");
	    }
	}
	
	

	public void clicksrunBtn() {
		try {
			run_btn.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.alertIsPresent()); // Wait for the alert
		} catch (Exception e) {
			System.out.println("No alert present.");
		}
		
	}

	public String getPopupAlertText() {
	    try {
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        alert.accept();
	        return alertText;
	    } catch (NoAlertPresentException e) {
	        return "No alert present.";
	    }
	}

	public String getOutputTextFromTryEditorPage() {
		if(output_text != null) {
			return output_text.getText();
		}
		return "";
	}

	public void ArrayUsingList() {
		arrayusinglistlink.click();                  
		
	}

		
	public boolean isArraysUsingListButtonisDisplayed() {
			return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/array/arrays-using-list/");
		
	}
		
	
	public void Tryhere1() {
		tryhere1_btn.click();
		
	}

	public void BasicOperationsInList() {
		basicoperationinlistlink.click();              
		
	}

		
   public boolean isBasicOperationsInListsButtonisDisplayed() {
   	return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/array/basic-operations-in-lists/");
		
	}
   
	public void Tryhere2() {
		tryhere2_btn.click();
	
	}
	
	public void ApplicationOfArray() {
		applicationofarraylink.click();         
		}

	
	public boolean isApplicationOfArrayButtonisDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/array/applications-of-array/");
	}

	public void Tryhere3() {
		tryhere3_btn.click();
		
	}	
	public void PracticeQuestions() {
		practicequestionslink.click();          
		
	}

	     
	public boolean isPracticeQuestionsPageisDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/array/practice");
	}
	
	public void SearchTheArray() {
		searchthearraylink.click();
		
	}

		
	public void SubmitButton() {
		submit_btn.equals(submit_btn);
		
	}

	public void MaxConsecutiveOnesButton() {
		maxconsecutiveones_btn.click();
		
	}

	
	public void FindNumberWithEvenNumberOfDigits() {
		findnumberwithevennumberofdigitslink.click();
		
	}

	public void navigatetofindnumberwithevennumberpage() {
		driver.get(prop.getProperty("testurl") + "/tryEditor");
		
	}

	public void SquaresOfASortedArray() {
		squaresofsortedarraylink.click();
		
	}
	
	
	
	public void enterPythonCode(String code, String expectedOutput) {

	    enterPythonCodeForPractice(code, txt_code);
	}
	
	public void enterPythonCodeForPractice(String code, WebElement element) {
	    new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
	    String[] str1 = code.split("\n");

	    for (int i = 0; i < str1.length; i++) {
	        if (str1[i].equalsIgnoreCase("\\b")) {
	            element.sendKeys(Keys.BACK_SPACE);
	        } else {
	            element.sendKeys(str1[i]);
	            element.sendKeys(Keys.ENTER);
	        }
	    }
	}
	
	
	public void clickssubmitBtn() {
		submit_btn.click();
		
	}

	
	public boolean isTryEditorPageDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/tryEditor");
	}

	public boolean isRunButtonDisplayed() {
		if(run_btn==null)
			return false;
		else 
			return true;
	}
	
	public boolean isSubmitButtonDisplayed() {
		if(run_btn==null)
			return false;
		else 
			return true;
	}

	public boolean isnavigatetopracticeqaeditorPageDisplayed() {
		if(run_btn==null)
			return false;
		else 
			return true;
	}
	
	public String getExcelData(String sheetName, Integer row, int column) {
		return excelReader.getCellData(sheetName, row, column);
	}

	public void enterCode(String code) {
		// TODO Auto-generated method stub
		codeEditor_click.click();

		// Focus on the input field, select all text, and clear it
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();

		String[] str1 = code.split("\n");

		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				txt_code.sendKeys(Keys.BACK_SPACE);
			} else {
				txt_code.sendKeys(str1[i]);
				txt_code.sendKeys(Keys.ENTER);
			}
		}
	}

		
	
	
}
