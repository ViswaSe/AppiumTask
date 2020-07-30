package org.task.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.task.base.ProjectSpecificMethods;

public class HomeListPage extends ProjectSpecificMethods{
	
	public HomeDetailsPage clickHouseBasedOnGivenNumber(int houseNumber)
	{
		List<WebElement> allHouses = getAllWebElements("id","com.nobroker.app:id/property_thumbnail");	
		int n=1;
		while(n<=(houseNumber-1))
		{
			scrollFromDownToUpinAppUsingTouchActions();
			allHouses.addAll(getAllWebElements("id","com.nobroker.app:id/property_thumbnail"));n++;sleep(500);
		}	
		WebElement eleRespectiveHouse = allHouses.get(houseNumber);
		if(click(eleRespectiveHouse))
			reportStep("House selected successfully from the list","PASS");
		else
			reportStep("Couldn't select the house from the given list","FAIL");
		sleep(7000);
		return new HomeDetailsPage();
		
	}
	
	

}
