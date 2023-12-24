package SeleniumProjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test
	public void verifyThatRootUserLoginSuccessfully() {
		// Find the username field and enter the username
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");

		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");

		// Find the login button and click it.
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

		// Verify that you have logged in

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		Actions action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement root = driver.findElement(By.xpath("(//span[@class='display-name' and text()='root'])[1]"));
		System.out.println(root.isDisplayed());
		new Actions(driver).moveToElement(root).click().perform();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();

	}
}
