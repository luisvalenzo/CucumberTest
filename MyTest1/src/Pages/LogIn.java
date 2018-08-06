package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
	WebDriver driver;

	@FindBy(name = "login.username")
	WebElement usertxtbox;
	@FindBy(name = "login.password")
	WebElement pwdtxtbox;
	@FindBy(css = "#login-page > p:nth-child(5) > button.btn.btn-lg.btn-primary.button-login")
	WebElement LogInBtn;
	@FindBy(className = "btn btn-lg btn-default button-cancel")
	WebElement CancelBtn;

	public LogIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_credentials(String user, String pwd) {
		usertxtbox.sendKeys(user);
		pwdtxtbox.sendKeys(pwd);
		LogInBtn.click();
	}
}
