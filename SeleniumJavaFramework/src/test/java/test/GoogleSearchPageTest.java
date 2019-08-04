package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearchtTest();
		
	}
	
	public static void googleSearchtTest(){
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		searchPageObj.setTextForSearchBox("ABCD");
		searchPageObj.clickSearchButton();
		
		System.out.println("Success");
		driver.close();
		
	}
	
}