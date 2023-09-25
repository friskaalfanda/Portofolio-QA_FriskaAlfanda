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

HashMap<String, Object> data = WebUI.callTestCase(findTestCase('Tracking Order/TC- Tracking'), [:], FailureHandling.STOP_ON_FAILURE)

No_invoice_tracking = data.get('No_Invoice')

Status_tracking_tracking = data.get('Status_Tracking')

WebUI.callTestCase(findTestCase('Tracking Order/TC- Order Konsumen Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Tracking Order/Status Pesanan/search_orderan_konsumen'), No_invoice_tracking)

WebUI.click(findTestObject('Tracking Order/button pilihan status'))

status_dikirim = WebUI.getText(findTestObject('Tracking Order/a_Dikirim'))

WebUI.click(findTestObject('Tracking Order/a_Dikirim'))

WebUI.acceptAlert()

WebUI.delay(5)

WebUI.setText(findTestObject('Tracking Order/Status Pesanan/search_orderan_konsumen'), No_invoice_tracking)

status_after_dikirim = WebUI.getText(findTestObject('Tracking Order/status_kirim2'))

data.put('status_dikirim', status_after_dikirim)

data.put('no_invoice', No_invoice_tracking)

assert status_dikirim == status_after_dikirim

return data

