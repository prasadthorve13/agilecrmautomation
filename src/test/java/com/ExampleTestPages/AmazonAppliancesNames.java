package com.ExampleTestPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonAppliancesNames extends BaseClass
{
	@Test(groups="sanity")
	@Parameters("browser")
	public void printLaptopNames(String browser) 
	{
		launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		selectDropDownByVisibleText(driver.findElement(By.id("searchDropdownBox")), "Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
//		click(By.id("nav-search-submit-button"), "Click on Search Icon!!!");
		
		List<WebElement> laptopName = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> laptopPrice = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']/span/span[@class='a-price-whole']"));
		for(int i=0; i<laptopName.size() ; i++)
		{
			String lapPrice = laptopPrice.get(i).getText();
			lapPrice = lapPrice.replace(",", "");
			int price = Integer.parseInt(lapPrice);
			if(price>30000)
			{
				System.out.println("₹"+lapPrice+ " - " +laptopName.get(i).getText());
			}
		}
	
	}
	
//	launchBrowser("edge");
//	driver.navigate().to("https://www.amazon.in");
//	selectDropDownByVisibleText(driver.findElement(By.id("searchDropdownBox")), "Appliances");
//	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
//	click(By.id("nav-search-submit-button"), "Click on Search Icon!!!");
//	List<WebElement> aname = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
//	List<WebElement> aprice = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']/span/span[@class='a-price-whole']"));
}