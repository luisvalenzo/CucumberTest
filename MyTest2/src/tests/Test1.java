package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import pages.Home;
import pages.LogIn;
import pages.MyNotes;

public class Test1 {
	WebDriver driver;
	Home home;
	LogIn login;
	MyNotes mynotes;
	
  @Test
  @Parameters({"sUsername","sPassword"})
  public void MyTest(String sUsername, String sPassword) {
	  home = new Home(driver);
	  login = new LogIn(driver);
	  mynotes=new MyNotes(driver);
	  home.LoginClick();
	  login.EnterCredentials(sUsername, sPassword);
	  Assert.assertTrue(mynotes.verify_mynotes_page(), "My Notes page is displayed");
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
	  driver.close();
  }

}
