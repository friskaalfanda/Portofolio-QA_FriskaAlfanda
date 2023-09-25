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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.DriverFactory as DriverFactory
import org.openqa.selenium.support.ui.Select as Select

WebUI.callTestCase(findTestCase('Ongkir Kurir Internal/TC-Ongkir Kurir Internal-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Ongkir Kurir Internal/Button_Tambahkan Data'))

WebUI.verifyElementPresent(findTestObject('Ongkir Kurir Internal/Verifikasi_ambah Rute dan Ongkir Driver'), 10)

//====================================================Kendaraan=============================================================================

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Kendaraan'), input_DropDown_Kendaraan, false)

Select select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@name=\'a\']')))

String kendaraan = select.getFirstSelectedOption().getText()

//=====================================================Posisi-Provinsi=========================================================================

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Posisi_Provinsi'), input_DropDown_Posisi_Provinsi, false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_provinsi\']')))

String posisiProv = select.getFirstSelectedOption().getText()

//======================================================Posisi-Kabupaten=======================================================================
WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Posisi_Kabupaten'), input_DropDown_Posisi_Kabupaten, false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_kotakab\']')))

String posisiKab = select.getFirstSelectedOption().getText()

//=======================================================Posisi-Kecamatan=======================================================================

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Posisi_Kecamatan'), input_DropDown_Posisi_Kecamatan, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_kecamatan\']')))

String posisiKec = select.getFirstSelectedOption().getText()

//=====================================================Gabungan Posisi- Prov,Kab,Kec============================================================

String gabPosisi = (posisiKec + ', ') + posisiKab

//======================================================Tujuan-Provinsi==========================================================================

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Tujuan_Provinsi'), input_DropDown_Tujuan_Provinsi, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_provinsit\']')))

String tujuanProv = select.getFirstSelectedOption().getText()

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Tujuan_Kabupaten'), input_DropDown_Tujuan_Kabupaten, false)

//======================================================Tujuan-Kabupaten==========================================================================

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_kotakabt\']')))

String tujuanKab = select.getFirstSelectedOption().getText()

//========================================================Tujuan-Kecamatan=========================================================================

WebUI.selectOptionByValue(findTestObject('Ongkir Kurir Internal/DropDown_Tujuan_Kecamatan'), input_DropDown_Tujuan_Kecamatan, false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_kecamatant\']')))

String tujuanKec = select.getFirstSelectedOption().getText()
//=======================================================Gabungan Tujuan-Prov,Kab,Kec===============================================================

String gabTujuan = (tujuanKec + ', ') + tujuanKab

//=============================================================Input Ongkir==========================================================================

WebUI.setText(findTestObject('Jemput Zakat Online/input_OngkirRp'), input_Ongkir)

String ongkir = WebUI.getAttribute(findTestObject('Jemput Zakat Online/input_OngkirRp'), 'value')

//==============================================================Input Keterangan=====================================================================

WebUI.setText(findTestObject('Ongkir Kurir Internal/input_Keterangan_TambahOngkir'), input_Keterangan)

String keterangan = WebUI.getAttribute(findTestObject('Ongkir Kurir Internal/input_Keterangan_TambahOngkir'), 'value')

//===================================================================================================================================================
WebUI.click(findTestObject('Ongkir Kurir Internal/button_Tambahkan_Rute dan Ongkir'))

WebUI.click(findTestObject('Ongkir Kurir Internal/Klik_Nomor'))

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Ongkir Kurir Internal/new_data4'), 10)

//=================================================== Data sesudah input=================================================================================

i = 0

kendaraan_depan = dataList.get(i + 1).getText()

posisi = dataList.get(i + 2).getText()

tujuan = dataList.get(i + 3).getText()

ongkir1 = dataList.get(i + 4).getText().replace(',','')

keterangan1 = dataList.get(i + 5).getText()

assert kendaraan == kendaraan_depan

assert gabPosisi == posisi

assert gabTujuan == tujuan

assert ongkir == ongkir1

assert keterangan == keterangan1

