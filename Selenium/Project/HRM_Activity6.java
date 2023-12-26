package HRMProjectActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_Activity6 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new ChromeDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/orangehrm/");
	}

	@Test
	public void verifyNavigationMenu() {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");

		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");

		// Find the login button and click it.
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu']")));
		driver.findElement(By.xpath("//b[contains(text(),'Directory')]")).isDisplayed();
		WebElement directory = driver.findElement(By.xpath("//b[contains(text(),'Directory')]"));
		Actions action = new Actions(driver);
		action.moveToElement(directory).perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		action.moveToElement(directory).click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='toggle tiptip']")));
		driver.findElement(By.xpath("//div[@class='head']/h1")).isDisplayed();
		String title = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();

		System.out.println("Page Title is " + title);

		// Assertion for page title
		Assert.assertEquals("Search Directory", title);

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
