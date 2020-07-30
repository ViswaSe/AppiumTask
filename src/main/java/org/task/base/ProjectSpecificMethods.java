package org.task.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import org.task.utils.DataInputProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class ProjectSpecificMethods extends MobileWrapper {
	
	public static String appPackage,appActivity,deviceName,udid,platformVersion,filename;
	
	public static Properties prop; 
	public BufferedReader reader;

	@BeforeSuite
	public void beforeSuiteRun()
	{
		beforeResult();
	}
	
	@BeforeClass
	public void beforeClassRun()
	{
		startTest();
	}
	
	@BeforeMethod
	public void beforeMethodRun()
	{
		createNode();
		launchApp(appPackage,appActivity,deviceName,udid,platformVersion);
	}
	
	@AfterMethod
	public void afterMethodRun()
	{
		closeApp();
	}
	
	@AfterSuite
	public void afterSuiteRun()
	{
		endResult();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] readValue()
	{
		return new DataInputProvider().readValuesFromExcel(filename);
	}
	
}
