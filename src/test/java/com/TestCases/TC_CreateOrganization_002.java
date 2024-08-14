package com.TestCases;

import org.testng.annotations.Test;

import com.PageObject.CreateOrganizationPage;
import com.PageObject.LoginPage;

import genericUtilities.BaseClass;

public class TC_CreateOrganization_002 extends BaseClass {

	@Test
	public void createOrganization() throws InterruptedException 
	{
		
		driver.get(baseurl);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickBtn();
		
		Thread.sleep(5000);
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrganization();
        cop.createLookupImg();
        cop.addOrgName(randomString());
        Thread.sleep(2000);
        cop.selectIndustry();
        cop.clickSave();
        
       // cop.clickAdImg();
       // cop.clickOnSignOut();
        
        
        Thread.sleep(5000);
        
		
	}


}
