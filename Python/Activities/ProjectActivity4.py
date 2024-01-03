from selenium.webdriver.chrome import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)


def openURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
    # driver = webdriver.Chrome(options=options)
    driver.get('https://alchemy.hguy.co/lms')


def VerifySecondMostPopularCourseTitle():
    expectedTitle = 'Email Marketing Strategies'
    ActualTitle = driver.find_element(By.XPATH,
                                      "//h3[@class='entry-title' and text()='Email Marketing Strategies']").text
    print('The most popular Course Title is:', ActualTitle)
    assert expectedTitle == ActualTitle
    print('Assertion successful, test completed!')


def browserClose():
    driver.quit()


openURL()
VerifySecondMostPopularCourseTitle()
browserClose()