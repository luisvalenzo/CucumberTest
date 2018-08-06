package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import pages.Home;
import pages.LogIn;

public class Test1 {
	WebDriver driver;
  @Test
  public void MyTest() {
		Home home = new Home(driver);
		LogIn login = new LogIn(driver);
		
		home.LoginClick();
		login.EnterCredentials("testuser@example.com", "test123");
  }
  @BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://testapp.galenframework.com");
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
