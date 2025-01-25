package pageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.configReader;
import java.util.Objects;
import java.util.Properties;

import Utilities.ExcelReader;



public class GraphPage {

	
	   WebDriver driver;
	  Properties prop;
	 
	
	  public GraphPage(WebDriver driver) {
	    	 this.driver = driver;
	 		configReader reader = new configReader();
	         prop = reader.init_prop();
	         PageFactory.initElements(driver, this);
	     }
	  
	  
	@FindBy(id = "id_username")
	WebElement txt_username;
	@FindBy(id = "id_password")
	WebElement txt_password;
	@FindBy(xpath = "//input[@type='submit'and @value='Login']")
	WebElement login_btn;
	@FindBy(xpath = "//a[@href='/login' and text()='Sign in']")
    WebElement signin_btn;
    @FindBy(xpath = "//a[@href='graph']")
    WebElement getstarted_btn;
    @FindBy( linkText="Graph")
    WebElement maingraphlink;
   @FindBy(xpath = "//a[@class='btn btn-info']")                             
   WebElement tryhere_btn;
   @FindBy(xpath="//form[@id='answer_form']/div/div/div[6]")
   WebElement codeEditor_click;
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement codeEditor;
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement txt_code;                                                       
   @FindBy(xpath = "//button[text()='Run']")
   WebElement run_btn;
   @FindBy(xpath = "//button[text()='Run']")
   WebElement run_btn2;
   @FindBy(xpath = "//pre[@id='output']")
   WebElement output_text;
   @FindBy(xpath = "//*[@id=\"content\"]/li[2]/a")
   WebElement graphRepresentations_btn;
   @FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")                                //failed
   WebElement practicequestions_btn;	
   @FindBy(xpath = "//a[@class='btn btn-info']")                             
   WebElement tryhere1_btn;
 
 

public void clickgetstartedBtn() {
		getstarted_btn.click();
		
}

	
public boolean isGraphPageDisplayed() {
	return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/graph/");
}

	
public void MainGraph() {
	  
	maingraphlink.click();	
	
}

public boolean isMainGraphPageDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/graph/graph/");
}

	
public void Tryhere() {
tryhere_btn.click();                                
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

	 
public void enterCode(String code) {
	txt_code.sendKeys(code);
}

public void clicksrunBtn() {
		run_btn.click();
		
}

public String getOutputTextFromTryEditorPage() {
	return output_text.getText();
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


public boolean isGraphRepresentationPageDisplayed() {
	return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/graph/graph-representations/");     
}


public void GraphRepresentations() {
		graphRepresentations_btn.click();
		
}

public void Tryhere1() {
	tryhere1_btn.click();                                 
}

public void PracticeQuestions() {
	practicequestions_btn.click();		
}

public void clicksrunBtn2() {
	run_btn2.click();
	
}


public boolean isPracticeQuestionsPageDisplayed() {
	return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/graph/practice");
}



}
