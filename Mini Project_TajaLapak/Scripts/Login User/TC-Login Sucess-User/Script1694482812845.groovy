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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('Paket Reseller/Verify_homepage'), 10)

WebUI.click(findTestObject('Login/user_Login'))

WebUI.verifyElementPresent(findTestObject('Paket Reseller/Verify_Login'), 10)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Paket Reseller/input_Username'), GlobalVariable.username_User)

WebUI.setEncryptedText(findTestObject('Paket Reseller/input_Password'), GlobalVariable.password_user)

WebUI.click(findTestObject('Paket Reseller/button_Masuk'))

WebUI.verifyElementPresent(findTestObject('Paket Reseller/Verify Profile'), 10)

