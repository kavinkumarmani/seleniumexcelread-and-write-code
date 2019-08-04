package readexceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {

	public static void main(String[] args) throws Exception {
		
		File src=new File("C:\\Users\\Saran\\exceldata\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wd=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wd.getSheetAt(0);
		String data1=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("the excel data is :"+data1);
		String data2=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("the excel data is :"+data2);
		String data3=sheet1.getRow(0).getCell(2).getStringCellValue();
		System.out.println("the excel data is :"+data3);

	}

}
