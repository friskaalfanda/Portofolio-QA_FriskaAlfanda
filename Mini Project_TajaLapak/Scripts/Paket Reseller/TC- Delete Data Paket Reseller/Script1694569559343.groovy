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

WebUI.callTestCase(findTestCase('Paket Reseller/TC-Paket Reseller-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Paket Reseller/button_delete_edit_reseller'))

String[] dataList = WebUI.getText(findTestObject('Object Repository/Paket Reseller/total_data_reseller')).split(' ')

println dataList

jumlahdata_sebelum = Integer.parseInt(dataList[5])

println jumlahdata_sebelum

WebUI.click(findTestObject('Object Repository/Delete Data Ongkir Kurir Internal/button_edit_reseller'))

WebUI.acceptAlert()

String[] dataList2 = WebUI.getText(findTestObject('Object Repository/Paket Reseller/total_data_reseller')).split(' ')

jumlahdata_sesudah = Integer.parseInt(dataList2[5])

assert jumlahdata_sebelum-1 == jumlahdata_sesudah


