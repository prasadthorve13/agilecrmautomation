package com.AgileCrmAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.pages.CompanyPage;
import com.AgileCrmAutomation.pages.ContactsPage;
import com.AgileCrmAutomation.pages.DealsPage;
import com.AgileCrmAutomation.pages.LoginPage;

public class MainAgileCrmTestScript extends BaseClass 
{
	LoginPage loginpage = new LoginPage();
	PropertyHandlingClass prophandling = new PropertyHandlingClass();
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	@BeforeClass
	public void launchBrowser()
	{
		String browser = prophandling.getValues("browser");
		String url = prophandling.getValues("agilecrm");
		launchBrowser(browser);
		driver.navigate().to(url); 	//Either get() or navigate() can be used to open a specific URL
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void mainScript() throws Exception 
	{
		String username = prophandling.getValues("username");
		String password = prophandling.getValues("password");
		loginpage.login(username,password);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	@AfterClass
	public void quit()
	{
		loginpage.logout();	//Logout & Close driver/browser			
	}
}