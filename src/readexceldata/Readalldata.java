package readexceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readalldata {
	
	int rowcount=0;
	public static void main(String[] args) throws Exception {
		
		File src=new File("C:\\Users\\Saran\\exceldata\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		int rowcount=sheet1.getLastRowNum();
		System.out.println("total number of row is : "+rowcount);
		for(int i=0;i<=rowcount;i++) {
			String data1=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("the data from excel are :"+data1);
		}
		wb.close();

	}

}
