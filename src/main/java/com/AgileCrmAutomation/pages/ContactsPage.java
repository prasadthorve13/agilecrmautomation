package com.AgileCrmAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.BaseClass;

public class ContactsPage extends BaseClass
{
//	----------------------------------------------------------------------------------------------
//	Constructor to initialize the @FindBy based declared variables	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
//	----------------------------------------------------------------------------------------------	
//	Declaring element variables for reusability
	public By contactsMenuOption = By.id("contactsmenu");
	private By contactSortByOptions = By.id("contact-view-sort-model-list");
	private By addContactButton = By.xpath("//div[@id='view-list']/child::div/button");
	private By continueContactEditingBtn = By.id("continue-contact");
	private By editContactButton = By.xpath("//div[@class='contact-lhs-actions']/a/i[contains(@class,'edit')]");
	private By selectAllCheckBox = By.xpath("//span[@id='companies-list-view-checkbox']//input");
	private By deleteContactButton = By.xpath("//button[@id='bulk-contacts-export']/following-sibling::button");
	private By addTagsButton = By.xpath("//button[text()='Add Tags']");
	private By removeTagsButton = By.xpath("//button[text()='Remove Tags']");
	private By bulkUpdateFieldsBtn = By.xpath("//button[text()='Bulk Update Fields']");
	private By exportToCsvBtn = By.xpath("//button[text()='Export as CSV']");
	private By sortByButton = By.xpath("//span[contains(text(), 'Sort By')]");
	private By contactEmailDropDown = By.xpath("//div[contains(@class,'hide controls')]/following::div[contains(@class,'email')]/div[contains(@class,'pull-left')]/select/option[@value='home']");
	private By contactPhoneDropDown = By.xpath("//div[contains(@class,'hide controls')]/following::div[contains(@class,'phone')]/div[contains(@class,'pull-left')]/select");
	private By contactWebsiteDropDown = By.xpath("//select[contains(@class,'website-select')]/child::option[@value='URL']");
	private By contactAddressDropDown = By.xpath("//select[@name='address-type']/child::option[@value='work']");
	private By updateEditContactButton = By.xpath("//a[@id='update']");
	private By contact3DotsExtraOptions = By.xpath("//i[@class='material-icons more_vert v-middle']");
	private By deleteContactOption = By.xpath("//div[@class='dropdown ibm open']//a[@id='contact-actions-delete']");
	private By deleteContactConfirmation = By.xpath("//a[@id='success_callback']"); 
	private By addBulkTagsButton = By.id("addBulkTags");
	private By addTagButton = By.xpath("//a[text()='Add Tag']");
	private By removeBulkTagsButton = By.id("removeBulkTags");
	private By removeButton = By.xpath("//a[text()='Remove']");
	private By updateBulkContactButton = By.xpath("//div[contains(@class,'form-actions')]/a[text()='Update']");
	private By selectAllContactExport = By.id("select-all");
	private By yesSelectAllContactExport = By.id("companies-export-csv-confirm");
	private By contactPageViewButton = By.xpath("//div[@id='contacts-view-options']/a/i[text()='list']");
	private By listViewContacts = By.xpath("//a[@data='list']");
	private By gridViewContacts = By.xpath("//a[@data='grid']");
	
