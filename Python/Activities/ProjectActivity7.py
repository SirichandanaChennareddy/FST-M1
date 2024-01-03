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


def calculateTheNumberOfCourses():
    Courses = driver.find_elements(By.XPATH, "//h3[@class='entry-title']")
    totalNoCourses = len(Courses)
    print('Total Number of Courses Offered:', totalNoCourses)
    print('The courses are:')
    for course in Courses:
        print(course.text)


def closeBrowser():
    driver.quit()


openBrowserAndNavigateURL()
calculateTheNumberOfCourses()
closeBrowser()
