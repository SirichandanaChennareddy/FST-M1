package SeleniumProjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test
	public void PreviewJobProfileAndSubmit() {
		// log in
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

		// click the menu item that says “Job Listings”.
		driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']")).click();

		// Locate the “Add New” button and click it
		driver.findElement(By.xpath("//a[@class='page-title-action']")).click();

		// Fill in the necessary details
		driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys("Testing12");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//input[@id='_job_location']")).sendKeys("Testing239");

		// Click the “Publish” button
		driver.findElement(By.xpath(
				"//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"))
				.click();
		driver.findElement(By.xpath(
				"//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']"))
				.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Verify that the job listing was created
		String s = driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-published']"))
				.getText();
		Assert.assertEquals(s, "Published");
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
