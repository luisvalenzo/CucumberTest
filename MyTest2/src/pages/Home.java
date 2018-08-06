package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"welcome-page\"]/p[3]/button")
	WebElement LoginBtn;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LoginClick() {
		LoginBtn.click();
	}

}
