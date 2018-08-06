package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
	WebDriver driver;

	public Tools(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void wait_to_be_clicked(WebElement object, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(object));
	}

	public void wait_to_be_selected(WebElement object, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeSelected(object));
	}
}
