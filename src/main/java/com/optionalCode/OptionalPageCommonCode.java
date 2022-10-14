package com.optionalCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.AgileCrmAutomation.BaseClass;

public class OptionalPageCommonCode extends BaseClass
{
	public static void printDropDownOptions(By by, String msg)
	{
		fluentWait(by, msg);		//Email Select DropDown
		Select selectOption = new Select(driver.findElement(by));
		List<WebElement> optionWebElement = selectOption.getOptions();
		System.out.println("Drop Down options are :-");
		for (WebElement optionElement : optionWebElement) 
		{
			String optionText = optionElement.getAttribute("value");
			System.out.print(" ," + optionText);
		}
		if(selectOption.isMultiple()) 
		{
			System.out.println("\n This is a Multi-Select Drop Down");
		}
		else
		{
			System.out.println("\n This is NOT a Multi-Select Drop Down");
		}
	}
	
//	Code for printing all the options in Country DropDown
//	Select selectCountry = new Select(driver.findElement(By.id("country")));
//	List<WebElement> countryDropDownList = selectCountry.getOptions();
//	System.out.println();
//	System.out.println("Country Drop Down Options are :-");
//	for (WebElement countryElement : countryDropDownList) 
//	{
//		String countryText = countryElement.getAttribute("value");
//		System.out.print(" ," + countryText);
//	}
}
