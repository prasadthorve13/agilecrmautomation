package com.AgileCrmAutomation.pages;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.BaseClass;

public class DashboardPage extends BaseClass
{
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
	@FindBy(id="calendarmenu")
	private By calenderMenu;
	
	@FindBy(xpath="//div[@id='calendar_event']/div//tbody/tr")
	private List<WebElement> totalWeeks;
	
	@FindBy(id="title")
	private WebElement eventName;
	
	@FindBy(id="color")
	private WebElement priority;
	
	@FindBy(id="status")
	private WebElement status;

	@FindBy(id="event-owners-list")
	private WebElement owner;

	@FindBy(id="event-time-1")
	private WebElement startTime;
	
	@FindBy(id="event-time-2")
	private WebElement endTime;

	@FindBy(id="46d6db")
	private WebElement eventColor;

	
	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------	
	public void createEvent(String eventName, String priority, String status, String owner, String startTime, String endTime  )
	{
		click(calenderMenu, "Click on calender Menu!!!");
		int totalRows = totalWeeks.size();
		for(int i=1 ; i <= totalRows ; i++)
		{
			for(int j = 1 ; j <= 7 ; j++)
			{
				String dayXPath = "//div[@id='calendar_event']/div//tbody/tr["+i+"]/td["+j+"]";
				WebElement weekDay = driver.findElement(By.xpath(dayXPath));
				if(!weekDay.getAttribute("class").contains("fc-other-month"))
				{
					WebElement weekDays = driver.findElement(By.xpath(dayXPath+"/div/div[1]"));
					String day = weekDays.getText();
					String currentDay = String.valueOf(LocalDateTime.now().getDayOfMonth());
					if(day.equals(currentDay))
					{
						click((By) weekDays, "Click on the today's date!!!");
						break;
					}
				}
			}
		}
		this.eventName.sendKeys(eventName);
		selectDropDownByVisibleText(this.priority, priority);
		selectDropDownByVisibleText(this.status, status);
		selectDropDownByVisibleText(this.owner, owner);
		this.startTime.sendKeys(startTime);
		this.endTime.sendKeys(endTime);
		eventColor.click();
		
	}
}








