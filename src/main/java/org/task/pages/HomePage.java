package org.task.pages;

import org.openqa.selenium.WebElement;
import org.task.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage clickOnBuy()
	{
		if(click("id", "com.nobroker.app:id/buyLayoutText"))
			reportStep("Buy property button clicked successfully","PASS");
		else
			reportStep("Couldn't click on the Buy property button","FAIL");

		sleep(2000);
		return this;
	}
	
	public HomePage clickOnSearchButton()
	{
		if(click("id", "com.nobroker.app:id/searchEditHome"))
			reportStep("Search Button clicked successfully","PASS");
		else
			reportStep("Couldn't click on the search button","FAIL");
		
		sleep(2000);
		return this;
		
	}
	
	public HomePage selectCountryFromDropdown()
	{
			click("id", "android:id/text1");
			sleep(1000);
			String value = "//android.widget.CheckedTextView[@text='Bangalore']";
			
			if(click("xpath", value));
				reportStep("Bangalore drop down value selected successfully","PASS");
			
		sleep(2000);
		return this;
	}
	
	public HomePage clickSearchLocality()
	{
		if(click("id", "com.nobroker.app:id/localityAutoCompleteTxt"))
			reportStep("Clicked on the Search Locality","PASS");
		else
			reportStep("Couldn't clicked on the Search Locality","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public HomePage enterLocality(String locValue)
	{
		if(enterValue(locValue, "id", "com.nobroker.app:id/localityAutoCompleteTxt"))
			reportStep("Locality Name: "+locValue+" entered successfully","PASS");
		else
			reportStep("Couldn't enter the locality name:"+locValue,"FAIL");
		
		return this;
	}
	
	public HomePage clickFirstLocalityPopUp()
	{
		if(click("id", "com.nobroker.app:id/nearByLayout"))
			reportStep("Marathahalli Value selected successfully","PASS");
		else
			reportStep("Couldn't click on the Marathahalli Popup Value","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public HomePage clickSecondLocalityPopup()
	{
		if(click("id", "com.nobroker.app:id/fl_multiple_locations"))
			reportStep("HSR Layout Value selected successfully","PASS");
		else
			reportStep("Couldn't click on the HSR Layout Popup Value","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public HomePage clickIncludeNearByPropertiesRadioButton()
	{
		WebElement radioButton=getWebElement("id","com.nobroker.app:id/nearByRadio");
		if(!(radioButton.isSelected()))
			if(click("id", "com.nobroker.app:id/nearByRadio"))
				reportStep("Clicked on the Include Near By Properties radio button on the page","PASS");
		else
			reportStep("Couldn't click on the Include Near By Properties radio button","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public HomePage click2BHKValue()
	{
		if(click("id","com.nobroker.app:id/bhktwo"))
			reportStep("Clicked on the 2BHK Value","PASS");
		else
			reportStep("Couldn't click on the 2BHK Value","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public HomePage click3BHKValue()
	{
		if(click("id", "com.nobroker.app:id/bhkthree"))
			reportStep("Clicked on the 3BHK Value","PASS");
		else
			reportStep("Couldn't click on the 3BHK Value","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public HomeListPage clickSearchButton()
	{
		if(click("id","com.nobroker.app:id/searchProperty"))
			reportStep("Search button clicked successfully","PASS");
		else
			reportStep("Couldn't click on the search button","FAIL");
		
		sleep(7000);
		return new HomeListPage();
	}
	
		
}
