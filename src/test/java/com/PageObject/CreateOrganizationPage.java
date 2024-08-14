package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationPage {

	WebDriver driver;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Organizations")
	WebElement lnkCreateOrg;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	WebElement createLookImg;
	
	
	@FindBy(name="accountname")
	WebElement orgName;
	
	@FindBy(name="industry")
	WebElement selIndustry;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement clickSave;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement adminimg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	WebElement signOut;
	
	public void createOrganization()
	{
		lnkCreateOrg.click();
	}
	
	public void createLookupImg()
	{
		createLookImg.click();
	}
	
	public void addOrgName(String oname)
	{
		orgName.sendKeys(oname);
	}
	
	public void selectIndustry()
	{
		Select sel=new Select(selIndustry);
		sel.selectByVisibleText("Banking");
	}
    
	public void clickSave()
	{
		clickSave.click();
	}
	
	public void clickAdImg()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	
}
