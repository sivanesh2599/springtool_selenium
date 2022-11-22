package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng {
		String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver;
		

		@BeforeTest
		public void bt() 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		@Test(priority=0)
		public void login() throws InterruptedException
		{
			Thread.sleep(3000);
			//enter a user name
			WebElement username =driver.findElement(By.name("username"));
			username.sendKeys("Admin");
			//enter a password
			WebElement password =driver.findElement(By.xpath("//*[@placeholder='Password']"));
			password.sendKeys("admin123");
			//click on login button
			WebElement login =driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
			login.click();
			
		}
		@Test(priority=1,enabled=true)
		public void links() throws InterruptedException
		{
			Thread.sleep(3000);
			//get how many links in page
			List <WebElement> links=driver.findElements(By.tagName("a"));
			//print number of links in page
			System.out.println(links.size());
			for(int i=0;i<links.size();i++)
			{
				String url=links.get(i).getAttribute("href");
				System.out.println(url);
			}
		}
		@Test(priority=1)
		public void deleteuser() throws InterruptedException
		{
			Thread.sleep(3000);
			//select one user
			//driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(6).click();
			Thread.sleep(3000);
			//click on checkbox
			driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(6).click();
			Thread.sleep(3000);
			//click on delete
			driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(6).click();
			Thread.sleep(3000);
			//select es delete in popup
			driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
			
		}
		@Test(priority=2)
		public void logout() throws InterruptedException
		{
			Thread.sleep(3000);
			//dropdown for logout
			driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
			Thread.sleep(2000);
			//click on logout
			driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
			Thread.sleep(3000);
		}
		@AfterTest
		public void quitbrowser()
		{
			driver.quit();
		}
		
}
