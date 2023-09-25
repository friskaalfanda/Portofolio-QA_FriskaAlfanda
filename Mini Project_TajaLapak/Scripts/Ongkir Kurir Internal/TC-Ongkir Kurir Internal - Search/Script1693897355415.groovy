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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement 

WebUI.callTestCase(findTestCase('Ongkir Kurir Internal/TC-Ongkir Kurir Internal-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Ongkir Kurir Internal/Search'), input)

//Ambil semua element dari nomor
List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Ongkir Kurir Internal/tabel_data_Ongkir'),10)

for(i = 0; i< dataList.size(); i += 7) {
	cekSearch = false
	nomor = dataList.get(i).getText()
	kendaraan = dataList.get(i+1).getText()
	posisi = dataList.get(i+2).getText()
	tujuan = dataList.get(i+3).getText()
	ongkir = dataList.get(i+4).getText()
	keterangan = dataList.get(i+5).getText()

	if(nomor.contains(input)) {
		cekSearch = true
	}
	if(kendaraan.contains(input)) {
		cekSearch = true
	}
	if(posisi.contains(input)) {
		cekSearch = true
	}
	if(tujuan.contains(input)) {
		cekSearch = true
	}
	if(ongkir.contains(input)) {
		cekSearch = true
	}
	if(keterangan.contains(input)) {
		cekSearch = true
	}
	assert cekSearch == true
	 
} 

