package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Home;
import Pages.LogIn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	WebDriver driver;

	@Given("^User is on Home Page$")
	public void User_is_on_HomePage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://testapp.galenframework.com/");
	}

	@When("^User Navigate to LogIn Page$")
	public void User_navigates_to_LogInPage() {
		Home home = new Home(driver);
		home.LoginClick();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
		LogIn login = new LogIn(driver);
		login.EnterCredentials("testuser@example.com", "test123");
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
		driver.close();
	}
}
