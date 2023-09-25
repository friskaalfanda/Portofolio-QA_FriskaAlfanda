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

WebUI.callTestCase(findTestCase('Login User/TC-Login Sucess-User'), [('username_user') : 'beti', ('password_user') : '5HcH3tf6X6k='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Tracking Order/Button_Shop'))

WebUI.click(findTestObject('Tracking Order/button_Tracking Orders'))

WebUI.verifyElementPresent(findTestObject('Tracking Order/Verifikasi_Tracking Order_page'), 10)

WebUI.setText(findTestObject('Tracking Order/input_No Invoice'), 'TRX97.2023091501234')

WebUI.setText(findTestObject('Tracking Order/input_Alamat E-mail_Tracking Orders'), '')

WebUI.click(findTestObject('Tracking Order/button_Lacak Pesanan'))

WebUI.verifyTextPresent('Enter a valid order number.', false)

