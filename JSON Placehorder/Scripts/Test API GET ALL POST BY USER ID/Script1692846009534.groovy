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

response = WS.sendRequest(findTestObject('Object Repository/GET ALL POST BY USER ID',
	["varUserId" : userId]))


//hitung user id
jumUserId = WS.getElementsCount(response, "")

//verifikasi user id nya sesuai
for (int i = 0 ; i < jumUserId; i++) {

WS.verifyElementPropertyValue(response, "["+ i +"].userId", userId)

//verifikasi data tidak boleh null atau kosong
userId = WS.getElementPropertyValue(response,"["+ i +"].userId")
title = WS.getElementPropertyValue(response,"["+ i +"].title")
body = WS.getElementPropertyValue(response,"["+ i +"].body")

assert userId != null && userId !="";
assert title != null && title !="";
assert body != null && body!="";
}







