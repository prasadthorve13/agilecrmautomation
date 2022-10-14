package com.AgileCrmAutomation;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.pages.DealsPage;
public class AgileCrmDealsTest extends BaseClass
{
	DealsPage deals = new DealsPage();
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void addDeal() throws Exception
	{
		deals.addDeal("Demo Deal", "vijayraj", "100000", "20", "New", "09/09/2022", "Website", "E1BEE7", "Dipali", "Cricket");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void changeDealStatus() throws Exception
	{
		deals.changeDealStatus("New", "Prospect");
//		deals.changeDealStatus("Prospect", "New");
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	public void sortDeals() throws Exception
	{
		deals.sortDealsBy("Created Date");
		deals.sortDealsBy("Descending");
	}
}