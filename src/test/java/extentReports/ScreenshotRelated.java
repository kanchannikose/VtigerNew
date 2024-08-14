package extentReports;

import static org.testng.Assert.fail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotRelated {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
	
		ExtentReports exRepo =new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter exSparkRepo=new ExtentSparkReporter(file);
        exRepo.attachReporter(exSparkRepo);
        
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        
        driver.get("https://www.google.com/");
        String base64Code = captureSceenshot();
        String path = captureSceenshot("Google.jpg");
       
		exRepo
		.createTest("screenshot Test 1", "This is for attaching the screenshot")
        .info("This is info msg")
        .addScreenCaptureFromBase64String(base64Code);
		
		exRepo.createTest("screenshot Test 2", "this is for attaching the screenshot")
		.info("This is info msg")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage");
        
		exRepo.createTest("screenshot Test 3", "this is for attaching the screenshot")
		.info("This is info msg")
		.addScreenCaptureFromPath(path, "google homepage1")
		.addScreenCaptureFromPath(path, "google homepage2")
		.addScreenCaptureFromPath(path, "google homepage3")
		.addScreenCaptureFromPath(path, "google homepage4")
		.addScreenCaptureFromPath(path, "google homepage5");
		
		exRepo
		.createTest("screenshot Test 4", "this is for attaching the screenshot")
		.info("This is info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
		//.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "Google Homepage").build());
		
		
		
        exRepo.flush();
        driver.quit();
        Desktop.getDesktop().browse(new File("report.html").toURI());
	} 
	


	public static String captureSceenshot() 
	  {
		  TakesScreenshot ts= (TakesScreenshot) driver;
		  String base64Code=ts.getScreenshotAs(OutputType.BASE64);
		  System.out.println("screenshot saved succesfully");
		  return base64Code;
		  
	
		
		
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

}
