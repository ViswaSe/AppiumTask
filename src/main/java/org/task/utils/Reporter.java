package org.task.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {

	public ExtentHtmlReporter html;
	public ExtentReports extent;
	public static ExtentTest suiteTest,test;
	
	public String testCaseName,testCaseDescription,testNodeName,author,category;
	
	public void beforeResult()
	{
		html = new ExtentHtmlReporter("./reports/result.html");
		html.config().setChartVisibilityOnOpen(true);
		html.config().setDocumentTitle("Appium Framework");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	public void startTest()
	{
		suiteTest = extent.createTest(testCaseName,testCaseDescription);
	}
	
	public ExtentTest createNode()
	{
		test = suiteTest.createNode(testNodeName);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}
	
	abstract public long takeScreenshot();
	
	public void reportStep(String desc,String status)
	{
		
		MediaEntityModelProvider img = null;
		
		if(status.equalsIgnoreCase("PASS") || status.equalsIgnoreCase("FAIL"))
		{
			long snapNumber = 1000000L; 
			snapNumber = takeScreenshot();
			try 
			{
				img = MediaEntityBuilder.createScreenCaptureFromPath("./../screenshots/"+snapNumber+".png").build();
			} 
			catch (IOException e) {
				System.out.println("Issue in taking the snapshot from the given path");
				e.printStackTrace();
			}
			
			if(status.equalsIgnoreCase("PASS"))
				test.pass(desc,img);
			else if(status.equalsIgnoreCase("FAIL"))
				test.fail(desc,img);
		}
		
		else if(status.equalsIgnoreCase("INFO"))
			test.info(desc);
		
		else
			test.error(desc);
		
	}
	
	public void endResult()
	{
		extent.flush();
	}
}
