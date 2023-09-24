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

HashMap<String, String> data = WebUI.callTestCase(findTestCase('Products/TC-Product-AddCart-001'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Product/tambahproduct'))

nama1_home = data.get('nama1_home')

deskripsi1_home = data.get('deskripsi1_home')

harga1_home = data.get('harga1_home')

nama1_cart = WebUI.getText(findTestObject('Cart/nama1_cart'))

deskripsi1_cart = WebUI.getText(findTestObject('Cart/deskripsi1_cart'))

harga1_cart = WebUI.getText(findTestObject('Cart/price1_cart'))

WebUI.verifyMatch(nama1_cart, nama1_home , false)

WebUI.verifyMatch(deskripsi1_cart, deskripsi1_home, false)

WebUI.verifyMatch(harga1_cart, harga1_home, false)

return data


