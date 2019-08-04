package readexceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelwrite {

	public static void main(String[] args) throws Exception {
		
		File src=new File("C:\\Users\\Saran\\exceldata\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		sheet1.getRow(0).createCell(3).setCellValue("pass");
		sheet1.getRow(1).createCell(3).setCellValue("pass");
		sheet1.getRow(2).createCell(3).setCellValue("fail");
		sheet1.getRow(3).createCell(3).setCellValue("pass");
		sheet1.getRow(4).createCell(3).setCellValue("pass");
		
		FileOutputStream fos=new FileOutputStream(src);
		wb.write(fos);
		wb.close();

	}

}
