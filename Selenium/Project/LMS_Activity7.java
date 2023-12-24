package LMSProjectActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity7 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void verifyCountForAllCourses() {
		// Verify Navigation bar and Click On My Courses
		driver.findElement(By.xpath("//div[@class='main-navigation']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='All Courses']")).click();

		List<WebElement> allCourses = driver.findElements(By.cssSelector("h3[class='entry-title']"));
		int coursesCount = allCourses.size();
		System.out.println("No Of courses available :" + coursesCount);
		for (WebElement coursePrint : allCourses) {
			System.out.println(coursePrint.getText());
		}
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
