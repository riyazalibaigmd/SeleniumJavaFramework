package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	static WebDriver driver=null;
	
	@BeforeTest
	public void setUp(){
				// starts reporter
				htmlReporter = new ExtentHtmlReporter("extentReports.html");
				
				// create ExtentReports and attach reporter(s)
		        extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest(){
		        String projectPath = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDrivers\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
	}

	@Test
	public void test() throws Exception{
		
		driver.get("https://www.google.com");
				
		driver.findElement(By.name("q")).sendKeys("Riyaz Ali Baig Mohammad");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
				
		// creates a toggle for the given test, adds all log events under it    
        test = extent.createTest("Google Search Test", "Test to validate Google srearch functionality");
        
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        
	}
	
	@Test
	public void test2() throws Exception{
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Riyaz Ali Baig Mohammad");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		// creates a toggle for the given test, adds all log events under it    
        test = extent.createTest("Google Search Test", "Test to validate Google srearch functionality");
        
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        
	}
	
	@AfterTest
	public void tearDown(){
		extent.flush();
	}
	
	@AfterTest
	public void tearDownTest(){
		driver.close();
	}
	
}
