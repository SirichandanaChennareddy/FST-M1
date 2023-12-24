package LMSProjectActivities;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity9 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void ValidateCompletingCourse() {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();

		// Click on Login Button
		driver.findElement(By.xpath("//*[text()='Login']")).click();

		// Enter username, password and click on login
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();

		// Verify Navigation bar and Click On My Courses
		driver.findElement(By.xpath("//div[@class='main-navigation']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='All Courses']")).click();

		// select any course and open it
		driver.findElement(By.xpath("//*[contains(text(),'See more...')]")).click();
		System.out.println(driver.getTitle());

		// click on each course and verify the title of the course
		driver.findElement(By.xpath("//div[contains(text(),' Developing Strategy ')]")).click();
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//div[contains(text(),' Monitoring & Digital Advertising ')]")).click();
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//div[contains(@class,'lesson-')]/div[3]/div[1]/a[1]/div[2]")).click();
		System.out.println(driver.getTitle());

		try {
			driver.findElement(By.xpath("//*[text()='Complete']"));
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("//*[@value='Mark Complete']")).click();
		}
		System.out.println(driver.getTitle() + " is completed");
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
