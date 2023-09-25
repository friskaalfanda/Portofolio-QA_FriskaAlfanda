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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver 

WebUI.callTestCase(findTestCase('Ongkir Kurir Internal/TC-Ongkir Kurir Internal-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Ongkir Kurir Internal/Button_Tambahkan Data'))

WebUI.verifyElementPresent(findTestObject('Ongkir Kurir Internal/Verifikasi_ambah Rute dan Ongkir Driver'), 0)

WebUI.click(findTestObject('Ongkir Kurir Internal/button_Tambahkan'))

//Membuat objek Web driver
WebDriver webDriver = DriverFactory.getWebDriver()

//Mengambil Objek inputan NO_HP dulu
field_kendaraan = webDriver.findElement(By.xpath('/html/body/div[2]/div[1]/section[2]/div/div/div[2]/form/div/table/tbody/tr[1]/td/select[1]'))

//Mengambil Error Messge
error_message = ((webDriver) as JavascriptExecutor).executeScript('return arguments[0].validationMessage', field_kendaraan)

println(error_message)

//verifikasi apakah error message sesuai
assert error_message == "Please select an item in the list."


