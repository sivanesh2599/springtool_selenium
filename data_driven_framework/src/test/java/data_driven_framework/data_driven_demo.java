package data_driven_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class data_driven_demo {
		WebDriver driver;
		public String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";		

		
	@Test
	public void tc1() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		File excel = new File("C:/Users/Hp/Desktop/driven.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("sheet1");
		int rowcount=sh.getLastRowNum();
		for(int i=0; i<rowcount;i++) {
			String user=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(user);
			String pass=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(pass);
			driver= new ChromeDriver();
			driver.get(url);
			Thread.sleep(3000);
			driver.findElement(By.name("username")).sendKeys(user);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			String str= driver.getCurrentUrl();
			if(str.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
		}
	
			else{
			for(int j=i+1;j<rowcount;j++) {
				String user1=sh.getRow(j).getCell(0).getStringCellValue();
				//System.out.println(user1);
				String password1=sh.getRow(j).getCell(1).getStringCellValue();
				//System.out.println(password1);
				driver.findElement(By.name("username")).sendKeys(user);
				driver.findElement(By.name("password")).sendKeys(pass);
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				
			}
		}
	
}
	}
}

	

