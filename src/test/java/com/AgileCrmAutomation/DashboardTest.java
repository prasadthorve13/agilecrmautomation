package com.AgileCrmAutomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.pages.DashboardPage;
import com.AgileCrmAutomation.pages.LoginPage;

public class DashboardTest extends BaseClass
{
	DashboardPage dashboard = new DashboardPage();
	@BeforeClass
	public void launchBrowser()
	{
		launchBrowser("edge");
		driver.navigate().to(url);
		LoginPage loginpage = new LoginPage();
		loginpage.login(username,password);		
	}
	
  @Test
  public void verifyEvent() 
  {
	  dashboard.createEvent();
  }
}