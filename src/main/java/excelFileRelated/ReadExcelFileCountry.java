package excelFileRelated;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileCountry {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/CountryRel.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
		for(int r=0; r<=rows ; r++)
		{
			XSSFRow row = sheet.getRow(r);
			
			for(int c=0; c<cols; c++)
			{
				XSSFCell cell = row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING: System.out.println(cell.getStringCellValue()); break;
				case BOOLEAN: System.out.println(cell.getBooleanCellValue());break;
				case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
				}
			}
			System.out.println();
		}

	}

}
