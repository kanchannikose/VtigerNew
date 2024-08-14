package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(name="user_name")
	WebElement txtUsername;
	
	@FindBy(name="user_password")
	WebElement txtPwd;
	
	@FindBy(id="submitButton")
	WebElement clickBtn;
	
	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void clickBtn()
	{
		clickBtn.click();
	}

}
