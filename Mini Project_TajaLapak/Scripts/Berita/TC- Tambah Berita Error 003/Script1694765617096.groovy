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

WebUI.callTestCase(findTestCase('Login Admin/TC-Login-Success-Admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Berita/menu_Modul Berita'))

WebUI.click(findTestObject('Berita/menu_Berita'))

WebUI.verifyElementPresent(findTestObject('Berita/Verifikasi_Semua Berita'), 10)

WebUI.click(findTestObject('Berita/button_Tambahkan Data'))

WebUI.verifyElementPresent(findTestObject('Berita/Verifikasi_Tambah Berita Baru'), 10)

WebUI.setText(findTestObject('Berita/input_Judul Berita'), judul_berita)

WebUI.setText(findTestObject('Berita/input_Sub Judul Berita'), sub_berita)

WebUI.setText(findTestObject('Berita/input_Video Youtube Berita'), video_yt)

WebUI.selectOptionByValue(findTestObject('Berita/pilihan kategori berita'), kategori_berita, false)

WebUI.click(findTestObject('Berita/input_headline'))

WebUI.click(findTestObject('Berita/input_pilihan'))

WebUI.click(findTestObject('Berita/input_berita utama'))

WebUI.setText(findTestObject('Berita/Isi berita'), isi_berita)

WebUI.setText(findTestObject('Berita/input_Ket gambar'), ket_gambar)

WebUI.click(findTestObject('Berita/button_Tambahkan'))

WebUI.verifyTextPresent('Masukkan form berita yang valid', false)

