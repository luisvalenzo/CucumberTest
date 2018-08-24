package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.BasePage;

public class Home extends BasePage{
	//WebDriver driver;

	@FindBy(xpath = "//*[@id=\"welcome-page\"]//button")
	WebElement LoginBtn;

	public Home(WebDriver driver) {
		super(driver);
	}

	public LogIn LoginClick() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));
		LoginBtn.click();
		return PageFactory.initElements(driver, LogIn.class);
	}

}
