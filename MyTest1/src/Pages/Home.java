package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Tools;

public class Home {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"welcome-page\"]/p[3]/button")
	WebElement loginbtn;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login_click() {
		Tools t = new Tools(driver);
		t.wait_to_be_clicked(loginbtn, 3);
		loginbtn.click();
	}

}
