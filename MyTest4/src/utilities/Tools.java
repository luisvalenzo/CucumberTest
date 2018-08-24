package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class Tools {
	WebDriver driver;

	public Tools(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void WaitToBeClicked(WebElement object, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(object));
	}

	public void WaitToBeSelected(WebElement object, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeSelected(object));
	}
	
}
