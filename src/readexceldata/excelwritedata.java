package readexceldata;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class excelwritedata {

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
		driver.findElement(By.xpath("(//div[@class='_3wU53n'])[1]")).click();
		
		//*[@id="container"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[1]
		//*[@id="container"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[2]
		
		List<WebElement>totalrows=driver.findElements(By.xpath("/*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr"));
		int totalrowscount=totalrows.size();
		//*[@id="container"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]
		//*[@id="container"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]
		
		List<WebElement>totalcolumns=driver.findElements(By.xpath("/*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td"));
		int totalcolumnscount=totalcolumns.size();
		
		System.out.println("Selected web table has " +totalrowscount+ " Rows and " +totalcolumnscount+ " Columns");
		System.out.println();


	}

}
