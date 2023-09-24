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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//1.User masuk kedalam web
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

WebUI.maximizeWindow()

//2. Verifikasi user masuk kedalam web
WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Title_Home_Page'), 10)

//3. Klik tombol hamburger
WebUI.click(findTestObject('Object Repository/Login/Menu_Burger'))

//4. Klik tombol login
WebUI.click(findTestObject('Object Repository/Login/Menu_Login'))

//5. Verifikasi user masuk ke halaman login
WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Title_Login'), 10)

//6. Masukkan asal username
WebUI.setText(findTestObject('Object Repository/Login/input_Username'), username)

//7. Masukkan asal password
WebUI.setText(findTestObject('Object Repository/Login/input_Password'), password)

//8. Klik tombol login
WebUI.click(findTestObject('Object Repository/Login/Button_Login'))

//9. Error Message
WebUI.verifyElementText(findTestObject('Object Repository/Login/error_message'), 'Login failed! Please ensure the username and password are valid.')

WebUI.delay(5)

WebUI.closeBrowser()

