package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps  {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUp() {
		//setup 
		//set chrome location
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\resources\\chromedriver.exe");
		
		//initialize chrome driver
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		
		//maximize window
		driver.manage().window().maximize();
		
		
		
	}
	@Given("I am on the login page")
	public void iAmOnTheLoginPage() {
		
		//open website
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
	}
	@When("I enter username {string} and password {string}")
	 
	public void UserAndPass(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);	
		
		
	}
	
	@When("I click on the login button")
	public void clickLoginButton() {
		
		loginPage.clickSubmit();
	}

	@Then("I should see the welcome message")
	public void welcomeMessage () {
		
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSuccessMessageLocator()));
		
		String successMessage = loginPage.getSuccessMessage();
		
		Assert.assertEquals("Logged In Successfully" , successMessage);
		
		System.out.println("Login successfully");
		
		loginPage.getSuccessMessage();
	}
	
	@After 
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
		
	}
}
