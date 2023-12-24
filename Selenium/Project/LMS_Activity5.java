package LMSProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity5 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyPageTitleForMyAccount() {
		// Verify Navigation bar and Click On My Account
		driver.findElement(By.xpath("//div[@class='main-navigation']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='My Account']")).click();

		// Get the title and print that title
		String MyAccountTitle = driver.getTitle();
		System.out.println("Page Title is: " + MyAccountTitle);

		// Assertion for Title
		Assert.assertEquals("My Account – Alchemy LMS", MyAccountTitle);

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
