package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataRead 
{
//	To get file extension w.r.t. filePath
	private String getFileExtension(String filePath)
	{
		String fileExtension = filePath.substring(filePath.indexOf("."));
		System.out.println(fileExtension);
		return fileExtension;
	}
	
//	To get Workbook object w.r.t. filePath
	private Workbook getWorkbookInstance(String filePath) throws IOException
	{
		Workbook book;
		FileInputStream input = new FileInputStream(filePath);
		if(getFileExtension(filePath).equals(".xlsx"))
		{
			book = new XSSFWorkbook(input); 
		}
		else
		{
			book = new HSSFWorkbook(input);
		}
		return book;
	}
	
//	To get Sheet object with the help of getWorkbookInstance, filePath and sheetName
	private Sheet getSheet(String filePath, String sheetName) throws IOException
	{
		Workbook book = getWorkbookInstance(filePath);
		Sheet sheet = book.getSheet(sheetName);
		return sheet;
	}
	
//	To get cell data from Excel file(filePath, sheetName) in 2-Dimensional Array
	public Object[][] getExcelData(String filePath, String sheetName) throws IOException
	{
		Sheet sheet = getSheet(filePath, sheetName);
		int totalRows = sheet.getPhysicalNumberOfRows();
		System.out.println(totalRows);
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(totalColumns);
		return getCellValue(sheet, totalRows, totalColumns);
	}
	
//	This method will check the cell data to return respective values in whichever form they exist in
	private Object[][] getCellValue(Sheet sheet, int totalRows, int totalColumns)
	{
		Object value[][] = new Object[totalRows][totalColumns];
		for(int i=1 ; i<totalRows ; i++)
		{
			Row row = sheet.getRow(i);
			
			for(int j=0 ; j<totalColumns ; j++)
			{
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();
				switch(type) 
				{
					case STRING:
						value[i][j]=cell.getStringCellValue();
						break;
					case NUMERIC:
						value[i][j]=cell.getNumericCellValue();
						break;
					case BOOLEAN:
						value[i][j]=cell.getBooleanCellValue();
						break;
					case _NONE:
						value[i][j]=null;
						break;
					case BLANK:
						value[i][j]=null;
						break;
					default:
						value[i][j]=null;
				}
			}
		}
		return value;
	}
	
	public static void main(String[] args) throws IOException 
	{
		String filePath = "F:\\Downloads\\Softwares\\Courses\\JAVA\\Docs\\NewExcel.xlsx";
		ExcelDataRead file = new ExcelDataRead();
		Object[][] data = file.getExcelData(filePath, "Sheet1");
		int rowLength = data.length;
		System.out.println(rowLength);
		int columnLength=data[0].length;
		for(int i=1 ; i<=rowLength-1 ; i++)
		{
			for(int j=0 ; j < columnLength ; j++)
			{
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
		
	}
}