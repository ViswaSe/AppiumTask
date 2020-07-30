package org.task.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.task.base.ProjectSpecificMethods;

public class HomeDetailsPage extends ProjectSpecificMethods{
	
	boolean val;
	
	public WrongInfoPage clickWrongInfo()
	{
		
		int size = 0;
		List<WebElement> ele = null;
		do
		{
			scrollFromDownToUpinAppUsingTouchActions();
			ele = getItemView();
			size =ele.size();
		}while(size==0);
		
		if(size>0)
		{
			sleep(500);
			val = click(ele.get(0));
		}
		
		if(val)
			reportStep("Wrong Info button clicked successfully","PASS");
		else
			reportStep("Couldn't able to click on the Wrong Info button","FAIL");
		
		sleep(5000);
		return new WrongInfoPage();
	}

}
