package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AmazonHome;
import pages.AmazonSearchResults;

public class MyTest {
	WebDriver driver;
	
	@Test
	public void mytest() {
		AmazonHome home=new AmazonHome(driver);
		AmazonSearchResults search_results = new AmazonSearchResults(driver);
		
		home.search_product("ipad air 2 case");
		search_results.refine_search_by_material("plastic");
		search_results.output_items_name();
	}
	@BeforeTest
	  public void beforeTest() {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://amazon.com");
	  }

	  @AfterTest
	  public void afterTest() {
		  //driver.close();
	  }
}
