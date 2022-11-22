package maven;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class new_tour {
	String url ="https://demo.guru99.com/test/newtours/";
	String urlorangehrm = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String alerturl ="https://demoqa.com/alerts/";
	String facebook = "https://www.facebook.com/";
	String youtube = "https://www.youtube.com/";
	String github = "https://github.com/";
	WebDriver driver;
	String t;
	String ur;
	
	
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get(url);
		driver.navigate().to(alerturl);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	
	}
	
	@Test(priority=0,enabled=false)
	public void brokenlinks() throws InterruptedException, IOException {
		Thread.sleep(3000);
		//Get a links from webpage
		List <WebElement> links=driver.findElements(By.tagName("a"));
		
		//Print number of links
		System.out.println(links.size());
		//for loop 
		for(int i=0;i<links.size();i++) {
			//Get all link using attribute
			WebElement ele=links.get(i);
			String url=ele.getAttribute("href");
			//create a class create a object link
			URL link=new URL(url);
			//create a connection using url 
			HttpURLConnection httpcon =(HttpURLConnection)link.openConnection();
			Thread.sleep(3000);
			//connect is method used to establish connection
			httpcon.connect();
			//It return responce code
			int responcecode=httpcon.getResponseCode();
			
			if(responcecode>400)
			{
				System.out.println(url + "is broken link");
				
			}
			else
			{
				System.out.println(url + "is  a working link");
			}
			
		}
		
	}
	@Test(priority=0,enabled=false)
	public void brokenlink2() throws InterruptedException
	{
		Thread.sleep(3000);
		//Get a links from webpage
		List <WebElement> links=driver.findElements(By.tagName("a"));
		
		//Print number of links
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			String url=links.get(i).getAttribute("href");
			String brokenurl="https://demo.guru99.com/test/newtours/support.php";
			
		if(url.equals(brokenurl))
		{
			System.out.println("The link is not working " +links.get(i).getText());
		}
		else
		{
			System.out.println("The link is working " +links.get(i).getText());
		}
		}
	}
	
	
	@Test(priority=0,enabled=false)
	public void userlogin() throws InterruptedException {
		//User login
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='REGISTER']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
	}
	@Test(priority=1,enabled=false)
	public void Registerpage() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).sendKeys("sivanesh");
		//First name
		driver.findElement(By.name("lastName")).sendKeys("kumar");
		//Last name
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		//Phone
		driver.findElement(By.id("userName")).sendKeys("sivanesh@gmail.com");
		//Mail id
		driver.findElement(By.name("address1")).sendKeys("Pattiveeranpatti");
		//address
		driver.findElement(By.name("city")).sendKeys("Dindigul");
		//City
		driver.findElement(By.name("state")).sendKeys("Tamilnadu");
		//state
		driver.findElement(By.name("postalCode")).sendKeys("624211");
		//postal code
		Select s = new Select(driver.findElement(By.name("country")));
		//s.selectByVisibleText("AUSTRALIA");
		//s.selectByValue("AUSTRALIA");
		s.selectByIndex(12);
		driver.findElement(By.id("email")).sendKeys("sivanesh@gmail.com");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("confirmPassword")).sendKeys("user");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		t=driver.getTitle();
		System.out.println(t);
		ur=driver.getCurrentUrl();
		System.out.println(ur);
		
	}
	@Test(priority=0,enabled=true)
	public void alert1() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		//Switch to alert box
		Alert siva = driver.switchTo().alert();
		//get a text inside the alert
		String text =siva.getText();
		System.out.println(text);
		siva.accept();
		Thread.sleep(3000);
		System.out.println("the Alert ok is clicked");
		
	}
	@Test(priority=1,enabled=true)
	public void alert2() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		//Switch to alert box
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		//Get text from alert box
		String text =alert2.getText();
		System.out.println(text);
		alert2.accept();
		Thread.sleep(3000);
		System.out.println("The alert2 is clicked");
		
	}
	@Test(priority=2,enabled=true)
	public void alert3() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		//switch to alert box
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(3000);
		//Get text from alert box
		String text=alert3.getText();
		System.out.println(text);
		alert3.dismiss();
		Thread.sleep(3000);
		System.out.println("The alert3 dismiss is clcked");
		
	}
	@Test(priority=3,enabled=true)
	public void alert4() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(5000);
		//switch into alert box
		Alert alert4 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert4.sendKeys("selenium");
		Thread.sleep(3000);
		alert4.accept();
		System.out.println("it entered value and accept it");
	
		
	}
	
	@AfterTest(enabled=false)
	public void at() {
		driver.quit();
	}
	
	
	

}
