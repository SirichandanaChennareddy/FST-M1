package LMSProjectActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity1 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyWebsiteTitle() {
		String expectedTitle = "Alchemy LMS – An LMS Application";
		String actualTitle = driver.getTitle();

		// Print the title of the Website
		System.out.println("Website title is: " + actualTitle);

		// Assertion for page title
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
