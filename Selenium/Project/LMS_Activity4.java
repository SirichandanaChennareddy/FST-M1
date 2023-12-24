package LMSProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity4 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyTitleForSecondPopularCourse() {
		// Get the Title for Second Popular Course
		String secondpopularCourse = driver.findElement(By.xpath("//h3[@class='entry-title' and text()='Email Marketing Strategies']")).getText();

		// Print the popular course heading
		System.out.println("Second Populat Course is: " + secondpopularCourse);

		// Assertion for second popular course
		Assert.assertEquals("Email Marketing Strategies", secondpopularCourse);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
