package org.task.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet; 
	public static XSSFRow row;
	
	public Object[][] readValuesFromExcel(String filename)
	{
		try 
		{
			wb = new XSSFWorkbook("./data/"+filename+".xlsx");
			sheet = wb.getSheetAt(0);
			
			int rowSize 	= sheet.getLastRowNum();
			int cellSize	= sheet.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[rowSize][cellSize];
			
			for(int i=1;i<=rowSize;i++)
			{
				row = sheet.getRow(i);
				String text;
				for(int j=0;j<cellSize;j++)
				{
					text=row.getCell(j).getStringCellValue();
					System.out.print(text+" ");
					data[i-1][j] = text;
				}
				System.out.println();
			}
			
			return data;
			
		} 
		catch (Exception e) {
			System.out.println("Issues in reading the values from excel");
			e.printStackTrace();
		}
		return null;
	}

}
