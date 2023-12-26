package CRMProjectActivities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity7 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Open browser
		driver.get("https://alchemy.hguy.co/crm/");
	}

	@Test
	public void verifyColourOfNavigationMenu() {

		// Login with user credentials
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement sales = driver.findElement(By.id("grouptab_0"));
		Actions action = new Actions(driver);
		action.moveToElement(sales).perform();

		driver.findElement(By.id("moduleTab_9_Leads")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Additional Details']")));

		WebElement additionalInfo = driver.findElement(By.xpath("//span[@title='Additional Details']"));
		additionalInfo.isDisplayed();
		additionalInfo.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable']/preceding-sibling::div/h2[contains(text(),'Leads')]")));
		driver.findElement(By.xpath(
				"//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable']/preceding-sibling::div/h2[contains(text(),'Leads')]"))
				.isDisplayed();

		WebElement phoneNumber = driver
				.findElement(By.xpath("//*[contains(text(),'Home Phone:')]/following-sibling::span"));
		System.out.println("Phone Number displayed under Popu up is : " + phoneNumber.getText());

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
