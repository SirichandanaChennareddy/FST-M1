package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;

import java.io.IOException;
import java.net.MalformedURLException;

public class Activity1 {
    WebDriverWait wait;
    AndroidDriver driver;
    String result=null;
    //setup desired capabilities

    @BeforeClass
    public void setupDesiredCapabilities() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();
        //Set server URL
        URL appiumserverURL = new URL("http://localhost:4723/wd/hub");

        //initialize the android driver
        driver = new AndroidDriver(appiumserverURL, options);
    }
    //calculator methods
    @Test
    public void calculateAddition() throws IOException {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        //Perform the addition of two numbers
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_3")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        result=driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "475");
    }
    @Test
    public void calculateSubstraction() throws IOException {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_4")).click();
        driver.findElement(AppiumBy.id("digit_4")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        result=driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "504");
    }
    @Test
    public void calculateMultiplication() throws IOException {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        result=driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "96");
    }
    @Test
    public void calculateDivision() throws IOException {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        result=driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "5");
    }
    @AfterClass
    //Close the browser
    public void closeCalculatorApp(){

        driver.quit();
    }
}
