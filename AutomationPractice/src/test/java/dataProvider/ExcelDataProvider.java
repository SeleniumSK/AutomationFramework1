package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testCases.BaseClass;

public class ExcelDataProvider {
	public File src;
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		 src = new File(System.getProperty("user.dir")+"/DataFiles/excelSheet.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
			
			
		
		} catch (IOException e) {
			System.out.println("Error in loading the excel "+e.getMessage());
		}
	}
	
	//method to get the String Data from the excel sheet
	public String getExcelData(String sheet, int row, int column)
	{
		String data= wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	//method to get the number of rows
	public int getNumberOfRows(String sheet)
	{
		return wb.getSheet(sheet).getPhysicalNumberOfRows();
	}
	
	//method to get the number of columns
	public int getNumberOfColumns(String sheet, int row)
	{
		return wb.getSheet(sheet).getRow(row).getPhysicalNumberOfCells();
	}
	
	//method to write to the data to excel
	
	public void setDataToExcel(String sheet, int row, int col, String Value)
	{
		 wb.getSheet(sheet).getRow(row).createCell(col).setCellValue(Value);
	}
	
	public void writeExcel()
	{
		try {
			wb.write(BaseClass.fout);
			wb.close();
		} catch (IOException e) {
			System.out.println("Unable to write data in the excel sheet");
			System.out.println("The error is "+e.getMessage());
		}
	}

}
