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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Tracking Order/TC- Checkout Order'), [:], FailureHandling.STOP_ON_FAILURE)

ongkos_kirim = data.get('ongkos_kirim')

fee_admin_checkout = data.get('fee_admin_checkout')

subtotal_checkuot = data.get('subtotal_checkuot')

//==============================================ongkos kirim tracking==================================================================
Ongkos_kirim_tracking = WebUI.getText(findTestObject('Tracking Order/Ongkos_kirim_tracking'))

Ongkos_kirim_tracking = Ongkos_kirim_tracking.replace('Rp ', '')

Ongkos_kirim_tracking = Ongkos_kirim_tracking.replace(',', '')

Ongkos_kirim_tracking = Double.parseDouble(Ongkos_kirim_tracking)

//===============================================fee admin tracking-==================================================================
fee_admin_tracking = WebUI.getText(findTestObject('Tracking Order/fee_admin_tracking'))

fee_admin_tracking = fee_admin_tracking.replace('Rp ', '')

fee_admin_tracking = fee_admin_tracking.replace(',', '')

fee_admin_tracking = Double.parseDouble(fee_admin_tracking)

//=====================================================subtotal tracking===============================================================
subtotal_tracking = WebUI.getText(findTestObject('Tracking Order/subtotal_tracking'))

No_Invoice_Tracking = WebUI.getText(findTestObject('Tracking Order/No_Invoice_Tracking'))

Status_Tracking = WebUI.getText(findTestObject('Tracking Order/Status_Tracking'))

subtotal_tracking = subtotal_tracking.replace('Rp ', '')

subtotal_tracking = subtotal_tracking.replace(',', '')

subtotal_tracking = Double.parseDouble(subtotal_tracking)

//=====================================================================================================================================

data.put('No_Invoice',No_Invoice_Tracking)

data.put('Status_Tracking',Status_Tracking)

assert ongkos_kirim == Ongkos_kirim_tracking

assert fee_admin_checkout == fee_admin_tracking

assert subtotal_checkuot == subtotal_tracking

return data
