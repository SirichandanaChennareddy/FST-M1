package LMSProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity2 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyTheHeadingOfWebSite() {
		// Get the Heading of website
		String title = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();

		// Print the title of website
		System.out.println("WebPage Heading is: " + title);

		// Assertion for website
		Assert.assertEquals("Learn from Industry Experts", title);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
