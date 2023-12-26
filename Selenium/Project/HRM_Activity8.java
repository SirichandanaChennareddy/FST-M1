package HRMProjectActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HRM_Activity8 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new ChromeDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/orangehrm/");
	}

	@Test
	public void verifyApplyLeave() {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");

		// Find the password field and enter the password
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");

		// Find the login button and click it.
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewMyDetails']")));
		driver.findElement(By.xpath(
				"//div[@id='dashboard-quick-launch-panel-menu_holder']/table[1]/tbody[1]/tr[1]/td[4]/div[1]/a[1]/img[1]"))
				.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));

		driver.findElement(By.id("applyleave_txtLeaveType")).click();
		driver.findElement(By.xpath("//option[contains(text(),'DayOff')]")).click();

		driver.findElement(By.id("applyleave_txtFromDate")).click();
		driver.findElement(By.xpath("//a[text()='26']")).click();

		driver.findElement(By.id("applyleave_txtToDate")).click();
		driver.findElement(By.xpath("//a[text()='26']")).click();
		driver.findElement(By.id("applyBtn")).click();

		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

		driver.findElement(By.id("calFromDate")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[text()='Dec']")).click();
		driver.findElement(By.xpath("//a[text()='26']")).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.findElement(By.id("calToDate")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[text()='2023']")).click();
		driver.findElement(By.xpath("//a[text()='26']")).click();
		
		driver.findElement(By.id("btnSearch")).click();
		String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody[1]/tr[1]/td[6]/a[1]")).getText();

		System.out.println("Status is: " + status);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
