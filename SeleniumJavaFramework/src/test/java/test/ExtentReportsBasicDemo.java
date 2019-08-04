package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// starts reporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Google Search Test", "Test to validate Google srearch functionality");

        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test.log(Status.INFO, "Starting Test Case...");
		driver.get("https://www.google.com");
		test.pass("Navigated to Google.com");
		
		test.log(Status.INFO, "Entering data into Seach Box.");
		driver.findElement(By.name("q")).sendKeys("Riyaz Ali Baig Mohammad");
		test.pass("Entered text in Search Box.");
		
		test.log(Status.INFO, "Pressing Keyboard Entry Key.");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test.pass("Pressed Keyboard Entry Key.");
		
		test.log(Status.INFO, "Closing the browser.");
		driver.close();
		test.pass("Closed the browser.");
		
		test.info("Test Completed.");
		
        // log with snapshot
//        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
//        test.addScreenCaptureFromPath("screenshot.png");

		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test2 = extent.createTest("Google Search Test", "Test to validate Google srearch functionality");

        System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test2.log(Status.INFO, "Starting Test Case...");
		driver.get("https://www.google.com");
		test2.pass("Navigated to Google.com");
		
		test2.log(Status.INFO, "Entering data into Seach Box.");
		driver.findElement(By.name("q")).sendKeys("Riyaz Ali Baig Mohammad");
		test2.pass("Entered text in Search Box.");
		
		test2.log(Status.INFO, "Pressing Keyboard Entry Key.");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test2.fail("Pressed Keyboard Entry Key.");
		
		test2.log(Status.INFO, "Closing the browser.");
		driver.close();
		test2.pass("Closed the browser.");
		
		test2.info("Test Completed.");

		
        // calling flush writes everything to the log file
        extent.flush();
		
	}

}