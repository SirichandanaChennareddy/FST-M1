package HRMProjectActivities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_Activity3 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/orangehrm");
	}

	@Test
	public void verifyThatUserLoginSuccessfully() {
		// Find the username field and enter the username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");

		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");

		// Find the login button and click it.
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		// Verify that you have logged in

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement message = driver.findElement(By.xpath("//a[@id='welcome']"));
		System.out.println(message.isDisplayed());
		
		//Get Current page url and print it in the console
		String homePageurl = driver.getCurrentUrl();
		System.out.println("Home Page url is:" + homePageurl);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();

	}

}
