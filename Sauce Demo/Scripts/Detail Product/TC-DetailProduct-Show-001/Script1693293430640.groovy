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

WebUI.callTestCase(findTestCase('Login/TC-Login-Success-001'), [:], FailureHandling.STOP_ON_FAILURE)

nama1_homepage = WebUI.getText(findTestObject('Product/nama_product1_homepage'), FailureHandling.STOP_ON_FAILURE)

deskripsi1_homepage = WebUI.getText(findTestObject('Product/deskripsi_product1_homepage'), FailureHandling.STOP_ON_FAILURE)

harga1_homepage = WebUI.getText(findTestObject('Product/harga_produk1_homepage'))

WebUI.click(findTestObject('Product/nama_product1_homepage'))

nama1_deskripsi = WebUI.getText(findTestObject('Product/nama_produk_1_deskripsi'), FailureHandling.STOP_ON_FAILURE)

deskripsi1_deskripsi = WebUI.getText(findTestObject('Product/deskripsi_produk_1_deskripsi'), FailureHandling.STOP_ON_FAILURE)

harga1_deskripsi = WebUI.getText(findTestObject('Product/harga_produk_1_deskripsi'), FailureHandling.STOP_ON_FAILURE)



WebUI.verifyMatch(nama1_deskripsi, nama1_homepage, false)

WebUI.verifyMatch(deskripsi1_deskripsi, deskripsi1_homepage, false)

WebUI.verifyMatch(harga1_deskripsi, harga1_homepage, false)

