package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	Workbook wb;
public ExcelReader(String path) throws FileNotFoundException, IOException
{
	if(path.endsWith(".xls"))
	{
		wb=new HSSFWorkbook(new FileInputStream(path));
	}
	else if(path.endsWith(".xlsx"))
	{
        wb=new XSSFWorkbook(new FileInputStream(path));
	}
}
	public int getRowNum(String sheetName)
	{
		//System.out.println(wb);
		int num=wb.getSheet(sheetName).getLastRowNum();
		return num;
	}

	public String getData(String sheetName,int Row, int Cell) {
	return	wb.getSheet(sheetName).getRow(Row).getCell(Cell).toString();
	}
	
	
	public String[][] getAllData(String sheetName,int Row, int Cell) {
		
     String data[][]=new String[Row][Cell];
     for(int i=0;i<Row;i++)
     {
    	 for(int j=0;j<Cell;j++)
    	 {
    		 System.out.println(i+" "+j);
    		 System.out.println(wb.getSheet(sheetName).getRow(i+1).getCell(j).toString());
    		 data[i][j]=wb.getSheet(sheetName).getRow(i+1).getCell(j).toString();
    	 }
     }

		return	data;
}
}