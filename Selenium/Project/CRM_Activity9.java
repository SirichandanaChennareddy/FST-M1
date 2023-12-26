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

public class CRM_Activity9 {

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

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody")));

		List<WebElement> totalRows = driver
				.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));

		int counter = 0;
		int num = 0;
		for (WebElement row : totalRows) {
			List<WebElement> cells = row.findElements(By.xpath("./td[@type='name']"));
			List<WebElement> cellnameValues = row.findElements(By.xpath("./td[@type='relate']"));

			// Print the contents of each cell

			for (WebElement cell : cells) {

				counter = counter + 1;
				if (counter <= 10) {
					System.out.println(cell.getText());
					break;
				}
			}

			for (WebElement cellname : cellnameValues) {

				num = num + 1;
				if (num <= 10) {
					System.out.println(cellname.getText());
					break;
				}
			}
		}

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}
