import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.DecimalFormat

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

HashMap<String, String> data = WebUI.callTestCase(findTestCase('Keranjang/TC-Cart-Show-003'), [:], FailureHandling.STOP_ON_FAILURE)

//get barang 1 dan 2 dari cart
nama1_cart = data.get('nama1_home')

deskripsi1_cart = data.get('deskripsi1_home')

harga1_cart = data.get('harga1_home')

nama2_cart = data.get('nama2_home')

deskripsi2_cart = data.get('deskripsi2_home')

harga2_cart = data.get('harga2_home')

//get text barang 2 di overview
nama2_overview = WebUI.getText(findTestObject('Checkout/nama2_overview'))

deskripsi2_overview = WebUI.getText(findTestObject('Checkout/deskripsi2_overview'))

harga2_overview = WebUI.getText(findTestObject('Checkout/harga2_overview'))

nama1_overview = WebUI.getText(findTestObject('Checkout/nama1_overview'))

deskripsi1_overview = WebUI.getText(findTestObject('Checkout/deskripsi1_overview'))

harga1_overview = WebUI.getText(findTestObject('Checkout/harga1_overview'))

//---------------------------------------------------------------------------------------------
WebUI.click(findTestObject('Checkout/button_Checkout'))

WebUI.verifyElementPresent(findTestObject('Checkout/Checkout-Your Information'), 0)

WebUI.setText(findTestObject('Checkout/input_Checkout Your Information_firstName'), 'rida')

WebUI.setText(findTestObject('Checkout/input_Checkout Your Information_lastName'), 'aridaini')

WebUI.setText(findTestObject('Checkout/input_Checkout Your Information_postalCode'), '1018')

WebUI.click(findTestObject('Checkout/button_continue'))

WebUI.verifyMatch(nama1_overview, nama1_cart, false)

WebUI.verifyMatch(deskripsi1_overview, deskripsi1_cart, false)

WebUI.verifyMatch(harga1_overview, harga1_cart, false)

WebUI.verifyMatch(nama2_overview, nama2_cart, false)

WebUI.verifyMatch(deskripsi2_overview, deskripsi2_cart, false)

WebUI.verifyMatch(harga2_overview, harga2_cart, false)

harga1_overview = harga1_overview.replace('$', '')

harga2_overview = harga2_overview.replace('$', '')

harga1_overview_parse = Double.parseDouble(harga1_overview)

harga2_overview_parse = Double.parseDouble(harga2_overview)

//harga total
total1dan2 = (harga1_overview_parse + harga2_overview_parse)
//-----------------------------------------------------------------------------------
itemtotal2_overview = WebUI.getText(findTestObject('Checkout/itemtotal2_overview'))




//------------------------------------------------------------------------------------
itemtotal2_overview = itemtotal2_overview.replace('Item total: $','')




itemtotal2_overview_parse =Double.parseDouble(itemtotal2_overview)




//--------------------------------------------------------------------------

assert total1dan2 == itemtotal2_overview_parse

tax2_overview = WebUI.getText(findTestObject('Checkout/tax2_oveview'))

tax2_overview = tax2_overview.replace('Tax: $', '')

tax2_overview_parse =Double.parseDouble(tax2_overview)

hitungtax2 = total1dan2 * 0.08

DecimalFormat df = new DecimalFormat('#.##')

hitungtax2_round = Double.parseDouble(df.format(hitungtax2 ))

assert hitungtax2_round == tax2_overview_parse

//===========================================================
total2_overview = WebUI.getText(findTestObject('Checkout/total2_overview'))

total2_overview = total2_overview.replace('Total: $', '')

total2_overview_parse = Double.parseDouble(total2_overview)

totalfix = tax2_overview_parse + total1dan2

assert total2_overview_parse  == totalfix

WebUI.verifyElementPresent(findTestObject('Checkout/CheckOut-Overview'), 0)

WebUI.click(findTestObject('Checkout/button_Finish'))

WebUI.verifyElementPresent(findTestObject('Checkout/success_order'), 0)

