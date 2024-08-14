package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.LoginPage;

import genericUtilities.BaseClass;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws InterruptedException, IOException	
	{
		driver.get(baseurl);
		
		LoginPage lp=new LoginPage(driver);
		{
			
			lp.setUsername(username);
			lp.setPassword(password);
			lp.clickBtn();
			Thread.sleep(5000);

            if(driver.getTitle().equals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"))
            {
            	Assert.assertTrue(true);
            	System.out.println("It is passed");
            }
            else
            {
            	
            	captureSceenshot("TC_LoginTest_001");
            	Assert.assertTrue(false);
            	System.out.println("It is failed");
            	
            }
		}
	}

	
		
	}
		




