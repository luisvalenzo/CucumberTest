package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome {
	WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchtxtbox;
	@FindBy(className="nav-input")
	WebElement searchbtn;
	
	public AmazonHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search_product(String product) {
		searchtxtbox.sendKeys(product);
		searchbtn.click();
	}

}
