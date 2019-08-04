package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

		

public class exceldataconfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	

	public exceldataconfig(String excelpath){
		
		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getdata(int sheetnumber,int row,int column) {
		
		 sheet1=wb.getSheetAt(sheetnumber);
		 String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		 return data;
	}
}
