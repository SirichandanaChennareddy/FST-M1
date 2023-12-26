package HRMProjectActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_Activity4 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new ChromeDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/orangehrm");
	}

	@Test
	public void verifyThatnewEmployeeAdded() {
		// Find the username field and enter the username
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");

		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");

		// Find the login button and click it.
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		// Verify PIM is displayed and click on PIM Option
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		WebElement PIMOption = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		Actions action = new Actions(driver);
		action.moveToElement(PIMOption).perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@id,'viewEmployeeList')]")));
		WebElement employeeList = driver.findElement(By.xpath("//a[contains(@id,'viewEmployeeList')]"));
		action = new Actions(driver);
		action.moveToElement(employeeList).click().perform();

		// Click on Add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnAdd']")));
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();

		// Fill all required fields
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Sirichandana");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Chennareddy");

		// Click on the Save button
		driver.findElement(By.id("btnSave"));

		PIMOption = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
		action = new Actions(driver);
		action.moveToElement(PIMOption).click().perform();

		// Search with Username and verify that employee is dispalyed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName")));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='empsearch[employee_name][empName]']")).clear();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='empsearch[employee_name][empName]']")).click();
		driver.findElement(By.xpath("//input[@name='empsearch[employee_name][empName]']"))
				.sendKeys("Sirichandana Chennareddy" + Keys.ENTER);

		driver.findElement(By.id("searchBtn")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();

	}

}
