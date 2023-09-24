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
import java.text.DecimalFormat as DecimalFormat

HashMap<String, String> data = WebUI.callTestCase(findTestCase('Keranjang/TC-Cart-Show-002'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout/button_Checkout'))

WebUI.setText(findTestObject('Checkout/input_Checkout Your Information_firstName'), 'rida')

WebUI.setText(findTestObject('Checkout/input_Checkout Your Information_lastName'), 'aridaini')

WebUI.setText(findTestObject('Checkout/input_Checkout Your Information_postalCode'), '1018')

WebUI.click(findTestObject('Checkout/button_continue'))

nama1_cart = data.get('nama1_home')

deskripsi1_cart = data.get('deskripsi1_home')

harga1_cart = data.get('harga1_home')

nama1_checkout = WebUI.getText(findTestObject('Checkout/nama1_overview'))

deskripsi1_checkout = WebUI.getText(findTestObject('Checkout/deskripsi1_overview'))

harga1_checkout = WebUI.getText(findTestObject('Checkout/harga1_overview'))

WebUI.verifyMatch(nama1_checkout, nama1_cart, false)

WebUI.verifyMatch(deskripsi1_checkout, deskripsi1_cart, false)

WebUI.verifyMatch(harga1_checkout, harga1_cart, false)

total = WebUI.getText(findTestObject('Checkout/itemtotal_overview_1'))

// replace harga total sebelum tax
total = total.replace('Item total: $', '')

harga1_cart = harga1_cart.replace('$', '')

//bandingkan
WebUI.verifyMatch(total, harga1_cart, false)

totaldouble = Double.parseDouble(total)

totaldouble1 = (totaldouble * 0.08)

DecimalFormat df = new DecimalFormat('#.##')

df2 = Double.parseDouble(df.format(totaldouble1))

tax1 = WebUI.getText(findTestObject('Checkout/tax1_overview'))

tax1 = tax1.replace('Tax: $', '')

tax1 = Double.parseDouble(tax1)

assert df2 == tax1

totalbelanja = (df2 + totaldouble)

totalakhir_1 = WebUI.getText(findTestObject('Checkout/TotalAkhir_1'))

totalakhir_1 = Double.parseDouble(totalakhir_1.replace('Total: $', ''))

assert totalbelanja == totalakhir_1

WebUI.click(findTestObject('Checkout/button_Cancel_overview'))

