package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility {
	
	static FileInputStream f; // inbuilt class used to input a file
	static XSSFWorkbook w; // inbuilt class used to input a workbook
	static XSSFSheet s; // inbuilt class used to input a sheet

	public static String getStringData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(Constants.TEST_DATA_EXCEL_FILE_PATH); // used to read a file
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet); 		// inbuilt method used to get a sheet
		XSSFRow r = s.getRow(a); 		// XSSFRow -inbuilt class used to input a row, getRow - inbuilt method used to
										// get a row
		XSSFCell c = r.getCell(b); 		// XSSFCell - inbuilt class used to input a cell, getCell - inbuilt method used
										// to get a cell
		return c.getStringCellValue();	//used to get a string value in a cell
	}

}
