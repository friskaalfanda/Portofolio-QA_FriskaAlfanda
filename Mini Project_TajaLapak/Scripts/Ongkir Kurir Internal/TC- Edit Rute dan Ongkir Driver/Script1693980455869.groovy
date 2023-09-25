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
import org.openqa.selenium.support.ui.Select as Select

WebUI.callTestCase(findTestCase('Ongkir Kurir Internal/TC-Ongkir Kurir Internal-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Edit Rute dan Ongkir Driver/button_edit rute'))

WebUI.verifyElementPresent(findTestObject('Edit Rute dan Ongkir Driver/Verifikasi_Edit Rute dan Ongkir Driver'), 10)

//=====================================================Edit Kendaraan======================================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Kendaraan_edit'), edit_DropDown_Kendaraan, false)

Select select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@name=\'a\']')))

String kendaraan = select.getFirstSelectedOption().getText()

//=======================================================Edit Posisi-Provinsi===============================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Edit_Posisi_Prov'), edit_DropDown_Posisi_Provinsi, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="list_provinsi"]')))

String posisiProv = select.getFirstSelectedOption().getText()

//========================================================Edit Posisi-Kebupaten===============================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Edit_Posisi_Kab'), edit_DropDown_Posisi_Kabupaten, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="list_kotakab"]')))

String posisiKab = select.getFirstSelectedOption().getText()

//=======================================================Edit Posisi-Kecamatan==================================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Edit_Posisi_Kec'), edit_DropDown_Posisi_Kecamatan, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="list_kecamatan"]')))

String posisiKec = select.getFirstSelectedOption().getText()

//=======================================================Gabungan Tujuan-Prov,Kab,Kec===============================================================
String gabPosisi = (posisiKec + ', ') + posisiKab

//=======================================================Edit Tujuan-Provinsi===============================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Edit_Tujuan_Prov'), edit_DropDown_Tujuan_Provinsi, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_provinsit\']')))

String tujuanProv = select.getFirstSelectedOption().getText()

//========================================================Edit Tujuan-Kebupaten===============================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Edit_Tujuan_Kab'), edit_DropDown_Tujuan_Kabupaten, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//select[@id=\'list_kotakabt\']')))

String tujuanKab = select.getFirstSelectedOption().getText()

//=======================================================Edit Tujuan-Kecamatan==================================================================
WebUI.selectOptionByValue(findTestObject('Edit Rute dan Ongkir Driver/Edit_Tujuan_Kec'), edit_DropDown_Tujuan_Kecamatan, 
    false)

select = new Select(com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver().findElement(By.xpath('//*[@id="list_kecamatant"]')))

String tujuanKec = select.getFirstSelectedOption().getText()

//=======================================================Gabungan Tujuan-Prov,Kab,Kec===============================================================
String gabTujuan = (tujuanKec + ', ') + tujuanKab

//==============================================================Edit Ongkir==========================================================================
WebUI.setText(findTestObject('Edit Rute dan Ongkir Driver/Edit_Ongkir'), edit_Ongkir)

String ongkir = WebUI.getAttribute(findTestObject('Edit Rute dan Ongkir Driver/Edit_Ongkir'), 'value')

//==============================================================Edit Keterangan=====================================================================
WebUI.setText(findTestObject('Edit Rute dan Ongkir Driver/Edit_Keterangan'), edit_Keterangan)

String keterangan = WebUI.getAttribute(findTestObject('Edit Rute dan Ongkir Driver/Edit_Keterangan'), 'value')

WebUI.click(findTestObject('Edit Rute dan Ongkir Driver/button_Tambahkan_Edit'))

WebUI.delay(3)

WebUI.click(findTestObject('Edit Rute dan Ongkir Driver/th_ongkir'))

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Edit Rute dan Ongkir Driver/dataedit_baru'), 
    10)

//===============================================================Data sesudah edit===================================================================
i = 0

kendaraan_depan = dataList.get(i + 1).getText()

posisi = dataList.get(i + 2).getText()

tujuan = dataList.get(i + 3).getText()

ongkir1 = dataList.get(i + 4).getText().replace(',', '')

keterangan1 = dataList.get(i + 5).getText()

assert kendaraan == kendaraan_depan

assert gabPosisi == posisi

assert gabTujuan == tujuan

assert ongkir == ongkir1

assert keterangan == keterangan1

