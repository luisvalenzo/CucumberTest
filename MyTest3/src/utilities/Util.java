package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	WebDriver driver;

	public Util(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void wait_object(WebElement object, int sec) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(sec, TimeUnit.SECONDS)
			    .pollingEvery(1, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(object));
	}

	public void WaitToBeSelected(WebElement object, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeSelected(object));
	}
}
