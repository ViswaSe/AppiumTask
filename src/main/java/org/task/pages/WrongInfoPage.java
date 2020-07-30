package org.task.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.task.base.ProjectSpecificMethods;

public class WrongInfoPage extends ProjectSpecificMethods {

	
	public WrongInfoPage clickAllCheckBoxes()
	{
		List<WebElement> allCheckBoxes = getAllWebElements("className", "android.widget.CheckBox");
		for(WebElement each:allCheckBoxes)
		{
			if(click(each))
				reportStep("Checkboxes clicked successfully","PASS");
			else
				reportStep("Couldn't click on all the check boxes","FAIL");
		}
		
		sleep(2000);
		return this;
	}
	
	public WrongInfoPage clickReportButton()
	{
		if(click("id","com.nobroker.app:id/btn_report"))
			reportStep("Clicked on the report button","PASS");
		else
			reportStep("Couldn't click on the report button","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public WrongInfoPage select3BHKValue()
	{
		if(click("xpath","//android.widget.TextView[@text='3 BHK']"))
			reportStep("Clicked on the 3BHK Value","PASS");
		else
			reportStep("Couldn't click on the 3BHK Value","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public WrongInfoPage select4PlusBHKValue()
	{
		if(click("xpath","//android.widget.TextView[@text='4+ BHK']"))
			reportStep("Clicked on the 4+BHK Value","PASS");
		else
			reportStep("Couldn't click on the 4+BHK Value","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public WrongInfoPage scrollDownTillNotes(String notes)
	{
		while(getNotesItem().size() == 0)
		{
			scrollFromDownToUpinAppUsingTouchActions();
		}
		if(getNotesItem().size()>0)
		{
			getNotesItem().get(0).sendKeys(notes);
			reportStep("Notes: "+notes+" entered successfully","PASS");
		}
		else
			reportStep("Couldn't enter the notes","FAIL");
		
		return this;
	}
	
	public WrongInfoPage clickSaveButton()
	{
		if(click("id","com.nobroker.app:id/btn_save"))
			reportStep("Clicked on the SAVE button","PASS");
		else
			reportStep("Couldn't click on the SAVE button","FAIL");
		
		sleep(2000);
		return this;
	}
	
	public WrongInfoPage getResultTextAndVerify(String message)
	{
		WebElement ele = getWebElement("xpath", "//android.widget.TextView[1]");
		if(getText(ele).equals(message))
			reportStep("Message Validated successfully-"+ele.getText(),"PASS");
		else
			reportStep("Couldn't Validate the message","FAIL");

		sleep(2000);
		return this;
	}
}
