package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;

public class LogIn extends BasePage{
	//WebDriver driver;

	@FindBy(name = "login.username")
	WebElement userTxtBox;
	@FindBy(name = "login.password")
	WebElement pwdTxtBox;
	@FindBy(css = "#login-page > p:nth-child(5) > button.btn.btn-lg.btn-primary.button-login")
	WebElement LogInBtn;
	@FindBy(className = "btn btn-lg btn-default button-cancel")
	WebElement CancelBtn;
	@FindBy(id="login-error-message")
	WebElement errMsg;

	public LogIn(WebDriver driver) {
		super(driver);
	}

	public MyNotes EnterCredentials(String user, String pwd) {
		userTxtBox.sendKeys(user);
		pwdTxtBox.sendKeys(pwd);
		LogInBtn.click();
		return PageFactory.initElements(driver, MyNotes.class);
	}
	
	public boolean ValidateErrorMsg() {
		return errMsg.isDisplayed();
	}
}
