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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Tracking Order/TC-Detail Produk'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Tracking Order/button_Beli Sekarang'))

nama_produk_keranjang = WebUI.getText(findTestObject('Tracking Order/nama_produk_keranjang'))

harga_produk_keranjang =WebUI.getText(findTestObject('Tracking Order/harga_produk_keranjang'))

fee_admin_keranjang = WebUI.getText(findTestObject('Tracking Order/fee_admin_keranjang'))

fee_admin_keranjang = fee_admin_keranjang.replace('Rp ','')

fee_admin_keranjang = fee_admin_keranjang.replace(',','')

fee_admin_double = Double.parseDouble(fee_admin_keranjang)

//===================================================subtotal===============================================================

subtotal_keranjang = WebUI.getText(findTestObject('Tracking Order/subtotal_keranjang'))

subtotal_keranjang = subtotal_keranjang.replace('Rp ','')

subtotal_keranjang = subtotal_keranjang.replace(',','')

subtotal_double = Double.parseDouble(subtotal_keranjang)

//=====================================================total==================================================================

total_keranjang = WebUI.getText(findTestObject('Tracking Order/total_keranjang'))

total_keranjang = total_keranjang.replace('Rp ','')

total_keranjang = total_keranjang.replace(',','')

total_double = Double.parseDouble(total_keranjang)

//buat ngitung total

itung_total = fee_admin_double + subtotal_double

nama_produk = data.get('nama_produk')

harga_produk = data.get('harga_produk')

data.put('fee_admin',fee_admin_double)

data.put('subtotal',subtotal_double)

assert itung_total == total_double

assert nama_produk_keranjang.contains(nama_produk)

assert harga_produk_keranjang == harga_produk

return data



