package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projectPath= System.getProperty("user.dir");
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\BrowserDrivers\\iedriver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(dc);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Riyaz Ali Baig Mohammad");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		System.out.println("Success");
		
		driver.close();
		driver.quit();
			
	}

}