	private By contactsTagsFilter = By.xpath("//div[@class='panel-body']//a[contains(text(),'Tags')]");
	private By filterContactsByTags = By.xpath("//div[@class='panel-body']//a[contains(text(),'Tags')]//following-sibling::div//div[contains(@class,'contact-filter')]/select[@id='tags-filter']");
	private By filterContactsTagsValue = By.xpath("//span[@id='RHS']/input[@id='temp-1']");
	private By contactsOwnerFilter = By.xpath("//div[@class='panel-body']//a[contains(text(),'Owner')]");
	private By filterContactsByOwner = By.xpath("//div[@class='panel-body']//a[contains(text(),'Owner')]/following-sibling::div[@id='owner_id_div']/div/select[@id='between_filter']");
	private By filterContactsOwnerValue = By.id("owner_select");
	private By contactsCreatedDateFilter = By.xpath("//div[@class='panel-body']//a[contains(text(),'Created Date')]");
	private By filterContactsByCreatedDate = By.xpath("//div[@class='panel-body']//a[contains(text(),'Created Date')]//following-sibling::div//select[@id='between_filter']");
	private By filterContactsCreatedDateValue = By.xpath("//div[@class='panel-body']//a[contains(text(),'Created Date')]//following-sibling::div//select[@id='between_filter']/following-sibling::div//input[@id='temp-53']");
	private By contactsUpdatedDateFilter = By.xpath("//div[@class='panel-body']//a[contains(text(),'Updated Date')]");
	private By filterContactsByUpdatedDate = By.xpath("//div[@class='panel-body']//a[contains(text(),'Updated Date')]/following-sibling::div//div/select[@id='between_filter']");
	private By filterContactsUpdatedDateValue = By.xpath("//div[@class='panel-body']//a[contains(text(),'Updated Date')]/following-sibling::div//div/select[@id='between_filter']/following-sibling::div//input[@id='temp-57']");
	private By contactsCountryFilter = By.xpath("//div[@class='panel-body']//a[contains(text(),'Country')]");
	private By filterContactsByCountry = By.xpath("//div[@class='panel-body']//a[contains(text(),'Country')]/following-sibling::div//div/select[@id='between_filter']");
	private By filterContactsCountryValue = By.xpath("//div[@class='panel-body']//a[contains(text(),'Country')]/following-sibling::div//div/select[@id='between_filter']/following-sibling::div//select");
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
	@FindBy(id="LHS")
	private By contactUpdateField;

	@FindBy(xpath="//div[@id='RHS']/input")
	private By contactUpdateFieldValue;
	
	@FindBy(id="fname")
	private By contactFirstName;

	@FindBy(id="lname")
	private By contactLastName;
	
	@FindBy(id="job_title")
	private By contactJobTitle;
	
	@FindBy(id="contact_company")
	private By contactCompany;
	
	@FindBy(id="email")
	private By contactEmail;
	
	@FindBy(id="phone")
	private By contactPhone;
	
	@FindBy(id="tags-new-person")
	private By contactTags;
	
	@FindBy(id="website_field_length")
	private By contactWebsite;
	
	@FindBy(id="address")
	private By contactAddress;
	
	@FindBy(id="city")
	private By contactCity;
	
	@FindBy(id="state")
	private By contactState;
	
