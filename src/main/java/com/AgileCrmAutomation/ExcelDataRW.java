package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation.pages.LoginPage;

public class ExcelDataRW extends BaseClass
{

	public static void main(String[] args) throws IOException
	{
		ExcelDataRW write = new ExcelDataRW();
//		write.setExcelData("F:\\Downloads\\Softwares\\Courses\\JAVA\\Docs\\NewExcel.xlsx", "DemoSheet", 0, 0, "Test");
		write.getContactsData("F:\\Downloads\\Softwares\\Courses\\JAVA\\Docs\\NewExcel.xlsx", "DemoSheet");
	}
	
	public void setExcelData(String filePath, String sheetName, int totalRows, int totalCol, Object value) throws IOException 
	{
		FileInputStream input = new FileInputStream(filePath);
		Workbook book = new XSSFWorkbook(filePath);
		Sheet sheet;
		if(book.getSheet(sheetName)!=null)
		{
			sheet = book.getSheet(sheetName);
			System.out.println(sheetName+" exists!!!");
		}
		else
		{
			sheet = book.createSheet(sheetName);
			System.out.println(sheetName+" created!!!");
		}
		Row row;
		if(sheet.getRow(totalRows)!=null)
		{
			row = sheet.getRow(totalRows);
		}
		else
		{
			row = sheet.createRow(totalRows);
		}
		Cell cell;
		if(row.getCell(totalCol)!=null)
		{
			cell = row.getCell(totalCol);
		}
		else
		{
			cell = row.createCell(totalCol);
		}
		setData(cell, value);
		input.close();
		FileOutputStream output = new FileOutputStream("F:\\Downloads\\Softwares\\Courses\\JAVA\\Docs\\NewExcel2.xlsx");
		book.write(output);
		output.close();
		book.close();
	}
	
	private void setData(Cell cell, Object value)
	{
		if(value instanceof String)
		{
			cell.setCellValue(value.toString());
		}
		else if(value instanceof Boolean)
		{
			cell.setCellValue((Boolean)value);
		}
		else if(value instanceof Integer)
		{
			cell.setCellValue((int)value);
		}
		System.out.println("The data inside cell is - "+cell);
	}
	
	public void getContactsData(String filePath, String sheetName) throws IOException
	{
		launchBrowser("edge");
		driver.navigate().to("https://cyberworld.agilecrm.com"); 	//Either get() or navigate() can be used to open a specific URL
		LoginPage loginpage = new LoginPage();
		loginpage.login("vijayraj@yopmail.com","Vijay@1234");
		click(By.xpath("//i[@class='material-icons people']"), "Click on Contacts Menu!!!");
		fluentWait(By.id("contacts-table"), "Waiting for contacts table to be visible...");
		List<WebElement> contacts = driver.findElements(By.xpath("//a[@class='text-cap custom-link ']"));
		System.out.println(contacts.size());
		for(int i = 0 ; i < contacts.size() ; i++)
		{
			String fullName = ((WebElement) contacts).getText();
			String[] names = fullName.split(" ");
			String firstName = names[0];
			String lastName = names[1];
			System.out.println("First Name - "+firstName+" | Last Name - "+lastName);
			setExcelData(filePath, sheetName, i, 0, firstName);
		}
	}
}