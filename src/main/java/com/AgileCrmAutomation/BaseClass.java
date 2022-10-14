package com.AgileCrmAutomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AgileCrmAutomation.pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Select select;
	public static Actions action;
	public ExtentTest logger;
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	public By searchIconButton = By.xpath("//div[contains(@class,'searchicon')]/button");
	private By searchFeatureAllLabel = By.xpath("//input[@name='all']/following-sibling::i");
	private By searchFeatureContactsLabel = By.xpath("//input[@name='person']/following-sibling::i");
	private By searchFeatureCompanyLabel = By.xpath("By.xpath(\"//input[@name='company']/following-sibling::i\")");
	private By searchFeatureSearchIcon = By.id("search-results");
	private By searchFeatureSearchTextField = By.id("searchText");
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static void launchBrowser(String browser)
	{
		switch(browser)
		{
			case "chrome" :
				System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\Softwares\\Courses\\JAVA\\Browser Drivers\\chromedriver.exe");
//				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(setChromeCapabilities());
				break;
			case "mozilla" :
				System.setProperty("webdriver.gecko.driver", "F:\\Downloads\\Softwares\\Courses\\JAVA\\Browser Drivers\\geckodriver64bit.exe");
//				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(setFirefoxCapabilities());
				break;
			case "edge" :
				System.setProperty("webdriver.edge.driver", "F:\\Downloads\\Softwares\\Courses\\JAVA\\Browser Drivers\\msedgedriver.exe");
//				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(setEdgeCapabilities());
				break;
			default:
				System.setProperty("webdriver.edge.driver", "F:\\Downloads\\Softwares\\Courses\\JAVA\\Browser Drivers\\msedgedriver.exe");
//				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Chrome capabilities method
	public static ChromeOptions setChromeCapabilities()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("download.default_directory", "F:\\Downloads");
		option.setExperimentalOption("prefs", map);
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("disable-popup-blocking");
//		option.setExperimentalOption("excludeSwitches", list);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));//Alternative to above 3 lines	
		return option;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	FireFox capabilities method	
	public static FirefoxOptions setFirefoxCapabilities()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("start-maximized");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("download.default_directory", "F:\\Downloads");
		option.setCapability("prefs", map);
		
		option.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	public static EdgeOptions setEdgeCapabilities()
	{
		EdgeOptions option = new EdgeOptions();
		option.addArguments("start-maximized");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("download.default_directory", "F:\\Downloads");
		option.setCapability("prefs", map);
		
		option.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	using this click() by adding wait to avoid creating multiple waits before click operation needs to be performed
	public static void click(By by, String msg)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		System.out.println(msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Mouse ClickAction() in case if there is a need to perfrom click operation 
	public static void clickAction(WebElement element, String msg)
	{
		action = new Actions(driver);
		action.click(element).build().perform();
		System.out.println("Mouse Click Action on "+msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//	Mouse ClickAction() in case if there is a need to perfrom click operation	
	public static void clickAction(By by, String msg)
	{
		action = new Actions(driver);
		action.click(driver.findElement(by)).build().perform();
		System.out.println("Mouse Click Action on "+msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Keyboard sendKeysAction() to sendKeys alteranative to normal sendKeys() method
	public static void sendKeysAction(WebElement element, String value)
	{
		action = new Actions(driver);
		action.sendKeys(element, value).build().perform();
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//	Explicit Wait - this method waits for an element to be visible
	public static void waitForVisibilityOfElement(WebElement element, String msg)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(msg);
	}	
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//	moveToElementAndLeftClick will perform left mouse click operation as if it were to be done manually	
	public static void moveToElementAndLeftClick(WebElement element, String msg)
	{
		action = new Actions(driver);
		action.moveToElement(element).pause(Duration.ofSeconds(1)).click().build().perform();
		System.out.println(msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static void moveToElementAndRightClick(WebElement element, String msg)
	{
		action = new Actions(driver);
		action.contextClick(element).build().perform();
		System.out.println(msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	moveToElementAndSendData is an alternative to the traditional sendKeys()
	public static void moveToElementAndSendData(WebElement element, String text, String msg)
	{
		action = new Actions(driver);
		action.moveToElement(element).pause(Duration.ofSeconds(1)).sendKeys(text).build().perform();
		System.out.println(msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	moveToElementAndSendKeyBoardOpr will perform keyboard based operations
	public static void moveToElementAndSendKeyBoardOpr(WebElement element, String keyboardOpr, String msg)
	{
		action = new Actions(driver);
		action.moveToElement(element).pause(Duration.ofSeconds(1)).sendKeys(keyboardOpr).build().perform();
		System.out.println(msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Explicit Wait - this method waits for an element to be ClickAble
	public static void elementsToBeClickable(By by, String msg)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		System.out.println(msg);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//	Explicit Wait -  this method waits for an element to be visible on webpage
	public static void elementToBePresent(By element)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//	Explicit Wait - this method waits for an element to be ClickAble
	public static void elementsToBeClickable(WebElement element, String msg)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println(msg);
	}	
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Fluent Wait
	public static void fluentWait(final By by, String msg)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class);
		wait.until(new Function<WebDriver, WebElement>()
						{ 
							public WebElement apply(WebDriver driver)
								{
										System.out.println("Waiting for Element to be available.....");
										return driver.findElement(by);
								}
						}
				  );
		System.out.println(msg);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Selecting option from DropDown based on index position
	public static void selectDropDownByIndex(WebElement element, int index)
	{
		select = new Select(element);
		select.selectByIndex(index);
		System.out.println("Respective option is selected from the dropdown!");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
//	Selecting option from DropDown based on value attribute of option tag
	public static void selectDropDownByValue(WebElement element, String value)
	{
		select = new Select(element);
		select.selectByValue(value);
		System.out.println(value+" is selected from the dropdown!");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Selecting option from DropDown based on visible text of the DropDown
	public static void selectDropDownByVisibleText(WebElement element, String text)
	{
		select = new Select(element);
		select.selectByVisibleText(text);
		System.out.println(text+" is selected from the dropdown!");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	Common Search Method for all pages
	public void searchEntity(String whatToSearch, String searchText)
	{
//		waitForVisibilityOfElement(driver.findElement(searchIconButton), "Waiting for search icon to be viewable...");
		fluentWait(searchIconButton, "Waiting for search icon to be clickable...");
		click(searchIconButton, "Click operation on Search Icon!!!");
//		elementsToBeClickable((WebElement) By.id("searchText"), "Waiting for searchText to be clickable");
		click(searchFeatureAllLabel, "Click on All to uncheck all options!!!");
		switch(whatToSearch)
		{
			case "Company":	
				click(searchFeatureCompanyLabel, "Click on Contact Label to check the checkbox!!!");
				driver.findElement(By.id("searchText")).sendKeys(searchText);
				driver.findElement(By.id("search-results")).click();
				break;
			case "Contact":
				click(searchFeatureContactsLabel, "Click on Contact Label to check the checkbox!!!");
				driver.findElement(searchFeatureSearchTextField).sendKeys(searchText);
				click(searchFeatureSearchIcon, "Click on Search icon to Search!!!");
				break;
			default :
				System.out.println("Invalid Search Entity!!!");
		}
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
}