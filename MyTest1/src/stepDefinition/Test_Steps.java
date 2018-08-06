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
	public void user_is_on_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://testapp.galenframework.com/");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_navigates_to_loginpage() {
		Home home = new Home(driver);
		home.login_click();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_username_and_password() {
		LogIn login = new LogIn(driver);
		login.enter_credentials("testuser@example.com", "test123");
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_login_successfully() throws Throwable {
		System.out.println("Login Successfully");
		driver.close();
	}
}
