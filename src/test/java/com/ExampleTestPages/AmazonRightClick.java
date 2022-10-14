package com.ExampleTestPages;

import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.awtui.Logo;

public class AmazonRightClick extends BaseClass
{
	@Test(groups={"regression", "sanity"})
	@Parameters("browser")
	public void multiWindowProductName(String browser) throws AWTException, InterruptedException 
	{
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in");
//		driver.manage().window().maximize();
		Actions action = new Actions(driver);
//		fluentWait(By.xpath("//div[@id='gw-desktop-herotator']//img[@alt='Great Indian Festival']"), "Waiting for GIF header image to load..." );
//		elementToBePresent(By.xpath("//div[@id='gw-desktop-herotator']//img[@alt='Great Indian Festival']"));
		WebElement grtINDFestival = driver.findElement(By.id("desktop-banner"));
//		int bannerWidth = grtINDFestival.getSize().getWidth();
//		System.out.println("Width is - "+bannerWidth);
//		int bannerHeight = grtINDFestival.getSize().getHeight();
//		System.out.println("Height is - "+bannerHeight);
//		action.moveToElement(grtINDFestival, 120, 180).contextClick().build().perform();
		click(By.xpath("//div[@id='gw-desktop-herotator']//i[contains(@class,'previous')]"), "Go to previous header image!!!");
		action.contextClick(grtINDFestival).build().perform();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2);
		
		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent Tab WindowID is :- "+parentWindowId);
		Set<String> allWindowIds = driver.getWindowHandles();
		for( String windowId: allWindowIds)
		{
			if(!windowId.equals(allWindowIds))
			{
				System.out.println("Current Window ID is -"+windowId);
				driver.switchTo().window(windowId);
				String childTabTitle = driver.getTitle();
				System.out.println("Window switched to - "+childTabTitle);
			}
		}

		List<WebElement> productList = driver.findElements(By.xpath("//div[contains(@class,'DealGridItem')]"));
		for( WebElement products : productList)
		{
			String productNames = products.getText();
			System.out.println(productNames);
		}
	}
}