package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class HomeTest {
	WebDriver driver;
	@Given("Initiate browser")
	public void initiate_browser() {
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@When("Direct to the home page")
	public void direct_to_the_home_page() {
	  driver.get("https://qa.gudsho.com");
	}

}
