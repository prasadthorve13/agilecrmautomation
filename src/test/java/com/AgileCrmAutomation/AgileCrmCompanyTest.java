package com.AgileCrmAutomation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.AgileCrmAutomation.pages.CompanyPage;
import com.AgileCrmAutomation.pages.LoginPage;
public class AgileCrmCompanyTest extends BaseClass 
{
	LoginPage loginpage = new LoginPage();
	CompanyPage company = new CompanyPage();
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	@BeforeClass
	public void launchBrowser()
	{
		launchBrowser("edge");
		driver.navigate().to("https://cyberworld.agilecrm.com"); 	//Either get() or navigate() can be used to open a specific URL
		loginpage.login("vijayraj@yopmail.com","Vijay@1234");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
//	@BeforeTest
//	public void login()
//	{
//		
//	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void addCompany() throws Exception
	{
		company.addCompany("Demo Company", "www.democompany.com", "Marketing", "company@company.com", "9876543210", "www.democompany.com", "Deccan", "Pune", "Maharashtra", "411001");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void searchCompany() throws Exception
	{
		company.searchEntity("Company" ,"Demo Company");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void deleteSingleCompany() throws InterruptedException
	{
		company.deleteCompany("Demo Company");	//Deletion of Single Contact
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void deleteBulkCompanies() throws Exception
	{
		company.deleteBulkCompany();
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void sortCompanies() throws Exception
	{
		company.sortCompaniesBy("Name");
		company.sortCompaniesBy("Ascending");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void updateBulkCompanyDetails() throws Exception
	{
		company.bulkUpdateCompaniesDetails("Country", "India");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void exportCompanyDetails() throws Exception
	{
		company.exportAllCompanyDetails();
	}
}