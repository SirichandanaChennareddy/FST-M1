package HRMProjectActivities;

import java.time.Duration;
import java.util.List;

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

public class HRM_Activity9 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new ChromeDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/orangehrm/");
	}

	@Test
	public void verifyEmergencyContacts() {

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
		driver.findElement(By.xpath("//a[contains(text(),'Emergency Contacts')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table hover']/tbody")));
		List<WebElement> emergencyContacts = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

		for (WebElement row : emergencyContacts) {
			List<WebElement> cells = row.findElements(By.xpath("./td[5]"));

			// Print the contents of each cell

			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}