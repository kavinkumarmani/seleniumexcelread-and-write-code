package readexceldata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class flipkartproject {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\Saran\\Downloads\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//close login popup
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		//action class to navigate to Laptop categories page
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[@class='_1QZ6fC _3Lgyp8'])[1]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Laptops")).click();
		//filter i7process with HP
		action.click(driver.findElement(By.xpath("(//div[@class='_1p7h2j'])[2]"))).build().perform();
		Thread.sleep(5000);
		action.click(driver.findElement(By.xpath("(//div[@class='_1p7h2j'])[9]"))).build().perform();
		Thread.sleep(15000);
		
		//excel write
		//File src=new File("C:\\Users\\Saran\\exceldata\\Datatest.xlsx");
		//FileInputStream fis=new FileInputStream(src);
		//XSSFWorkbook wb=new XSSFWorkbook(fis);
		//XSSFSheet sheet1=wb.getSheetAt(0);
		
		//total number of HP laptops
		List<WebElement>HPlaptops=driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		int names=HPlaptops.size();
		System.out.println("total number of available laptop are :"+names);
		//iterate the values
		for(int i=0;i<names;i++) {
			System.out.println(HPlaptops.get(i).getText());
			String name= HPlaptops.get(i).getText();
		//click on laptops one by one
			driver.findElement(By.xpath("(//div[@class='_3wU53n'])["+(i+1)+"]")).click();
			Thread.sleep(5000);
		//switching to child window
			Set<String>secondwindow=driver.getWindowHandles();
			Iterator<String> it=secondwindow.iterator();
			String parentwindowid=it.next();
			String childwindowid=it.next();
			driver.switchTo().window(childwindowid);
		//getting name,price,offer
			WebElement price=driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']"));
			System.out.println(price.getText());
			String pprice=price.getText();
			WebElement offer=driver.findElement(By.xpath("//div[@class='VGWI6T _1iCvwn']"));
			System.out.println(offer.getText());
			String poffer=offer.getText();
			
			
			WebElement table=driver.findElement(By.xpath("(//table[@class='_3ENrHu'])[1]"));

			List<WebElement> totalrow=table.findElements(By.tagName("tr"));
			int rowcount=totalrow.size();
			System.out.println("total number of rows are "+rowcount);
			
			//xpath (//table[@class='_3ENrHu'])[1]//tr[1]/td[1]
			
					
			String rowbeforexpath="(//table[@class='_3ENrHu'])[1]//tr[";
			String rowafterxpath="]/td[1]";
			
			for(int j=1;j<=rowcount;j++) {
				
				String actualxpath=rowbeforexpath+j+rowafterxpath;
				WebElement element=driver.findElement(By.xpath(actualxpath));
				String tabledata=element.getText();
				if(tabledata.equals("Color")){ 
					String color = driver.findElement(By.xpath("(//table[@class='_3ENrHu'])[1]//tr["+j+"]/td[2]")).getText();
					System.out.println(color);
				}
					
				}driver.close();
			driver.switchTo().window(parentwindowid);
			
		}
		driver.close();

	}

}
