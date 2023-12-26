package CRMProjectActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity2 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/crm/");
	}

	@Test
	public void GetUrlOfHeaderImage() {
		// Get the URL of Header Image
		WebElement headerImageUrl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		String src = headerImageUrl.getAttribute("src");

		// Print the heading URL in the console
		System.out.println("Header Image URL is: " + src);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
