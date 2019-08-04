package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

static WebDriver driver=null;
	
	@BeforeTest
	public void setUp(){
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
	}
	
	@Test
	public static void googleSearchTwo() throws InterruptedException{
		
		driver.get("https://www.google.com");
		
		By textbox_search = By.name("q");
		
//		By button_search = By.name("btnK");
		
		driver.findElement(textbox_search).sendKeys("Faraz Ullah");
			
		driver.findElement(textbox_search).sendKeys(Keys.RETURN);
		
		//Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDownTest(){
		
		driver.close();
		System.out.println("Success");
		
	}
	
}