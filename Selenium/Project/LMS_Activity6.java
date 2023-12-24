package LMSProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity6 {
	
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyLoginPageForMyAccount() {
		// Verify Navigation bar and Click On My Account
		driver.findElement(By.xpath("//div[@class='main-navigation']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='My Account']")).click();

		// Get the title and print that title
		String MyAccountTitle = driver.getTitle();
		System.out.println("Page Title is: " + MyAccountTitle);

		// Assertion for Title
		Assert.assertEquals("My Account – Alchemy LMS", MyAccountTitle);
		
		//Click on Login Button
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		
		//Enter username, password and click on login
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		//Verify the login Page
		driver.findElement(By.xpath("(//span[@class='display-name'])[1]")).isDisplayed();

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
