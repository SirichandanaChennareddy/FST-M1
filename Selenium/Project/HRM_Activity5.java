package HRMProjectActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_Activity5 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new ChromeDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/orangehrm");
	}

	@Test
	public void verifyMyInfo() {
		// Find the username field and enter the username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");

		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");

		// Find the login button and click it.
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewMyDetails']")));
		WebElement MyInfo = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		Actions action = new Actions(driver);
		action.moveToElement(MyInfo).build().perform();
		MyInfo.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmEmpPersonalDetails")));

		// Click on Edit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnSave']")));
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();

		// Update the fields
		driver.findElement(By.xpath("//input[@name='personal[txtEmpFirstName]']")).sendKeys("John_FST_1");
		driver.findElement(By.xpath("//input[@name='personal[txtEmpLastName]']")).sendKeys("Doe_FST_1");
		driver.findElement(By.xpath("//input[@name='personal[optGender]']")).click();
		Select drpCountry = new Select(
				driver.findElement(By.xpath("//select[@id='personal_cmbNation']")));

		// Click on the Save button
		driver.findElement(By.id("btnSave"));

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();

	}

}
