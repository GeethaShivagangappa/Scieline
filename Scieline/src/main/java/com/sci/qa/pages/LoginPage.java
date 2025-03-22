package com.sci.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sci.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="txtUser")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@src,'../skylineFormWebapp/images/skyline_logo_login.svg')]")
	WebElement Scilogo;
	
	@FindBy(xpath="//h2[text()='Experiment']")
	WebElement lblExperiment;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean Scilogo(){
		return Scilogo.isDisplayed();
	}
	
	public void login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		
	}
	
}
