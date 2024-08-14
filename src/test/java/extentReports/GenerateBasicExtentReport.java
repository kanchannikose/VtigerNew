package extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateBasicExtentReport {

	public static void main(String[] args) throws IOException {
		
		ExtentReports exrepo=new ExtentReports();
		File file=new File("report.html");
        ExtentSparkReporter sparkrepo=new ExtentSparkReporter(file);
        exrepo.attachReporter(sparkrepo);
        
        ExtentTest test1 = exrepo.createTest("Test 1");
        test1.pass("This is passed");
        
    
	    ExtentTest test2 = exrepo.createTest("test 2");
        test2.log(Status.FAIL, "This is failed");
        
        exrepo.createTest("test 3").skip("This is skipped");
        
        exrepo.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
        
	}

}
