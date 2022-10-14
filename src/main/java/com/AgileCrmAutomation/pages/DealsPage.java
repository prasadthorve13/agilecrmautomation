package com.AgileCrmAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.BaseClass;

public class DealsPage extends BaseClass
{
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	private By dealsMenuOption = By.id("dealsmenu");
	private By addDealButton = By.xpath("//button[contains(text(),'Add Deal')]");
	private By addDealSaveButton = By.xpath("//div[@id='deals-new-footer']//a[@id='opportunity_validate']");
	private By sortByButton = By.xpath("//span[contains(text(), 'Sort By')]");
	private By sortByDropDownList = By.id("contact-view-sort-model-list");
	private By dealsViewButton = By.id("deals-view");	
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	@FindBy(xpath="//form[@id='opportunityForm']//input[@id='name']")
	private By dealName;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::select[@id='owners-list']")
	private By dealOwnerName;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::input[@name='currency_conversion_value']")
	private By dealValue;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::input[@id='probability']")
	private By dealProbability;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::select[@id='pipeline_milestone']")
	private By dealMilestone;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::input[@id='close_date']")
	private By dealCloseDate;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::select[@id='deal_source']")
	private By dealSource;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::input[@id='relates_to']")
	private By dealContactName;
	
	@FindBy(xpath="//form[@id='opportunityForm']/descendant::input[@id='tags-new-person']")
	private By dealTags;	
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void addDeal(String dealName, String ownerName, String dealValue, String probablitiy, String milestone, String closeDate, String dealSource, String dealType, String contactName, String tags)
	{
		clickAction(driver.findElement(dealsMenuOption),"Click on Deal Menu!!!");
		clickAction(driver.findElement(addDealButton), "Click on Add Deal button!!!");
		elementsToBeClickable(this.dealName, "Waiting for Deal Name to be Clickable...");
		driver.findElement(this.dealName).sendKeys(dealName);										//Deal Name
		selectDropDownByVisibleText(driver.findElement(dealOwnerName), ownerName);					//Owner Name
		sendKeysAction(driver.findElement(this.dealValue), dealValue);								//Deal Value
		driver.findElement(dealProbability).clear();												//Clear existing Probability value
		sendKeysAction(driver.findElement(dealProbability), probablitiy);							//Probability
		selectDropDownByVisibleText(driver.findElement(dealMilestone), milestone);					//Milestone
		sendKeysAction(driver.findElement(By.xpath("")), closeDate);								//Close Date
		selectDropDownByVisibleText(driver.findElement(this.dealSource), dealSource);				//Deal Source
		//Type - color selection
		clickAction(driver.findElement(By.xpath("//form[@id='opportunityForm']/descendant::div[@id='"+dealType+"']")), "Blue Type Selected!!!");
		sendKeysAction(driver.findElement(dealContactName), contactName);							//Related to
		action.sendKeys(Keys.ENTER).build().perform();
		sendKeysAction(driver.findElement(dealTags), tags);											//Tags
		clickAction(driver.findElement(addDealSaveButton), "Click on Save Button!!!");
	}	
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void changeDealStatus(String sourceStatus, String destinationStatus) throws Exception
	{
		clickAction(driver.findElement(dealsMenuOption),"Click on Deal Menu!!!");
		//Wait for source status to be clickable
		elementsToBeClickable(By.xpath("//ul[@milestone='"+sourceStatus+"']/li[1]"), "Waiting for Deal Status to be Clickable...");
		//find the source status and store it in sourceElement WebElement
		WebElement sourceElement = driver.findElement(By.xpath("//ul[@milestone='"+sourceStatus+"']/li[1]"));
		//Get the name of the sourceStatus deal name and storing it in dealsName
		String srcDealsName = driver.findElement(By.xpath("//ul[@milestone='"+sourceStatus+"']/li[1]/descendant::a[1]")).getText();

		//find the destination status and store it in sourceElement WebElement
		WebElement destinationElement = driver.findElement(By.xpath("//ul[@milestone='"+destinationStatus+"']/li[1]"));
		Actions action = new Actions(driver);
		//Perform Drag & Drop operation between sourceElement and destinationElement 
		action.dragAndDrop(sourceElement, destinationElement).build().perform();
		
		System.out.println("The Deal status of "+srcDealsName+ " from "+sourceStatus+" ---> "+destinationStatus);
		//Get the name of the destinationStatus deal name and storing it in destDealsName
		fluentWait(By.xpath("//ul[@milestone='"+destinationStatus+"']/li[1]/descendat::a[1]"), "Waiting for destinationStatus...");
		WebElement destDealsName = driver.findElement(By.xpath("//ul[@milestone='"+destinationStatus+"']/li[1]/descendat::a[1]"));
		
		verifyDealStatus(destinationStatus, destDealsName);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void verifyDealStatus(String expectedStatus, WebElement element) throws Exception
	{
//		Wait for destDealsName to be clickable
		elementsToBeClickable(element, "Waiting for destDealsName to be clickable...");
		//perform click operation
		element.click();
		//get updated status of the deal
		String actualStatus = driver.findElement(By.xpath("//div[@class='panel-body']/descendant::span[2]")).getText();
		//compare actual & expected deal status
		if(actualStatus.equals(actualStatus))
		{
			System.out.println("Successfully performed Drag & Drop operation!!!");
		}
		else
		{
			throw new Exception("Drag & Drop did not work for the source element!!!");
		}
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void sortDealsBy(String sortByChoice)
	{
		click(dealsMenuOption, "Click on Deals Menu!!!");
		elementsToBeClickable(sortByButton, "Waiting for 'Sort By' to be clickable...");
		click(sortByButton, "Click on 'Sort By' to select respective option!!!");
		switch(sortByChoice)
		{
			case "Created Date":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Created Date");
				break;
			case "Close Date":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Close Date");
				break;
			case "Won Date":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Won Date");
				break;
			case "Value":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Value");
				break;
			default:
				System.out.println("Deals are Sorted by Created Date in descending order, by default!!!");
		}
		
		switch(sortByChoice)
		{
			case "Ascending":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Ascending");
				break;
			case "Descending":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Ascending");
				break;
			default:
				System.out.println("Compaines are Sorted by Created Date in descending order, by default!!!");
		}
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------
	public void changeDealsLView(String setDealsView)
	{
		click(dealsMenuOption, "Click on Deals Menu!!!");
		elementsToBeClickable(dealsViewButton, "Waiting for 'View' button to be clickable...");
		click(dealsViewButton, "Click on the 'View' button!!!");
		switch(setDealsView)
		{
			case "List View":
				click(By.xpath("//div[@id='deals-view']//span[text()='"+setDealsView+"']"), "Click on 'List View' !!!");
				break;
			case "Relaxed":
				click(By.xpath("//div[@id='deals-view']//span[text()='"+setDealsView+"']"), "Click on 'Relaxed' !!!");
				break;
			case "Compact":
				click(By.xpath("//div[@id='deals-view']//span[text()='"+setDealsView+"']"), "Click on 'Compact' !!!");
				break;
			case "Fit":
				click(By.xpath("//div[@id='deals-view']//span[text()='"+setDealsView+"']"), "Click on 'Fit' !!!");
				break;
			default:
				System.out.println("Invalid view choice entered. Please enter a valid view amonng - List View/Relaxed/Compact/Fit");
		}
	}	
}