package SeleniumProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/jobs/");
	}

	@Test
	public void verifyTheHeadingText() {
		// Check the heading of the page
		String headingText = driver.findElement(By.className("entry-title")).getText();

		// Print the heading of the page
		System.out.println("Page Heading is: " + headingText);

		// Assertion for heading page
		Assert.assertEquals("Welcome to Alchemy Jobs", headingText);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
