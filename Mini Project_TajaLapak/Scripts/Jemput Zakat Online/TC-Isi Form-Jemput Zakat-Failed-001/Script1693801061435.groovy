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

WebUI.verifyElementPresent(findTestObject('Login/Verify HomePage'), 10)

WebUI.mouseOver(findTestObject('Jemput Zakat Online/Menu_Donasi'))

WebUI.click(findTestObject('Jemput Zakat Online/Menu_Jemput Zakat'))

WebUI.verifyElementPresent(findTestObject('Jemput Zakat Online/Verifikasi_Jemput Zakat Online_Page'), 0)

WebUI.selectOptionByValue(findTestObject('Jemput Zakat Online/Dropbox_JenisZakat'), 'Zakat Fitrah', false, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Jemput Zakat Online/Input_Ongkir'), '###')

WebUI.setText(findTestObject('Jemput Zakat Online/Input_No Handphone'), GlobalVariable.No_Handphone)

WebUI.setText(findTestObject('Jemput Zakat Online/Input_Alamat Email'), GlobalVariable.Alamat_Email)

WebUI.selectOptionByValue(findTestObject('Jemput Zakat Online/DropDown_MetodePembayaran'), '1', false)

WebUI.setText(findTestObject('Jemput Zakat Online/Input_Alamat Penjemputan'), GlobalVariable.Alamat_Penjemputan)

WebUI.setText(findTestObject('Jemput Zakat Online/Input_Doa Terbaik'), GlobalVariable.Doa)

WebUI.setText(findTestObject('Jemput Zakat Online/input_OngkirRp'), GlobalVariable.Digit_NoHP)

WebUI.click(findTestObject('Jemput Zakat Online/button_Jemput Zakat Sekarang'))

WebUI.verifyElementText(findTestObject('Jemput Zakat Online/Verifikasi_BerhasilZakat'), 'Inputan tidak valid, masukkan nama lengkap dengan huruf yang valid')

