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

WebUI.verifyElementPresent(findTestObject('Tracking Order/Verifikasi_Profile'), 10)

WebUI.mouseOver(findTestObject('Tracking Order/Menu_Kategori Produk'))

WebUI.click(findTestObject('Tracking Order/Menu_Fashion  Busana Wanita'))

WebUI.verifyElementPresent(findTestObject('Tracking Order/Verifikasi_Kategori  Fashion  Busana Wanita'), 10)

nama_produk = WebUI.getText(findTestObject('Tracking Order/nama_produk'))

nama_produk = nama_produk.replace(',..','')

harga_produk = WebUI.getText(findTestObject('Tracking Order/harga_produk'))

HashMap<String, Object> data = new HashMap <String,Object>()

data.put('nama_produk', nama_produk)

data.put('harga_produk',harga_produk)

return data

