import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.Keys as Keys


WebUI.openBrowser('')

WebUI.navigateToUrl('https://stage-txt.ad.portal.texas.gov/')

WebUI.maximizeWindow()

Thread.sleep(3000)

WebUI.sendKeys(findTestObject('Object Repository/loginElements/emailField'), 'sai@yopmail.com')


WebUI.sendKeys(findTestObject('Object Repository/loginElements/passwordField'), 'password')

WebUI.click((findTestObject('Object Repository/loginElements/signInButton')))

WebDriver driver = DriverFactory.getWebDriver()

WebUI.executeJavaScript("window.open('about:blank','_blank');",null)

ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles())

driver.switchTo().window(tabs.get(1))

driver.navigate().to('https://yopmail.com/')

WebUI.sendKeys((findTestObject('Object Repository/loginElements/yopUsernameField')),'sai')


WebUI.sendKeys(findTestObject('Object Repository/loginElements/yopUsernameField'), Keys.chord(Keys.ENTER))
driver.switchTo().frame('ifmail')
String otp = WebUI.getText(findTestObject('Object Repository/loginElements/optYobEmail'))


driver.switchTo().window(tabs.get(0))
	

WebUI.sendKeys(findTestObject('Object Repository/loginElements/optField'),otp)

//WebUI.click((findTestObject('Object Repository/loginElements/rememberCheckboxField')))


WebUI.click((findTestObject('Object Repository/loginElements/submitOtpButton')))

Thread.sleep(3000)

WebUI.verifyMatch(WebUI.getUrl(), 'https://stage-txt.ad.portal.texas.gov/dashboard', false)
