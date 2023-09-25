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

WebUI.callTestCase(findTestCase('Paket Reseller/TC-Paket Reseller-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Paket Reseller/input_Search_reseller'), search_reseller)

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Paket Reseller/data_starreseller'),10)

for(i = 0; i< dataList.size(); i += 8) {
	cekSearch = false
	nomor = dataList.get(i).getText().toLowerCase()
	nama_paket = dataList.get(i+1).getText().toLowerCase()
	durasi = dataList.get(i+2).getText().toLowerCase()
	harga = dataList.get(i+3).getText().toLowerCase()
	Max_Produk = dataList.get(i+4).getText().toLowerCase()
	Icon_kode = dataList.get(i+5).getText().toLowerCase()
	Icon_Image = dataList.get(i+6).getText().toLowerCase()

	if(nomor.contains(search_reseller)) {
		cekSearch = true
	}
	if(nama_paket.contains(search_reseller)) {
		cekSearch = true
	}
	if(durasi.contains(search_reseller)) {
		cekSearch = true
	}
	
	if(harga.contains(search_reseller)) {
		cekSearch = true
	}
	if( Max_Produk.contains(search_reseller)) {
		cekSearch = true
	}
	if(Icon_kode.contains(search_reseller)) {
		cekSearch = true
	}
	if(Icon_Image.contains(search_reseller)) {
		cekSearch = true
	}
	assert cekSearch == true
	 
}

