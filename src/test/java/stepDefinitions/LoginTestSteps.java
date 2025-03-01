package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {

	WebDriver driver;

	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/");
	}

	@When("^title of login page is FREE CRM$")
	public void title_of_login_page_is_free_crm() {
		String title = driver.getTitle();
		System.out.println("Login Page Title :" + title);
		Assert.assertEquals("Free CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
	}

	@Then("^clicks on login button$")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("^user is on login page$")
	public void user_is_on_login_page() {
		String title = driver.getTitle();
		System.out.println("Home Page Title :" + title);
		Assert.assertEquals("CRMPRO", title);
		driver.close();
	}
}
