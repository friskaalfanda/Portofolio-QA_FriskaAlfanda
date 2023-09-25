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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Tracking Order/TC-Keranjang Belanja'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Tracking Order/button_lanjut bayar'))

WebUI.selectOptionByValue(findTestObject('Tracking Order/select_Prov'), '5', false)

WebUI.selectOptionByValue(findTestObject('Tracking Order/select_Kab'), '501', false)

WebUI.selectOptionByValue(findTestObject('Tracking Order/select_Kec'), '6987', false)

WebUI.selectOptionByValue(findTestObject('Tracking Order/select_Kirim via Kurir Lokal'), '2', false)

WebUI.click(findTestObject('Tracking Order/pilihan_kurir'))

//=======================================================ongkos kurir======================================================================
ongkos_kurir = WebUI.getText(findTestObject('Tracking Order/ongkos_kurir'))

ongkos_kurir = ongkos_kurir.replace('Rp. ', '')

ongkos_kurir = ongkos_kurir.replace(',', '')

ongkos_kurir = Double.parseDouble(ongkos_kurir)

//=======================================================ongkos kirim=========================================================================
ongkos_kirim = WebUI.getAttribute(findTestObject('Tracking Order/ongkos_kirim'), 'value')

ongkos_kirim = ongkos_kirim.replace('Rp ', '')

ongkos_kirim = ongkos_kirim.replace(',', '')

ongkos_kirim = Double.parseDouble(ongkos_kirim)



//============================================================fee admin=========================================================================
fee_admin_checkout = WebUI.getText(findTestObject('Tracking Order/fee_admin_checkout'))

fee_admin_checkout = fee_admin_checkout.replace('Rp ', '')

fee_admin_checkout = fee_admin_checkout.replace(',', '')

fee_admin_checkout = Double.parseDouble(fee_admin_checkout)


//===============================================================subtotal=======================================================================
subtotal_checkuot = WebUI.getText(findTestObject('Tracking Order/subtotal_checkuot'))

subtotal_checkuot = subtotal_checkuot.replace('Rp ', '')

subtotal_checkuot = subtotal_checkuot.replace(',', '')

subtotal_checkuot = Double.parseDouble(subtotal_checkuot)


//============================================================totalcheckout=====================================================================
total_checkout = WebUI.getText(findTestObject('Tracking Order/total_checkout'))

total_checkout = total_checkout.replace('Rp ', '')

total_checkout = total_checkout.replace(',', '')

total_checkout = Double.parseDouble(total_checkout)

//===============================================================hitung==========================================================================

data.put('ongkos_kirim',ongkos_kirim)

data.put('fee_admin_checkout',fee_admin_checkout)

data.put('subtotal_checkuot',subtotal_checkuot) 

total = ((ongkos_kirim + fee_admin_checkout) + subtotal_checkuot)

assert total_checkout == total

WebUI.click(findTestObject('Tracking Order/input_metode_pembayaran'))

WebUI.click(findTestObject('Tracking Order/button_Proses Pembayaran'))

return data

