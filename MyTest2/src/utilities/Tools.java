package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
	WebDriver driver;
	WebDriverWait wait;
	
	public Tools(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void WaitToBeClicked(WebElement object) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(object));
	}

	public void WaitToBeSelected(WebElement object) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeSelected(object));
	}
}
