package CRMProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity4 {
	
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/crm/");
	}

	@Test
	public void verifyHomePageLogin() {
		
		// Login with user credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).sendKeys("admin");
		
		//verify user landed on Home page
		String homepage = driver.getTitle();
		System.out.println("Home Page Title is: " + homepage);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}


}
