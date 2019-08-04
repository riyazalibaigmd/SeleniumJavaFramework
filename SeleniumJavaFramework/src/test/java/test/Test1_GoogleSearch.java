package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1_GoogleSearch {

	public static void main(String[] args) {
						
		googleSearch();
		
	}

	public static void googleSearch() {
		
		//setting up the chrome driver 
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		
		//Navigating to google.com
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		//sending text to search textbox
		driver.findElement(By.name("q")).sendKeys("riyaz ali baig mohammad");
				
		//search on click button
//		driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//closing the driver
		driver.close();
		
		System.out.println("Google Test Search Completed successfully.");
		
	}
	
}