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

WebUI.callTestCase(findTestCase('Products/TC-Product-Show-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Product/button_Add to cart_Pertama'))

namaproduct1_homepage = WebUI.getText(findTestObject('Product/nama_product1_homepage'))

deskripsiproduct1_homepage = WebUI.getText(findTestObject('Product/deskripsi_product1_homepage'))

hargaproduct1_homepage = WebUI.getText(findTestObject('Product/harga_produk1_homepage'))

WebUI.verifyElementNotPresent(findTestObject('Product/button_Add to cart_Pertama'), 0)

WebUI.verifyElementPresent(findTestObject('Product/tambahproduct'), 0)

HashMap<String, String> data = new HashMap<String, String>()

data.put('nama1_home', namaproduct1_homepage)
data.put('deskripsi1_home',deskripsiproduct1_homepage)
data.put('harga1_home', hargaproduct1_homepage)

return data;
