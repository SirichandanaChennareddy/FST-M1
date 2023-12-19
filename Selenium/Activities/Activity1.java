package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {
	
	public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
 
        driver.get("https://v1.training-support.net");
        System.out.println("Home page title: " + driver.getTitle());
        
     
        driver.findElement(By.id("about-link")).click();
        System.out.println("About page title: " + driver.getTitle());

        driver.close();
    }

}