	@FindBy(id="zip")
	private By contactZip;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void addContact(String fname,String lname,String jobTitle,String company,String email,String phone,String tag) throws InterruptedException
	{
		fluentWait(contactsMenuOption, "Waiting for Contact Menu...");
		driver.findElement(contactsMenuOption).click();								//Clicks on the Contacts Tab on LHS
		click(addContactButton, "Click Operation on Add Contact Button on Contacts Page!");
		System.out.println("Welcome to Add Contact Pop-up Module!");
		elementsToBeClickable(contactFirstName, "Waiting for First Name to be Clickable...");
		driver.findElement(contactFirstName).sendKeys("Demo"); 						//First Name
		driver.findElement(contactLastName).sendKeys("Account");					//Last Name
		driver.findElement(contactJobTitle).sendKeys("Demo");						//Title
		driver.findElement(contactCompany).sendKeys("Demo Company");				//Company Name
		driver.findElement(contactEmail).sendKeys("demo@yopmail.com");				//Email
		driver.findElement(contactPhone).sendKeys("9876543210");					//Phone
		driver.findElement(contactTags).sendKeys("B2B");							//Tags
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void addDetailContact(String website, String address, String city, String state, String zipcode) throws InterruptedException
	{
		addContact("Demo","Account","Demo","Demo Company","demo@yopmail.com","9876543210","B2B");
		click(continueContactEditingBtn, "Continue Editing Click Action!!1");	//Continue Editing Click Action
		System.out.println("Page Redirect to Continue Editing Contact Details!");
//		fluentWait(By.xpath("//select[contains(@class,'email-select')]/child::option[@value='work']"), "Waiting for Email DropDown...");
		elementsToBeClickable(contactEmailDropDown, "Waiting for Email-Select to be Clickable...");
		WebElement emailType = driver.findElement(contactEmailDropDown);
		selectDropDownByIndex(emailType, 2);
		
		WebElement phoneType = driver.findElement(contactPhoneDropDown);
		fluentWait(contactPhoneDropDown, "Waiting for Phone Type...");
		selectDropDownByVisibleText(phoneType, "Work");

		driver.findElement(contactWebsite).sendKeys(website);			//Website
		selectDropDownByVisibleText(phoneType, "Website");
		click(contactWebsiteDropDown, "URL Type Website!!!");			//Website Type Select
		driver.findElement(contactAddress).sendKeys(address);			//Address
		selectDropDownByVisibleText(phoneType, "Work");
		click(contactAddressDropDown,"Work Type Address!!!");			//Address Type Select
		driver.findElement(contactCity).sendKeys(city);					//City
		driver.findElement(contactState).sendKeys(state);				//State
		driver.findElement(contactZip).sendKeys(zipcode);				//Zip
		selectDropDownByVisibleText(phoneType, "Work");
		click(By.xpath("//select[@id='country']/child::option[@value='IN']"),"Country is India");	//Country Select
		click(By.xpath("//a[@id='update']"),"Click on Update Button!!!");	//Update Contact Details click  Event
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
	public void editContact(String contactName, String city, String state)
	{
		click(contactsMenuOption, "Click on Contacts Menu!!!");
		click(By.xpath("//a[normalize-space()='"+contactName+"']"), "Click on Particular Contact!!!");
		click(editContactButton, "Click on Edit Contact Button!!!");
		fluentWait(contactCity, "Waiting for City...");
		driver.findElement(contactCity).sendKeys(city);											//City
		driver.findElement(contactState).sendKeys(state);									//State
		click(updateEditContactButton,"Click on Update Button!!!");
		System.out.println("Contact Updated Successfully!!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
	public void deleteContact(String contactName) throws InterruptedException
	{
		click(contactsMenuOption, "Click on Contacts Menu!!!");
		click(By.xpath("//a[normalize-space()='"+contactName+"']"), "Click on Particular Contact!!!");
		click(contact3DotsExtraOptions, "Click on 3dots!!!");
		click(deleteContactOption, "Click on Delete!!!");
		click(deleteContactConfirmation, "Click to Confirm Contact Deletion...");
		System.out.println("Contact Deleted Successfully!!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void selectAllCheckBox()
	{
//		Clicks on the Company Tab on LHS
		click(contactsMenuOption, "Click on Contacts Menu!!!");
//		Waits for the Visibility of SelectAllCheckBox
		elementsToBeClickable(selectAllCheckBox, "Waiting for select all checkbox to be clickable...");
//		Clicks on the SelectAllCheckBox
		click(selectAllCheckBox, "Click on selectAllCheckBox");		
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void deleteBulkContacts() throws InterruptedException
	{
		selectAllCheckBox();
		elementsToBeClickable(deleteContactButton, "Waiting for Delete Button to be clickable...");
		click(deleteContactButton, "Click on Delete button!!!");
		click(deleteContactConfirmation, "Click on Yes!!!");
		System.out.println("Contacts Deleted Successfully!!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void addBulkTags(String tag1, String tag2, String tag3)
	{
		selectAllCheckBox();
		click(addTagsButton, "Click on 'Add Tags' button!!!");
		sendKeysAction(driver.findElement(addBulkTagsButton), tag1+","+tag2+","+tag3+",");
		click(addTagButton, "Click on 'Add Tag' button!!!");
		System.out.println("Bulk Tags added Successfully!!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void removeBulkTags(String tag1, String tag2, String tag3)
	{
		selectAllCheckBox();
		click(removeTagsButton, "Click on 'Remove Tags' button!!!");
		sendKeysAction(driver.findElement(removeBulkTagsButton), tag1+","+tag2+","+tag3+",");
		click(removeButton, "Click on 'Remove' button!!!");
		System.out.println("Bulk Tags removed Successfully!!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void bulkUpdateContactDetails(String fieldToUpdate, String valueOfField)
	{
		selectAllCheckBox();
		click(bulkUpdateFieldsBtn, "Click on 'Bulk Update Fields' button!!!");
		switch(fieldToUpdate)
		{
			case "Owner":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "Owner");
				if(valueOfField.equalsIgnoreCase("vijayraj"))
				{
					selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "vijayraj");
				}
				else if(valueOfField.equalsIgnoreCase("gauri01"))
				{
					selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "gauri01");
				}
				else
				{
					System.out.println("The field doesn't exist!!!");
				}
				break;
			case "Job Title":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "Job Title");
				sendKeysAction(driver.findElement(this.contactUpdateFieldValue), valueOfField);
				break;
			case "Company":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "Company");
				sendKeysAction(driver.findElement(this.contactUpdateFieldValue), valueOfField);
				break;
			case "City":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "City");
				sendKeysAction(driver.findElement(this.contactUpdateFieldValue), valueOfField);
				break;
			case "State":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "State");
				sendKeysAction(driver.findElement(this.contactUpdateFieldValue), valueOfField);
				break;
			case "Country":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "Country");
				selectDropDownByVisibleText(driver.findElement(By.id("RHS")), valueOfField);
				break;
			case "Zip":
				selectDropDownByVisibleText(driver.findElement(this.contactUpdateField), "Zip");
				sendKeysAction(driver.findElement(this.contactUpdateFieldValue), valueOfField);
				break;
		}
			click(updateBulkContactButton, "Click on Update button!!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
	public void exportAllContactDetails()
	{
		selectAllCheckBox();
		click(exportToCsvBtn, "Click on 'Export as CSV' button!!!");
		click(selectAllContactExport, "Click on 'Select all' !!!");
		click(yesSelectAllContactExport, "Click on 'Yes' !!!");
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void sortContactsBy(String sortByChoice)
	{
		click(contactsMenuOption, "Click on Contacts Menu!!!");
		elementsToBeClickable(sortByButton, "Waiting for 'Sort By' to be clickable...");
		click(sortByButton, "Click on 'Sort By' to select respective option!!!");
		switch(sortByChoice)
		{
			case "Created Date":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "Created Date");
				break;
			case "Score":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "Score");
				break;
			case "Star Value":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "Star Value");
				break;
			case "First Name":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "First Name");
				break;				
			case "Last Name":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "Last Name");
				break;
			case "Contacted Date":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "Contacted Date");
				break;
			case "Last Emailed":
				selectDropDownByVisibleText(driver.findElement(this.contactSortByOptions), "Last Emailed");
				break;
			default:
				System.out.println("Contacts are Sorted by Created Date, by default!!!");
		}
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void changeContactListView(String setContactsView)
	{
		click(contactsMenuOption, "Click on Contacts Menu!!!");
		elementsToBeClickable(contactPageViewButton, "Waiting for 'View' button to be clickable...");
		if(setContactsView.equalsIgnoreCase("List View"))
		{
			click(listViewContacts, "Click on 'List View' !!!");
		}
		else
		{
			click(gridViewContacts, "Click on 'Grid View' !!!");
		}
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void filters(String filterName, String filterType, String filterValue)
	{
		click(contactsMenuOption, "Click on Contacts Menu!!!");
		switch(filterName)
		{
			case "Tags":
				click(contactsTagsFilter, "Click on Filter Contacts By Tags !!!");
				selectDropDownByVisibleText(driver.findElement(filterContactsByTags), filterType);
				selectDropDownByVisibleText(driver.findElement(filterContactsTagsValue), filterValue);
				System.out.println("Contacts Filtered by Tags!!!");
				break;
			case "Owner":
				click(contactsOwnerFilter, "Click on Filter Contacts By Owner !!!");
				selectDropDownByVisibleText(driver.findElement(filterContactsByOwner), filterType);
				selectDropDownByVisibleText(driver.findElement(filterContactsOwnerValue), filterValue);
				System.out.println("Contacts Filtered by Owner!!!");
				break;
			case "Created Date":
				click(contactsCreatedDateFilter, "Click on Filter Contacts By Created Date !!!");
				selectDropDownByVisibleText(driver.findElement(filterContactsByCreatedDate), filterType);
				selectDropDownByVisibleText(driver.findElement(filterContactsCreatedDateValue), filterValue);
				System.out.println("Contacts Filtered by Created Date!!!");
				break;
			case "Updated Date":
				click(contactsUpdatedDateFilter, "Click on Filter Contacts By Owner !!!");
				selectDropDownByVisibleText(driver.findElement(filterContactsByUpdatedDate), filterType);
				selectDropDownByVisibleText(driver.findElement(filterContactsUpdatedDateValue), filterValue);
				System.out.println("Contacts Filtered by Updated Date!!!");
				break;
			case "Country":
				click(contactsCountryFilter, "Click on Filter Contacts By Owner !!!");
				selectDropDownByVisibleText(driver.findElement(filterContactsByCountry), filterType);
				selectDropDownByVisibleText(driver.findElement(filterContactsCountryValue), filterValue);
				System.out.println("Contacts Filtered by Country!!!");
				break;
			case "clear":
				click(By.id("clear-lhs-contact-filters"), "To clear the applied filters !!!");
				System.out.println("Filters Cleared!!!");
				break;
			default :
				System.out.println("Filter not found!!!");
		}
	}	
}