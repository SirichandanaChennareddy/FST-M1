package LMSProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity3 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyTitleOfFirstInfoBox() {
		// Get the title of first info box
		String title_infoBox = driver.findElement(By.xpath("//h3[@class='uagb-ifb-title']")).getText();

		// Print the title of first Info box
		System.out.println("WebPage Heading is: " + title_infoBox);

		// Assertion for first Info box
		Assert.assertEquals("Actionable Training", title_infoBox);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
