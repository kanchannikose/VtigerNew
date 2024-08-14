package genericUtilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	PropertyFileUtility putil=new PropertyFileUtility();
	public String baseurl=putil.getUrl();
	public String username=putil.getUsername();
	public String password=putil.getPassword();
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", putil.getFirefoxPath());
		    driver=new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
		    driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public static String captureSceenshot(String fileName) throws IOException
	  {
		  TakesScreenshot ts= (TakesScreenshot) driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  File trg=new File("./screenshots/"+fileName+".png");
		  FileUtils.copyFile(src, trg);
		  
		  System.out.println("screenshot saved successfully");
		  return trg.getAbsolutePath();
		
		
	  }
	
	
	public String randomString()
	{
		String generateSring = RandomStringUtils.randomAlphabetic(5);
		return generateSring;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	@BeforeSuite
	public void intializedExtentRepo()
	{
		exRepo=new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkRepo=new ExtentSparkReporter(file);
		exRepo.attachReporter(sparkRepo);
		
	}
	
	@AfterSuite
	public void generateExtentReports() throws IOException
	{
		
		exRepo.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
	
*/
	

}
