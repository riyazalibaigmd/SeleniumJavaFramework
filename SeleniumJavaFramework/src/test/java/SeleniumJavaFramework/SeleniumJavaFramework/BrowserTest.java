package SeleniumJavaFramework.SeleniumJavaFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String args[]){
		
		String projectPath= System.getProperty("user.dir");
				
		System.setProperty("webdriver.gecko.driver", projectPath+"\\BrowserDrivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://seleniumhq.org");
		driver.manage().window().maximize();
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumhq.org");
		driver.manage().window().maximize();
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\BrowserDrivers\\iedriver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://seleniumhq.org");
		driver.manage().window().maximize();
		
		driver.close();
		
	}
	
}