package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utilities.PageGenerator;

public class BaseTest {
	public WebDriver driver;
    public PageGenerator page;
  
    @BeforeMethod
    public void beforeClass() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
        //Maximize Window	
        driver.manage().window().maximize();
        driver.get("http://testapp.galenframework.com");
    }
 
   @BeforeMethod
    public void methodLevelSetup () {
        //Instantiate the Page Class
        page = new PageGenerator(driver);
    }
 
    @AfterMethod
    public void teardown () {
        driver.close();
    }
    
    @AfterTest
    public void afterTest() {
    	driver.quit();
    }

}
