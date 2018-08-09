package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyNotes {
	WebDriver driver;
	@FindBy(id="my-notes-page")
	WebElement mynotetxt;
	
	public MyNotes(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_mynotes_page() {
		return mynotetxt.isDisplayed();
	}
}
