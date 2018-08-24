package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.BasePage;

public class MyNotes extends BasePage {
	@FindBy(id="my-notes-page")
	WebElement mynotetxt;
	
	public MyNotes(WebDriver driver) {
		super(driver);
	}
	
	public boolean verify_mynotes_page() {
		wait.until(ExpectedConditions.visibilityOf(mynotetxt));
		return mynotetxt.isDisplayed();
	}
}
