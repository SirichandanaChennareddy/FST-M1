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


def navigateToAccountPageAndVerifyTitleOfPage():
    driver.find_element(By.LINK_TEXT, "My Account").click()
    actualTitle = driver.title
    expectedTitle = 'My Account – Alchemy LMS'
    assert actualTitle == expectedTitle
    print('Assertion successful, test completed!')
    print('You redirected to My Account Page')


def closeBrowser():
    driver.quit()


openBrowserAndNavigateURL()
navigateToAccountPageAndVerifyTitleOfPage()
closeBrowser()
