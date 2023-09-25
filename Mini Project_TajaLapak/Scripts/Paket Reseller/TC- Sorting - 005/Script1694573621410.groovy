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

WebUI.click(findTestObject('Paket Reseller/th_Harga'))

//Ambil semua element dari Harga
List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Paket Reseller/td_Harga'),10);

//Deklarasi dua array
String[] arrHargaOri = new String[dataList.size()]
String[] arrHargaSort = new String[dataList.size()]

//Isi Array yang Ori & Sort
for(int i = 0; i< dataList.size(); i++){
	text = dataList.get(i).text
	arrHargaOri[i] = text
	arrHargaSort[i] = text
}

//Sort Array
Arrays.sort(arrHargaSort)

//Arrays.sort(arrKendaraanSort,Collections.reverseOrder())


//verifikasi arrayOri == arraySort
assert arrHargaOri == arrHargaSort

