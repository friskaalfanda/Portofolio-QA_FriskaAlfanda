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

WebUI.click(findTestObject('Paket Reseller/button_edit_data1'))

WebUI.verifyElementPresent(findTestObject('Paket Reseller/verifikasi_Edit Paket'), 10)

WebUI.setText(findTestObject('Paket Reseller/input_Nama Paket_paket'), nama_paket_edit)

nama_paket = WebUI.getAttribute(findTestObject('Paket Reseller/input_Nama Paket_paket'), 'value')

WebUI.setText(findTestObject('Paket Reseller/input_Judul_paket'), judul_paket_edit)

judul_paket = WebUI.getAttribute(findTestObject('Paket Reseller/input_Judul_paket'), 'value')

WebUI.setText(findTestObject('Paket Reseller/input_Keterangan_paket'), keterangan_paket_edit)

keterangan_paket = WebUI.getAttribute(findTestObject('Paket Reseller/input_Keterangan_paket'), 'value')

WebUI.setText(findTestObject('Paket Reseller/input_Durasi_paket'), durasi_paket_edit)

durasi_paket = WebUI.getAttribute(findTestObject('Paket Reseller/input_Durasi_paket'), 'value')

WebUI.setText(findTestObject('Paket Reseller/input_Harga_paket'), harga_paket_edit)

harga_paket = WebUI.getAttribute(findTestObject('Paket Reseller/input_Harga_paket'), 'value')

WebUI.setText(findTestObject('Paket Reseller/input_Max Produk_paket'), max_produk_edit)

max_produk = WebUI.getAttribute(findTestObject('Paket Reseller/input_Max Produk_paket'), 'value')

WebUI.setText(findTestObject('Paket Reseller/input_Icon Kode_paket'), icon_kode_edit)

icon_kode = WebUI.getAttribute(findTestObject('Paket Reseller/input_Icon Kode_paket'), 'value')

WebUI.click(findTestObject('Paket Reseller/button_Tambahkan_reseller'))

namapaket_after = WebUI.getText(findTestObject('Paket Reseller/td_NamaPaket'))

durasi_after= WebUI.getText(findTestObject('Paket Reseller/td_Durasi'))

rep = durasi_after.replace(" Hari", "")

harga_after = WebUI.getText(findTestObject('Paket Reseller/td_Harga'))

repharga = harga_after.replace(",", "")

repharga2 = repharga.replace("Rp ","")

maxproduk_after = WebUI.getText(findTestObject('Paket Reseller/td_MaxProduk'))

repmaxproduk = maxproduk_after.replace(" Produk","")

iconkode_after = WebUI.getText(findTestObject('Paket Reseller/td_IconKode'))




//=============================================================test data after dan input===============================================================

assert namapaket_after == nama_paket

assert rep == durasi_paket

assert repharga2 == harga_paket

assert repmaxproduk == max_produk

assert iconkode_after == icon_kode



