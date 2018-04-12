package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingSteps {
	static WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		driver = new FirefoxDriver();
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() {
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test@email.com");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc");
	}
	
	@When("^User clicks on Go button$")
	public void User_clicks_on_Go_button() {
		WebElement goButton = driver.findElement(By.id("memberLoginDialogoklabel"));
		goButton.click();
	}

	@Then("^He can visit the practice page$")
	public void he_can_visit_the_practice_page() throws InterruptedException {
		Thread.sleep(5000);
		WebElement practicePage = driver.findElement(By.xpath("//*[text()='Practice Page']"));
		practicePage.click();
	}
	
	@Then("^A message is displayed$")
	public void A_message_is_displayed() {
		System.out.println("Login Successful");
	}

//	@When("^User LogOut from the Application$")
//	public void user_LogOut_from_the_Application() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^he cannot visit practice page$")
//	public void he_cannot_visit_practice_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
}
