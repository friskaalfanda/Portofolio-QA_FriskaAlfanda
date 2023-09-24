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

WebUI.callTestCase(findTestCase('Login/Test Case 1.1 (Script)'), [('username') : username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Make Appointment/Select Drop Down Facility                          Hongkong CURA Healthcare Center                            Seoul CURA Healthcare Center'), 
    facility, false)

if (hospital_readmission.toString().equalsIgnoreCase('yes')) {
    System.out.print('Friska')

    WebUI.check(findTestObject('Object Repository/Make Appointment/Checkbox Hospital Readmission'))
}

if (healthcare_program.toString().equalsIgnoreCase('medicare')) {
    WebUI.check(findTestObject('Object Repository/Make Appointment/input_Medicare'))
} else if (healthcare_program.toString().equalsIgnoreCase('medicaid')) {
    WebUI.check(findTestObject('Object Repository/Make Appointment/input_Medicaid'))
} else {
    WebUI.check(findTestObject('Object Repository/Make Appointment/input_None'))
}

WebUI.setText(findTestObject('Make Appointment/input_Visit Date'), '24/08/2023')

WebUI.setText(findTestObject('Make Appointment/Comment'), 'ulangi lagi')

WebUI.click(findTestObject('Make Appointment/button_Appointment'))

WebUI.verifyElementPresent(findTestObject('Make Appointment/Title_Appointment Confirmation'), 0)

hasil_facility = WebUI.getText(findTestObject('Object Repository/Make Appointment/hasil_facility'))

hasil_readmission = WebUI.getText(findTestObject('Make Appointment/Hasil_readmission'))

hasil_healthcare = WebUI.getText(findTestObject('Make Appointment/Hasil_Healthcare'))

hasil_visitdate = WebUI.getText(findTestObject('Make Appointment/Hasil_VisitDate'))

hasil_comment = WebUI.getText(findTestObject('Make Appointment/Hasil_comment'))

assert hasil_facility.toString().equalsIgnoreCase(facility)

assert hasil_readmission.toString().equalsIgnoreCase(hospital_readmission)

assert hasil_healthcare.toString().equalsIgnoreCase(healthcare_program)

assert hasil_visitdate.toString().equalsIgnoreCase(visit_date)

assert hasil_comment.toString().equalsIgnoreCase(comment)

