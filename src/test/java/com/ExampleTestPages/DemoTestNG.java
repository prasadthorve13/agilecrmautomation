package com.ExampleTestPages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class DemoTestNG extends BaseClass 
{
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) 
	{
		System.out.println("This is before test method...");
		launchBrowser(browser);
		driver.get("https://www.google.co.in");
	}

	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("This is before class method...");
	}

	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("This is before method...");
	}

	@Test
	public void test1() 
	{
		System.out.println("This is test1 method!!!");
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is test2 method!!!");
		System.out.println("Displayed Webpage is - "+driver.getTitle());
		Assert.fail("test2 failed!!!");
	}
	
	@Test(dependsOnMethods = "test2")
	public void test3()
	{
		System.out.println("This is test3 method!!!");
	}

	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("This is after method...");
	}

	@AfterClass
	public void afterClass() 
	{
		System.out.println("This is after class method...");
	}

	@AfterTest
	public void afterTest() 
	{
		System.out.println("This is after test method...");
		driver.quit();
	}

}