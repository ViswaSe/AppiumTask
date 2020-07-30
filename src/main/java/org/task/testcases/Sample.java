package org.task.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hpsf.Thumbnail;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.task.base.MobileWrapper;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class Sample extends MobileWrapper{
	
	@Test
	public void dryRun() throws MalformedURLException, InterruptedException
	{
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("noReset", true);*/
		
		//dc.setCapability("app", "D:\\Appium\\NoBroker Flat Apartment House Rent Buy Sell_v6.8.204.apk");
	/*	
		dc.setCapability("appPackage", "");
		dc.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");*/
		
		launchApp("com.nobroker.app","com.nobroker.app.activities.NBSplashScreen","Android Emulator","emulator-5554","10.0");
		Thread.sleep(10000);
		
		driver.findElementById("com.nobroker.app:id/buyLayoutText").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.nobroker.app:id/searchEditHome").click();
		Thread.sleep(3000);
		
		driver.findElementById("android:id/text1").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Bangalore']").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.nobroker.app:id/localityAutoCompleteTxt").click();
		Thread.sleep(3000);
		
		WebElement eleSearchIcon=driver.findElementById("com.nobroker.app:id/localityAutoCompleteTxt");
		eleSearchIcon.click();
		eleSearchIcon.sendKeys("Marathahalli");
		driver.findElementById("com.nobroker.app:id/nearByLayout").click();
		
		eleSearchIcon.sendKeys("HSR Layout");
		driver.findElementById("com.nobroker.app:id/fl_multiple_locations").click();
		Thread.sleep(3000);
		
		boolean val=driver.findElementById("com.nobroker.app:id/nearByRadio").isSelected();
		if(!val)
			driver.findElementById("com.nobroker.app:id/nearByRadio").click();
		
		driver.findElementById("com.nobroker.app:id/bhktwo").click();
		driver.findElementById("com.nobroker.app:id/bhkthree").click();
		
		driver.findElementById("com.nobroker.app:id/searchProperty").click();
		Thread.sleep(10000);
		
		List<WebElement> thumbNailList = driver.findElementsById("com.nobroker.app:id/property_thumbnail");
		
		int n=1;
		
		while(n<=3)
		{
			scrollFromDownToUpinAppUsingTouchActions();
			System.out.println("scrolling:"+n);
			thumbNailList.addAll(driver.findElementsById("com.nobroker.app:id/property_thumbnail"));
/*			scrollFromUpToDowninAppUsingTouchActions();
			System.out.println("scrolling 2");*/
			n++;
			Thread.sleep(500);
		}
				
		thumbNailList.get(4).click();
		/*
		MobileElement listItem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"\"));"));*/
		
	/*	
		String value = "Wrong Info";
		
		((AndroidDriver<WebElement>) driver).findElementByAndroidUIAutomator(
	"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+value+"\").instance(0))").click();
		*/
		
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
			Thread.sleep(500);
			ele.get(0).click();
			Thread.sleep(3000);
		}
		
		
		List<WebElement> allCheckBox = driver.findElementsByClassName("android.widget.CheckBox");
		for(WebElement each:allCheckBox)
		{
			each.click();
		}
		
		driver.findElementById("com.nobroker.app:id/btn_report").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//android.widget.TextView[@text='3 BHK']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//android.widget.TextView[@text='4+ BHK']").click();
		Thread.sleep(2000);
		
		
		
		while(getItem().size() == 0)
		{
			scrollFromDownToUpinAppUsingTouchActions();
		}
		
		if(getItem().size()>0)
		{
			getItem().get(0).sendKeys("Thank you for reporting");
		}
		
		driver.findElementById("com.nobroker.app:id/btn_save").click();
		Thread.sleep(5000);
		
		String result = driver.findElementByXPath("//android.widget.TextView[1]").getText();
		System.out.println(result);
	}
	
	
	
	public List<WebElement> getItemView()
	{
		return driver.findElementsByXPath("//android.widget.TextView[@text='Wrong Info']");
	}
	
	public List<WebElement> getItem()
	{
		return driver.findElementsById("com.nobroker.app:id/edt_others");
	}
	

}
