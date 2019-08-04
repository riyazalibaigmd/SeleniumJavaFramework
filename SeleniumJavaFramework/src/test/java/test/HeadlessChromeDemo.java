package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {

	public static void main (String args[]){
		test();
	}
	
	public static void test(){
		
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
//		options.addArguments("window-size=1920*1080");
				
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("Riyaz Ali");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
				
		driver.close();
		
	}
	
}
