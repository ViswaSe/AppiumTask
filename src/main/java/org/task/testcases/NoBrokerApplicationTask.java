package org.task.testcases;

import org.task.base.ProjectSpecificMethods;
import org.task.pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoBrokerApplicationTask extends ProjectSpecificMethods {
	
	@BeforeTest
	public void provideData()
	{
		appPackage	 	= "com.nobroker.app";
		appActivity 	= "com.nobroker.app.activities.NBSplashScreen";
		deviceName		= "Android Emulator";
		udid			= "emulator-5554";
		platformVersion	= "10.0";
		testCaseName	= "No Broker Mobile validations";
		testCaseDescription = "Verifying and reporting the flats in NoBroker apartments";
		testNodeName	= "TC001_NoBrokerValidations";
		author			= "Vishveshwar";
		category		= "SIT";
		filename		= "TC001";
	}
	
	@Test(dataProvider = "fetchData")
	public void noBrokerValidations(String loc,String loc1,String houseno,String notes,String message)
	{
		new HomePage()
		.clickOnBuy()
		.clickOnSearchButton()
		.selectCountryFromDropdown()
		.clickSearchLocality()
		.enterLocality(loc)
		.clickFirstLocalityPopUp()
		.clickSearchLocality()
		.enterLocality(loc1)
		.clickSecondLocalityPopup()
		.clickIncludeNearByPropertiesRadioButton()
		.click2BHKValue()
		.click3BHKValue()
		.clickSearchButton()
		.clickHouseBasedOnGivenNumber(Integer.parseInt(houseno))
		.clickWrongInfo()
		.clickAllCheckBoxes()
		.clickReportButton()
		.select3BHKValue()
		.select4PlusBHKValue()
		.scrollDownTillNotes(notes)
		.clickSaveButton()
		.getResultTextAndVerify(message);
		
	}

}
