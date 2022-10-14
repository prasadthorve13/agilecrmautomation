package com.AgileCrmAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AgileCrmAutomation.BaseClass;

public class CompanyPage extends BaseClass 
{
//------------------------------------------------------------------------------------------------------------------------------------------------------
//	Constructor to initialize the @FindBy based declared variables
	public CompanyPage()
	{
		PageFactory.initElements(driver, this);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------
//	Declaring element variables for reusability
	private By companyMenuOption = By.id("companiesmenu");
	private By addCompanyButton = By.xpath("//button[contains(text(),'Add Company')]");  
	private By deleteButton = By.xpath("//button[contains(text(), 'Delete')]");
	private By selectAllCheckbox = By.xpath("By.xpath(\"//span[@id='companies-list-view-checkbox']//input\")");
	private By continueCompanyEditingButton = By.id("continue-company");
	private By companyEmailDropDown = By.xpath("//div[contains(@class,'col-sm-9  hide')]/following::div//select[@name='email-select']");
	private By companyPhoneDropDown = By.xpath("//div[contains(@class,'col-sm-9 second')]//select[@name='phone-select']");
	private By companyWebsiteDropDown = By.xpath("//div[contains(@class,'col-sm-9 second')]//select[@name='website-select']");
	private By companyAddressDropDown = By.name("address-type");
	private By addCompanyUpdateButton = By.id("company-update");
	private By contact3DotsExtraOptions = By.xpath("//i[@class='material-icons more_vert v-middle']");
	private By deleteCompanyOption = By.xpath("//div[@class='dropdown ibm open']//a[@id='company-actions-delete']");
	private By deleteCompanyConfirmation = By.xpath("//a[@id='success_callback']");
	private By yesDeleteAllCompanies = By.xpath("//a[@id='success_callback']");
	private By sortByButton = By.xpath("//span[contains(text(), 'Sort By')]");
	private By sortByDropDownList = By.id("contact-view-sort-model-list");
	private By bulkUpdateFieldsButton = By.xpath("//button[text()='Bulk Update Fields']");
	private By bulkCompanyUpdateUpdateButton = By.xpath("//div[contains(@class,'form-actions')]/a[text()='Update']");
	private By exportToCsvBtn = By.xpath("//button[text()='Export as CSV']");
	private By selectAllCompanyExport = By.id("select-all");
	private By yesSelectAllCompanyExport = By.id("companies-export-csv-confirm");
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	private By companyName = By.id("company_name");
	private By companyUrl = By.id("company_url");
	private By companyTags = By.id("tags-new-person");
	private By companyEmail = By.xpath("//div[contains(@class,'addField')]//div[2]//input[@id='email']");
	private By companyPhone = By.xpath("//div[contains(@class,'col-sm-9 second')]//input[@id='phone']");
	private By companyWebsite = By.xpath("//div[contains(@class,'col-sm-9 second')]//input[@id='website']");
	private By companyAddress = By.id("address");
	private By companyCity = By.id("city");
	private By companyState = By.id("state");
	private By companyZip = By.id("zip");
	private By companyCountry = By.id("country");
	private By companyUpdateField = By.id("LHS");
	private By companyUpdateFieldValue = By.xpath("//div[@id='RHS']/input");
	private By companyCountryUpdateField = By.id("RHS");
	private String destcompanyName;
//------------------------------------------------------------------------------------------------------------------------------------------------------
	public void addCompany(String companyName, String companyUrl, String tag, String companyEmail, String companyPhone, String companyWebsite, String companyAddress, String city, String state, String zip)
	{
		click(companyMenuOption, "Click on Companines Menu!!!");
		clickAction(addCompanyButton, "Add Company Button!!!");
		driver.findElement(this.companyName).sendKeys(companyName);												//Company Name
		driver.findElement(this.companyUrl).sendKeys(companyUrl);												//Company URL
		clickAction(driver.findElement(continueCompanyEditingButton), "Continue Editing Button!!!");

		elementsToBeClickable(companyTags, "Waiting for tags to be clickable......");
		driver.findElement(companyTags).sendKeys(tag);															//Tags
		
		driver.findElement(this.companyEmail).sendKeys(companyEmail);
		selectDropDownByIndex(driver.findElement(companyEmailDropDown), 2);										//Email DropDown
		
		driver.findElement(this.companyPhone).sendKeys(companyPhone);											//Phone
		selectDropDownByValue(driver.findElement(companyPhoneDropDown), "primary");								//Phone DropDown
		
		driver.findElement(this.companyWebsite).sendKeys(companyWebsite);								//Website
		selectDropDownByValue(driver.findElement(companyWebsiteDropDown), "URL");								//Website DropDown
		
		driver.findElement(this.companyAddress).sendKeys(companyAddress);								//Address
		selectDropDownByValue(driver.findElement(companyAddressDropDown), "work");								//Address DropDown
		
		driver.findElement(companyCity).sendKeys(city);															//City
		driver.findElement(companyState).sendKeys(state);														//State
		driver.findElement(companyZip).sendKeys(zip);															//Zip
		selectDropDownByValue(driver.findElement(companyCountry), "IN");										//Country DropDown				
		clickAction(driver.findElement(addCompanyUpdateButton), "Update Button!!!");
		destcompanyName = driver.findElement(By.xpath("//a[normalize-space()='"+companyName+"']")).getText();
		Assert.assertEquals(companyName, destcompanyName);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------		
	public void selectAllCheckBox()
	{
//		Clicks on the Company Tab on LHS
		click(companyMenuOption, "Click on Companines Menu!!!");
//		Waits for the Visibility of SelectAllCheckBox
		WebElement selectAllCheckBox = driver.findElement(this.selectAllCheckbox);
		waitForVisibilityOfElement(selectAllCheckBox, "Waiting for SelectAllCheckBox to be visible!");
//		Clicks on the SelectAllCheckBox
		String checkBoxSelectedMessage1 = driver.findElement(By.id("bulk-select")).getText();
		click(selectAllCheckbox, "Click on selectAllCheckBox");	
		String checkBoxSelectedMessage2 = driver.findElement(By.id("bulk-select")).getText();
		Assert.assertNotEquals(checkBoxSelectedMessage1, checkBoxSelectedMessage2);		
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void deleteCompany(String companyName) throws InterruptedException
	{
		click(companyMenuOption, "Click on Contacts Menu!!!");
		click(By.xpath("//a[normalize-space()='"+companyName+"']"), "Click on Particular Contact!!!");
		click(contact3DotsExtraOptions, "Click on 3dots!!!");
		click(deleteCompanyOption, "Click on Delete!!!");
		click(deleteCompanyConfirmation, "Click to Confirm Contact Deletion...");
		System.out.println("Contact Deleted Successfully!!!");
		searchEntity("Company", companyName);
		String deletedCompanySearchResult = driver.findElement(By.id("search-query-heading")).getText();
		String destCompanyDeletedMessage = "No matches found for "+companyName+" in ";
		Assert.assertEquals(deletedCompanySearchResult, destCompanyDeletedMessage);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
	public void deleteBulkCompany() throws InterruptedException
	{
		String companyCountBeforeBulkDelete = driver.findElement(By.id("contacts-count")).getText();
		selectAllCheckBox();
//		Clicks on the Delete Button		
		WebElement deleteButton = driver.findElement(this.deleteButton);
		BaseClass.waitForVisibilityOfElement(deleteButton, "Delete Button is Viewable!");
		deleteButton.click();
		System.out.println("Delete Button is Clickable!");
		click(yesDeleteAllCompanies, "Confirmation Yes to delete all company!!!");
		String companyCountAfterBulkDelete = driver.findElement(By.id("contacts-count")).getText();
		Assert.assertNotEquals(companyCountBeforeBulkDelete, companyCountAfterBulkDelete);
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------
	public void sortCompaniesBy(String sortByChoice)
	{
		click(companyMenuOption, "Click on Companines Menu!!!");
		elementsToBeClickable(sortByButton, "Waiting for 'Sort By' to be clickable...");
		click(sortByButton, "Click on 'Sort By' to select respective option!!!");
		switch(sortByChoice)
		{
			case "Created Date":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Created Date");
				break;
			case "Star Value":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Star Value");
				break;
			case "Name":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Name");
				break;
			case "Score":
				selectDropDownByVisibleText(driver.findElement(sortByDropDownList), "Score");
				break;
			default:
				System.out.println("Compaines are Sorted by Created Date in descending order, by default!!!");
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
	public void bulkUpdateCompaniesDetails(String fieldToUpdate, String valueOfField)
	{
		selectAllCheckBox();
		click(bulkUpdateFieldsButton, "Click on 'Bulk Update Fields' button!!!");
		switch(fieldToUpdate)
		{
			case "Owner":
				selectDropDownByVisibleText(driver.findElement(companyUpdateField), "Owner");
				if(valueOfField.equalsIgnoreCase("vijayraj"))
				{
					selectDropDownByVisibleText(driver.findElement(companyUpdateField), "vijayraj");
				}
				else if(valueOfField.equalsIgnoreCase("gauri01"))
				{
					selectDropDownByVisibleText(driver.findElement(companyUpdateField), "gauri01");
				}
				else
				{
					System.out.println("The field doesn't exist!!!");
				}
				break;
			case "City":
				selectDropDownByVisibleText(driver.findElement(companyUpdateField), "City");
				driver.findElement(companyUpdateFieldValue).sendKeys(valueOfField);
				break;
			case "State":
				selectDropDownByVisibleText(driver.findElement(companyUpdateField), "State");
				driver.findElement(companyUpdateFieldValue).sendKeys(valueOfField);
				break;
			case "Country":
				selectDropDownByVisibleText(driver.findElement(companyUpdateField), "Country");
				selectDropDownByVisibleText(driver.findElement(companyCountryUpdateField), valueOfField);
				break;
			case "Zip":
				selectDropDownByVisibleText(driver.findElement(companyUpdateField), "Zip");
				driver.findElement(companyUpdateFieldValue).sendKeys(valueOfField);
				break;
		}
			click(bulkCompanyUpdateUpdateButton, "Click on Update button!!!");
			
	}
//------------------------------------------------------------------------------------------------------------------------------------------------------
	public void exportAllCompanyDetails()
	{
		selectAllCheckBox();
		click(exportToCsvBtn, "Click on 'Export as CSV' button!!!");
		click(selectAllCompanyExport, "Click on 'Select all' !!!");
		click(yesSelectAllCompanyExport, "Click on 'Yes' !!!");
	}
}