package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Tools;

public class Home{
	WebDriver driver;
	Tools t = new Tools(driver);
	@FindBy(xpath = "//*[@id=\"welcome-page\"]//button")
	WebElement LoginBtn;

	public Home(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	public void LoginClick() {
		t.WaitToBeClicked(LoginBtn);
		LoginBtn.click();
	}

}
