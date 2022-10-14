package com.AgileCrmAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.AgileCrmAutomation.BaseClass;

public class LoginPage extends BaseClass
{
	private By emailTextFieldLoginPage = By.name("email");
	private By passwordTextFieldLoginPage = By.name("password");
	private By signInButton = By.xpath("//input[@type='submit']");
	private By accountFavIcon = By.xpath("//li[@id='fat-menu']");
	private By ogoutButton = By.xpath("//a[contains(@class,'logout-in')]");
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	public void login(String username, String password)
	{
		WebElement uname = driver.findElement(emailTextFieldLoginPage);
		uname.clear();
		uname.sendKeys(username);
		WebElement pwd = driver.findElement(passwordTextFieldLoginPage);
		pwd.clear();
		pwd.sendKeys(password);
		click(signInButton, "Click on Sign In Button!!!");		
		String dashboardName = driver.findElement(By.xpath("//h1[@id='dashboard-name']")).getText();
		Assert.assertTrue((!dashboardName.isEmpty()), "Logged in successfully!!!");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void logout() 
	{
		click(accountFavIcon, "Click on the Account Icon!!!");
		click(ogoutButton, "Click on Logout Button!!!");
		String forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Password')]")).getText();
		Assert.assertTrue((!forgotPassword.isEmpty()), "Logged out successfully!!!");
		driver.close();
	}
}