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


def clickContactUsAndFillTheRequestedInfo():
    driver.find_element(By.LINK_TEXT, "Contact").click();
    driver.find_element(By.ID, "wpforms-8-field_0").send_keys("Tom Harrison")
    driver.find_element(By.ID, "wpforms-8-field_1").send_keys("abcd@gmail.com")
    driver.find_element(By.ID, "wpforms-8-field_3").send_keys("Query for Course")
    driver.find_element(By.ID, "wpforms-8-field_2").send_keys("I have query regarding a course.")
    driver.find_element(By.ID, "wpforms-submit-8").click()
    message = driver.find_element(By.XPATH,
                                  "//div[contains(@id,'wpforms-confirmation')]/p").get_attribute(
        "innerHTML")
    print("The message displayed is :", message)


def closeBrowser():
    driver.quit()


openBrowserAndNavigateURL()
clickContactUsAndFillTheRequestedInfo()
closeBrowser()