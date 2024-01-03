from selenium.webdriver.chrome import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)


def openBrowserAndNavigateURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
    # driver = webdriver.Chrome(options=options)
    driver.get('https://alchemy.hguy.co/lms')


def Login():
    driver.find_element(By.LINK_TEXT, "My Account").click()
    driver.find_element(By.XPATH, "//a[contains(@class,'ld-login')]").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()


def SelectCourseAndMarkComplete():
    driver.find_element(By.LINK_TEXT, "All Courses").click()
    driver.find_element(By.XPATH, "//*[@id='post-71']/div[2]/p[2]/a").click()
    expectedTitle = "Email Marketing Strategies – Alchemy LMS"
    actualTitle = driver.title
    assert actualTitle == expectedTitle
    # Verify page title
    print('The title of page is:', actualTitle)
    print('Assertion successful, test completed!')

    # Select the lesson
    driver.find_element(By.LINK_TEXT, "Improving & Designing Marketing Emails").click();

    # Mark the lesson complete if possible
    if (driver.find_element(By.XPATH, "//*[@id='learndash_post_24186']/div/div[1]/div/div[2]")).isDisplayed():
        driver.find_element(By.XPATH, "//*[@id='learndash_post_24186']/div/div[1]/div/div[2]").click()
        print("The lesson is not complete")

    elif (driver.find_element(By.XPATH, "//*[@id='learndash_post_24186']/div/div[3]/a")).is_displayed():
        driver.find_element(By.XPATH, "//*[@id='learndash_post_24186']/div/div[3]/a").click()
        print("The lesson is complete")


def closeBrowser():
    driver.quit()


openBrowserAndNavigateURL()
Login()
SelectCourseAndMarkComplete()
closeBrowser()
