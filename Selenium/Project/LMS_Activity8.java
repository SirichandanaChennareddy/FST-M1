package LMSProjectActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity8 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyContactPage() {
		// Verify Navigation bar and Click On Contact
		driver.findElement(By.xpath("//div[@class='main-navigation']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='Contact']")).click();

        driver.findElement(By.name("wpforms[fields][0]")).sendKeys("Test123");
        driver.findElement(By.name("wpforms[fields][1]")).sendKeys("testlms@gmail.com");
        driver.findElement(By.name("wpforms[fields][2]")).sendKeys("Testing");
        driver.findElement(By.name("wpforms[fields][3]")).sendKeys("Testing Activity 8 in LMS");
        driver.findElement(By.cssSelector("button[name='wpforms[submit]']")).click();
        
        
        String successMessage = driver.findElement(By.id("wpforms-confirmation-8")).getText();
        //Print the message
        System.out.println("Message displayed after submission is: " +successMessage);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}
}
