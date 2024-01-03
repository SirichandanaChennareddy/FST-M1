from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()


def navigateToURL():
    options = webdriver.ChromeOptions()
    options.add_experimental_option("detach", True)
    # driver = webdriver.Chrome(options=options)
    driver.get('https://alchemy.hguy.co/lms')
    get_title = driver.title
    print('Page title is: ', get_title)
    assert get_title == 'Alchemy LMS – An LMS Application'
    print('Assertion successful, test completed!')


def verifyTheHeadingText():
    headingText = driver.find_element(By.CLASS_NAME, 'uagb-ifb-title').text;
    assert headingText == 'Learn from Industry Experts'
    print('Heading Text is: ', headingText)


def closeBrowser():
    driver.quit()


navigateToURL()
verifyTheHeadingText()
closeBrowser()
