package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utilities.PageGenerator;

public class BaseTest {
	public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
 
    @BeforeTest
    public void setup () {
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("http://testapp.galenframework.com");
    }
 
    @BeforeMethod
    public void methodLevelSetup () {
        page = new PageGenerator(driver);
    }
 
    @AfterTest
    public void teardown () {
        driver.quit();
    }
    
    @DataProvider(name = "Authentication")
	public Object[][] credentials(){
		return new Object[][] {
			{"testuser@example.com","test123"}
		};
	}
}
