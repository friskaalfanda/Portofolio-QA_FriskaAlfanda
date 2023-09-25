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

WebUI.callTestCase(findTestCase('Ongkir Kurir Internal/TC-Ongkir Kurir Internal-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Ongkir Kurir Internal/Button_Tambahkan Data'))

WebUI.verifyElementPresent(findTestObject('Ongkir Kurir Internal/Verifikasi_ambah Rute dan Ongkir Driver'), 0)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Kendaraan'), input_Kendaraan, false)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Posisi_Provinsi'), input_Posisi_Prov, false)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Posisi_Kabupaten'), input_Posisi_Kab, false)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Posisi_Kecamatan'), input_Posisi_Kec, false)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Tujuan_Provinsi'), input_Tujuan_Prov, false)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Tujuan_Kabupaten'), input_Tujuan_Kab, false)

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Tujuan_Kecamatan'), input_Tujuan_Kec, false)

WebUI.setText(findTestObject('Ongkir Kurir Internal/input_Ongkir'), input_Ongkir)

WebUI.setText(findTestObject('Ongkir Kurir Internal/input_Keterangan_TambahOngkir'), input_Keterangan)

WebUI.click(findTestObject('Ongkir Kurir Internal/button_Tambahkan'))

WebUI.verifyTextPresent('Enter a valid shipping price', false)

