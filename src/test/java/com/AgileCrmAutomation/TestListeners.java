package com.AgileCrmAutomation;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListeners extends BaseClass implements ITestListener, ISuiteListener
{
	public ExtentReports extentReport;
	String reportPath;
	LocalDateTime dateTime = LocalDateTime.now();//now() returns date & time in long format
	//this will format the d&t from now() in the form of dd_MM_yyyy_hh_mm
	String timeStamp = dateTime.format(DateTimeFormatter.ofPattern("EEE_dd_MM_yyyy_hh_mm_a"));
	public void onStart(ISuite suite)	//It will only execute onStart of Suite in TestNG.xml
	{
		System.out.println("This is onStart Method of Suite"); 
		String folderName = "Report_"+timeStamp;
		System.out.println(folderName);
		
		reportPath = System.getProperty("user.dir")+"//ExecutionResult//"+folderName;
		//We need to get control of the folderName
		File file = new File(reportPath);
		//We need to check if folderName exists or not
		if(!file.exists())
		{
			file.mkdir();//this will create the Report_dd_MM_yyyy_hh_mm named folder in the ExecutionResult folder
		}
		setExtentReportDetails();//this is called here as we first need to create folder so it can be used in this method
	}
	
	public void onFinish(ISuite suite)	//It will only execute onFinish of Suite in TestNG.xml
	{
		System.out.println("This is onFinish Method of Suite");
		driver.quit();
		extentReport.flush();
	}
	
	public void onStart(ITestContext context)	//It will only execute onStart of Test in TestNG.xml
	{
		System.out.println("This is onStart Method of Test");
	}
	
	public void onFinish(ITestContext context)	//It will only execute onFinish of Suite in TestNG.xml
	{
		System.out.println("This is onFinish Method of Test");
	}
	
	public void onTestStart(ITestResult result) //It will only execute before start of Test
	{
		System.out.println("This is onTestStart Method of Test");
		String methodName = result.getName();
		logger = extentReport.createTest(methodName);
	}
	
	public void onTestSuccess(ITestResult result)	//It will only execute after successfully execution of Test 
	{
		System.out.println("This is onTestSuccess Method of Test");
		//Add this info into the html extent report using logger
		logger.pass("Successfully executed the test "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)	//It will only execute after a test fails to execute 
	{
		System.out.println("This is onTestFailure Method of Test");
		//Downcast driver to behave as TakeScreenshot and getScreenShotAs will capture screenshot in FILE format
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String outputPath = reportPath+"//Screenshots "+timeStamp+".png";
		File outputFile = new File(outputPath);
		
		try
		{
			FileUtils.copyFile(screenshotFile, outputFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.fail("Test execution failed due to : "+result.getThrowable());
		logger.addScreenCaptureFromPath(outputPath);
	}
	
	public void onTestSkipped(ITestResult result)	//It will execute when a test is relying on another the there other test fails which results in this test to be skipped 
	{
		System.out.println("This is onTestSkipped Method of Test");
		logger.skip("This test was skipped due to : "+result.getSkipCausedBy());
	}
	
	public void onTestFailedWithTimeout(ITestResult result)	//It will execute when a test fails because of timeout 
	{
		System.out.println("This is onTestFailedWithTimeout Method of Test");
		onTestFailure(result);
	}
	
	private void setExtentReportDetails()
	{
//		Set the path and html filename
		String htmlReportPath = reportPath+"//AutomationReport.html";
//		Get the control of the html file
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(htmlReportPath);
		sparkReport.config().setDocumentTitle("AgileCrmAutomationReport");
		sparkReport.config().setReportName("Automation Report");
//		Set the configurations of the html file
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReport);
//		Add the below data to the html report		
		extentReport.setSystemInfo("username", "cybersuccess");
		extentReport.setSystemInfo("environment", "test");
		extentReport.setSystemInfo("browser", "edge");

	}
	
}