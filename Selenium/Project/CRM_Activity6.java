package CRMProjectActivities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity6 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/crm/");
	}

	@Test
	public void verifyMenuListHasActivities() {

		// Login with user credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();

		// Go to Activities Screen from Navigation menu
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar")));
		driver.findElement(By.id("toolbar")).isDisplayed();

		List<WebElement> menuList = driver
				.findElements(By.xpath("//div[@id='toolbar']//ul//li[@class='topnav']/span/a"));
		for (WebElement value : menuList) {
			if(value.getText().equalsIgnoreCase("ACTIVITIES")) {
				System.out.println("Activities exists in Menu item");
			}
		}
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
