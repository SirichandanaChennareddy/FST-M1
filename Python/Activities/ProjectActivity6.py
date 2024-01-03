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


def loginToAlchemyPortal():
    driver.find_element(By.LINK_TEXT, "My Account").click();
    driver.find_element(By.XPATH, "//a[contains(@class,'ld-login')]").click()
    driver.find_element(By.ID, "user_login").send_keys("root")
    driver.find_element(By.ID, "user_pass").send_keys("pa$$w0rd")
    driver.find_element(By.ID, "wp-submit").click()
    login = driver.find_element(By.XPATH, "/html/body/div[2]/div/ul[2]/li[2]/a").is_displayed()
    if login:
        print("Login successfully")
    else:
        print('User is not Logged In')


def closeBrowser():
    driver.quit()


openBrowserAndNavigateURL()
loginToAlchemyPortal()
closeBrowser()
