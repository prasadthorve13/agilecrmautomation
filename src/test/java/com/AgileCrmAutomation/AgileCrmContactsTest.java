package com.AgileCrmAutomation;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.AgileCrmAutomation.pages.ContactsPage;
public class AgileCrmContactsTest extends BaseClass
{
	ContactsPage contact = new ContactsPage();
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void addContact() throws InterruptedException
	{
		contact.addContact("Demo","Account","Demo","Demo Company","demo@yopmail.com","9876543210","B2B");		//Add Contact Pop-Up
		driver.findElement(By.xpath("//a[@id='person_validate']")).click(); 									//Save Button Click Action
		System.out.println("1 Contact Added Successfully!!!");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void addDetailContact() throws InterruptedException
	{
		contact.addDetailContact("www.democompany.com", "Deccan", "Pune", "Maharashtra", "411001");	//Add Detailed Contact Page
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void searchContact() throws InterruptedException
	{
		contact.searchEntity("Contact", "Dip");	//Search Contact
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void editContact() throws InterruptedException
	{
		contact.editContact("Demo Account", "Mumbai", "MaHarashtra");		//Edit Contact
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void deleteSingleContact() throws InterruptedException
	{
		contact.deleteContact("Demo Contact");	//Deletion of Single Contact
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void deleteBulkContact() throws InterruptedException
	{
		contact.deleteBulkContacts();	//Bulk Deletion of Contacts
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void addBulkContactTags() throws InterruptedException
	{
		contact.addBulkTags("tag", "tag", "tag");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void removeBulkContactTags() throws InterruptedException
	{
		contact.removeBulkTags("tag", "tag", "tag");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void addBulkContactDetails() throws InterruptedException
	{
		contact.bulkUpdateContactDetails("Job", "Owner");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void sortContacts() throws InterruptedException
	{
		contact.sortContactsBy("First Name");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void changeContactTableView() throws InterruptedException
	{
		contact.changeContactListView("List View");
	}
}