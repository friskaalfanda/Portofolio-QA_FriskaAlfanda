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

WebUI.callTestCase(findTestCase('Keterangan Kurir Internal/TC-Keterangan Kurir Internal-Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sort Data Keterangan Driver/th_Keterangan'))

//Ambil semua element dari Keterangan
List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Sort Data Keterangan Driver/td_Keterangan'),10);

//Deklarasi dua array
String[] arrKeteranganOri = new String[dataList.size()]
String[] arrKeteranganSort = new String[dataList.size()]

//Isi Array yang Ori & Sort
for(int i = 0; i< dataList.size(); i++){
	text = dataList.get(i).text
	arrKeteranganOri[i] = text
	arrKeteranganSort[i] = text
}

//Sort Array
Arrays.sort(arrKeteranganSort)


//verifikasi arrayOri == arraySort
assert arrKeteranganOri == arrKeteranganSort

