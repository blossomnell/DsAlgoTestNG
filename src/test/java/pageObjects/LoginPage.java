package pageObjects;

import java.util.Objects;
import java.util.Properties;
import Utilities.configReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    Properties prop;
    
    public LoginPage(WebDriver driver) {
    
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
	@FindBy(xpath = "//div[@class='alert alert-primary' and @role='alert']")
	private WebElement alertMessage;
	@FindBy(xpath = "//a[@href='/logout' and text()='Sign out']")
	WebElement signoutBtn;

	public void navigatetohomepage() {
		driver.get(prop.getProperty("testurl") + "/home");
	}
	
	public void signin() {
		signin_btn.click();
	}
	
	public Boolean isLoginPageDisplayed() {
		return Objects.requireNonNull(driver.getCurrentUrl()).endsWith("/login");	
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public Boolean isUsernameFieldDisplayed() {
		return txt_username.isDisplayed();
	}

	public Boolean isPasswordFieldDisplayed() {
		return txt_password.isDisplayed();
	}

	public Boolean isLoginButtonDisplayed() {
		return login_btn.isDisplayed();
	}
	
	public void clickloginBtn() {
		login_btn.click();
	}

	public String getAlertMessage() {
		String loginMessage = getLoginMessage();
		if (!loginMessage.isBlank()) {
			return loginMessage;
		} else {
			loginMessage = getValidationError(txt_username);
			if (!loginMessage.isBlank()) {
				return loginMessage;
			}
			return getValidationError(txt_password);
		}
	}

	public String getLoginMessage() {
		String message = ""; 
		try {
			message = alertMessage.getText();
		} catch (Exception e) {
		}
		return message;
	}

	public String getValidationError(WebElement element) {
		String error = "";
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			error = (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		} catch (Exception e) {
		}
		return error;
	}
	public void navigatetologinpage() {
		driver.get(prop.getProperty("testurl") +"/login");
	}
	
	public Boolean isSignOutButtonDisplayed() {
		return signoutBtn != null;
	}
	
	public void clickSignOutBtn() {
		signoutBtn.click();
	}
	
	public boolean isLoggedOutMessageDisplayed(String expectedMessage) {
		return getLoginMessage().equals(expectedMessage);
	}

//	public String getTestData(String sheetName, int row, int col) {
//        return excelReader.getCellData(sheetName, row, col);
//    
//	}
}